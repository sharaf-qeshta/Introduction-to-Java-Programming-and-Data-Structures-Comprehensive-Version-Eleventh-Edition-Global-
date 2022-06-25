package chapter_fifteen.samples;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

/**
 * Listing 15.1 HandleEvent.java
 */
public class HandleEvent extends Application
{
    @Override // Override the start method in the Application class
    public void start(Stage primaryStage)
    {
        // Create a pane and set its properties
        HBox pane = new HBox(10);
        pane.setAlignment(Pos.CENTER);
        Button btOK = new Button("OK");
        Button btCancel = new Button("Cancel");
        OKHandlerClass handler1 = new OKHandlerClass();
        btOK.setOnAction(handler1);
        CancelHandlerClass handler2 = new CancelHandlerClass();
        btCancel.setOnAction(handler2);
        pane.getChildren().addAll(btOK, btCancel);

        // Create a scene and place it in the stage
        Scene scene = new Scene(pane);
        primaryStage.setTitle("HandleEvent"); // Set the stage title
        primaryStage.setScene(scene); // Place the scene in the stage
        primaryStage.show(); // Display the stage
    }
}

class OKHandlerClass implements EventHandler<ActionEvent>
{
    @Override
    public void handle(ActionEvent e)
    {
        System.out.println("OK button clicked");
    }
}

class CancelHandlerClass implements EventHandler<ActionEvent>
{
    @Override
    public void handle(ActionEvent e)
    {
        System.out.println("Cancel button clicked");
    }
}
