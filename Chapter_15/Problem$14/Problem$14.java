package chapter_fifteen;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.text.DecimalFormat;

/**
 * **15.14 (Geometry: inside a polygon?) Write a program that draws a fixed polygon
 * with points at (30, 10), (60, 30), (50, 70), (35, 35), and (10, 50). Whenever
 * the mouse is moved, display a message indicating whether the mouse
 * point is inside the polygon at the mouse point or outside of it, as shown in
 * Figure 15.29c. To detect whether a point is inside a polygon, use the contains
 * method defined in the Node class.
 *
 *
 * @author Sharaf Qeshta
 * */
public class Problem$14 extends Application
{
    public static void main(String[] args)
    {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage)
    {
        Pane pane = new Pane();

        Polygon polygon = new Polygon(30, 10, 60, 30, 50, 70, 35, 35, 10, 50);
        polygon.setFill(Color.WHITE);
        polygon.setStroke(Color.BLACK);
        Text text = new Text();

        pane.getChildren().addAll(polygon, text);

        Scene scene = new Scene(pane, 500, 500);
        primaryStage.setTitle("Problem$14");
        primaryStage.setScene(scene);
        primaryStage.show();

        DecimalFormat df = new DecimalFormat(".00");

        pane.setOnMouseMoved(e ->
        {
            double x = e.getX();
            double y = e.getY();
            String point = "(" + df.format(x) + ", " + df.format(y) + ")";
            text.setX(x);
            text.setY(y);

            if (polygon.contains(x, y))
                text.setText("point " + point + " inside the polygon");
            else
                text.setText("point " + point + " is outside the polygon");
        });
    }
}
