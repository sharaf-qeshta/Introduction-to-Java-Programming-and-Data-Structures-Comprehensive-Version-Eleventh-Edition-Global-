package chapter_thirty_three;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.io.DataOutputStream;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

public class Problem$05Server extends Application
{
    public static final String NAME = "localhost";
    public static final int PORT = 8_000;

    @Override
    public void start(Stage stage)
    {
        TextArea textArea = new TextArea();
        StackPane pane = new StackPane(textArea);


        new Thread(() ->
        {
            try
            {
                ServerSocket serverSocket = new ServerSocket(PORT);
                Platform.runLater(()
                        -> textArea.setText("Problem$05Server started at " + new Date()));
                Socket socket = serverSocket.accept();
                Platform.runLater(() ->
                        textArea.setText(textArea.getText() + "\n"
                                + "Connected to client at " + new Date()));

                ObjectInputStream fromClient = new ObjectInputStream(socket.getInputStream());

                DataOutputStream toClient = new DataOutputStream(socket.getOutputStream());

                while (true)
                {
                    Loan loan = (Loan) fromClient.readObject();

                    double annualInterestRate = loan.getInterestRate();
                    double years = loan.getYears();
                    double amount = loan.getAmount();

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
                    Platform.runLater(() -> textArea.setText(textArea.getText()
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
            }
        }).start();

        Scene scene = new Scene(pane, 500, 500);
        stage.setScene(scene);
        stage.setTitle("Problem$05Server");
        stage.show();
    }
}
