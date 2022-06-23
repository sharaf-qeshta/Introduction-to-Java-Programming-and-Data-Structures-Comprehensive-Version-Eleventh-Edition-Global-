package chapter_fifteen;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * *15.16 (Two movable vertices and their distances) Write a program that displays two
 * circles with radius 10 at location (40, 40) and (120, 150) with a line connecting
 * the two circles, as shown in Figure 15.30b. The distance between the circles
 * is displayed along the line. The user can drag a circle. When that happens, the
 * circle and its line are moved, and the distance between the circles is updated.
 *
 *
 * @author Sharaf Qeshta
 * */
public class Problem$16 extends Application
{

    public static void main(String[] args)
    {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage)
    {
        Pane pane = new Pane();

        Circle circle1 = new Circle(40, 40, 10);
        Circle circle2 = new Circle(120, 150, 10);

        circle1.setFill(Color.WHITE);
        circle1.setStroke(Color.BLACK);
        circle2.setFill(Color.WHITE);
        circle2.setStroke(Color.BLACK);

        Line line = new Line(circle1.getCenterX(), circle1.getCenterY(),
                circle2.getCenterX(), circle2.getCenterY());

        double distance = Math.sqrt(Math.pow(circle1.getCenterX() - circle2.getCenterX(), 2)
                + Math.pow(circle1.getCenterY() - circle2.getCenterY(), 2));


        Text text = new Text((line.getStartX()+ line.getEndX())/2, // midpoint
                (line.getStartY()+ line.getEndY())/2, Math.ceil(distance) + "");

        pane.getChildren().addAll(line, circle1, circle2, text);

        Scene scene = new Scene(pane, 500, 500);
        primaryStage.setTitle("Problem$16");
        primaryStage.setScene(scene);
        primaryStage.show();


        circle1.setOnMouseDragged(e ->
        {
            circle1.setCenterX(e.getX());
            circle1.setCenterY(e.getY());

            double distance_ = Math.sqrt(Math.pow(circle1.getCenterX() - circle2.getCenterX(), 2)
                    + Math.pow(circle1.getCenterY() - circle2.getCenterY(), 2));
            text.setText(Math.ceil(distance_) + "");
            text.setX((line.getStartX()+ line.getEndX())/2);
            text.setY((line.getStartY()+ line.getEndY())/2);

            line.setStartX(e.getX());
            line.setStartY(e.getY());
        });

        circle2.setOnMouseDragged(e ->
        {
            circle2.setCenterX(e.getX());
            circle2.setCenterY(e.getY());

            double distance_ = Math.sqrt(Math.pow(circle1.getCenterX() - circle2.getCenterX(), 2)
                    + Math.pow(circle1.getCenterY() - circle2.getCenterY(), 2));
            text.setText(Math.ceil(distance_) + "");
            text.setX((line.getStartX()+ line.getEndX())/2);
            text.setY((line.getStartY()+ line.getEndY())/2);

            line.setEndX(e.getX());
            line.setEndY(e.getY());
        });
    }
}
