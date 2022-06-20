package chapter_fourteen.samples;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * Listing 14.18 ShowArc.java
 */
public class ShowArc extends Application
{
    @Override // Override the start method in the Application class
    public void start(Stage primaryStage)
    {
        Arc arc1 = new Arc(150, 100, 80, 80, 30, 35); // Create an arc
        arc1.setFill(Color.RED); // Set fill color
        arc1.setType(ArcType.ROUND); // Set arc type

        Arc arc2 = new Arc(150, 100, 80, 80, 30 + 90, 35);
        arc2.setFill(Color.WHITE);
        arc2.setType(ArcType.OPEN);
        arc2.setStroke(Color.BLACK);

        Arc arc3 = new Arc(150, 100, 80, 80, 30 + 180, 35);
        arc3.setFill(Color.WHITE);
        arc3.setType(ArcType.CHORD);
        arc3.setStroke(Color.BLACK);

        Arc arc4 = new Arc(150, 100, 80, 80, 30 + 270, 35);
        arc4.setFill(Color.GREEN);
        arc4.setType(ArcType.CHORD);
        arc4.setStroke(Color.BLACK);

        // Create a group and add nodes to the group
        Group group = new Group();
        group.getChildren().addAll(new Text(210, 40, "arc1: round"),
                arc1, new Text(20, 40, "arc2: open"), arc2,
                new Text(20, 170, "arc3: chord"), arc3,
                new Text(210, 170, "arc4: chord"), arc4);

        // Create a scene and place it in the stage
        Scene scene = new Scene(new BorderPane(group), 300, 200);
        primaryStage.setTitle("ShowArc"); // Set the stage title
        primaryStage.setScene(scene); // Place the scene in the stage
        primaryStage.show(); // Display the stage
    }
}
