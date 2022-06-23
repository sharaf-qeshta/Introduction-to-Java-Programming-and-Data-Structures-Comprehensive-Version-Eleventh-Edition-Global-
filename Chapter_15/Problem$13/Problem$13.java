package chapter_fifteen;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.text.DecimalFormat;

/**
 * **15.13 (Geometry: inside a rectangle?) Write a program that draws a fixed rectangle
 * centered at (80, 50) with width 100 and height 30. Whenever the mouse is
 * moved, display a message indicating whether the mouse point is inside the rectangle
 * at the mouse point or outside of it, as shown in Figure 15.29b. To detect
 * whether a point is inside a polygon, use the contains method defined in the
 * Node class.
 *
 *
 * @author Sharaf Qeshta
 * */
public class Problem$13 extends Application
{
    public static void main(String[] args)
    {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage)
    {
        Pane pane = new Pane();

        Rectangle rectangle = new Rectangle(80, 50, 100, 30);
        rectangle.setFill(Color.WHITE);
        rectangle.setStroke(Color.BLACK);
        Text text = new Text();
        text.setVisible(false);

        pane.getChildren().addAll(rectangle, text);

        Scene scene = new Scene(pane, 500, 500);
        primaryStage.setTitle("Problem$13");
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

            if (rectangle.contains(x, y))
                text.setText("point " + point + " inside the rectangle");
            else
                text.setText("point " + point + " is not in the rectangle");
            text.setVisible(true);
        });
    }
}
