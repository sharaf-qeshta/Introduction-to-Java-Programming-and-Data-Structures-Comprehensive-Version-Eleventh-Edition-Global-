package chapter_thirty_two;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * ***32.20 (Sudoku search animation) Modify Programming Exercise 22.21 to display the
 * intermediate results of the search. Figure 32.32 gives a snapshot of an animation
 * in progress with number 2 placed in the cell in Figure 32.32a, number 3 placed
 * in the cell in Figure 32.32b, and number 3 placed in the cell in Figure 32.32c.
 * The animation displays all the search steps.
 *
 *
 * @author Sharaf Qeshta
 * */
public class Problem$20 extends Application
{
    public static final int ROWS = 9;
    public static final int COLUMNS = 9;
    public static final MyTextField[][] BOARD = new MyTextField[ROWS][COLUMNS];
    public static final Label status = new Label();

    @Override
    public void start(Stage primaryStage)
    {
        VBox pane = new VBox(10);

        status.setAlignment(Pos.CENTER);
        pane.getChildren().addAll(status, getBoard());

        HBox settings = new HBox(5);
        Button solve = new Button("Solve");
        Button clear = new Button("Clear");
        settings.getChildren().addAll(solve, clear);

        clear.setOnAction(e -> pane.getChildren().set(1, getBoard()));
        solve.setOnAction(e -> solve());
        settings.setAlignment(Pos.CENTER);

        pane.getChildren().add(settings);

        Scene scene = new Scene(pane, 400, 400);
        primaryStage.setTitle("Problem$20");
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

    public static void solve()
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
            status.setText("Invalid input");

        new Thread(() -> solve(getGrid())).start();

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

    public static void solve(int[][] grid)
    {
        int[][] freeCellList = getFreeCellList(grid);

        if (freeCellList.length == 0)
            Platform.runLater(() -> status.setText("No Solution Found"));

        int k = 0;
        while (true)
        {
            int i = freeCellList[k][0];
            int j = freeCellList[k][1];
            if (grid[i][j] == 0)
                grid[i][j] = 1;

            if (isValid(i, j, grid))
            {
                if (k + 1 == freeCellList.length)
                    break;
                else
                    k++;
                BOARD[i][j].setText(grid[i][j] + "");
                BOARD[i][j].setStyle("-fx-text-fill: black;");
            }
            else
            {
                if (grid[i][j] >= 9)
                {
                    while (grid[i][j] == 9)
                    {
                        if (k == 0)
                            Platform.runLater(() ->
                                    status.setText("No Solution Found"));

                        grid[i][j] = 0;
                        k--;
                        i = freeCellList[k][0];
                        j = freeCellList[k][1];
                    }
                }
                grid[i][j] = grid[i][j] + 1;
                BOARD[i][j].setText((grid[i][j] + 1)+ "");
                BOARD[i][j].setStyle("-fx-text-fill: grey;");
            }

            try
            {
                Thread.sleep(25);
            }
            catch (Exception exception)
            {
                exception.printStackTrace();
            }
        }
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
