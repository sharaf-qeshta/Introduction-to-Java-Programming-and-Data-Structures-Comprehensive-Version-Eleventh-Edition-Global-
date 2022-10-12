package chapter_thirty_one.samples;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.scene.shape.Circle;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.stage.Stage;

/**
 * Listing 31.3 CurveDemo.java
 * */
public class CurveDemo extends Application
{
    @Override // Override the start method in the Application class
    public void start(Stage primaryStage)
    {
        Pane pane = new Pane();

        // Create a QuadCurve
        QuadCurve quadCurve = new QuadCurve(10, 80, 40, 20, 150, 56);
        quadCurve.setFill(Color.WHITE);
        quadCurve.setStroke(Color.BLACK);

        pane.getChildren().addAll(quadCurve, new Circle(40, 20, 6),
                new Text(40 + 5, 20 - 5, "Control point"));

        // Create a CubicCurve
        CubicCurve cubicCurve = new CubicCurve
                (200, 80, 240, 20, 350, 156, 450, 80);
        cubicCurve.setFill(Color.WHITE);
        cubicCurve.setStroke(Color.BLACK);

        pane.getChildren().addAll(cubicCurve, new Circle(240, 20, 6),
                new Text(240 + 5, 20 - 5, "Control point 1"),
                new Circle(350, 156, 6),
                new Text(350 + 5, 156 - 5, "Control point 2"));

        Scene scene = new Scene(pane, 300, 250);
        primaryStage.setTitle("CurveDemo"); // Set the window title
        primaryStage.setScene(scene); // Place the scene in the window
        primaryStage.show(); // Display the window
    }
}
