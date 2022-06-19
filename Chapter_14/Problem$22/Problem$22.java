package chapter_fourteen;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * *14.22 (Connect two circles) Write a program that draws two filled circles with radius
 * 15 pixels, centered at random locations, with a line connecting the two circles.
 * The line should not cross inside the circles, as shown in Figure 14.49c.
 *
 *
 * @author Sharaf Qeshta
 * */
public class Problem$22 extends Application
{
    public static void main(String[] args)
    {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage)
    {
        Pane pane = new Pane();

        draw(pane);

        Scene scene = new Scene(pane, 500, 500);
        primaryStage.setTitle("Problem$22");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void draw(Pane pane)
    {
        Circle circle1 = new Circle();
        double centerX1 = ((Math.random() * 1000) % 300) + 100;
        double centerY1 = ((Math.random() * 1000) % 300) + 100;
        circle1.setCenterX(centerX1);
        circle1.setCenterY(centerY1);
        circle1.setRadius(15);
        circle1.setFill(Color.WHITE);
        circle1.setStroke(Color.BLACK);

        Circle circle2 = new Circle();
        double centerX2 = ((Math.random() * 1000) % 300) + 100;
        double centerY2 = ((Math.random() * 1000) % 300) + 100;
        circle2.setCenterX(centerX2);
        circle2.setCenterY(centerY2);
        circle2.setRadius(15);
        circle2.setFill(Color.WHITE);
        circle2.setStroke(Color.BLACK);

        Text one = new Text(centerX1, centerY1, "1");
        Text two = new Text(centerX2, centerY2, "2");


        Line connectCircles = new Line(centerX1, centerY1, centerX2, centerY2);


        pane.getChildren().addAll(connectCircles, circle1, circle2
                , one, two);
    }
}
