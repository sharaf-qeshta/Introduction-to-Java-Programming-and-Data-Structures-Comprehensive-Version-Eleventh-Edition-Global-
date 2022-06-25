package chapter_fifteen;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * **15.31 (Geometry: pendulum) Write a program that animates a pendulum swinging,
 * as shown in Figure 15.37. Press the up arrow key to increase the speed, and the
 * down arrow key to decrease it. Press the S key to stop animation of and the R
 * key to resume it.
 *
 *
 * @author Sharaf Qeshta
 * */
public class Problem$31 extends Application
{
    public static void main(String[] args)
    {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage)
    {
        PendulumPane pane = new PendulumPane();

        pane.setOnKeyPressed(e ->
        {
            switch (e.getCode())
            {
                case UP -> pane.increaseSpeed();
                case DOWN -> pane.decreaseSpeed();
                case R -> pane.play();
                case S -> pane.pause();
            }
        });

        Scene scene = new Scene(pane, 500, 500);
        primaryStage.setTitle("Problem$31");
        primaryStage.setScene(scene);
        primaryStage.show();

        pane.requestFocus();
    }
}
