package chapter_fifteen;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

/**
 * **15.18 (Move a rectangle using mouse) Write a program that displays a rectangle.
 * You can point the mouse inside the rectangle and drag (i.e., move with mouse
 * pressed) the rectangle wherever the mouse goes. The mouse point becomes the
 * center of the rectangle.
 *
 *
 * @author Sharaf Qeshta
 * */
public class Problem$18 extends Application
{
    public static void main(String[] args)
    {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage)
    {
        Pane pane = new Pane();
        Rectangle rectangle = new Rectangle(80, 50, 150, 100);
        rectangle.setStroke(Color.BLACK);
        rectangle.setFill(Color.WHITE);
        pane.getChildren().add(rectangle);

        Scene scene = new Scene(pane, 500, 500);
        primaryStage.setTitle("Problem$18");
        primaryStage.setScene(scene);
        primaryStage.show();

        rectangle.setOnMouseDragged(e ->
        {
            rectangle.setX(e.getX() - 75);
            rectangle.setY(e.getY() - 50);
        });
    }
}
