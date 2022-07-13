package chapter_eighteen;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * **18.26 (Create a maze) Write a program that will find a path in a maze, as shown in
 * Figure 18.13a. The maze is represented by a 9 * 9 board. The path must meet the
 * following conditions:
 * ■■ The program enables the user to place or remove a mark on a cell. A path
 * consists of adjacent unmarked cells. Two cells are said to be adjacent if they
 * are horizontal or vertical neighbors, but not if they are diagonal neighbors.
 * ■ The path does not contain cells that form a square. The path in Figure 18.13b,
 * for example, does not meet this condition. (The condition makes a path easy
 * to identify on the board.)
 *
 *
 * @author Sharaf Qeshta
 * */
public class Problem$26 extends Application
{
    @Override
    public void start(Stage primaryStage)
    {
        MazePane pane = new MazePane();
        Scene scene = new Scene(pane, 500, 600);
        primaryStage.setTitle("Problem$26");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
