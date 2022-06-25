package chapter_fifteen.samples;

import javafx.application.Application;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;

/**
 * Listing 15.11 ResizableCircleRectangle.java
 * */
public class ResizableCircleRectangle extends Application
{
    // Create a circle and a rectangle
    private Circle circle = new Circle(60);
    private Rectangle rectangle = new Rectangle(120, 120);

    // Place clock and label in border pane
    private StackPane pane = new StackPane();

    @Override // Override the start method in the Application class
    public void start(Stage primaryStage)
    {
        circle.setFill(Color.GRAY);
        rectangle.setFill(Color.WHITE);
        rectangle.setStroke(Color.BLACK);
        pane.getChildren().addAll(rectangle, circle);
        // Create a scene and place the pane in the stage
        Scene scene = new Scene(pane, 140, 140);
        primaryStage.setTitle("ResizableCircleRectangle");
        primaryStage.setScene(scene); // Place the scene in the stage
        primaryStage.show(); // Display the stage

        pane.widthProperty().addListener(ov -> resize());
        pane.heightProperty().addListener(ov -> resize());
    }

    private void resize()
    {
        double length = Math.min(pane.getWidth(), pane.getHeight());
        circle.setRadius(length / 2 - 15);
        rectangle.setWidth(length - 30);
        rectangle.setHeight(length - 30);
    }
}
