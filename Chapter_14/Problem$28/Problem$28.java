package chapter_fourteen;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 * *14.28 (Random time) Modify the ClockPane class with three new Boolean properties—
 * hourHandVisible, minuteHandVisible, and secondHandVisible—and
 * their associated accessor and mutator methods. You can use the set methods
 * to make a hand visible or invisible. Write a test program that displays only the
 * hour and minute hands. The hour and minute values are randomly generated.
 * The hour is between 0 and 11, and the minute is either 0 or 30, as shown in
 * Figure 14.52b.
 *
 *
 * @author Sharaf Qeshta
 * */
public class Problem$28 extends Application
{
    public static void main(String[] args)
    {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage)
    {
        int randomHour = (int) (Math.random() * 11);
        int randomMinute = (int) ((Math.random() * 10) % 2) * 30;

        ClockPane clock = new ClockPane(randomHour, randomMinute, 45);
        String timeString = clock.getHour() + ":" + clock.getMinute() + ":" + clock.getSecond();
        Label lblCurrentTime = new Label(timeString);
        clock.setHourHandVisible(true);
        clock.setMinuteHandVisible(true);


        BorderPane pane = new BorderPane();
        pane.setCenter(clock);
        pane.setBottom(lblCurrentTime);
        BorderPane.setAlignment(lblCurrentTime, Pos.TOP_CENTER);

        Scene scene = new Scene(pane, 500, 500);
        primaryStage.setTitle("Problem$28");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
