package chapter_thirty_three;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;

public class Problem$09Client extends Application
{
    DataInputStream fromServer;
    DataOutputStream toServer;

    @Override
    public void start(Stage stage)
    {
        Label serverLabel = new Label("Server");
        TextArea received = new TextArea();
        received.setMinWidth(250);
        received.setEditable(false);

        Label clientLabel = new Label("Client");
        TextArea sent = new TextArea();
        sent.setMinWidth(250);

        try
        {
            Socket socket = new Socket("localhost", 8_000);
            fromServer = new DataInputStream(socket.getInputStream());
            toServer = new DataOutputStream(socket.getOutputStream());

            new Thread(() ->
            {
                while (true)
                {
                    try
                    {
                        String message = fromServer.readUTF();
                        Platform.runLater( () -> received.appendText("\n" + message));
                    }
                    catch (Exception exception)
                    {
                        exception.printStackTrace();
                    }
                }
            }).start();
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
        }

        VBox pane = new VBox(5, serverLabel, received, clientLabel, sent);

        sent.setOnKeyPressed(e ->
        {
            if (e.getCode() == KeyCode.ENTER)
            {
                 try
                 {
                     toServer.writeUTF(sent.getText().trim());
                     toServer.flush();
                     sent.setText("");
                 }
                 catch (Exception exception)
                 {
                     exception.printStackTrace();
                 }
            }
        });

        Scene scene = new Scene(pane, 250, 250);
        stage.setScene(scene);
        stage.setTitle("Problem$09Client");
        stage.show();
    }
}
