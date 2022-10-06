package chapter_thirty_one;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 * *31.2 (Tic-tac-toe board) Write a program that displays a tic-tac-toe board, as shown
 * in Figure 31.48b. A cell may be X, O, or empty. What to display at each cell is
 * randomly decided. The X and O are images in the files x.gif and o.gif. Use the
 * style sheet for border
 *
 *
 * @author Sharaf Qeshta
 * */
public class Problem$02 extends Application
{
    @Override
    public void start(Stage stage)
    {
        GridPane pane = new GridPane();
        Scene scene = new Scene(pane, 300, 200);
        scene.getStylesheets().add("chapter_thirty_one/Problem$02.css");
        pane.getStyleClass().add("pane_border");

        pane.setHgap(5);
        pane.setVgap(5);
        pane.setPadding(new Insets(10, 10, 10, 10));
        pane.setAlignment(Pos.CENTER);

        boolean[][] board = new boolean[3][3];
        String[] content = {"chapter_thirty_one/x.gif", "chapter_thirty_one/o.gif", "chapter_thirty_one/blank.jpg"};

        for (int i = 0; i < board.length;i++)
        {
            for (int j = 0; j < board[i].length; j++)
            {
                ImageView node = new ImageView(content[(int) ((Math.random() * 10) % 3)]);
                node.setFitHeight(50);
                node.setFitWidth(50);
                pane.add(node, j, i);
            }
        }

        stage.setTitle("Problem$02");
        stage.setScene(scene);
        stage.show();
    }
}
