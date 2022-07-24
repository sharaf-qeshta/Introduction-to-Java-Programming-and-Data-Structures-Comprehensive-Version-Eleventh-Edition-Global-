package chapter_twenty;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.File;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;
import java.util.Stack;

/**
 * 20.16 (Game: the 24-point card game) Improve Programming Exercise 20.15 by
 * adding another expression verifier text box below the card images that accept
 * prefix notations instead of infix notations. You have to write your own prefix
 * evaluator.
 *
 *
 * @author Sharaf Qeshta
 * */
public class Problem$16 extends Application
{
    private static final ArrayList<ImageView> IMAGES = new ArrayList<>();
    private static final ArrayList<Integer> NUMBERS = new ArrayList<>();
    private static final ArrayList<Integer> INDICES = new ArrayList<>();


    @Override
    public void start(Stage primaryStage)
    {
        getAllImages();
        Button findSolution = new Button("FIND SOLUTION");

        TextField evaluatedSolution = new TextField();
        evaluatedSolution.setEditable(false);
        evaluatedSolution.setPrefColumnCount(12);

        Button shuffle = new Button("SHUFFLE");

        HBox top = new HBox(10, findSolution, evaluatedSolution, shuffle);
        top.setAlignment(Pos.CENTER);

        selectRandomImages();
        HBox imagesContainer = new HBox(5, IMAGES.get(INDICES.get(0))
                , IMAGES.get(INDICES.get(1)), IMAGES.get(INDICES.get(2)),
                IMAGES.get(INDICES.get(3)));

        imagesContainer.setAlignment(Pos.CENTER);

        Label label = new Label("Enter an Expression (INFIX)");
        TextField solution = new TextField();
        solution.setPrefColumnCount(12);
        Button verifyInfix = new Button("VERIFY");
        HBox bottom = new HBox(10, label, solution, verifyInfix);
        bottom.setAlignment(Pos.CENTER);

        Label label2 = new Label("Enter an Expression (PREFIX)");
        TextField solution2 = new TextField();
        solution2.setPrefColumnCount(12);
        Button verifyPrefix = new Button("VERIFY");
        HBox bottom2 = new HBox(10, label2, solution2, verifyPrefix);
        bottom2.setAlignment(Pos.CENTER);

        Label status = new Label("Incorrect Answer");
        HBox statusBox = new HBox(status);
        statusBox.setAlignment(Pos.CENTER_LEFT);
        statusBox.setVisible(false);

        VBox pane = new VBox(10, top,
                imagesContainer, bottom, bottom2, statusBox);

        Scene scene = new Scene(pane, 500, 500);
        primaryStage.setTitle("Problem$16");
        primaryStage.setScene(scene);
        primaryStage.show();

        verifyInfix.setOnAction(e ->
        {
            String expression;
            if (solution.getText().trim().isEmpty())
                return;
            expression = solution.getText().trim();
            if (checkSolution(expression))
                status.setText("Correct Answer");
            else
                status.setText("Incorrect Answer");

            statusBox.setVisible(true);
        });

        verifyPrefix.setOnAction(e ->
        {
            String expression;
            if (solution2.getText().trim().isEmpty())
                return;
            expression = solution2.getText().trim();
            if (evaluateExpression(translate(expression)) == 24)
                status.setText("Correct Answer");
            else
                status.setText("Incorrect Answer");
            statusBox.setVisible(true);
        });

        findSolution.setOnAction(e-> evaluatedSolution.setText(findSolution()));

        shuffle.setOnAction(e->
        {
            shuffle();
            imagesContainer.getChildren().clear();
            imagesContainer.getChildren().addAll(IMAGES.get(INDICES.get(0))
                    , IMAGES.get(INDICES.get(1)), IMAGES.get(INDICES.get(2)),
                    IMAGES.get(INDICES.get(3)));
        });
    }


    /** translate prefix to infix */
    private static String translate(String prefix)
    {
        Scanner scanner = new Scanner(prefix);
        Stack<String> infix = new Stack<>();
        ArrayList<String> prefixContent = new ArrayList<>();
        while (scanner.hasNext())
            prefixContent.add(scanner.next());

        for (int i = prefixContent.size()-1; i > -1; i-- )
        {
            try
            {
                int value = Integer.parseInt(prefixContent.get(i));
                infix.push(value + "");
            }
            catch (Exception exception)
            {
                String operand1 = infix.pop();
                String operand2 = infix.pop();
                infix.push("(" + operand1 + prefixContent.get(i) + operand2 + ")");
            }
        }
        return infix.pop();
    }

