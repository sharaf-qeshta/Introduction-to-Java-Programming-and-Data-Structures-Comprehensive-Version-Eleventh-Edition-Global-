package chapter_thirty_three;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;

public class Problem$10Client extends Application
{
    DataOutputStream toServer;
    @Override
    public void start(Stage stage)
    {
        GridPane gridPane = new GridPane();

        gridPane.add(new Label("Name"), 0, 0);
        TextField txtName = new TextField();
        txtName.setPrefColumnCount(12);
        gridPane.add(txtName, 1, 0);

        gridPane.add(new Label("Enter Text: "), 0, 1);
        TextField txtMessage = new TextField();
        txtMessage.setPrefColumnCount(12);
        gridPane.add(txtMessage, 1, 1);

        TextArea chat = new TextArea();
        chat.setEditable(false);
        chat.setMinWidth(250);

        try
        {
            Socket socket = new Socket("localhost", 8_000);
            DataInputStream fromServer = new DataInputStream(socket.getInputStream());
            toServer = new DataOutputStream(socket.getOutputStream());

            new Thread( () ->
            {
                try
                {
                    while (true)
                    {
                        String message = fromServer.readUTF();
                        Platform.runLater(() -> chat.appendText("\n" + message));
                    }
                }
                catch (Exception exception)
                {
                    exception.printStackTrace();
                }
            }).start();
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
            System.exit(-1);
        }


        txtMessage.setOnAction(e ->
        {
            try
            {
                String name = txtName.getText().trim();
                String message = txtMessage.getText().trim();
                toServer.writeUTF(name + " : " + message);
                toServer.flush();
            }
            catch (Exception exception)
            {
                exception.printStackTrace();
            }
        });

        VBox pane = new VBox(5, gridPane, chat);

        Scene scene = new Scene(pane, 250, 250);
        stage.setScene(scene);
        stage.setTitle("Problem$10Client");
        stage.show();
    }
}
