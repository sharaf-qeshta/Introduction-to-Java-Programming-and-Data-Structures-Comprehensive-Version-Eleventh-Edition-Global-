package chapter_fourteen;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.text.DecimalFormat;

/**
 * *14.21 (Two circles and their distance) Write a program that draws two circles with
 * radius 15 pixels, centered at random locations, with a line connecting the two
 * circles. The distance between the two centers is displayed on the line, as shown
 * in Figure 14.49b
 *
 *
 * @author Sharaf Qeshta
 * */
public class Problem$21 extends Application
{
    public static void main(String[] args)
    {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage)
    {
        Pane pane = new Pane();

        draw(pane);

        Scene scene = new Scene(pane, 500, 500);
        primaryStage.setTitle("Problem$21");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void draw(Pane pane)
    {
        Circle circle1 = new Circle();
        double centerX1 = ((Math.random() * 1000) % 300) + 100;
        double centerY1 = ((Math.random() * 1000) % 300) + 100;
        circle1.setCenterX(centerX1);
        circle1.setCenterY(centerY1);
        circle1.setRadius(15);
        circle1.setFill(Color.BLACK);

        Circle circle2 = new Circle();
        double centerX2 = ((Math.random() * 1000) % 300) + 100;
        double centerY2 = ((Math.random() * 1000) % 300) + 100;
        circle2.setCenterX(centerX2);
        circle2.setCenterY(centerY2);
        circle2.setRadius(15);
        circle1.setFill(Color.BLACK);

        double distance = Math.sqrt(Math.pow(centerX2 - centerX1, 2) + Math.pow(centerY2 - centerY1, 2)) - 30;
        DecimalFormat df = new DecimalFormat(".00");

        Line connectCircles = new Line(centerX1, centerY1, centerX2, centerY2);

        Text text = new Text(df.format(distance));
        text.setX(((centerX1 + centerX2) / 2) + 10);
        text.setY((centerY1 + centerY2) / 2);

        pane.getChildren().addAll(circle1, circle2, connectCircles, text);
    }
}
