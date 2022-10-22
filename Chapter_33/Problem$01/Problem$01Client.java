package chapter_thirty_three;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;

public class Problem$01Client extends Application
{
    private DataOutputStream toServer = null;
    private DataInputStream fromServer = null;

    @Override
    public void start(Stage stage)
    {
        VBox pane = new VBox(5);
        pane.setAlignment(Pos.CENTER);

        GridPane dataContainer = new GridPane();

        dataContainer.add(new Label("Annual Interest Rate: "), 0, 0);
        TextField annualInterestRate = new TextField();
        annualInterestRate.setPrefColumnCount(12);
        dataContainer.add(annualInterestRate, 1, 0);

        dataContainer.add(new Label("Number of Years: "), 0, 1);
        TextField years = new TextField();
        years.setPrefColumnCount(12);
        dataContainer.add(years, 1, 1);

        Button submit = new Button("Submit");
        dataContainer.add(submit, 2, 1);

        dataContainer.add(new Label("Loan Amount: "), 0, 2);
        TextField amount = new TextField();
        amount.setPrefColumnCount(12);
        dataContainer.add(amount, 1, 2);

        TextArea connectionStatus = new TextArea();
        pane.getChildren().addAll(dataContainer, connectionStatus);

        Scene scene = new Scene(pane, 500, 500);
        stage.setScene(scene);
        stage.setTitle("Problem$01Client");
        stage.show();

        submit.setOnAction(e ->
        {
            double interestRate_ = Double.parseDouble(annualInterestRate.getText());
            int years_ = Integer.parseInt(years.getText());
            double amount_ = Double.parseDouble(amount.getText());

            try
            {
                toServer.writeDouble(interestRate_);
                toServer.flush();
                toServer.writeInt(years_);
                toServer.flush();
                toServer.writeDouble(amount_);
                toServer.flush();

                double total = fromServer.readDouble();
                double monthlyPayment = fromServer.readDouble();

                String output = "Annual Interest Rate: " + interestRate_;
                output += "\nNumber of Years: " + years_;
                output += "\nLoan Amount: " + amount_;
                output += "\nMonthly Payment: " + monthlyPayment;
                output += "\nTotal Payment: " + total;

                connectionStatus.setText(connectionStatus.getText() + "\n" + output);
            }
            catch (Exception exception)
            {
                exception.printStackTrace();
            }

        });

        try
        {
            Socket socket = new Socket(Problem$01Server.NAME, Problem$01Server.PORT);
            toServer = new DataOutputStream(socket.getOutputStream());
            fromServer = new DataInputStream(socket.getInputStream());
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
        }
    }
}
