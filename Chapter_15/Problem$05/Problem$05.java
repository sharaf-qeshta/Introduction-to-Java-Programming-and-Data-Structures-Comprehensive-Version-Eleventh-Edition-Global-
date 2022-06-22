package chapter_fifteen;

import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.util.ArrayList;

/**
 * *15.5 (Calculate final velocity) Write a program that prompts the users to enter
 * initial velocity, acceleration, and time to compute final velocity, as shown in
 * Figure 15.27b. (vf = v0 + acceleration * time.)
 *
 * @author Sharaf Qeshta
 * */
public class Problem$05 extends Application
{
    private static final ArrayList<TextField> INPUTS = new ArrayList<>();
    public static void main(String[] args)
    {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage)
    {
        GridPane pane = new GridPane();
        pane.setAlignment(Pos.CENTER);
        pane.setVgap(10);
        pane.setHgap(10);

        String[] phrase = {"Investment Amount: ", "Number Of Years: ",
                "Annual Interest Rate: ", "Future Value: "};

        for (int i = 0; i < phrase.length; i++)
        {
            Label label = new Label(phrase[i]);
            TextField input = new TextField();
            INPUTS.add(input);
            pane.add(label, 0, i);
            pane.add(input, 1, i);
        }

        INPUTS.get(3).setEditable(false);

        Button calculate = new Button("Calculate");
        GridPane.setHalignment(calculate, HPos.RIGHT);
        pane.add(calculate, 1, phrase.length);

        calculate.setOnAction(e -> {
            double investmentAmount = Double.parseDouble(INPUTS.get(0).getText());
            double years = Double.parseDouble(INPUTS.get(1).getText());
            double interestRate = Double.parseDouble(INPUTS.get(2).getText());
            INPUTS.get(3).setText(String.format("$%.2f", investmentAmount + interestRate * years));
        });

        Scene scene = new Scene(pane, 500, 500);
        primaryStage.setTitle("Problem$05");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
