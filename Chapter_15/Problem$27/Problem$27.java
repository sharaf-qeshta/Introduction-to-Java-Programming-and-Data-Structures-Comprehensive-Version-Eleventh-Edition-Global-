package chapter_fifteen;

import javafx.animation.PathTransition;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 * *15.27 (Control a moving text) Write a program that displays a moving text, as shown
 * in Figures 15.35a and b. The text moves from left to right circularly. When it
 * disappears in the right, it reappears from the left. The text freezes when the
 * mouse is pressed and moves again when the button is released.
 *
 *
 * @author Sharaf Qeshta
 * */
public class Problem$27 extends Application
{
    public static void main(String[] args)
    {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage)
    {
        Pane pane = new Pane();

        Text text = new Text(10, 10, "Welcome to Java");
        Line line = new Line(-40, 250, 550, 250);

        pane.getChildren().add(text);

        PathTransition pt = new PathTransition();
        pt.setDuration(Duration.millis(4000));
        pt.setPath(line);
        pt.setNode(text);
        pt.setOrientation(PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT);
        pt.setCycleCount(Timeline.INDEFINITE);
        pt.play();

        pane.setOnMousePressed(e -> pt.pause());
        pane.setOnMouseReleased(e -> pt.play());


        Scene scene = new Scene(pane, 500, 500);
        primaryStage.setTitle("Problem$27");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
