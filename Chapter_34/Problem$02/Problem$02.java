package chapter_thirty_four;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.chart.*;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * **34.2 (Visualize data) Write a program that displays the number of students in each
 * department in a pie chart and a bar chart, as shown in Figure 34.27b. The PieChart
 * and BarChart classes are created in Programming Exercises 14.12 and 14.13. The
 * number of students for each department can be obtained from the Student table
 * (see Figure 34.4) using the following SQL statement:
 * select deptId, count(*)
 * from Student
 * where deptId is not null
 * group by deptId;
 *
 *
 * @author Sharaf Qeshta
 * */
public class Problem$02 extends Application
{
    public static final String LINK = "jdbc:mysql://localhost:3307/java_book";
    public static final String USER_NAME = "root";
    public static final String PASSWORD = "123456";

    @Override
    public void start(Stage stage)
    {
        CategoryAxis xAxis = new CategoryAxis();
        xAxis.setLabel("Departments");

        NumberAxis yAxis = new NumberAxis();
        yAxis.setLabel("Students");

        BarChart barChart = new BarChart(xAxis, yAxis);
        XYChart.Series barChartData = new XYChart.Series();
        ArrayList<PieChart.Data> list = new ArrayList<>();

        try
        {
            Connection connection = DriverManager.getConnection(
                    LINK, USER_NAME, PASSWORD);

            Statement statement = connection.createStatement();

            ResultSet result = statement.executeQuery("select deptId, count(*) " +
                    " from Student " +
                    " where deptId is not null " +
                    " group by deptId; ");

            while (result.next())
            {
                String deptId = result.getString(1);
                int count = result.getInt(2);

                list.add(new PieChart.Data(deptId, count));
                barChartData.getData().add(new XYChart.Data(deptId, count));
            }
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
            System.exit(-1);
        }

        barChart.getData().add(barChartData);
        ObservableList<PieChart.Data> pieChartData =
                FXCollections.observableList(list);
        PieChart pieChart = new PieChart(pieChartData);
        HBox pane = new HBox(5, pieChart, barChart);

        Scene scene = new Scene(pane, 500, 500);
        stage.setScene(scene);
        stage.setTitle("Problem$02");
        stage.show();
    }
}
