package chapter_fourteen;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * **14.12 (Display a bar chart) Write a program that uses a bar chart to display the percentages
 * of the overall market share represented by Apple, HTC, Samsung, and
 * Others, as shown in Figure 14.46b. Suppose that Apple takes 20 percent and is
 * displayed in red, HTC takes 26 percent and is displayed in blue, Samsung takes
 * 28 percent and is displayed in green, and the Others take 26 and are displayed
 * in orange. Use the Rectangle class to display the bars. Interested readers may
 * explore the JavaFX BarChart class for further study.
 *
 * @author Sharaf Qeshta
 * */
public class Problem$12 extends Application
{
    public static void main(String[] args)
    {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage)
    {
        CategoryAxis xAxis = new CategoryAxis();
        xAxis.setLabel("Companies");

        NumberAxis yAxis = new NumberAxis();
        yAxis.setLabel("Market Shares");

        BarChart barChart = new BarChart(xAxis, yAxis);

        XYChart.Series dataSeries1 = new XYChart.Series();
        dataSeries1.setName("2022");

        dataSeries1.getData().add(new XYChart.Data("Apple", 20));
        dataSeries1.getData().add(new XYChart.Data("HTC"  , 26));
        dataSeries1.getData().add(new XYChart.Data("Samsung"  , 28));
        dataSeries1.getData().add(new XYChart.Data("Others"  , 26));

        barChart.getData().add(dataSeries1);

        VBox vbox = new VBox(barChart);

        Scene scene = new Scene(vbox, 500, 500);
        primaryStage.setTitle("Problem$12");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
