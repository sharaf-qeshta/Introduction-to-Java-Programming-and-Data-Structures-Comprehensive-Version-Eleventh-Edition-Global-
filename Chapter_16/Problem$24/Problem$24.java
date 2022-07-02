package chapter_sixteen;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 * **16.24 (Revise Listing 16.14 MediaDemo.java) Add a slider to enable the user to set the
 * current time for the video and a label to display the current time and the total
 * time for the video. As shown in Figure 16.47a, the total time is 5 minutes and 3
 * seconds and the current time is 3 minutes and 58 seconds. As the video plays, the
 * slider value and current time are continuously updated.
 *
 *
 * @author Sharaf Qeshta
 * */
public class Problem$24 extends Application
{
    private static final String MEDIA_URL =
        "http://liveexample.pearsoncmg.com/common/sample.mp4";

    @Override
    public void start(Stage primaryStage)
    {
        Media media = new Media(MEDIA_URL);
        MediaPlayer mediaPlayer = new MediaPlayer(media);
        MediaView mediaView = new MediaView(mediaPlayer);

        Button playButton = new Button(">");
        playButton.setOnAction(e -> {
            if (playButton.getText().equals(">"))
            {
                mediaPlayer.play();
                playButton.setText("||");
            }
            else
            {
                mediaPlayer.pause();
                playButton.setText(">");
            }
        });

        Button rewindButton = new Button("<<");
        rewindButton.setOnAction(e -> mediaPlayer.seek(Duration.ZERO));

        Slider slVolume = new Slider();
        slVolume.setPrefWidth(150);
        slVolume.setMaxWidth(Region.USE_PREF_SIZE);
        slVolume.setMinWidth(30);
        slVolume.setValue(50);
        mediaPlayer.volumeProperty().bind(slVolume.valueProperty().divide(100));

        Slider slTime = new Slider();
        slTime.setPrefWidth(150);
        slTime.setMaxWidth(Region.USE_PREF_SIZE);
        slTime.setMinWidth(30);
        slTime.setValue(0);

        slTime.valueProperty().addListener(e -> mediaPlayer.seek(mediaPlayer.getStopTime().divide(100)
                .multiply(slTime.getValue())));

        HBox hBox = new HBox(10);
        hBox.setAlignment(Pos.CENTER);
        hBox.getChildren().addAll(playButton, rewindButton,
                new Label("Time"), slTime,
                new Label("Volume"), slVolume);

        BorderPane pane = new BorderPane();
        pane.setCenter(mediaView);
        pane.setBottom(hBox);

        Scene scene = new Scene(pane, 500, 500);
        primaryStage.setTitle("Problem$24");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
