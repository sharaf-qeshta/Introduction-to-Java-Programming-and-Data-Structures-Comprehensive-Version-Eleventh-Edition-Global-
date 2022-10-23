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

public class Problem$03Server extends Application
{
    public static final String NAME = "localhost";
    public static final int PORT = 8_000;

    @Override
    public void start(Stage stage)
    {
        TextArea status = new TextArea();
        StackPane pane = new StackPane(status);

        new Thread(() ->
        {
            try
            {
                ServerSocket serverSocket = new ServerSocket(PORT);
                status.setText("Problem$01Server started at " + new Date());

                while (true)
                {
                    Socket socket = serverSocket.accept();
                    ClientHandler handler = new ClientHandler(socket, status);
                    new Thread(handler).start();
                }
            }
            catch (Exception exception)
            {
                exception.printStackTrace();
                System.exit(-1);
            }
        }).start();


        Scene scene = new Scene(pane, 500, 500);
        stage.setScene(scene);
        stage.setTitle("Problem$03Server");
        stage.show();
    }

    private static class ClientHandler implements Runnable
    {
        private DataOutputStream toClient;
        private DataInputStream fromClient;
        private TextArea status;

        public ClientHandler(Socket socket, TextArea status)
        {
            Platform.runLater(() -> status.setText(status.getText() + "\n"
                    + "Connected to client at " + new Date()));
            try
            {
                toClient = new DataOutputStream(socket.getOutputStream());
                fromClient = new DataInputStream(socket.getInputStream());
            }
            catch (Exception exception)
            {
                exception.printStackTrace();
                System.exit(-1);
            }
            this.status = status;
        }

        @Override
        public void run()
        {
            try
            {
                while (true)
                {
                    double annualInterestRate = fromClient.readDouble();
                    double years = fromClient.readInt();
                    double amount = fromClient.readDouble();

                    double monthlyInterestRate = annualInterestRate / 1200;
                    double monthlyPayment = amount * monthlyInterestRate / (1
                            - 1 / Math.pow(1 + monthlyInterestRate, years * 12));
                    double total = monthlyPayment * 12 * years;

                    String output = "Annual Interest Rate: " + annualInterestRate;
                    output += "\nNumber of Years: " + years;
                    output += "\nLoan Amount: " + amount;
                    output += "\nMonthly Payment: " + monthlyPayment;
                    output += "\nTotal Payment: " + total;
                    String finalOutput = output;
                    Platform.runLater(() -> status.setText(status.getText()
                            + "\n" + finalOutput));

                    toClient.writeDouble(total);
                    toClient.flush();
                    toClient.writeDouble(monthlyPayment);
                    toClient.flush();
                }
            }
            catch (Exception exception)
            {
                exception.printStackTrace();
                System.exit(-1);
            }
        }
    }
}

