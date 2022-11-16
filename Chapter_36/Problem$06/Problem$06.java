package chapter_thirty_six;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.text.NumberFormat;
import java.util.Locale;

/**
 * 36.6 (Convert dollars to other currencies) Write a program that converts U.S. dollars to
 * Canadian dollars, German marks, and British pounds, as shown in Figure 36.18.
 * The user enters the U.S. dollar amount and the conversion rate, and clicks the Convert
 * button to display the converted amount
 *
 *
 * @author Sharaf Qeshta
 * */
public class Problem$06 extends Application
{
    @Override
    public void start(Stage stage)
    {
        Label lblHeader = new Label("Enter Dollar Amount");

        Label lblUSDollars = new Label("US Dollars");
        TextField txtUSDollars = new TextField();
        txtUSDollars.setPrefColumnCount(24);
        Button btnConvert = new Button("Convert");

        HBox row1 = new HBox(lblUSDollars, txtUSDollars, btnConvert);

        Label lblDisplayChange = new Label("Display Change");

        GridPane currencies = new GridPane();
        currencies.add(new Label("Exchange Rate"), 1, 0);
        currencies.add(new Label("Converted Amount"), 2, 0);
        currencies.add(new Label("Canadian Dollars"), 0,1);
        TextField txtCanadianDollarsExchange = new TextField();
        currencies.add(txtCanadianDollarsExchange, 1, 1);
        TextField txtCanadianDollarsAmount = new TextField();
        currencies.add(txtCanadianDollarsAmount, 2, 1);
        currencies.add(new Label("Euro"), 0, 2);
        TextField txtEuroExchange = new TextField();
        currencies.add(txtEuroExchange, 1, 2);
        TextField txtEuroAmount = new TextField();
        currencies.add(txtEuroAmount, 2, 2);
        currencies.add(new Label("British Pounds"), 0, 3);
        TextField txtBritishPoundsExchange = new TextField();
        currencies.add(txtBritishPoundsExchange, 1, 3);
        TextField txtBritishPoundsAmount = new TextField();
        currencies.add(txtBritishPoundsAmount, 2, 3);

        VBox pane = new VBox(10, lblHeader, row1, lblDisplayChange, currencies);
        Scene scene = new Scene(pane, 400, 250);
        stage.setScene(scene);
        stage.setTitle("Problem$06");
        stage.show();

        btnConvert.setOnAction(e ->
        {
            double amount, euroExchange,
                    canadianDollarsExchange, britishPoundExchange;
            try
            {
                amount = Double.parseDouble(txtUSDollars.getText().trim());
                euroExchange = Double.parseDouble(txtEuroExchange.getText().trim());
                canadianDollarsExchange = Double.parseDouble
                        (txtCanadianDollarsExchange.getText().trim());
                britishPoundExchange = Double.parseDouble
                        (txtBritishPoundsExchange.getText().trim());
            }
            catch (Exception exception)
            {
                exception.printStackTrace();
                return;
            }

            NumberFormat canadaFormat =
                    NumberFormat.getCurrencyInstance(Locale.CANADA);
            NumberFormat britainFormat =
                    NumberFormat.getCurrencyInstance(Locale.UK);
            NumberFormat euroFormat =
                    NumberFormat.getCurrencyInstance(Locale.GERMANY);

            txtCanadianDollarsAmount.setText(canadaFormat.format(amount
                    * canadianDollarsExchange));
            txtBritishPoundsAmount.setText(britainFormat.format(amount
                    * britishPoundExchange));
            txtEuroAmount.setText(euroFormat.format(amount * euroExchange));
        });
    }
}
