package chapter_thirty_six;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.stage.Stage;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import java.util.Locale;
import java.util.ResourceBundle;

/**
 * **36.10 (Flag and anthem) Rewrite Listing 16.13, ImageAudioAnimation.java, to use the
 * resource bundle to retrieve image and audio files.
 *  (Hint: When a new country is selected, set an appropriate locale for it. Have your
 * program look for the flag and audio file from the resource file for the locale.)
 *
 *
 * @author Sharaf Qeshta
 * */
public class Problem$10 extends Application
{
    private static final Locale[] LOCALES =
            {Locale.getAvailableLocales()[393],
                    Locale.getAvailableLocales()[238], Locale.getAvailableLocales()[510],
                    Locale.getAvailableLocales()[267], Locale.getAvailableLocales()[77],
                    Locale.getAvailableLocales()[514], Locale.getAvailableLocales()[208]};


    private ResourceBundle resourceBundle
            = ResourceBundle.getBundle("Problem$10Resource", LOCALES[0]);
    private MediaPlayer mediaPlayer =
            new MediaPlayer(new Media(resourceBundle.getString("anthem")));
    private final Image image = new Image(resourceBundle.getString("flag"));

    @Override
    public void start(Stage primaryStage)
    {
        Button btPlayPause = new Button("||");
        btPlayPause.setOnAction(e ->
        {
            if (btPlayPause.getText().equals(">"))
            {
                btPlayPause.setText("||");
                mediaPlayer.play();
            }
            else
            {
                btPlayPause.setText(">");
                mediaPlayer.pause();
            }
        });

        ImageView imageView = new ImageView(image);
        ComboBox<String> cboNation = new ComboBox<>();
        ObservableList<String> items = FXCollections.observableArrayList
                ("Denmark", "Germany", "China", "India", "Norway", "UK", "US");
        cboNation.getItems().addAll(items);
        cboNation.setValue(items.get(0));

        cboNation.setOnAction(e ->
        {
            mediaPlayer.stop();
            int currentIndex = items.indexOf(cboNation.getValue());
            resourceBundle = ResourceBundle.getBundle("Problem$10Resource",
                    LOCALES[currentIndex]);
            imageView.setImage(new Image(resourceBundle.getString("flag")));
            mediaPlayer = new MediaPlayer(
                    new Media(resourceBundle.getString("anthem")));
            mediaPlayer.play();
            btPlayPause.setText("||");
        });

        HBox hBox = new HBox(10);
        hBox.getChildren().addAll(btPlayPause,
                new Label("Select a nation: "), cboNation);
        hBox.setAlignment(Pos.CENTER);

        BorderPane pane = new BorderPane();
        pane.setCenter(imageView);
        pane.setBottom(hBox);

        Scene scene = new Scene(pane, 350, 270);
        primaryStage.setTitle("Problem$10");
        primaryStage.setScene(scene);
        primaryStage.show();
        mediaPlayer.play();
    }
}
