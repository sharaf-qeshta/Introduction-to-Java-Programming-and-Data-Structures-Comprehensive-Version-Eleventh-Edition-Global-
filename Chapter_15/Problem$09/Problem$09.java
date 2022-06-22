package chapter_fifteen;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Line;
import javafx.stage.Stage;

/**
 * *15.9 (Draw lines using the arrow keys) Write a program that draws line segments
 * using the arrow keys. The line starts from (100, 100) in the pane and draws
 * toward east, north, west, or south when the right-arrow key, up-arrow key,
 * left arrow key, or down-arrow key is pressed, as shown in Figure 15.2
 *
 *
 * @author Sharaf Qeshta
 * */
public class Problem$09 extends Application
{
    private static double lastX = 100;
    private static double lastY = 100;
    public static void main(String[] args)
    {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage)
    {
        Pane pane = new Pane();

        Scene scene = new Scene(pane, 500, 500);
        primaryStage.setTitle("Problem$09");
        primaryStage.setScene(scene);
        primaryStage.show();

        pane.setOnKeyPressed(e ->
        {
            switch (e.getCode())
            {
                case UP ->
                {
                    if (lastY-10 >= 0)
                    {
                        Line line = new Line(lastX, lastY, lastX, lastY-10);
                        pane.getChildren().add(line);
                        lastY -= 10;
                    }
                }
                case DOWN ->
                {
                    if (lastY+10 <= scene.getHeight())
                    {
                        Line line = new Line(lastX, lastY, lastX, lastY+10);
                        pane.getChildren().add(line);
                        lastY += 10;
                    }
                }

                case LEFT ->
                {
                    if (lastX-10 >= 0)
                    {
                        Line line = new Line(lastX, lastY, lastX-10, lastY);
                        pane.getChildren().add(line);
                        lastX -= 10;
                    }
                }

                case RIGHT ->
                {
                    if (lastX+10 <= scene.getWidth())
                    {
                        Line line = new Line(lastX, lastY, lastX+10, lastY);
                        pane.getChildren().add(line);
                        lastX += 10;
                    }
                }
            }
        });

        pane.requestFocus();
    }
}
