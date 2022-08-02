package chapter_twenty_two;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 * *22.19 (Largest block) The problem for finding a largest block is described in
 * Programming Exercise 8.35. Design a dynamic programming algorithm for
 * solving this problem in O(n²) time.
 * Write a test program that displays a 10-by 10 square matrix, as shown in
 * Figure 22.14a. Each element in the matrix is 0 or
 * 1, randomly generated with a click of the Refresh button. Display each number
 * centered in a text field. Use a text field for each entry. Allow the user to change
 * the entry value. Click the Find Largest Block button to find a largest square
 * submatrix that consists of 1s. Highlight the numbers in the block, as shown
 * in Figure 22.14b. See liveexample.pearsoncmg.com/dsanimation/LargestBlock
 * .html for an interactive test.
 *
 *
 * @author Sharaf Qeshta
 * */
public class Problem$19 extends Application
{
    public static final int ROWS = 10;
    public static final int COLUMNS = 10;
    public static final MyTextField[][] MATRIX = new MyTextField[ROWS][COLUMNS];
    public static int[] largestBlock = new int[3];


    @Override
    public void start(Stage primaryStage)
    {
        VBox pane = new VBox(5);
        pane.getChildren().add(getMatrixPane(getMatrix(ROWS, COLUMNS)));

        HBox settings = new HBox(5);
        Button refresh = new Button("Refresh");
        Button findLargestBlock = new Button("Find Largest Block");
        settings.getChildren().addAll(refresh, findLargestBlock);
        settings.setAlignment(Pos.CENTER);

        refresh.setOnAction(e -> pane.getChildren().set(0,
                getMatrixPane(getMatrix(ROWS, COLUMNS))));
        findLargestBlock.setOnAction(e -> findSolution());

        pane.getChildren().add(settings);

        Scene scene = new Scene(pane, 500, 500);
        primaryStage.setTitle("Problem$19");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void findSolution()
    {
        for (MyTextField[] matrix : MATRIX)
        {
            for (MyTextField myTextField : matrix)
            {
                int newValue;
                try
                {
                    newValue = Integer.parseInt(myTextField.getText());
                }
                catch (Exception exception)
                {
                    continue;
                }
                if (newValue == 0 || newValue == 1)
                    myTextField.value = newValue;
            }
        }

        // delete the previous largest block
        if (largestBlock[2] != 0)
            color(largestBlock, Color.WHITE);
        if (largestBlock.length != 1)
        {
            largestBlock = findLargestBlock(MATRIX);
            color(largestBlock,Color.RED);
        }
    }

    public static void color(int[] solution, Color color)
    {
        for (int i = solution[0]; i < solution[0]+solution[2]; i++)
            for (int j = solution[1]; j < solution[1]+solution[2]; j++)
                MATRIX[i][j].setStyle("-fx-control-inner-background: #"
                        +color.toString().substring(2));
    }

    public static GridPane getMatrixPane(int[][] matrix)
    {
        largestBlock = new int[3];
        GridPane pane = new GridPane();
        pane.setVgap(1); pane.setHgap(1);
        for (int i = 0; i < matrix.length; i++)
        {
            for (int j = 0; j < matrix[i].length; j++)
            {
                MyTextField textField = new MyTextField(matrix[i][j], 5);
                MATRIX[i][j] = textField;
                pane.add(textField, j, i);
            }
        }
        return pane;
    }

    public static int[][] getMatrix(int rows, int columns)
    {
        int[][] matrix = new int[rows][columns];
        for (int i = 0; i < matrix.length; i++)
            for (int j = 0; j < matrix[i].length; j++)
                matrix[i][j] = (int) Math.round(Math.random());
        return matrix;
    }

    public static int[] findLargestBlock(MyTextField[][] matrix)
    {
        for (int size = matrix.length; size >=1 ; size--)
        {
            for (int row = 0; row < matrix.length; row++)
            {
                for (int column = 0; column < matrix[row].length; column++)
                {
                    if((matrix.length - row >= size)
                            && (matrix[row].length - column >= size))
                    {
                        boolean allOnes = true;
                        for (int i = row; i < row + size; i++)
                        {
                            for (int j = column; j < column + size; j++)
                            {
                                if(matrix[i][j].value != 1)
                                {
                                    allOnes = false;
                                    break;
                                }
                            }
                            if(!allOnes)
                                break;
                        }
                        if(allOnes)
                            return new int[] {row, column, size};
                    }
                }
            }
        }
        return new int[] {0};
    }

    private static class MyTextField extends TextField
    {
        int value;

        public MyTextField(int value, int columns)
        {
            this.value = value;
            setPrefColumnCount(columns);
            setText(value + "");
        }
    }
}
