package chapter_fourteen;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

/**
 * *14.6 (Game: display a checkerboard) Write a program that displays a checkerboard
 * in which each white and black cell is a Rectangle with a fill color black or
 * white, as shown in Figure 14.44c.
 *
 * @author Sharaf Qeshta
 * */
public class Problem$06 extends Application
{
    public static void main(String[] args)
    {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage)
    {
        GridPane pane = new GridPane();
        pane.setAlignment(Pos.CENTER);

        boolean white = true;
        for (int i = 0; i < 10; i++)
        {
            for (int j = 0; j < 10;j++)
            {
                Rectangle rectangle = new Rectangle();
                rectangle.setWidth(50);
                rectangle.setHeight(50);
                rectangle.setFill((white)? Color.WHITE : Color.BLACK);
                pane.add(rectangle, j, i);
                white = !white;
            }
            white = !white;
        }

        Scene scene = new Scene(pane, 500, 500);
        primaryStage.setTitle("Problem$06");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
