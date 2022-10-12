package chapter_thirty_one.samples;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

/**
 * Listing 31.18 FXMLDocumentController.java
 * */
public class FXMLDocumentController18
{
    @FXML
    private TextField tfNumber1, tfNumber2, tfResult;

    @FXML
    private void addButtonAction(ActionEvent event)
    {
        tfResult.setText(getResult('+') + "");
    }

    @FXML
    private void subtractButtonAction(ActionEvent event)
    {
        tfResult.setText(getResult('−') + "");
    }

    @FXML
    private void multiplyButtonAction(ActionEvent event)
    {
        tfResult.setText(getResult('*') + "");
    }

    @FXML
    private void divideButtonAction(ActionEvent event)
    {
        tfResult.setText(getResult('/') + "");
    }

    private double getResult(char op)
    {
        double number1 = Double.parseDouble(tfNumber1.getText());
        double number2 = Double.parseDouble(tfNumber2.getText());
        switch (op)
        {
            case '+':
                return number1 + number2;
            case '−':
                return number1 - number2;
            case '*':
                return number1 * number2;
            case '/':
                return number1 / number2;
        }
        return Double.NaN;
    }
}
