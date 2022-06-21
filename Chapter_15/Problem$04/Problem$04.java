package chapter_fifteen;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * *15.4 (Create a simple calculator) Write a program to perform addition, subtraction,
 * multiplication, and division, as shown in Figure 15.27a.
 *
 *
 * @author Sharaf Qeshta
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
        VBox pane = new VBox();
        pane.setAlignment(Pos.CENTER);
        pane.setSpacing(20);

        HBox hBox1 = new HBox();
        hBox1.setAlignment(Pos.CENTER);
        hBox1.setSpacing(10);

        Label number1 = new Label("Number 1: ");
        TextField number1Input = new TextField();
        number1Input.setPrefWidth(80);

        Label number2 = new Label("Number 2: ");
        TextField number2Input = new TextField();
        number2Input.setPrefWidth(80);

        Label result = new Label("Result: ");
        TextField resultOutput = new TextField();
        resultOutput.setEditable(false);
        resultOutput.setPrefWidth(80);

        hBox1.getChildren().addAll(number1, number1Input,
                number2, number2Input, result, resultOutput);


        HBox hBox2 = new HBox();
        hBox2.setAlignment(Pos.CENTER);
        hBox2.setSpacing(10);

        Button add = new Button("Add");
        Button subtract = new Button("Subtract");
        Button multiply = new Button("Multiply");
        Button divide = new Button("Divide");

        hBox2.getChildren().addAll(add, subtract, multiply, divide);

        pane.getChildren().addAll(hBox1, hBox2);


        add.setOnAction(e -> {
            double n1 = Double.parseDouble(number1Input.getText());
            double n2 = Double.parseDouble(number2Input.getText());
            resultOutput.setText(String.format("%.2f", n1+n2));
        });

        subtract.setOnAction(e -> {
            double n1 = Double.parseDouble(number1Input.getText());
            double n2 = Double.parseDouble(number2Input.getText());
            resultOutput.setText(String.format("%.2f", n1-n2));
        });

        multiply.setOnAction(e -> {
            double n1 = Double.parseDouble(number1Input.getText());
            double n2 = Double.parseDouble(number2Input.getText());
            resultOutput.setText(String.format("%.2f", n1*n2));
        });

        divide.setOnAction(e -> {
            double n1 = Double.parseDouble(number1Input.getText());
            double n2 = Double.parseDouble(number2Input.getText());
            resultOutput.setText(String.format("%.2f", n1/n2));
        });

        Scene scene = new Scene(pane, 500, 500);
        primaryStage.setTitle("Problem$04");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
