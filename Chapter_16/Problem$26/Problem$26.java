package chapter_sixteen;

import javafx.animation.PathTransition;
import javafx.application.Application;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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
import javafx.scene.shape.Line;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 * **16.26 (Simulation: raise flag and play anthem) Write a program that displays a flag
 * rising up, as shown in Figure 15.15. As the national flag rises, play the national
 * anthem. (You may use a flag image and anthem audio file from Listing 16.15.)
 *
 *
 * @author Sharaf Qeshta
 * */
public class Problem$26 extends Application
{
    private final static int NUMBER_OF_NATIONS = 7;
    private final static String URLBase =
            "https://liveexample.pearsoncmg.com/common";
    private int currentIndex = 0;
    Line pole;

    @Override
    public void start(Stage primaryStage)
    {
        Image[] images = new Image[NUMBER_OF_NATIONS];
        MediaPlayer[] mp = new MediaPlayer[NUMBER_OF_NATIONS];

        // Load images and audio
        for (int i = 0; i < NUMBER_OF_NATIONS; i++)
        {
            images[i] = new Image(URLBase + "/image/flag" + i + ".gif");
            mp[i] = new MediaPlayer(new Media(
                    URLBase + "/audio/anthem/anthem" + i + ".mp3"));
        }

        Button btPlayPause = new Button("||");
        btPlayPause.setOnAction(e ->
        {
            if (btPlayPause.getText().equals(">"))
            {
                btPlayPause.setText("||");
                mp[currentIndex].play();
            }
            else
            {
                btPlayPause.setText(">");
                mp[currentIndex].pause();
            }
        });

        ImageView imageView = new ImageView(images[currentIndex]);
        ComboBox<String> cboNation = new ComboBox<>();
        ObservableList<String> items = FXCollections.observableArrayList
                ("Denmark", "Germany", "China", "India", "Norway", "UK", "US");
        cboNation.getItems().addAll(items);
        cboNation.setValue(items.get(0));
        cboNation.setOnAction(e ->
        {
            mp[currentIndex].stop();
            currentIndex = items.indexOf(cboNation.getValue());
            imageView.setImage(images[currentIndex]);
            // animation
            PathTransition animation = new PathTransition(
                    Duration.millis(4000), pole, imageView
            );
            animation.setCycleCount(1);
            animation.play();

            mp[currentIndex].play();
            btPlayPause.setText("||");
        });

        HBox hBox = new HBox(10);
        hBox.getChildren().addAll(btPlayPause,
                new Label("Select a nation: "), cboNation);
        hBox.setAlignment(Pos.CENTER);


        BorderPane pane = new BorderPane();
        pane.setCenter(imageView);
        pane.setBottom(hBox);

        Scene scene = new Scene(pane, 500, 500);
        primaryStage.setTitle("Problem$26");
        primaryStage.setScene(scene);
        primaryStage.show();
        mp[currentIndex].play();

        // pole
        pole = new Line();
        pole.startXProperty().bind(pane.widthProperty().divide(2));
        pole.startYProperty().bind(pane.heightProperty());
        pole.endXProperty().bind(pane.widthProperty().divide(2));
        pole.endYProperty().bind(new SimpleDoubleProperty(0));
    }
}
