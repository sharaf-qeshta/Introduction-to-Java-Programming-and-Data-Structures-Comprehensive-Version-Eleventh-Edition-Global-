package chapter_thirty_two;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 * ***32.22 (Eight Queens animation) Modify Listing 22.11, EightQueens.java, to display
 * the intermediate results of the search. As shown in Figure 32.33, the current row
 * being searched is highlighted. Every one second, a new state of the chess board
 * is displayed.
 *
 *
 * @author Sharaf Qeshta
 * */
public class Problem$22 extends Application
{
    public static final int SIZE = 8;
    private final int[] queens = {-1, -1, -1, -1, -1, -1, -1, -1};
    private final Label[][] LABELS = new Label[SIZE][SIZE];

    @Override
    public void start(Stage primaryStage)
    {
        GridPane chessBoard = new GridPane();
        chessBoard.setAlignment(Pos.CENTER);

        for (int i = 0; i < SIZE; i++)
        {
            for (int j = 0; j < SIZE; j++)
            {
                chessBoard.add(LABELS[i][j] = new Label(), j, i);
                LABELS[i][j].setStyle("-fx-border-color: black");
                LABELS[i][j].setPrefSize(55, 55);
            }
        }

        new Thread(this::search).start();

        Scene scene = new Scene(chessBoard, 55 * SIZE, 55 * SIZE);
        primaryStage.setTitle("Problem$22");
        primaryStage.setScene(scene);
        primaryStage.show();
    }


    private boolean search()
    {
        int k = 0;
        while (k >= 0 && k < SIZE)
        {
            int j = findPosition(k);
            int finalK = k;
            int finalQueensK = queens[finalK];

            // highlight the current row
            for (int i = 0; i < SIZE; i++)
            {
                int currentI = i;
                Platform.runLater(() ->
                        LABELS[finalK][currentI].setStyle
                                ("-fx-background-color: grey; -fx-border-color: black;"));
            }

            if (queens[k] != -1)
            {
                Platform.runLater(() ->
                        LABELS[finalK][finalQueensK].setGraphic(null));
            }
            if (j < 0)
            {
                queens[k] = -1;
                k--;
            }
            else
            {

                Image image = new Image("chapter_thirty_two/queen.png");
                ImageView imageView = new ImageView(image);
                imageView.setFitWidth(55); imageView.setFitHeight(55);
                queens[k] = j;
                Platform.runLater(()
                        -> LABELS[finalK][queens[finalK]].setGraphic(imageView));
                k++;
            }
            try
            {
                Thread.sleep(1_000);
            }
            catch (Exception exception)
            {
                exception.printStackTrace();
            }

            // remove highlighting from the current row
            for (int i = 0; i < SIZE; i++)
            {
                int currentI = i;
                Platform.runLater(() ->
                        LABELS[finalK][currentI].setStyle
                                ("-fx-background-color: white; -fx-border-color: black;"));
            }
        }
        return k != -1;
    }


    public int findPosition(int k)
    {
        int start = queens[k] + 1;
        for (int j = start; j < SIZE; j++)
        {
            if (isValid(k, j))
            {
                return j;
            }
        }
        return -1;
    }

    public boolean isValid(int row, int column)
    {
        for (int i = 1; i <= row; i++)
            if (queens[row - i] == column
                    || queens[row - i] == column - i
                    || queens[row - i] == column + i)
                return false;
        return true;
    }
}
