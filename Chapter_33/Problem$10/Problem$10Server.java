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
import java.util.ArrayList;
import java.util.Date;

public class Problem$10Server extends Application
{
    @Override
    public void start(Stage stage)
    {
        TextArea serverStatus = new TextArea();
        StackPane stackPane = new StackPane(serverStatus);

        new Thread( () ->
        {
            try
            {
                ServerSocket serverSocket = new ServerSocket(8_000);
                Platform.runLater(() -> serverStatus.appendText("MultiThreadedServer started at "
                        + new Date()));

                while (true)
                {
                    Socket socket = serverSocket.accept();
                    new Thread(new ClientHandler(socket)).start();
                    Platform.runLater(() -> serverStatus.appendText
                            ("\nConnection from " + socket + " at " + new Date()));
                }
            }
            catch (Exception exception)
            {
                exception.printStackTrace();
                System.exit(-1);
            }
        }).start();

        Scene scene = new Scene(stackPane, 500, 250);
        stage.setScene(scene);
        stage.setTitle("Problem$10Server");
        stage.show();
    }

    private static class ClientHandler implements Runnable
    {
        private static final ArrayList<ClientHandler> CLIENTS
                = new ArrayList<>();

        private DataInputStream fromClient;
        private DataOutputStream toClient;
        private Socket socket;

        public ClientHandler(Socket socket)
        {
            try
            {
                this.socket = socket;
                fromClient = new DataInputStream(socket.getInputStream());
                toClient = new DataOutputStream(socket.getOutputStream());
                CLIENTS.add(this);
            }
            catch (Exception exception)
            {
               try
               {
                    socket.close();
                    CLIENTS.remove(this);
               }
               catch (Exception exception1)
               {
                   exception1.printStackTrace();
                   System.exit(-1);
               }
               exception.printStackTrace();
            }
        }

        @Override
        public void run()
        {
            try
            {
                while (true)
                {
                    String message = fromClient.readUTF();
                    for (ClientHandler client: CLIENTS)
                    {
                        client.toClient.writeUTF(message);
                        client.toClient.flush();
                    }
                }
            }
            catch (Exception exception)
            {
                exception.printStackTrace();
                try
                {
                    socket.close();
                    CLIENTS.remove(this);
                }
                catch (Exception exception1)
                {
                    exception1.printStackTrace();
                    System.exit(-1);
                }
            }
        }
    }
}
