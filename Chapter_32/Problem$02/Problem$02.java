package chapter_thirty_two;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.stage.Stage;

/**
 * 32.2 (Racing cars) Rewrite Programming Exercise 15.29 using a thread to control car
 * racing. Compare the program with Programming Exercise 15.29 by setting the
 * delay time to 10 in both the programs. Which one runs the animation faster?
 *
 *
 * @author Sharaf Qeshta
 * */
public class Problem$02 extends Application
{
    @Override
    public void start(Stage stage)
    {
        RacingCar pane = new RacingCar();

        pane.setOnKeyPressed(e ->
                Platform.runLater(() ->
                {
                    if (e.getCode() == KeyCode.UP)
                        pane.increaseSpeed();
                    else if (e.getCode() == KeyCode.DOWN)
                        pane.decreaseSpeed();
                    else
                        pane.pause();
                }));

        pane.setOnKeyReleased(e ->
                Platform.runLater(pane::play));

        Scene scene = new Scene(pane, 500, 500);
        stage.setTitle("Problem$02");
        stage.setScene(scene);
        stage.show();

        pane.requestFocus();
    }
}
