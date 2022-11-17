package chapter_thirty_six.samples;

import java.util.*;
import java.text.NumberFormat;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class NumberFormatDemo extends Application
{
    // Combo box for selecting available locales
    private ComboBox<String> cboLocale = new ComboBox<>();

    // Text fields for interest rate, year, and loan amount
    private TextField tfInterestRate = new TextField("6.75");
    private TextField tfNumberOfYears = new TextField("15");
    private TextField tfLoanAmount = new TextField("107000");
    private TextField tfFormattedInterestRate = new TextField();
    private TextField tfFormattedNumberOfYears = new TextField();
    private TextField tfFormattedLoanAmount = new TextField();

    // Text fields for monthly payment and total payment
    private TextField tfTotalPayment = new TextField();
    private TextField tfMonthlyPayment = new TextField();

    // Compute button
    private Button btCompute = new Button("Compute");

    // Current locale
    private Locale locale = Locale.getDefault();

    // Declare locales to store available locales
    private Locale locales[] = Calendar.getAvailableLocales();

    /**
     * Initialize the combo box
     */
    public void initializeComboBox()
    {
        // Add locale names to the combo box
        for (int i = 0; i < locales.length; i++)
            cboLocale.getItems().add(locales[i].getDisplayName());
    }

    @Override // Override the start method in the Application class
    public void start(Stage primaryStage)
    {
        initializeComboBox();

        // Pane to hold the combo box for selecting locales
        HBox hBox = new HBox(5);
        hBox.getChildren().addAll(
                new Label("Choose a Locale"), cboLocale);

        // Pane to hold the input
        GridPane gridPane = new GridPane();
        gridPane.add(new Label("Interest Rate"), 0, 0);
        gridPane.add(tfInterestRate, 1, 0);
        gridPane.add(tfFormattedInterestRate, 2, 0);
        gridPane.add(new Label("Number of Years"), 0, 1);
        gridPane.add(tfNumberOfYears, 1, 1);
        gridPane.add(tfFormattedNumberOfYears, 2, 1);
        gridPane.add(new Label("Loan Amount"), 0, 2);
        gridPane.add(tfLoanAmount, 1, 2);
        gridPane.add(tfFormattedLoanAmount, 2, 2);

        // Pane to hold the output
        GridPane gridPaneOutput = new GridPane();
        gridPaneOutput.add(new Label("Monthly Payment"), 0, 0);
        gridPaneOutput.add(tfMonthlyPayment, 1, 0);
        gridPaneOutput.add(new Label("Total Payment"), 0, 1);
        gridPaneOutput.add(tfTotalPayment, 1, 1);

        // Set text field alignment
        tfFormattedInterestRate.setAlignment(Pos.BASELINE_RIGHT);
        tfFormattedNumberOfYears.setAlignment(Pos.BASELINE_RIGHT);
        tfFormattedLoanAmount.setAlignment(Pos.BASELINE_RIGHT);
        tfTotalPayment.setAlignment(Pos.BASELINE_RIGHT);
        tfMonthlyPayment.setAlignment(Pos.BASELINE_RIGHT);

        // Set editable false
        tfFormattedInterestRate.setEditable(false);
        tfFormattedNumberOfYears.setEditable(false);
        tfFormattedLoanAmount.setEditable(false);
        tfTotalPayment.setEditable(false);
        tfMonthlyPayment.setEditable(false);

        VBox vBox = new VBox(5);
        vBox.getChildren().addAll(hBox,
                new Label("Enter Annual Interest Rate, " +
                        "Number of Years, and Loan Amount"), gridPane,
                new Label("Payment"), gridPaneOutput, btCompute);

        // Create a scene and place it in the stage
        Scene scene = new Scene(vBox, 400, 300);
        primaryStage.setTitle("NumberFormatDemo"); // Set the stage title
        primaryStage.setScene(scene); // Place the scene in the stage
        primaryStage.show(); // Display the stage

        // Register listeners
        cboLocale.setOnAction(e ->
        {
            locale = locales[cboLocale
                    .getSelectionModel().getSelectedIndex()];
            computeLoan();
        });

        btCompute.setOnAction(e -> computeLoan());
    }

    /**
     * Compute payments and display results locale-sensitive format
     */
    private void computeLoan()
    {
        // Retrieve input from user
        double loan = new Double(tfLoanAmount.getText()).doubleValue();
        double interestRate =
                new Double(tfInterestRate.getText()).doubleValue() / 1240;
        int numberOfYears =
                new Integer(tfNumberOfYears.getText()).intValue();

        // Calculate payments
        double monthlyPayment = loan * interestRate /
                (1 - (Math.pow(1 / (1 + interestRate), numberOfYears * 12)));
        double totalPayment = monthlyPayment * numberOfYears * 12;

        // Get formatters
        NumberFormat percentFormatter =
                NumberFormat.getPercentInstance(locale);
        NumberFormat currencyForm =
                NumberFormat.getCurrencyInstance(locale);
        NumberFormat numberForm = NumberFormat.getNumberInstance(locale);
        percentFormatter.setMinimumFractionDigits(2);

        // Display formatted input
        tfFormattedInterestRate.setText(
                percentFormatter.format(interestRate * 12));
        tfFormattedNumberOfYears.setText
                (numberForm.format(numberOfYears));
        tfFormattedLoanAmount.setText(currencyForm.format(loan));

        // Display results in currency format
        tfMonthlyPayment.setText(currencyForm.format(monthlyPayment));
        tfTotalPayment.setText(currencyForm.format(totalPayment));
    }
}

