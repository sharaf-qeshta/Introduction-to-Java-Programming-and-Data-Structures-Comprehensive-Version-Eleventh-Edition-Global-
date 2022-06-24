package chapter_fifteen;

import javafx.animation.PathTransition;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Polyline;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 * **15.25 (Animation: ball on curve) Write a program that animates a ball moving along
 * a cosine curve, as shown in Figure 15.34. When the ball gets to the right border,
 * it starts over from the left. Enable the user to resume/pause the animation with
 * a click on the left/right mouse button.
 *
 *
 * @author Sharaf Qeshta
 * */
public class Problem$25 extends Application
{
    public static void main(String[] args)
    {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage)
    {
        Pane pane = new Pane();


        Polyline polyline = new Polyline();
        ObservableList<Double> list = polyline.getPoints();
        double scaleFactor2 = 50;
        for (int x = -170; x <= 170; x++)
        {
            list.add(x + 250.0);
            list.add(100 - scaleFactor2 * Math.cos((x / 100.0) * 2 * Math.PI) + 150.0);
        }

        polyline.setStroke(Color.RED);

        Text zero = new Text(250, 250, "0");
        zero.setFont(Font.font(Font.getFontNames().get(0), FontWeight.BOLD, 15));

        Text minusPI = new Text(200, 250, "-\u03c0");
        minusPI.setFont(Font.font(Font.getFontNames().get(0), FontWeight.BOLD, 15));

        Text minus2PI = new Text(150, 250, "-2\u03c0");
        minus2PI.setFont(Font.font(Font.getFontNames().get(0), FontWeight.BOLD, 15));

        Text pi = new Text(300, 250, "\u03c0");
        pi.setFont(Font.font(Font.getFontNames().get(0), FontWeight.BOLD, 15));

        Text pi2 = new Text(350, 250, "2\u03c0");
        pi2.setFont(Font.font(Font.getFontNames().get(0), FontWeight.BOLD, 15));


        // cartesian plane lines
        // line 1 (horizontal)
        Line line1 = new Line();
        line1.setStartX(0);
        line1.startYProperty().bind(pane.heightProperty().divide(2));
        line1.endXProperty().bind(pane.widthProperty());
        line1.endYProperty().bind(pane.heightProperty().divide(2));


        // line 2 (vertical)
        Line line2 = new Line();
        line2.setStartY(0);
        line2.startXProperty().bind(pane.widthProperty().divide(2));
        line2.endYProperty().bind(pane.heightProperty());
        line2.endXProperty().bind(pane.widthProperty().divide(2));



        Circle circle = new Circle(list.get(0), list.get(1), 10);
        pane.getChildren().addAll(polyline, line1, line2, zero, minusPI, minus2PI, pi, pi2, circle);

        PathTransition pt = new PathTransition();
        pt.setDuration(Duration.millis(4000));
        pt.setPath(polyline);
        pt.setNode(circle);
        pt.setOrientation(PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT);
        pt.setCycleCount(Timeline.INDEFINITE);
        pt.setAutoReverse(true);
        pt.play();

        pane.setOnMousePressed(e ->
        {
            if (e.getButton() == MouseButton.PRIMARY)
                pt.pause();
            else if (e.getButton() == MouseButton.SECONDARY)
                pt.play();
        });

        Scene scene = new Scene(pane, 500, 500);
        primaryStage.setTitle("Problem$25");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
