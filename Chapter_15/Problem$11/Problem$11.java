package chapter_fifteen;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

/**
 * *15.11 (Move a circle using keys) Write a program that moves a circle up, down, left,
 * or right using the arrow keys.
 *
 *
 * @author Sharaf Qeshta
 * */
public class Problem$11 extends Application
{
    public static void main(String[] args)
    {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage)
    {
        Pane pane = new Pane();

        Scene scene = new Scene(pane, 500, 500);
        primaryStage.setTitle("Problem$11");
        primaryStage.setScene(scene);
        primaryStage.show();

        Circle circle = new Circle(scene.getWidth()/2, scene.getHeight()/2, 50);
        circle.setStroke(Color.BLACK);
        circle.setFill(Color.WHITE);
        pane.getChildren().add(circle);

        pane.setOnKeyPressed(e ->
        {
            switch (e.getCode())
            {
                case UP ->
                {
                    if (circle.getCenterY()-10 >= 0)
                        circle.setCenterY(circle.getCenterY()-10);
                }
                case DOWN ->
                {
                    if (circle.getCenterY()+10 <= scene.getHeight())
                        circle.setCenterY(circle.getCenterY()+10);
                }
                case LEFT ->
                {
                    if (circle.getCenterX()-10 >= 0)
                        circle.setCenterX(circle.getCenterX()-10);
                }
                case RIGHT ->
                {
                    if (circle.getCenterX()+10 <= scene.getWidth())
                        circle.setCenterX(circle.getCenterX()+10);
                }
            }
        });
        pane.requestFocus();
    }
}
