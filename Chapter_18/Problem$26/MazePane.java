package chapter_eighteen;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class MazePane extends VBox
{
    private static final HashSet<Rectangle> path = new HashSet<>();
    private static final HashSet<Integer> pathIndex = new HashSet<>();
    private static final HashSet<Integer> forbiddenIndices = new HashSet<>();

    // possible solutions
    /**
     * you can add another solutions
     */
    private static final HashSet<Integer> path1 = new HashSet<>(
            Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 17,
                    26, 35, 44, 53, 62, 71, 80)
    );

    private static final HashSet<Integer> path2 = new HashSet<>(
            Arrays.asList(0, 9, 18, 27, 36, 45, 54, 63, 72,
                    73, 74, 75, 76, 77, 78, 79, 80)
    );

    private static final HashSet<Integer> path3 = new HashSet<>(
            Arrays.asList(0, 9, 18, 27, 36, 37, 38, 39, 40,
                    41, 42, 43, 44, 53, 62, 71, 80)
    );

    private static final ArrayList<HashSet<Integer>> solutions = new ArrayList<>
            (Arrays.asList(path1, path2, path3));


    private static GridPane maze;
    private static Text status;
    private static int lastAddedCell = -1;

    public MazePane()
    {
        draw();
    }

    public void draw()
    {
        HashSet<Integer> chosenSolution = solutions.get((int) ((Math.random() * 10) % 3));
        status = new Text("Find Path");
        status.setTextAlignment(TextAlignment.CENTER);
        status.setFont(Font.font(25));

        maze = new GridPane();
        maze.setAlignment(Pos.CENTER);

        for (int i = 0; i < 9; i++)
        {
            for (int j = 0; j < 9; j++)
            {
                Rectangle rectangle = new Rectangle(0, 0, 50, 50);
                rectangle.setFill(Color.WHITE);
                rectangle.setStroke(Color.BLACK);

                maze.add(rectangle, j, i);
                if (i == 0 && j == 0)
                    modifyCell(rectangle);
                rectangle.setOnMouseClicked(e -> modifyCell(rectangle));
            }
        }

        for (int i = 0; i < 10; i++)
        {
            int randomIndex = (int) ((Math.random() * maze.getChildren().size() * 2)
                    % maze.getChildren().size());
            if (chosenSolution.contains(randomIndex))
                continue;
            Rectangle rectangle = (Rectangle) maze.getChildren().get(randomIndex);
            rectangle.setFill(Color.RED);
            forbiddenIndices.add(randomIndex);
        }

        Button findPath = new Button("Find Path");
        Button clearPath = new Button("Clear Path");

        findPath.setOnAction(e ->
        {
            clear(true);
            for (int index : chosenSolution)
            {
                Rectangle rectangle = (Rectangle) maze.getChildren().get(index);
                rectangle.setFill(Color.BLACK);
            }
        });
        clearPath.setOnAction(e -> clear());

        HBox buttonsContainer = new HBox(5, findPath, clearPath);
        buttonsContainer.setAlignment(Pos.CENTER);

        setAlignment(Pos.CENTER);
        setSpacing(20);
        getChildren().addAll(status, maze, buttonsContainer);
    }

    private void modifyCell(Rectangle rectangle)
    {
        int currentIndex = maze.getChildren().indexOf(rectangle);
        if (forbiddenIndices.contains(currentIndex))
            return;

        if (currentIndex == 80)
            checkPath();
        else
        {
            if (rectangle.getFill() == Color.BLACK)
            {
                rectangle.setFill(Color.WHITE);
                path.remove(rectangle);
                pathIndex.remove(currentIndex);
                if (pathIndex.size() == 0)
                    lastAddedCell = -1;
            }
            else
            {
                int difference = Math.abs(lastAddedCell - currentIndex);
                if (lastAddedCell == -1
                        || difference == 1 || difference == 9 || difference == 0)
                {
                    rectangle.setFill(Color.BLACK);
                    path.add(rectangle);
                    pathIndex.add(currentIndex);
                    lastAddedCell = currentIndex;
                }
            }
        }

    }

    private void checkPath()
    {
        if (pathIndex.size() > 48)
        {
            status.setText("Wrong Path");
            return;
        }

        int sum = 0;
        for (int x : pathIndex)
            sum += x;

        if (sum % 2 == 0)
            status.setText("Right Path");
        else
            status.setText("Wrong Path");
    }


    private void clear()
    {
        getChildren().clear();
        forbiddenIndices.clear();
        path.clear();
        pathIndex.clear();
        lastAddedCell = -1;
        draw();
    }

    private void clear(boolean clearOnlyColored)
    {
        path.clear();
        pathIndex.clear();
        lastAddedCell = -1;
        for (int i = 0; i < maze.getChildren().size(); i++)
        {
            if (!forbiddenIndices.contains(i))
            {
                Rectangle rectangle = (Rectangle) maze.getChildren().get(i);
                rectangle.setFill(Color.WHITE);
            }
        }
    }
}


