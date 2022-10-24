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
import java.net.ServerSocket;
import java.net.Socket;

public class Problem$09Server extends Application
{
    private DataInputStream fromClient;
    private DataOutputStream toClient;
    @Override
    public void start(Stage stage)
    {
        Label serverLabel = new Label("Server");
        TextArea sent = new TextArea();
        sent.setMinWidth(250);

        Label clientLabel = new Label("Client");
        TextArea received = new TextArea();
        received.setMinWidth(250);
        received.setEditable(false);

        try
        {
            ServerSocket serverSocket = new ServerSocket(8_000);
            // the ui will not shown until the client join
            Socket socket = serverSocket.accept();

            fromClient = new DataInputStream(socket.getInputStream());
            toClient = new DataOutputStream(socket.getOutputStream());

            // thread for receiving data
            new Thread(() ->
            {
                while (true)
                {
                    try
                    {
                        String message = fromClient.readUTF();
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
            System.exit(-1);
        }

        VBox pane = new VBox(5, serverLabel, sent, clientLabel, received);

        sent.setOnKeyPressed(e ->
        {
            if (e.getCode() == KeyCode.ENTER)
            {
                try
                {
                    toClient.writeUTF(sent.getText().trim());
                    toClient.flush();
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
        stage.setTitle("Problem$09Server");
        stage.show();
    }
}
