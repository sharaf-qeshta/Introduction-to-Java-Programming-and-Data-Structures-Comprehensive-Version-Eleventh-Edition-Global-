package chapter_thirty_three;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.io.DataOutputStream;
import java.io.File;
import java.io.RandomAccessFile;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

public class Problem$04Server extends Application
{
    public static final String NAME = "localhost";
    public static final int PORT = 8_000;
    private static final String COUNT_FILE_PATH = "src/chapter_thirty_three/count.dat";

    @Override
    public void start(Stage stage)
    {
        TextArea connectionStatus = new TextArea();
        StackPane pane = new StackPane(connectionStatus);

        new Thread( () ->
        {
            try
            {
                ServerSocket serverSocket = new ServerSocket(PORT);
                Platform.runLater(() -> connectionStatus.appendText("\nProblem$04Server started at " + new Date()));
                int i = 0;
                while (true)
                {
                    Socket socket = serverSocket.accept();
                    String ip= (((InetSocketAddress) socket.getRemoteSocketAddress()).getAddress())
                            .toString().replace("/","");

                    ClientHandler handler = new ClientHandler(socket);
                    new Thread(handler).start();

                    int finalI = i;
                    Platform.runLater(() -> connectionStatus.appendText("\nStarting Thread " + finalI));
                    Platform.runLater(() -> connectionStatus.appendText("\nClient IP /"+ip));
                    i++;
                }
            }
            catch (Exception exception)
            {
                exception.printStackTrace();
                System.exit(-1);
            }
        }).start();

        Scene scene = new Scene(pane, 500, 500);
        stage.setTitle("Problem$04Server");
        stage.setScene(scene);
        stage.show();
    }


    private static class ClientHandler implements Runnable
    {
        private DataOutputStream toClient;

        public ClientHandler(Socket socket)
        {
            try
            {
                toClient = new DataOutputStream(socket.getOutputStream());
            }
            catch (Exception exception)
            {
                exception.printStackTrace();
                System.exit(-1);
            }
        }

        @Override
        public void run()
        {
            try
            {
                int currentUser = increment();
                toClient.writeInt(currentUser);
                toClient.flush();
            }
            catch (Exception exception)
            {
                exception.printStackTrace();
                System.exit(-1);
            }
        }

        public synchronized int increment()
        {
            try (RandomAccessFile file = new RandomAccessFile(new File(COUNT_FILE_PATH), "rw"))
            {
                int x = 0;
                try
                {
                    x = file.readInt();
                }
                catch (Exception ignored) { }
                file.setLength(0);
                file.writeInt(x+1);
                return x;
            }
            catch (Exception exception)
            {
                exception.printStackTrace();
                System.exit(-1);
            }
            return -1; // to make compiler happy
        }
    }
}
