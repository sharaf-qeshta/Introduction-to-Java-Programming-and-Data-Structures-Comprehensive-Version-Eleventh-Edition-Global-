package chapter_sixteen;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 * *16.21 (Count-down stopwatch) Write a program that allows the user to enter time
 * in seconds in the text field and press the Enter key to count down the seconds,
 * as  shown in Figure 16.45d. The remaining seconds are redisplayed
 * every second. When the seconds are expired, the program starts to play music
 * continuously.
 *
 *
 * @author Sharaf Qeshta
 * */
public class Problem$21 extends Application
{
    private int secondCounter = 0;

    @Override
    public void start(Stage primaryStage)
    {
        TextField seconds = new TextField();
        seconds.setStyle("-fx-background-color: -fx-control-inner-background;");
        seconds.setMaxSize(50, 25);


        StackPane pane = new StackPane(seconds);

        Scene scene = new Scene(pane, 100, 100);
        primaryStage.setTitle("Problem$21");
        primaryStage.setScene(scene);
        primaryStage.show();

        seconds.setOnAction(e ->
        {
            try
            {
                secondCounter = Integer.parseInt(seconds.getText());
            }
            catch (Exception ex)
            {
                System.out.println("Invalid Input");
                return;
            }
            if (secondCounter > 99 || secondCounter < 0)
                return;
            seconds.setEditable(false);

            Timeline counter = new Timeline(
                    new KeyFrame(Duration.millis(1000), event ->
                    {
                        secondCounter--;
                        seconds.setText(secondCounter + "");

                    })
            );

            counter.setCycleCount(secondCounter);
            counter.play();
            counter.setOnFinished(event ->
            {
                seconds.setEditable(true);
                Media media = new Media("https://quz1yp-a.akamaihd.net/downloads/ringtones/files/mp3/twirling-intime-lenovo-k8-note-alarm-tone-41440.mp3");
                MediaPlayer player = new MediaPlayer(media);
                player.play();
                player.setCycleCount(Timeline.INDEFINITE);
            });
        });
    }
}
