package chapter_fifteen;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.stage.Stage;

/**
 * **15.29 (Racing car) Write a program that simulates car racing, as shown in
 * Figure 15.36a. The car moves from left to right. When it hits the right end, it
 * restarts from the left and continues the same process. You can use a timer to
 * control animation. Redraw the car with new base coordinates (x, y), as shown
 * in Figure 15.36b. Also let the user pause/resume the animation with a button
 * press/release and increase/decrease the car speed by pressing the up and down
 * arrow keys.
 *
 *
 * @author Sharaf Qeshta
 * */
public class Problem$29 extends Application
{
    public static void main(String[] args)
    {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage)
    {
        RacingCar pane = new RacingCar();

        pane.setOnKeyPressed(e ->
        {
            if (e.getCode() == KeyCode.UP)
                pane.increaseSpeed();
            else if (e.getCode() == KeyCode.DOWN)
                pane.decreaseSpeed();
            else
                pane.pause();
        });

        pane.setOnKeyReleased(e -> pane.play());

        Scene scene = new Scene(pane, 500, 500);
        primaryStage.setTitle("Problem$29");
        primaryStage.setScene(scene);
        primaryStage.show();

        pane.requestFocus();
    }
}
