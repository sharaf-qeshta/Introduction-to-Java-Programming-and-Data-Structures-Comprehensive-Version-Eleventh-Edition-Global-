package chapter_thirty_one.samples;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

/**
 * Listing 31.6 RotateDemo.java
 * */
public class RotateDemo extends Application
{
    @Override // Override the start method in the Application class
    public void start(Stage primaryStage)
    {
        Pane pane = new Pane();
        java.util.Random random = new java.util.Random();
        // The radius of the circle for anchoring rectangles
        double radius = 90;
        double width = 20; // Width of the rectangle
        double height = 40; // Height of the rectangle
        for (int i = 0; i < 8; i++)
        {
            // Center of a rectangle
            double x = 150 + radius * Math.cos(i * 2 * Math.PI / 8);
            double y = 150 + radius * Math.sin(i * 2 * Math.PI / 8);
            Rectangle rectangle = new Rectangle(
                    x - width / 2, y - height / 2, width, height);
            rectangle.setFill(Color.WHITE);
            rectangle.setStroke(Color.color(random.nextDouble(),
                    random.nextDouble(), random.nextDouble()));
            rectangle.setRotate(i * 360 / 8); // Rotate the rectangle
            pane.getChildren().add(rectangle);
        }

        Scene scene = new Scene(pane, 300, 300);
        primaryStage.setTitle("RotateDemo"); // Set the window title
        primaryStage.setScene(scene); // Place the scene in the window
        primaryStage.show(); // Display the window
    }
}
