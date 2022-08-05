package chapter_twenty_two;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * ***22.23 (Game: multiple Eight Queens solution) Write a program to display all possible
 * solutions for the Eight Queens puzzle in a scroll pane, as shown in Figure 22.16.
 * For each solution, put a label to denote the solution number. (Hint: Place all
 * solution panes into an HBox and place this one pane into a ScrollPane. If
 * you run into a StackOverflowError, run the program using java –Xss200m
 * Exercise22_23 from the command window.)
 *
 *
 * @author Sharaf Qeshta
 * */
public class Problem$23 extends Application
{
    @Override
    public void start(Stage primaryStage)
    {
        NQueenPane pane = new NQueenPane(8);

        Scene scene = new Scene(pane, 500, 500);
        primaryStage.setTitle("Problem$23");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
