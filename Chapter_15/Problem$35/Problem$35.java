package chapter_fifteen;

import javafx.application.Application;
import javafx.geometry.Point2D;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * ***15.35 (Animation: self-avoiding random walk) Revise the preceding
 * exercise to display the walk step by step in an animation, as shown in Figures 15.39c
 *
 *
 * @author Sharaf Qeshta
 * */
public class Problem$35 extends Application
{
    public static void main(String[] args)
    {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage)
    {
        LatticePane pane = new LatticePane();
        Point2D endPoint = new Point2D(250+pane.getHorizontalStep(),
                250+pane.getVerticalStep());
        Path path = new Path(pane, pane.getVerticalStep(),
                pane.getHorizontalStep(), endPoint);

        Scene scene = new Scene(pane, 500, 500);
        primaryStage.setTitle("Problem$35");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
