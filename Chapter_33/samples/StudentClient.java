package chapter_thirty_three.samples;

import java.io.*;
import java.net.*;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

/**
 * Listing 33.6 StudentClient.java
 * */
public class StudentClient extends Application
{
    private TextField tfName = new TextField();
    private TextField tfStreet = new TextField();
    private TextField tfCity = new TextField();
    private TextField tfState = new TextField();
    private TextField tfZip = new TextField();

    // Button for sending a student to the server
    private Button btRegister = new Button("Register to the Server");

    // Host name or ip
    String host = "localhost";

    @Override // Override the start method in the Application class
    public void start(Stage primaryStage)
    {
        GridPane pane = new GridPane();
        pane.add(new Label("Name"), 0, 0);
        pane.add(tfName, 1, 0);
        pane.add(new Label("Street"), 0, 1);
        pane.add(tfStreet, 1, 1);
        pane.add(new Label("City"), 0, 2);
        HBox hBox = new HBox(2);
        pane.add(hBox, 1, 2);
        hBox.getChildren().addAll(tfCity, new Label("State"), tfState,
                new Label("Zip"), tfZip);
        pane.add(btRegister, 1, 3);
        GridPane.setHalignment(btRegister, HPos.RIGHT);

        pane.setAlignment(Pos.CENTER);
        tfName.setPrefColumnCount(15);
        tfStreet.setPrefColumnCount(15);
        tfCity.setPrefColumnCount(10);
        tfState.setPrefColumnCount(2);
        tfZip.setPrefColumnCount(3);

        btRegister.setOnAction(new ButtonListener());

        // Create a scene and place it in the stage
        Scene scene = new Scene(pane, 450, 200);
        primaryStage.setTitle("StudentClient"); // Set the stage title
        primaryStage.setScene(scene); // Place the scene in the stage
        primaryStage.show(); // Display the stage
    }

    /**
     * Handle button action
     */
    private class ButtonListener implements EventHandler<ActionEvent>
    {
        @Override
        public void handle(ActionEvent e)
        {
            try
            {
                // Establish connection with the server
                Socket socket = new Socket(host, 8000);

                // Create an output stream to the server
                ObjectOutputStream toServer =
                        new ObjectOutputStream(socket.getOutputStream());

                // Get text field
                String name = tfName.getText().trim();
                String street = tfStreet.getText().trim();
                String city = tfCity.getText().trim();
                String state = tfState.getText().trim();
                String zip = tfZip.getText().trim();

                // Create a Student object and send to the server
                StudentAddress s =
                        new StudentAddress(name, street, city, state, zip);
                toServer.writeObject(s);
            }
            catch (IOException ex)
            {
                ex.printStackTrace();
            }
        }
    }
}
