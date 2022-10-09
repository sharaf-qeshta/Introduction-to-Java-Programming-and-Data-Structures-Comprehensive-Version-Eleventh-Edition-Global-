package chapter_thirty_one;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.StrokeLineCap;
import javafx.stage.Stage;

/**
 * *31.15 (Sunshine) Write a program that displays a circle filled with a gradient color to
 * animate a sun and display light rays coming out from the sun using dashed lines,
 * as shown in Figure 31.54a.
 *
 *
 * @author Sharaf Qeshta
 * */
public class Problem$15 extends Application
{
    @Override
    public void start(Stage stage)
    {
        Circle circle = new Circle(250, 250, 50);
        circle.setFill(Color.GOLD); circle.setStroke(Color.GOLD);
        Pane pane = new Pane(circle);

        // Draw the rays
        double increment = 360/48.0;
        double angle = 0;
        for (int i = 0; i < 48; i++)
        {
            double startX = circle.getRadius() * Math.cos(Math.toRadians(angle))
                    + circle.getCenterX();
            double startY = circle.getRadius() * Math.sin(Math.toRadians(angle))
                    + circle.getCenterY();

            // Imagine if there`s a bigger circle around the original one
            double endX = (circle.getRadius() + 20) * Math.cos(Math.toRadians(angle))
                    + circle.getCenterX();
            double endY = (circle.getRadius() + 20) * Math.sin(Math.toRadians(angle))
                    + circle.getCenterY();

            Line line = new Line(startX, startY, endX, endY);
            line.getStrokeDashArray().addAll(3.0);
            pane.getChildren().add(line);
            angle += increment;
        }

        Scene scene = new Scene(pane, 500, 500);
        stage.setScene(scene);
        stage.setTitle("Problem$15");
        stage.show();
    }
}
