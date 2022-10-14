package chapter_thirty_two;

import javafx.animation.PathTransition;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Line;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 * 32.3 (Raise flags) Rewrite Listing 15.13 using a thread to animate a flag being raised.
 * Compare the program with Listing 15.13 by setting the delay time to 10 in both
 * programs. Which one runs the animation faster?
 *
 *
 * @author Sharaf Qeshta
 * */
public class problem$03 extends Application
{
    @Override
    public void start(Stage stage)
    {
        Pane pane = new Pane();

        ImageView imageView = new ImageView("chapter_thirty_two/us.png");
        pane.getChildren().add(imageView);

        Thread raisingFlagThread = new Thread(() ->
        {
            Platform.runLater(() ->
            {
                PathTransition pt = new PathTransition(Duration.millis(10000),
                        new Line(250, 500, 250, 100), imageView);
                pt.setCycleCount(Timeline.INDEFINITE);
                pt.play();
            });
        });

        raisingFlagThread.start();

        Scene scene = new Scene(pane, 500, 500);
        stage.setTitle("problem$03");
        stage.setScene(scene);
        stage.show();
    }
}
