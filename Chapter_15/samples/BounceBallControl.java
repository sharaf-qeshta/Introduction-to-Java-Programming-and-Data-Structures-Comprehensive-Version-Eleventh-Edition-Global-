package chapter_fifteen.samples;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;

/**
 * Listing 15.18 BounceBallControl.java
 */
public class BounceBallControl extends Application
{
    @Override // Override the start method in the Application class
    public void start(Stage primaryStage)
    {
        BallPane ballPane = new BallPane(); // Create a ball pane

        // Pause and resume animation
        ballPane.setOnMousePressed(e -> ballPane.pause());
        ballPane.setOnMouseReleased(e -> ballPane.play());

        // Increase and decrease animation
        ballPane.setOnKeyPressed(e ->
        {
            if (e.getCode() == KeyCode.UP)
            {
                ballPane.increaseSpeed();
            }
            else if (e.getCode() == KeyCode.DOWN)
            {
                ballPane.decreaseSpeed();
            }
        });

        // Create a scene and place it in the stage
        Scene scene = new Scene(ballPane, 250, 150);
        primaryStage.setTitle("BounceBallControl"); // Set the stage title
        primaryStage.setScene(scene); // Place the scene in the stage
        primaryStage.show(); // Display the stage

        // Must request focus after the primary stage is displayed
        ballPane.requestFocus();
    }
}
