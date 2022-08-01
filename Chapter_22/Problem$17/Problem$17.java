package chapter_twenty_two;

import javafx.application.Application;
import javafx.geometry.Point2D;
import javafx.scene.Scene;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.stage.Stage;

import java.util.ArrayList;

/**
 * **22.17 (Closest-pair animation) Write a program that enables the user to add/remove
 * points by clicking the left/right mouse button and displays a line that connects
 * the pair of nearest points, as shown in Figure 22.4.
 *
 *
 * @author Sharaf Qeshta
 */
public class Problem$17 extends Application
{
    private static final ArrayList<Point2D> POINTS = new ArrayList<>();

    @Override
    public void start(Stage primaryStage)
    {
        Pane pane = new Pane();
        Line line = new Line();
        pane.getChildren().add(line);

        pane.setOnMousePressed(e ->
        {
            Point2D point = new Point2D(e.getX(), e.getY());
            Circle circle = new Circle(e.getX(), e.getY(), 5);

            if (e.getButton() == MouseButton.PRIMARY)
            {
                POINTS.add(point);
                pane.getChildren().add(circle);
            }
            else
            {
                // delete circle
                int i;
                for (i = 0; i < pane.getChildren().size(); i++)
                {
                    if (pane.getChildren().get(i) instanceof Circle)
                    {
                        if (pane.getChildren().get(i).contains(e.getX(), e.getY()))
                        {
                            pane.getChildren().remove(pane.getChildren().get(i));
                            break;
                        }
                    }
                }
                POINTS.remove(i - 1);
            }
            if (POINTS.size() == 1 || POINTS.isEmpty())
                return;

            if (POINTS.size() == 2)
            {
                line.setStartX(POINTS.get(0).getX());
                line.setStartY(POINTS.get(0).getY());
                line.setEndX(POINTS.get(1).getX());
                line.setEndY(POINTS.get(1).getY());
            }
            else
            {
                Pair closestPair = ClosestPair.getClosestPair(toArray());
                line.setStartX(closestPair.p1.getX());
                line.setStartY(closestPair.p1.getY());
                line.setEndX(closestPair.p2.getX());
                line.setEndY(closestPair.p2.getY());
            }
        });


        Scene scene = new Scene(pane, 500, 500);
        primaryStage.setTitle("Problem$17");
        primaryStage.setScene(scene);
        primaryStage.show();
        pane.requestFocus();
    }

    public static Point2D[] toArray()
    {
        Point2D[] array = new Point2D[POINTS.size()];
        for (int i = 0; i < POINTS.size(); i++)
            array[i] = POINTS.get(i);
        return array;
    }
}
