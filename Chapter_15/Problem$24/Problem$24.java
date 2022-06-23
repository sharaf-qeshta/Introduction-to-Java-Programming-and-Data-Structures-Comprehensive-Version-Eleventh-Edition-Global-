package chapter_fifteen;

import javafx.animation.PathTransition;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 * **15.24 (Animation: pendulum swing) Write a program that animates a pendulum
 * swing, as shown in Figure 15.33. Press/release the mouse to pause/resume the
 * animation.
 *
 *
 * @author Sharaf Qeshta
 * */
public class Problem$24 extends Application
{
    public static void main(String[] args)
    {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage)
    {
        Pane pane = new Pane();

        Arc arc = new Arc(250, 250, 150, 100, 0, -180);
        arc.setType(ArcType.OPEN);
        arc.setFill(Color.WHITE);
        arc.setStroke(Color.BLACK);

        Circle circle = new Circle(250, 350, 10);

        pane.getChildren().addAll(arc, circle);

        PathTransition pt = new PathTransition();
        pt.setDuration(Duration.millis(4000));
        pt.setPath(arc);
        pt.setNode(circle);
        pt.setOrientation(PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT);
        pt.setCycleCount(Timeline.INDEFINITE);
        pt.setAutoReverse(true);
        pt.play();

        pane.setOnMousePressed(e -> pt.pause());
        pane.setOnMouseReleased(e -> pt.play());

        Scene scene = new Scene(pane, 500, 500);
        primaryStage.setTitle("Problem$24");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
