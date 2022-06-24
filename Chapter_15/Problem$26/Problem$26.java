package chapter_fifteen;

import javafx.animation.FadeTransition;
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
 * *15.26 (Change opacity) Rewrite Programming Exercise 15.24 so the ball’s opacity is
 * changed as it swings.
 *
 *
 * @author Sharaf Qeshta
 * */
public class Problem$26 extends Application
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

        FadeTransition ft = new FadeTransition(Duration.millis(4000), circle);
        ft.setFromValue(1.0);
        ft.setToValue(0.1);
        ft.setCycleCount(Timeline.INDEFINITE);
        ft.setAutoReverse(true);
        ft.play();

        Scene scene = new Scene(pane, 500, 500);
        primaryStage.setTitle("Problem$26");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
