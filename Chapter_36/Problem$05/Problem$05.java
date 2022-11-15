package chapter_thirty_six;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * *36.5 (Compute loan amortization schedule) Rewrite Exercise 5.22 using JavaFX, as
 * shown in Figure 36.17. The program allows the user to set the loan amount, loan
 * period, and interest rate, and displays the corresponding interest, principal, and
 * balance in the currency format.
 *
 *
 * @author Sharaf Qeshta
 * */
public class Problem$05 extends Application
{
    @Override
    public void start(Stage stage)
    {
        Label lblHeader = new Label
                ("Enter Loan Amount, Number of Years, and Annual Interest Rate");
        Button btnDisplaySchedule = new Button("Display Loan Schedule");
        HBox header = new HBox(5, lblHeader, btnDisplaySchedule);
        header.setAlignment(Pos.CENTER);

        Label lblLoanAmount = new Label("Loan Amount         ");
        TextField txtLoanAmount = new TextField();
        HBox row1 = new HBox(20, lblLoanAmount, txtLoanAmount);


        Label lblYears = new Label("Number of Years     ");
        TextField txtYears = new TextField();
        HBox row2 = new HBox(20, lblYears, txtYears);


        Label lblInterestRate = new Label("Annual Interest Rate");
        TextField txtInterestRate = new TextField();
        HBox row3 = new HBox(20, lblInterestRate, txtInterestRate);


        TextArea taResult = new TextArea();
        taResult.setMinWidth(500); taResult.setMinHeight(250);
        taResult.setEditable(false);

        VBox pane = new VBox(5, header, row1, row2, row3, taResult);
        Scene scene = new Scene(pane, 500, 500);
        stage.setTitle("Problem$05");
        stage.setScene(scene);
        stage.show();


        btnDisplaySchedule.setOnAction(e ->
        {
            taResult.setText("");
            double amount, interest;
            int years;
            try
            {
                amount = Double.parseDouble(txtLoanAmount.getText().trim());
                interest = Double.parseDouble(txtInterestRate.getText().trim());
                years = Integer.parseInt(txtYears.getText().trim());
            }
            catch (Exception exception)
            {
                taResult.setText(exception.getMessage());
                return;
            }

            double balance = amount;
            double monthlyInterestRate = interest / (1200 * years);
            double principal;
            double monthlyPayment = balance/(12*years)
                    + (monthlyInterestRate * balance/(12*years));

            taResult.appendText("Monthly Payment: "
                    + String.format("%.3f", monthlyPayment) + "\n");
            taResult.appendText("Total Payment: "
                    + String.format("%.3f", (monthlyPayment*years * 12)) + "\n\n\n");

            taResult.appendText("Payment#\t\tInterest\t\tPrincipal\t\tBalance\n");
            for (int i = 1; i <= years * 12; i++)
            {
                double interest_ = monthlyInterestRate * balance;
                principal = monthlyPayment - interest_;
                balance = balance - principal;
                taResult.appendText(i + "\t\t\t\t" + String.format("%.3f", interest_)
                        + "\t\t\t" + String.format("%.3f", principal)
                        + "\t\t\t" + String.format("%.3f", balance) + "\n");
            }
        });
    }
}
