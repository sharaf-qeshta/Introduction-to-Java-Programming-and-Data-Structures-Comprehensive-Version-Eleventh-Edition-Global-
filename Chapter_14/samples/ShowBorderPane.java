package chapter_fourteen.samples;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 * Listing 14.12 ShowBorderPane.java
 */
public class ShowBorderPane extends Application
{
    @Override // Override the start method in the Application class
    public void start(Stage primaryStage)
    {
        // Create a border pane
        BorderPane pane = new BorderPane();

        // Place nodes in the pane
        pane.setTop(new CustomPane("Top"));
        pane.setRight(new CustomPane("Right"));
        pane.setBottom(new CustomPane("Bottom"));
        pane.setLeft(new CustomPane("Left"));
        pane.setCenter(new CustomPane("Center"));

        // Create a scene and place it in the stage
        Scene scene = new Scene(pane);
        primaryStage.setTitle("ShowBorderPane"); // Set the stage title
        primaryStage.setScene(scene); // Place the scene in the stage
        primaryStage.show(); // Display the stage
    }
}

// Define a custom pane to hold a label in the center of the pane
class CustomPane extends StackPane
{
    public CustomPane(String title)
    {
        getChildren().add(new Label(title));
        setStyle("−fx−border−color: red");
        setPadding(new Insets(11.5, 12.5, 13.5, 14.5));
    }
}
