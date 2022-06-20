package chapter_fourteen.samples;


import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import javafx.stage.Stage;

/**
 * Listing 14.19 ShowPolygon.java
 */
public class ShowPolygon extends Application
{
    @Override // Override the start method in the Application class
    public void start(Stage primaryStage)
    {
        // Create a scene and place it in the stage
        Scene scene = new Scene(new MyPolygon(), 400, 400);
        primaryStage.setTitle("ShowPolygon"); // Set the stage title
        primaryStage.setScene(scene); // Place the scene in the stage
        primaryStage.show(); // Display the stage
    }
}

class MyPolygon extends Pane
{
    private void paint()
    {
        // Create a polygon and place polygon to pane
        Polygon polygon = new Polygon();
        polygon.setFill(Color.WHITE);
        polygon.setStroke(Color.BLACK);
        ObservableList<Double> list = polygon.getPoints();

        double centerX = getWidth() / 2, centerY = getHeight() / 2;
        double radius = Math.min(getWidth(), getHeight()) * 0.4;

        // Add points to the polygon list
        for (int i = 0; i < 6; i++)
        {
            list.add(centerX + radius * Math.cos(2 * i * Math.PI / 6));
            list.add(centerY - radius * Math.sin(2 * i * Math.PI / 6));
        }

        getChildren().clear();
        getChildren().add(polygon);
    }

    @Override
    public void setWidth(double width)
    {
        super.setWidth(width);
        paint();
    }

    @Override
    public void setHeight(double height)
    {
        super.setHeight(height);
        paint();
    }
}