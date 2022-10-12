package chapter_thirty_one;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * *31.21 (Use tab panes) Write a program using tab panes for performing integer and rational
 * number arithmetic as shown in Figure 31.58.
 *
 *
 * @author Sharaf Qeshta
 * */
public class Problem$21 extends Application
{
    @Override
    public void start(Stage stage)
    {
        TabPane tabPane = new TabPane();

        Tab integersOperations = new Tab("Integer Operations");

        Label integerCalculationLabel = new Label("Integer Calculation");

        HBox integerNumbersContainer = new HBox(5);
        integerNumbersContainer.setAlignment(Pos.CENTER);

        Label number1IntegerLabel = new Label("Number 1: ");
        TextField number1Integer = new TextField();
        number1Integer.setPrefColumnCount(6);

        Label number2IntegerLabel = new Label("Number 2: ");
        TextField number2Integer = new TextField();
        number2Integer.setPrefColumnCount(6);

        Label resultIntegerLabel = new Label("Result: ");
        TextField resultInteger = new TextField();
        resultInteger.setPrefColumnCount(6);
        resultInteger.setEditable(false);

        integerNumbersContainer.getChildren().addAll(number1IntegerLabel, number1Integer,
                number2IntegerLabel, number2Integer, resultIntegerLabel, resultInteger);

        Button addIntegers = new Button("Add");
        Button subtractIntegers = new Button("Subtract");
        Button multiplyIntegers = new Button("Multiply");
        Button divideIntegers = new Button("Divide");
        HBox integerOperationsContainer = new HBox(addIntegers, subtractIntegers,
                multiplyIntegers, divideIntegers);
        integerOperationsContainer.setAlignment(Pos.CENTER);

        VBox integersCalculation = new VBox(5, integerCalculationLabel,
                integerNumbersContainer, integerOperationsContainer);
        integersOperations.setContent(integersCalculation);


        Tab rationalsOperations = new Tab("Rational Operations");

        Label rationalCalculationLabel = new Label("Rational Calculation");

        HBox rationalNumbersContainer = new HBox(5);
        rationalNumbersContainer.setAlignment(Pos.CENTER);

        Label number1RationalLabel = new Label("Number 1: ");
        TextField number1Rational = new TextField();
        number1Rational.setPrefColumnCount(6);

        Label number2RationalLabel = new Label("Number 2: ");
        TextField number2Rational = new TextField();
        number2Rational.setPrefColumnCount(6);

        Label resultRationalLabel = new Label("Result: ");
        TextField resultRational = new TextField();
        resultRational.setPrefColumnCount(6);
        resultRational.setEditable(false);

        rationalNumbersContainer.getChildren().addAll(number1RationalLabel, number1Rational,
                number2RationalLabel, number2Rational, resultRationalLabel, resultRational);

        Button addRationals = new Button("Add");
        Button subtractRationals = new Button("Subtract");
        Button multiplyRationals = new Button("Multiply");
        Button divideRationals = new Button("Divide");
        HBox rationalOperationsContainer = new HBox(addRationals, subtractRationals,
                multiplyRationals, divideRationals);
        rationalOperationsContainer.setAlignment(Pos.CENTER);

        VBox rationalsCalculation = new VBox(5, rationalCalculationLabel,
                rationalNumbersContainer, rationalOperationsContainer);

        rationalsOperations.setContent(rationalsCalculation);

        tabPane.getTabs().addAll(integersOperations, rationalsOperations);

        Scene scene = new Scene(tabPane, 500, 250);
        stage.setTitle("Problem$21");
        stage.setScene(scene);
        stage.show();


        addIntegers.setOnAction(e ->
        {
            int x, y;
            try
            {
                x = Integer.parseInt(number1Integer.getText());
                y = Integer.parseInt(number2Integer.getText());
                resultInteger.setText((x + y) + "");
            }
            catch (Exception ignored) { }
        });

        subtractIntegers.setOnAction(e ->
        {
            int x, y;
            try
            {
                x = Integer.parseInt(number1Integer.getText());
                y = Integer.parseInt(number2Integer.getText());
                resultInteger.setText((x - y) + "");
            }
            catch (Exception ignored) { }
        });

        multiplyIntegers.setOnAction(e ->
        {
            int x, y;
            try
            {
                x = Integer.parseInt(number1Integer.getText());
                y = Integer.parseInt(number2Integer.getText());
                resultInteger.setText((x * y) + "");
            }
            catch (Exception ignored) { }
        });

        divideIntegers.setOnAction(e ->
        {
            int x, y;
            try
            {
                x = Integer.parseInt(number1Integer.getText());
                y = Integer.parseInt(number2Integer.getText());
                resultInteger.setText((x / y) + "");
            }
            catch (Exception ignored) { }
        });


        addRationals.setOnAction(e ->
        {
            double x, y;
            try
            {
                x = Double.parseDouble(number1Rational.getText());
                y = Double.parseDouble(number2Rational.getText());
                resultRational.setText((x + y) + "");
            }
            catch (Exception ignored) { }
        });


        subtractRationals.setOnAction(e ->
        {
            double x, y;
            try
            {
                x = Double.parseDouble(number1Rational.getText());
                y = Double.parseDouble(number2Rational.getText());
                resultRational.setText((x - y) + "");
            }
            catch (Exception ignored) { }
        });


        multiplyRationals.setOnAction(e ->
        {
            double x, y;
            try
            {
                x = Double.parseDouble(number1Rational.getText());
                y = Double.parseDouble(number2Rational.getText());
                resultRational.setText((x * y) + "");
            }
            catch (Exception ignored) { }
        });


        divideRationals.setOnAction(e ->
        {
            double x, y;
            try
            {
                x = Double.parseDouble(number1Rational.getText());
                y = Double.parseDouble(number2Rational.getText());
                resultRational.setText((x / y) + "");
            }
            catch (Exception ignored) { }
        });
    }
}
