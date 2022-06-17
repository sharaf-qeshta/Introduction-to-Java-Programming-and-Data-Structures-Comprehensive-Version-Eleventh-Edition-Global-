package chapter_fourteen;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 * **14.13 (Display a pie chart) Write a program that uses a pie chart to display the
 * percentages of the overall market share represented by Apple, HTC, Samsung, and
 * Others, as shown in Figure 14.46c. Suppose that Apple takes 26 percent and is
 * displayed in red, HTC takes 26 percent and is displayed in blue, Samsung takes
 * 28 percent and is displayed in green, and the Others take 26 percent and are displayed
 * in orange. Use the Arc class to display the pies. Interested readers may
 * explore the JavaFX PieChart class for further study.
 *
 * @author Sharaf Qeshta
 * */
public class Problem$13 extends Application
{
    public static void main(String[] args)
    {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage)
    {
        ObservableList<PieChart.Data> pieChartData = FXCollections.observableArrayList(
                new PieChart.Data("Apple", 20),
                new PieChart.Data("HTC", 26),
                new PieChart.Data("Samsung", 28),
                new PieChart.Data("Others", 26));

        PieChart pieChart = new PieChart(pieChartData);


        GridPane pane = new GridPane();
        pane.setAlignment(Pos.CENTER);

        pane.add(pieChart, 0, 0);

        Scene scene = new Scene(pane, 500, 500);
        primaryStage.setTitle("Problem$13");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
