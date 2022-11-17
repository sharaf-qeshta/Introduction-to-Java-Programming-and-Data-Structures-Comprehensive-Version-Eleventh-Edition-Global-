package chapter_thirty_six.samples;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Listing 36.3 WorldClockApp.java
 * */
public class WorldClockApp extends Application
{
    @Override // Override the start method in the Application class
    public void start(Stage primaryStage)
    {
        // Create a scene and place it in the stage
        Scene scene = new Scene(new WorldClockControl(), 450, 350);
        primaryStage.setTitle("WorldClockApp"); // Set the stage title
        primaryStage.setScene(scene); // Place the scene in the stage
        primaryStage.show(); // Display the stage
    }
}
