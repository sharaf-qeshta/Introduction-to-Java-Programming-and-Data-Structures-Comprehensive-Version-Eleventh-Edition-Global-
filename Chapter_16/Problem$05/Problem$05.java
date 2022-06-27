package chapter_sixteen;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 * *16.5 (Convert numbers) Write a program that converts among decimal, hex, and binary
 * numbers, as shown in Figure 16.37c. When you enter a decimal value in the decimal-value
 * text field and press the Enter key, its corresponding hex and binary
 * numbers are displayed in the other two text fields. Likewise, you can enter values
 * in the other fields and convert them accordingly. (Hint: Use the Integer
 * .parseInt(s, radix) method to parse a string to a decimal and use Integer
 * .toHexString(decimal) and Integer.toBinaryString(decimal) to
 * obtain a hex number or a binary number from a decimal.)
 *
 *
 * @author Sharaf Qesha
 * */
public class Problem$05 extends Application
{
    public static void main(String[] args)
    {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage)
    {
        GridPane pane = new GridPane();
        pane.setAlignment(Pos.CENTER);
        pane.setHgap(10); pane.setVgap(10);

        Label integerLabel = new Label("Decimal");
        Label hexLabel = new Label("Hex");
        Label binaryLabel = new Label("Binary");

        TextField integerInput = new TextField();
        TextField hexInput = new TextField();
        TextField binaryInput = new TextField();

        pane.add(integerLabel, 0, 0);
        pane.add(integerInput, 1, 0);

        pane.add(hexLabel, 0, 1);
        pane.add(hexInput, 1, 1);

        pane.add(binaryLabel, 0, 2);
        pane.add(binaryInput, 1, 2);


        integerInput.setOnAction(e ->
        {
            int integer;
            try
            {
                integer = Integer.parseInt(integerInput.getText());
            }
            catch (Throwable t)
            {
                integerInput.setText("Decimal Type Required");
                return;
            }

            hexInput.setText(Integer.toHexString(integer));
            binaryInput.setText(Integer.toBinaryString(integer));
        });

        Scene scene = new Scene(pane, 450, 170);
        primaryStage.setTitle("Problem$05");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
