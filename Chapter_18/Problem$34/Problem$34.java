package chapter_eighteen;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * **18.34 (Game: Eight Queens) The Eight Queens problem is to find a solution to place
 * a queen in each row on a chessboard such that no two queens can attack each
 * other. Write a program to solve the Eight Queens problem using recursion and
 * display the result as shown in Figure 18.17.
 *
 *
 * @author Sharaf Qeshta
 * */
public class Problem$34 extends Application
{
    @Override
    public void start(Stage primaryStage)
    {
        NQueenPane pane = new NQueenPane(8);

        Scene scene = new Scene(pane, 500, 500);
        primaryStage.setTitle("Problem$34");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
