package chapter_fourteen.samples;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.stage.Stage;

/**
 * Listing 14.15 ShowLine.java
 */
public class ShowLine extends Application
{
    @Override // Override the start method in the Application class
    public void start(Stage primaryStage)
    {
        // Create a scene and place it in the stage
        Scene scene = new Scene(new LinePane(), 200, 200);
        primaryStage.setTitle("ShowLine"); // Set the stage title
        primaryStage.setScene(scene); // Place the scene in the stage
        primaryStage.show(); // Display the stage
    }
}

class LinePane extends Pane
{
    public LinePane()
    {
        Line line1 = new Line(10, 10, 10, 10);
        line1.endXProperty().bind(widthProperty().subtract(10));
        line1.endYProperty().bind(heightProperty().subtract(10));
        line1.setStrokeWidth(5);
        line1.setStroke(Color.GREEN);
        getChildren().add(line1);
        Line line2 = new Line(10, 10, 10, 10);
        line2.startXProperty().bind(widthProperty().subtract(10));
        line2.endYProperty().bind(heightProperty().subtract(10));
        line2.setStrokeWidth(5);
        line2.setStroke(Color.GREEN);
        getChildren().add(line2);
    }
}
