package chapter_sixteen;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Arrays;

public class ConnectFour extends GridPane
{
    private final int VERTICAL_GAP = 10;
    private final int HORIZONTAL_GAP = 10;
    private final ArrayList<Cell> cellsAvailable = new ArrayList<>();
    private int player = 1;
    private final Stage primaryStage;


    public ConnectFour(Stage primaryStage)
    {
        this.primaryStage = primaryStage;
        draw();
    }

    private void draw()
    {
        setVgap(VERTICAL_GAP); setHgap(HORIZONTAL_GAP);
        setAlignment(Pos.CENTER); setStyle("-fx-background-color: #00f;");


        for (int i = 0; i < 6; i++)
        {
            for (int j = 0; j < 7; j++)
            {
                Cell cell = new Cell(j, i, getChildren().size());
                add(cell, j, i);
                if (i == 5)
                    cellsAvailable.add(cell);

                cell.setOnMousePressed(e ->
                {
                    if (cellsAvailable.get(cell.getColumn()) == null)
                        return;

                    cellsAvailable.get(cell.getColumn()).setOccupied(player);
                    player = (player == 1)? 2 : 1;

                    int newAvailable = getChildren().indexOf(cellsAvailable.get(cell.getColumn())) - 7;
                    if (newAvailable >= 0)
                    {
                        cellsAvailable.set(cell.getColumn(), (Cell) getChildren().get(newAvailable));
                        check();
                    }
                    else
                        cellsAvailable.set(cell.getColumn(), null);

                });
            }
        }

    }

    private void check()
    {
        int rowsStatus = checkRows();
        int columnsStatus = checkColumns();
        int rightDiagonalsStatus = checkRightDiagonals();
        int leftDiagonalsStatus = checkLeftDiagonals();

        if (rowsStatus == 0 && columnsStatus == 0
                && leftDiagonalsStatus == 0 && rightDiagonalsStatus == 0)
        {
            if (isDraw())
            {
                System.out.println("It`s A draw");
                clearCells();
            }
            else
                return;
        }


        int winner;
        if (rowsStatus > 0)
            winner = rowsStatus;
        else if (columnsStatus > 0)
            winner = columnsStatus;
        else if (leftDiagonalsStatus > 0)
            winner = leftDiagonalsStatus;
        else
            winner = rightDiagonalsStatus;

        final Stage dialog = new Stage();

        dialog.initModality(Modality.APPLICATION_MODAL);
        dialog.initOwner(primaryStage);

        VBox dialogVbox = new VBox(20);
        dialogVbox.setAlignment(Pos.CENTER);



        String player = (winner == 1) ? "Yellow" : "Red";
        Text text = new Text(player + " won !!");
        dialogVbox.getChildren().add(text);

        Scene dialogScene = new Scene(dialogVbox, 300, 200);
        dialog.setScene(dialogScene);
        dialog.show();

        dialog.setOnCloseRequest(e -> clearCells());
    }

    public int checkRows()
    {
        Cell element = (Cell) getChildren().get(0);
        int repeated = 1, counter = 0;
        for (int i = 0; i < getChildren().size(); i++, counter++)
        {
            Cell cell = (Cell) getChildren().get(i);
            if (counter == 7)
            {
                repeated = 0;
                element = cell;
                counter = 1;
            }

            if (element.getPlayer() == cell.getPlayer() && cell.getPlayer() != 0)
            {
                if (++repeated == 4)
                    return element.getPlayer();
            }
            else
            {
                element = cell;
                repeated = 1;
            }
        }
        return 0;
    }


    public int checkColumns()
    {
        int repeated = 1;
        for (int i = 0; i < 7; i++)
        {
            int j = i;
            Cell element = (Cell) getChildren().get(i);
            while (j < 42)
            {
                Cell cell = (Cell) getChildren().get(j);
                if (element.getPlayer() == cell.getPlayer()
                        && cell.getPlayer() != 0)
                {
                    if (++repeated == 4)
                        return element.getPlayer();
                }
                else
                {
                    element = cell;
                    repeated = 1;
                }
                j += 7;
            }
        }
        return 0;
    }


