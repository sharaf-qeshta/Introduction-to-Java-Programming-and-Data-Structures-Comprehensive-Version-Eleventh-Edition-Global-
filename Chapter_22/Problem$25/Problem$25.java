package chapter_twenty_two;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.ArrayList;


/**
 * ***22.25 (Game: Sudoku) Revise Programming Exercise 22.21 to display all solutions
 * for the Sudoku game, as shown in Figure 22.17a. When you click the Solve
 * button, the program stores all solutions in an ArrayList. Each element in the
 * list is a two-dimensional 9-by-9 grid. If the program has multiple solutions, the
 * Next button appears as shown in Figure 22.17b. You can click the Next button
 * to display the next solution and also add a label to show the solution count.
 * When the Clear button is clicked, the cells are cleared and the Next button is
 * hidden as shown in Figure 22.17c.
 *
 *
 * @author Sharaf Qeshta
 * */
public class Problem$25 extends Application
{
    public static final int ROWS = 9;
    public static final int COLUMNS = 9;
    public static final MyTextField[][] BOARD = new MyTextField[ROWS][COLUMNS];
    public static ArrayList<int[][]> solutions = new ArrayList<>();
    private static int currentSolution = 0;
    private static boolean solvable = false;

    @Override
    public void start(Stage primaryStage)
    {
        VBox pane = new VBox(10);
        pane.setAlignment(Pos.CENTER);

        Label status = new Label();
        status.setAlignment(Pos.CENTER);
        pane.getChildren().addAll(status, getBoard());

        HBox settings = new HBox(5);
        Button solve = new Button("Solve");
        Button clear = new Button("Clear");
        Button next = new Button("Next");
        next.setVisible(false);
        settings.getChildren().addAll(solve, clear, next);

        clear.setOnAction(e ->
        {
            pane.getChildren().set(1, getBoard());
            currentSolution = 0;
            solvable = false;
            next.setVisible(false);
            status.setText("");
        });

        solve.setOnAction(e ->
        {
            status.setText(solve());
            next.setVisible(solvable);
        });

        next.setOnAction(e ->
        {
            if (currentSolution+1 == solutions.size())
                return;
            displaySolution(solutions.get(++currentSolution));
            status.setText((currentSolution+1) + "/" + solutions.size() + " solutions");
        });


        settings.setAlignment(Pos.CENTER);

        pane.getChildren().add(settings);

        Scene scene = new Scene(pane, 400, 400);
        primaryStage.setTitle("Problem$25");
        primaryStage.setScene(scene);
        primaryStage.show();
    }


    public static GridPane getBoard()
    {
        GridPane pane = new GridPane();
        pane.setAlignment(Pos.CENTER);
        pane.setPrefWidth(200);
        pane.setVgap(5); pane.setHgap(5);
        pane.setStyle("-fx-border-color: black");
        for (int i = 0; i < ROWS; i++)
        {
            for (int j = 0; j < COLUMNS; j++)
            {
                MyTextField field = new MyTextField(2);
                BOARD[i][j] = field;
                pane.add(field, j, i);
            }
        }
        return pane;
    }

    public static String solve()
    {
        for (int i = 0; i < ROWS; i++)
        {
            for (int j = 0; j < COLUMNS; j++)
            {
                if (!BOARD[i][j].getText().isEmpty())
                    BOARD[i][j].assignValue();

                if (BOARD[i][j].value != 0)
                    BOARD[i][j].setDisable(true);
            }
        }

        int[][] grid = getGrid();
        if (!isValid(grid))
            return "Invalid input";

        solutions = solve(getGrid());
        if (solutions.size() == 0)
            return "No Solution Found";
        else
        {
            solvable = true;
            displaySolution(solutions.get(0));
            return "1/"+solutions.size() + " solutions";
        }
    }


    public static void displaySolution(int[][] solution)
    {
        for (int i = 0; i < solution.length; i++)
            for (int j = 0; j < solution[i].length; j++)
                BOARD[i][j].setValue(solution[i][j]);
    }


    public static boolean isValid(int i, int j, int[][] grid)
    {
        for (int column = 0; column < 9; column++)
            if (column != j && grid[i][column] == grid[i][j])
                return false;

        for (int row = 0; row < 9; row++)
            if (row != i && grid[row][j] == grid[i][j])
                return false;

        for (int row = (i / 3) * 3; row < (i / 3) * 3 + 3; row++)
            for (int col = (j / 3) * 3; col < (j / 3) * 3 + 3; col++)
                if (row != i && col != j && grid[row][col] == grid[i][j])
                    return false;

        return true;
    }

    public static ArrayList<int[][]> solve(int[][] grid)
    {
        ArrayList<int[][]> result = new ArrayList<>();
        int[][] freeCellList = getFreeCellList(grid);

        if (freeCellList.length == 0)
        {
            result.add(clone(grid));
            return result;
        }

        int k = 0;
        while (true)
        {
            int i = freeCellList[k][0];
            int j = freeCellList[k][1];
            if (grid[i][j] == 0)
                grid[i][j] = 1;

            boolean valid = false;
            if (isValid(i, j, grid))
            {
                valid = true;
                if (k + 1 == freeCellList.length)
                {
                    result.add(clone(grid));
                    valid = false;
                }
                else
                    k++;
            }
            if (!valid)
            {
                if (grid[i][j] >= 9)
                {
                    while (grid[i][j] == 9)
                    {
                        if (k == 0)
                            return result;

                        grid[i][j] = 0;
                        k--;
                        i = freeCellList[k][0];
                        j = freeCellList[k][1];
                    }
                }
                grid[i][j] = grid[i][j] + 1;
            }
        }
    }


    public static int[][] clone(int[][] grid)
    {
        int[][] cloned = new int[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++)
            for (int j = 0; j < grid[i].length; j++)
                cloned[i][j] = grid[i][j];
        return cloned;
    }


    public static int[][] getGrid()
    {
        int[][] intGrid = new int[ROWS][COLUMNS];
        for (int i = 0; i < BOARD.length; i++)
            for (int j = 0; j < BOARD[i].length; j++)
                intGrid[i][j] = BOARD[i][j].value;
        return intGrid;
    }


    public static int[][] getFreeCellList(int[][] grid)
    {
        int numberOfFreeCells = 0;
        for (int i = 0; i < 9; i++)
            for (int j = 0; j < 9; j++)
                if (grid[i][j] == 0)
                    numberOfFreeCells++;

        int[][] freeCellList = new int[numberOfFreeCells][2];
        int count = 0;
        for (int i = 0; i < 9; i++)
            for (int j = 0; j < 9; j++)
                if (grid[i][j] == 0)
                {
                    freeCellList[count][0] = i;
                    freeCellList[count++][1] = j;
                }
        return freeCellList;
    }

    public static boolean isValid(int[][] grid)
    {
        for (int i = 0; i < 9; i++)
            for (int j = 0; j < 9; j++)
                if (grid[i][j] < 0 || grid[i][j] > 9
                        || (grid[i][j] != 0 && !isValid(i, j, grid)))
                    return false;
        return true;
    }



    private static class MyTextField extends TextField
    {
        int value;

        public MyTextField(int columns)
        {
            setPrefColumnCount(columns);
        }

        public void assignValue()
        {
            int value;
            try
            {
                value = Integer.parseInt(getText());
            }
            catch (Exception exception)
            {
                return;
            }

            if (value > 0 && value < 10)
                this.value = value;
        }

        public void setValue(int value)
        {
            setText(value + "");
            this.value = value;
        }
    }
}
