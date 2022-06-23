package chapter_fifteen;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * *15.23 (Auto resize slow sign) Rewrite Programming Exercise 14.15 so that the slow
 * sign’s width and height are automatically resized when the window is resized.
 *
 *
 * @author Sharaf Qeshta
 * */
public class Problem$23 extends Application
{
    private static double lastSize = 500;
    private static double scaleFactor = 0.5;

    public static void main(String[] args)
    {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage)
    {
        StackPane pane = new StackPane();

        Polygon polygon = new Polygon();
        pane.getChildren().add(polygon);
        polygon.setFill(Color.RED);
        polygon.setRotate(20);
        ObservableList<Double> list = polygon.getPoints();

        final double WIDTH = 200, HEIGHT = 200;
        double centerX = WIDTH / 2, centerY = HEIGHT / 2;
        double radius = Math.min(WIDTH, HEIGHT) * 0.4;

        // Add points to polygon list
        for (int i = 0; i < 8; i++)
        {
            list.add(centerX + radius * Math.cos(2 * i * Math.PI / 8));
            list.add(centerY - radius * Math.sin(2 * i * Math.PI / 8));
        }

        // Create a text and set its properties
        Text text = new Text("STOP");
        text.setFont(Font.font("Times new Roman", FontWeight.BOLD, 40));
        text.setFill(Color.WHITE);
        pane.getChildren().add(text);


        Scene scene = new Scene(pane, 500, 500);
        primaryStage.setTitle("Problem$23");
        primaryStage.setScene(scene);
        primaryStage.show();

        pane.heightProperty().addListener(ov ->
        {
            if (scene.getHeight() > lastSize)
                scaleFactor = 2;
            else
                scaleFactor = 0.5;
            ObservableList<Double> points = polygon.getPoints();
            for (int i = 0; i < points.size();i++)
            {
                points.set(i, points.get(i) * scaleFactor);
            }
            lastSize = scene.getHeight();
        });
    }
}
