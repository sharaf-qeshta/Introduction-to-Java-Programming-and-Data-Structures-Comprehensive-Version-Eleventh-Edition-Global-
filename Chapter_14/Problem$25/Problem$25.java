package chapter_fourteen;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Polygon;
import javafx.stage.Stage;

/**
 * *14.25 (Random points on a circle) Modify Programming Exercise 4.6 to create five
 * random points on a circle, form a polygon by connecting the points clockwise,
 * and display the circle and the polygon, as shown in Figure 14.51b.
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

        double randomCenterX = ((Math.random() * 1000) % 300) + 100; // 100 -> 399
        double randomCenterY = ((Math.random() * 1000) % 300) + 100; // 100 -> 399
        double randomRadius = ((Math.random() * 100) % 200) + 10; // 10 -> 209

        Circle circle = new Circle(randomCenterX, randomCenterY, randomRadius);
        circle.setFill(Color.WHITE);
        circle.setStroke(Color.BLACK);


        double[][] points = new double[5][2];
        for (int i = 0; i < points.length;i++)
        {
            double randomAngle = (Math.random() * 500) % 360;
            double x = randomRadius * Math.cos(Math.toRadians(randomAngle)) + randomCenterX;
            double y = randomRadius * Math.sin(Math.toRadians(randomAngle)) + randomCenterY;

            points[i][0] = x;
            points[i][1] = y;
        }

        Polygon polygon = new Polygon();
        polygon.getPoints().addAll(
                points[0][0], points[0][1],
                points[1][0], points[1][1],
                points[2][0], points[2][1],
                points[3][0], points[3][1],
                points[4][0], points[4][1],
                points[0][0], points[0][1]
        );
        polygon.setFill(Color.WHITE);
        polygon.setStroke(Color.BLACK);



        pane.getChildren().addAll(circle, polygon);


        Scene scene = new Scene(pane, 500, 500);
        primaryStage.setTitle("Problem$25");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
