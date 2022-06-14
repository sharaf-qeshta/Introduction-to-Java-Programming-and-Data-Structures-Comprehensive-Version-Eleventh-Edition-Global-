package chapter_fourteen;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
/**
 * *14.2 (Tic-tac-toe board) Write a program that displays a tic-tac-toe board, as
 * shown in Figure 14.43b. A cell may be X, O, or empty. What to display
 * at  each cell is randomly decided. The X and O are the image files x.gif
 * and o.gif.
 *
 * @author Sharaf Qeshta
 * */
public class Problem$02 extends Application
{
    public static void main(String[] args)
    {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage)
    {
        GridPane pane = new GridPane();
        pane.setHgap(5);
        pane.setVgap(5);
        pane.setPadding(new Insets(10, 10, 10, 10));
        pane.setAlignment(Pos.CENTER);

        boolean[][] board = new boolean[3][3];
        String[] content = {"chapter_fourteen/x.gif", "chapter_fourteen/o.gif", "chapter_fourteen/blank.jpg"};

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

        Scene scene = new Scene(pane, 300, 200);
        primaryStage.setTitle("Problem$02");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
