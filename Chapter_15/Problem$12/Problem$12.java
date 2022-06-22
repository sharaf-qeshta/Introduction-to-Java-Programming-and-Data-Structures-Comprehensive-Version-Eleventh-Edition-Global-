package chapter_fifteen;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.text.DecimalFormat;

/**
 * **15.12 (Geometry: inside a circle?) Write a program that draws a fixed circle centered
 * at (100, 60) with radius 50. Whenever the mouse is moved, display a message
 * indicating whether the mouse point is inside the circle at the mouse point or
 * outside of it, as shown in Figure 15.29a.
 *
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
        Pane pane = new Pane();

        Circle circle = new Circle(100, 60, 50);
        circle.setFill(Color.WHITE);
        circle.setStroke(Color.BLACK);
        Text text = new Text();
        text.setVisible(false);

        pane.getChildren().addAll(circle, text);

        Scene scene = new Scene(pane, 500, 500);
        primaryStage.setTitle("Problem$12");
        primaryStage.setScene(scene);
        primaryStage.show();

        DecimalFormat df = new DecimalFormat(".00");

        pane.setOnMouseMoved(e ->
        {
            double x = e.getX();
            double y = e.getY();
            String point = "(" + df.format(x) + ", " + df.format(y) + ")";
            text.setX(x);
            text.setY(y);

            if (isInCircle(circle, x, y))
                text.setText("point " + point + " inside the circle");
            else
                text.setText("point " + point + " is not in the circle");
            text.setVisible(true);
        });
    }

    private boolean isInCircle(Circle circle, double x, double y)
    {
        double distance = Math.sqrt(Math.pow(circle.getCenterX() - x, 2)
                + Math.pow(circle.getCenterY() - y, 2));
        return distance <= circle.getRadius();
    }
}
