package chapter_fourteen;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Polygon;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.Locale;
import java.util.Scanner;

/**
 * *14.24 (Geometry: Inside a polygon?) Write a program that prompts the user to enter
 * the coordinates of five points from the command line. The first four points form a
 * polygon, and the program displays the polygon and a text that indicates whether
 * the fifth point is inside the polygon, as shown in Figure 14.51a. (Hint: Use the
 * Node’s contains method to test whether a point is inside a node.)
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
        Scanner scanner = new Scanner(System.in).useLocale(Locale.US);
        double[][] points = new double[5][2];

        for (int i = 0; i < points.length;i++)
        {
            System.out.print("enter point " + (i+1) + " coordinates (X, Y): ");
            double x = scanner.nextDouble();
            double y = scanner.nextDouble();
            points[i][0] = x;
            points[i][1] = y;
        }

        Polygon polygon = new Polygon();
        polygon.setStroke(Color.BLACK);
        polygon.setFill(Color.WHITE);
        polygon.getPoints().addAll
        (
                points[0][0], points[0][1],
                points[1][0], points[1][1],
                points[2][0], points[2][1],
                points[3][0], points[3][1]
        );

        String output = "(" + points[4][0] + ", " + points[4][1] + ") ";
        if (polygon.contains(points[4][0], points[4][1]))
            output += "in the polygon";
        else
            output += "not in the polygon";

        Text text = new Text(output);
        text.xProperty().bind(pane.widthProperty().divide(2));
        text.yProperty().bind(pane.heightProperty());

        Circle circle = new Circle(points[4][0], points[4][1], 10);


        pane.getChildren().addAll(polygon, text, circle);

        Scene scene = new Scene(pane, 500, 500);
        primaryStage.setTitle("Problem$24");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
