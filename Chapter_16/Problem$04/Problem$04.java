package chapter_sixteen;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.text.DecimalFormat;

/**
 * *16.4 (Create a Celsius/Fahrenheit converter) Write a program that converts Celsius
 * and Fahrenheit, as shown in Figure 16.37b. If you enter a value in the Celsius
 * text field and press the Enter key, the corresponding Fahrenheit measurement is
 * displayed in the Fahrenheit text field. Likewise, if you enter a value in the
 * Fahrenheit text field and press the Enter key, the corresponding Celsius measurement
 * is displayed in the Celsius text field.
 *
 *
 * @author Sharaf Qeshtaa
 * */
public class Problem$04 extends Application
{

    public static void main(String[] args)
    {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage)
    {
        DecimalFormat df = new DecimalFormat(".0");

        GridPane pane = new GridPane();
        pane.setAlignment(Pos.CENTER);
        pane.setHgap(10); pane.setVgap(10);

        Label celsiusLabel = new Label("Celsius");
        Label fahrenheitLabel = new Label("Fahrenheit");

        TextField celsiusInput = new TextField();
        TextField fahrenheitInput = new TextField();

        pane.add(celsiusLabel, 0, 0);
        pane.add(celsiusInput, 1, 0);

        pane.add(fahrenheitLabel, 0, 1);
        pane.add(fahrenheitInput, 1, 1);

        celsiusInput.setOnAction(e ->
        {
            double celsius;
            try
            {
                celsius = Double.parseDouble(celsiusInput.getText());
            }
            catch (Exception ex)
            {
                celsiusInput.setText("Numeric Value Required");
                return;
            }

            double fahrenheit = (celsius * (9/5.0)) + 32;
            fahrenheitInput.setText(df.format(fahrenheit));
        });

        fahrenheitInput.setOnAction(e ->
        {
            double fahrenheit;
            try
            {
                fahrenheit = Double.parseDouble(fahrenheitInput.getText());
            }
            catch (Exception ex)
            {
                fahrenheitInput.setText("Numeric Value Required");
                return;
            }

            double celsius = (fahrenheit - 32) * (5.0/9.0);
            celsiusInput.setText(df.format(celsius));
        });


        Scene scene = new Scene(pane, 450, 170);
        primaryStage.setTitle("Problem$04");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