    public int checkLeftDiagonals()
    {
        int repeated = 1;
        for (int i = 0; i < 4; i++)
        {
            int j = i;
            int bound = (i == 3)? 28 : 42;
            Cell element = (Cell) getChildren().get(i);
            while (j < bound)
            {
                Cell cell = (Cell) getChildren().get(j);
                if (element.getPlayer() == cell.getPlayer()
                        && cell.getPlayer() != 0)
                {
                    if (++repeated == 4)
                        return element.getPlayer();
                }
                else
                {
                    element = cell;
                    repeated = 1;
                }
                j += 8;
            }
        }

        repeated = 1;
        for (int i = 0; i < 15; i+= 7)
        {
            int j = i;
            Cell element = (Cell) getChildren().get(i);
            while (j < 42)
            {
                Cell cell = (Cell) getChildren().get(j);
                if (element.getPlayer() == cell.getPlayer()
                        && cell.getPlayer() != 0)
                {
                    if (++repeated == 4)
                        return element.getPlayer();
                }
                else
                {
                    element = cell;
                    repeated = 1;
                }
                j += 8;
            }
        }
        return 0;
    }


    public int checkRightDiagonals()
    {
        int repeated = 1;
        for (int i = 6; i > 2; i--)
        {
            int j = i;
            int bound = i * 7 + ((i == 6)? 0 : 1);
            Cell element = (Cell) getChildren().get(i);
            while (j < bound)
            {
                Cell cell = (Cell) getChildren().get(j);
                if (element.getPlayer() == cell.getPlayer()
                        && cell.getPlayer() != 0)
                {
                    if (++repeated == 4)
                        return element.getPlayer();
                }
                else
                {
                    element = cell;
                    repeated = 1;
                }
                j += 6;
            }
        }

        repeated = 1;
        for (int i = 0; i < 21; i+= 7)
        {
            int j = i;
            Cell element = (Cell) getChildren().get(i);
            while (j < 42)
            {
                Cell cell = (Cell) getChildren().get(j);
                if (element.getPlayer() == cell.getPlayer()
                        && cell.getPlayer() != 0)
                {
                    if (++repeated == 4)
                        return element.getPlayer();
                }
                else
                {
                    element = cell;
                    repeated = 1;
                }
                j += 6;
            }
        }
        return 0;
    }

    private void clearCells()
    {
        for (int i = 0; i < getChildren().size(); i++)
        {
            Cell cell = (Cell) getChildren().get(i);
            if (cell.isOccupied())
                cell.setFill(Color.WHITE);
        }
        getChildren().clear();
        cellsAvailable.clear();
        draw();
        player = 1;
    }

    public boolean isDraw()
    {
        for (int i = 0; i < getChildren().size(); i++)
        {
            Cell cell = (Cell) getChildren().get(i);
            if (!cell.isOccupied())
                return false;
        }
        return true;
    }
}


class Cell extends Circle
{
    private Color fill = Color.WHITE;
    private Color stroke = Color.BLACK;
    private boolean occupied = false;
    private final int column;
    private final int row;
    private final int index;
    private int player = 0; // no one
    Integer[] a = {1, 7, 6, 8};
    private final ArrayList<Integer> possibleDifferences = new ArrayList<>(Arrays.asList(a));

    public Cell(int column, int row, int index)
    {
        this.index = index;
        this.column = column;
        this.row = row;
        setFill(fill);
        setStroke(stroke);
        setStyle("-fx-border-color: blue");
        setRadius(35);
    }


    public boolean isOccupied()
    {
        return occupied;
    }

    public void setOccupied(int player) // 1 yellow 2 red
    {
        Color fillColor = (player == 1)? Color.YELLOW : Color.RED;
        setFill(fillColor);
        this.player = player;
        this.occupied = true;
    }

    public int getColumn()
    {
        return column;
    }

    public int getRow()
    {
        return row;
    }

    public boolean equal(Cell cell)
    {
        int difference = getDifference(cell);
        boolean differenceComparison = possibleDifferences.contains(difference);
        boolean playerComparison = player == cell.getPlayer();
        boolean rowComparison = row == cell.getRow();
        boolean columnComparison = column == cell.getColumn();

        return differenceComparison & playerComparison
                & (rowComparison | columnComparison) & difference != 0;
    }

    public int getDifference(Cell cell)
    {
        return Math.abs(index - cell.getIndex());
    }

    public int getIndex()
    {
        return index;
    }

    public int getPlayer()
    {
        return player;
    }
}
