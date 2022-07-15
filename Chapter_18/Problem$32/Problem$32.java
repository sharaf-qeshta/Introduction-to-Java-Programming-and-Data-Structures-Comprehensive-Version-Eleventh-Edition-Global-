package chapter_eighteen;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * ***18.32 (Game: Knight’s Tour) The Knight’s Tour is an ancient puzzle. The objective is
 * to move a knight, starting from any square on a chessboard, to every other square
 * once, as shown in Figure 18.15a. Note the knight makes only L-shaped moves
 * (two spaces in one direction and one space in a perpendicular direction). As
 * shown in Figure 18.15b, the knight can move to eight squares. Write a program
 * that displays the moves for the knight, as shown in Figure 18.15c. When you
 * click a cell, the knight is placed at the cell. This cell will be the starting point for
 * the knight. Click the Solve button to display the path for a solution.
 * (Hint: A brute-force approach for this problem is to move the knight from one
 * square to another available square arbitrarily. Using such an approach, your
 * program will take a long time to finish. A better approach is to employ some
 * heuristics. A knight has two, three, four, six, or eight possible moves, depending
 * on its location. Intuitively, you should attempt to move the knight to the least
 * accessible squares first and leave those more accessible squares open, so there
 * will be a better chance of success at the end of the search.)
 *
 *
 * @author Sharaf Qeshta
 * */
public class Problem$32 extends Application
{
    @Override
    public void start(Stage primaryStage)
    {
        ChessPane pane = new ChessPane(8, 8);

        Scene scene = new Scene(pane, 500, 600);
        primaryStage.setTitle("Problem$32");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}