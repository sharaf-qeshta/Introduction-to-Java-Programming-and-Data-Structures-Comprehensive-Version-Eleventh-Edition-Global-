package chapter_thirty_three;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.DataInputStream;
import java.net.Socket;

public class Problem$04Client extends Application
{
    @Override
    public void start(Stage stage)
    {
        Text text = new Text();
        StackPane pane = new StackPane(text);

        new Thread( () ->
        {
            try
            {
                Socket socket = new Socket(Problem$04Server.NAME, Problem$04Server.PORT);
                DataInputStream fromServer = new DataInputStream(socket.getInputStream());

                int count = fromServer.readInt();

                Platform.runLater(() ->
                        text.setText("You are visitor " + count));
            }
            catch (Exception exception)
            {
                exception.printStackTrace();
                System.exit(-1);
            }
        }).start();

        Scene scene = new Scene(pane, 500, 500);
        stage.setScene(scene);
        stage.setTitle("Problem$04Client");
        stage.show();
    }
}
