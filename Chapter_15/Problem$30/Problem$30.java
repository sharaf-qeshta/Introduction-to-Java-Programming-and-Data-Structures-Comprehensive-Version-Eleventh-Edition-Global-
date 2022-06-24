package chapter_fifteen;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.File;
import java.util.ArrayList;
import java.util.Objects;

/**
 * **15.30 (Slide show) Twenty-five slides are stored as image files (slide0.jpg, slide1.
 * jpg, . . . , slide24.jpg) in the image directory downloadable along with the
 * source code in the book. The size of each image is 800 * 600. Write a program
 * that automatically displays the slides repeatedly. Each slide is shown for two
 * seconds. The slides are displayed in order. When the last slide finishes, the first
 * slide is redisplayed, and so on. Click to pause if the animation is currently playing.
 * Click to resume if the animation is currently
 *
 *
 *
 * @author Sharaf Qeshta
 * */
public class Problem$30 extends Application
{
    public static void main(String[] args)
    {
        launch(args);
    }

    private static final ArrayList<ImageView> images = getAllImages();
    private static ImageView image;
    private static int index = 0;
    @Override
    public void start(Stage primaryStage)
    {
        VBox pane = new VBox();
        pane.setAlignment(Pos.CENTER);
        pane.setSpacing(20);

        image = images.get(index);

        HBox hBox = new HBox();
        hBox.setAlignment(Pos.CENTER);
        hBox.setSpacing(20);

        EventHandler<ActionEvent> eventHandler = e ->
        {
            if (index < images.size())
            {
                image = images.get(index++);
                pane.getChildren().set(0, image);
            }
            else
                index = 0;
        };

        Timeline animation = new Timeline(
                new KeyFrame(Duration.millis(500), eventHandler)
        );

        animation.setCycleCount(Timeline.INDEFINITE);
        animation.setAutoReverse(true);
        animation.play();

        Button pause = new Button("Pause");
        Button play = new Button("Play");


        pause.setOnAction(e -> animation.pause());
        play.setOnAction(e -> animation.play());


        hBox.getChildren().addAll(pause, play);

        pane.getChildren().addAll(image, hBox);


        Scene scene = new Scene(pane, 500, 500);
        primaryStage.setTitle("Problem$30");
        primaryStage.setScene(scene);
        primaryStage.show();

        pane.requestFocus();
    }

    private static ArrayList<ImageView> getAllImages()
    {
        ArrayList<ImageView> images = new ArrayList<>();
        File[] cards = new File("src/chapter_fifteen/PNG-cards-1.3").listFiles();
        for (int i = 0; i < Objects.requireNonNull(cards).length; i++)
        {
            ImageView node = new ImageView("sample/PNG-cards-1.3/" + cards[i].getName());
            node.setFitHeight(200);
            node.setFitWidth(100);
            images.add(node);
        }
        return images;
    }
}
