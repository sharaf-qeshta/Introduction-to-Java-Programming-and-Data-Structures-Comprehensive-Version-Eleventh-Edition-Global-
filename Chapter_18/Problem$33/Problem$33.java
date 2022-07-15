package chapter_eighteen;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * ***18.33 (Game: Knight’s Tour animation) Write a program for the Knight’s Tour problem.
 * Your program should let the user move a knight to any starting square and click the
 * Solve button to animate a knight moving along the path, as shown in Figure 18.16.
 *
 *
 * @author Sharaf Qeshta
 * */
public class Problem$33 extends Application
{
    @Override
    public void start(Stage primaryStage)
    {
        ChessPane pane = new ChessPane(8, 8);

        Scene scene = new Scene(pane, 500, 600);
        primaryStage.setTitle("Problem$33");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
