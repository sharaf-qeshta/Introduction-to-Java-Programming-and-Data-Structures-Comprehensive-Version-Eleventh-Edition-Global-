package chapter_thirty_two;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.stage.Stage;

/**
 * 32.6 (Bouncing balls) Rewrite Listing 15.17, BallPane.java using a thread to animate
 * bouncing ball movements
 *
 *
 * @author Sharaf Qeshta
 * */
public class Problem$06 extends Application
{
    @Override
    public void start(Stage stage)
    {
        BallPane ballPane = new BallPane();

        new Thread(() ->
        {
            ballPane.setOnMousePressed(e -> ballPane.pause());
            ballPane.setOnMouseReleased(e -> ballPane.play());

            ballPane.setOnKeyPressed(e ->
            {
                if (e.getCode() == KeyCode.UP)
                    ballPane.increaseSpeed();
                else if (e.getCode() == KeyCode.DOWN)
                    ballPane.decreaseSpeed();
            });
        }).start();

        Scene scene = new Scene(ballPane, 250, 150);
        stage.setTitle("Problem$06");
        stage.setScene(scene);
        stage.show();

        ballPane.requestFocus();
    }
}
