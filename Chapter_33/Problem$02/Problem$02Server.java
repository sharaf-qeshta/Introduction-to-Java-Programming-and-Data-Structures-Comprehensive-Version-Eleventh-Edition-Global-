package chapter_thirty_three;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

public class Problem$02Server extends Application
{
    public static final String NAME = "localhost";
    public static final int PORT = 8_000;

    @Override
    public void start(Stage stage)
    {
        TextArea connectionStatus = new TextArea();
        StackPane pane = new StackPane(connectionStatus);

        new Thread(() ->
        {
            try
            {
                ServerSocket serverSocket = new ServerSocket(PORT);
                Platform.runLater(()
                        -> connectionStatus.setText("Problem$02Server started at " + new Date()));
                Socket socket = serverSocket.accept();
                Platform.runLater(() ->
                        connectionStatus.setText(connectionStatus.getText() + "\n"
                                + "Connected to client at " + new Date()));

                DataInputStream fromClient = new DataInputStream(socket.getInputStream());
                DataOutputStream toClient = new DataOutputStream(socket.getOutputStream());

                while (true)
                {
                    double weight = fromClient.readDouble();
                    double height = fromClient.readDouble();

                    double bmi = weight/(height * height);
                    String status;
                    if (bmi < 18.5)
                        status = "Under Weight";
                    else if (bmi < 25)
                        status = "Normal";
                    else if (bmi < 30)
                        status = "Over Weight";
                    else if (bmi < 35)
                        status = "Obesity (Class I)";
                    else if (bmi < 40)
                        status = "Obesity (Class II)";
                    else
                        status = "Extreme Obesity";

                    String finalStatus = status;
                    Platform.runLater(() -> connectionStatus.setText(connectionStatus.getText()
                            + "\n" + "Weight : " + weight + "\nHeight: " + height + "\nBMI: " + bmi
                            + "\nStatus " + finalStatus));
                    toClient.writeUTF(finalStatus);
                    toClient.flush();
                }
            }
            catch (Exception exception)
            {
                exception.printStackTrace();
            }
        }).start();

        Scene scene = new Scene(pane, 500, 500);
        stage.setScene(scene);
        stage.setTitle("Problem$02Server");
        stage.show();
    }
}
