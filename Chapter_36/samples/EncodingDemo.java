package chapter_thirty_six.samples;

import java.util.*;
import java.io.*;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.scene.text.Text;

public class EncodingDemo extends Application
{
    @Override // Override the start method in the Application class
    public void start(Stage primaryStage) throws Exception
    {
        try (
                PrintWriter output = new PrintWriter("temp.txt", "GB18030");
        )
        {
            output.print("\u6B22\u8FCE Welcome \u03b1\u03b2\u03b3");
        }
        try (
                Scanner input = new Scanner(new File("temp.txt"), "GB18030");
        )
        {
            StackPane pane = new StackPane();
            pane.getChildren().add(new Text(input.nextLine()));

            // Create a scene and place it in the stage
            Scene scene = new Scene(pane, 200, 200);
            primaryStage.setTitle("EncodingDemo"); // Set the stage title
            primaryStage.setScene(scene); // Place the scene in the stage
            primaryStage.show(); // Display the stage
        }
    }
}

