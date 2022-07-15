package chapter_eighteen;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Line;

import java.util.ArrayList;

public class ChessPane extends Pane
{
    private int rows, columns;
    private GridPane chessBoard;
    private int startX, startY;

    private static final ArrayList<String> ROWS_COLUMNS = new ArrayList<>();
    private static final ArrayList<Integer> INDICES = new ArrayList<>();


    public ChessPane(int rows, int columns)
    {
        this.rows = rows;
        this.columns = columns;
        draw();
    }

    public void draw()
    {
        VBox container = new VBox( 10);
        getChildren().clear();
        chessBoard = new GridPane();
        int boxWidth = 500/rows, boxHeight = 500/columns;

        for (int i = 0; i < rows; i++)
        {
            for (int j = 0; j < columns; j++)
            {
                int centerX = boxWidth * i + (boxWidth/2);
                int centerY = boxHeight * j + (boxHeight/2);
                CustomLabel label = new CustomLabel(i, j, centerX, centerY,
                        boxWidth, boxHeight);

                chessBoard.add(label, j, i);

                ROWS_COLUMNS.add(i + "" + j);
                INDICES.add(chessBoard.getChildren().indexOf(label));

                int finalI = i;
                int finalJ = j;
                label.setOnMousePressed(e ->
                {
                    startX = finalI; startY = finalJ;
                    Image image = new Image("chapter_eighteen/Knight.jpg");
                    ImageView imageView = new ImageView(image);
                    imageView.setFitWidth(boxWidth); imageView.setFitHeight(boxHeight);
                    label.setGraphic(imageView);
                });
            }
        }

        HBox hBox = new HBox();
        hBox.setAlignment(Pos.CENTER);
        Button solve = new Button("Solve");
        hBox.getChildren().add(solve);
        solve.setOnAction(e ->
        {
            int[][] solution = KnightTourSolver.getSolutions(rows, columns,
                    startX, startY);

            CustomLabel previousLabel = (CustomLabel) chessBoard.getChildren()
                                    .get(getIndex(solution, 1));
            for (int i = 2; i < rows*columns+1; i++)
            {
                CustomLabel currentLabel = (CustomLabel) chessBoard.getChildren()
                        .get(getIndex(solution, i));

                Line line = new Line(previousLabel.getCenterX(), previousLabel.getCenterY()
                , currentLabel.getCenterX(), currentLabel.getCenterY());
                getChildren().add(line);
                previousLabel = currentLabel;
            }
        });

        container.getChildren().addAll(chessBoard, hBox);
        getChildren().add(container);
    }


    private int getIndex(int[][] solution, int value)
    {
        for (int i = 0; i < solution.length; i++)
        {
            for (int j = 0; j < solution.length; j++)
            {
                if (solution[i][j] == value)
                    return INDICES.get(ROWS_COLUMNS.indexOf(i + "" + j));
            }
        }
        return -1; // to make compiler happy
    }
}
