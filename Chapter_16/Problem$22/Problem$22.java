package chapter_sixteen;

import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.media.AudioClip;
import javafx.stage.Stage;

/**
 * 16.22 (Play, loop, and stop a sound clip) Write a program that meets the following
 * requirements:
 * ■■ Get an audio file from the class directory using AudioClip.
 * ■■ Place three buttons labeled Play, Loop, and Stop, as shown in Figure 16.46a.
 * ■■ If you click the Play button, the audio file is played once. If you click the Loop
 * button, the audio file keeps playing repeatedly. If you click the Stop button,
 * the playing stops.
 *
 *
 * @author Sharaf Qeshta
 * */
public class Problem$22 extends Application
{
    private final String CLIP_URL_WEB = "https://quz1yp-a.akamaihd.net/downloads/ringtones/files/mp3/twirling-intime-lenovo-k8-note-alarm-tone-41440.mp3";
    private final String CLIP_URL_LOCAL = "file:///src/chapter_sixteen/ringtone.mp3";


    @Override
    public void start(Stage primaryStage)
    {
        AudioClip clip = new AudioClip(CLIP_URL_LOCAL);

        Button play = new Button("Play");
        Button loop = new Button("Loop");
        Button stop = new Button("Stop");
        HBox buttons = new HBox(5, play, loop, stop);
        buttons.setAlignment(Pos.CENTER);

        BorderPane pane = new BorderPane();
        pane.setCenter(buttons);

        Scene scene = new Scene(pane, 100, 100);
        primaryStage.setTitle("Problem$22");
        primaryStage.setScene(scene);
        primaryStage.show();


        play.setOnAction(e -> clip.play());

        stop.setOnAction(e -> clip.stop());

        loop.setOnAction(e ->
        {
            if (clip.getCycleCount() == Timeline.INDEFINITE)
                clip.setCycleCount(1);
            else
                clip.setCycleCount(Timeline.INDEFINITE);
        });
    }
}