    private static void getAllImages()
    {
        File file = new File("src/chapter_twenty/PNG-cards-1.3");
        File[] files = file.listFiles();
        IMAGES.clear();
        NUMBERS.clear();

        for (int i = 0; i < Objects.requireNonNull(files).length; i++)
        {
            ImageView imageView = new ImageView(files[i].getAbsolutePath());
            imageView.setFitWidth(100); imageView.setFitHeight(200);
            IMAGES.add(imageView);
            NUMBERS.add(getCardNumber(files[i].getName()));
        }
    }

    private static int getCardNumber(String cardName)
    {
        if (cardName.startsWith("13"))
            return 13;
        if (cardName.startsWith("12"))
            return 12;
        if (cardName.startsWith("11"))
            return 11;
        if (cardName.startsWith("10"))
            return 10;
        return cardName.charAt(0) - '0';
    }

    private static void selectRandomImages()
    {
        INDICES.clear();

        int index1 = (int) ((Math.random() * (IMAGES.size() * 2)) % IMAGES.size());
        int index2 = (int) ((Math.random() * (IMAGES.size() * 2)) % IMAGES.size());
        int index3 = (int) ((Math.random() * (IMAGES.size() * 2)) % IMAGES.size());
        int index4 = (int) ((Math.random() * (IMAGES.size() * 2)) % IMAGES.size());

        INDICES.add(index1); INDICES.add(index2); INDICES.add(index3); INDICES.add(index4);
    }

    private static boolean checkSolution(String expression)
    {
        return evaluateExpression(expression) == 24;
    }

    public static int evaluateExpression(String expression)
    {
        Stack<Integer> operandStack = new Stack<>();
        Stack<Character> operatorStack = new Stack<>();

        expression = insertBlanks(expression);
        String[] tokens = expression.split(" ");

        for (String token: tokens)
        {
            if (token.length() == 0)
                continue;
            else if (token.charAt(0) == '+' || token.charAt(0) == '-')
            {
                while (!operatorStack.isEmpty() &&
                        (operatorStack.peek() == '+' ||
                                operatorStack.peek() == '-' ||
                                operatorStack.peek() == '*' ||
                                operatorStack.peek() == '/'))
                    processAnOperator(operandStack, operatorStack);
                operatorStack.push(token.charAt(0));
            }
            else if (token.charAt(0) == '*' || token.charAt(0) == '/')
            {
                while (!operatorStack.isEmpty() &&
                        (operatorStack.peek() == '*' ||
                                operatorStack.peek() == '/'))
                    processAnOperator(operandStack, operatorStack);
                operatorStack.push(token.charAt(0));
            }
            else if(token.trim().charAt(0) =='(')
                operatorStack.push('(');

            else if (token.trim().charAt(0) ==')')
            {
                while (operatorStack.peek() != '(')
                    processAnOperator(operandStack, operatorStack);
                operatorStack.pop();
            }
            else
                operandStack.push(Integer.valueOf(token));
        }
        while (!operatorStack.isEmpty())
            processAnOperator(operandStack, operatorStack);
        return operandStack.pop();
    }


    public static void processAnOperator(
            Stack<Integer> operandStack, Stack<Character> operatorStack)
    {
        char op = operatorStack.pop();
        int op1 = operandStack.pop();
        int op2 = operandStack.pop();
        if (op == '+')
            operandStack.push(op2 + op1);
        else if (op == '-')
            operandStack.push(op2 - op1);
        else if (op == '*')
            operandStack.push(op2 * op1);
        else if (op == '/')
            operandStack.push(op2 / op1);
    }

    public static String insertBlanks(String s)
    {
        String result = "";
        for (int i = 0; i < s.length(); i++)
        {
            if (s.charAt(i) == '(' || s.charAt(i) == ')' ||
                    s.charAt(i) == '+' || s.charAt(i) == '-' ||
                    s.charAt(i) == '*' || s.charAt(i) == '/')
                result += " " + s.charAt(i) + " ";
            else
                result += s.charAt(i);
        }
        return result;
    }

    private static String findSolution()
    {
        String[] numbersArray = {NUMBERS.get(INDICES.get(0))+"", NUMBERS.get(INDICES.get(1))+""
                , NUMBERS.get(INDICES.get(2))+"", NUMBERS.get(INDICES.get(3))+""};
        return TwentyFourCardsSolver.getSolution(numbersArray);
    }

    private static void shuffle()
    {
        for (int i = 0; i < 8; i++)
        {
            int index1 = (int) ((Math.random() * (INDICES.size() * 2)) % INDICES.size());
            int index2 = (int) ((Math.random() * (INDICES.size() * 2)) % INDICES.size());
            int temp = INDICES.get(index1);
            INDICES.set(index1, INDICES.get(index2));
            INDICES.set(index2, temp);
        }
    }
}
