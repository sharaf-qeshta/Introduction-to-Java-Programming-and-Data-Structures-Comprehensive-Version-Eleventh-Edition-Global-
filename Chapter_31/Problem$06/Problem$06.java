package chapter_thirty_one;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Ellipse;
import javafx.stage.Stage;

/**
 * *31.6 (Eyes) Write a program that displays two eyes in an oval, as shown in Figure 31.49c.
 *
 *
 * @author Sharaf Qeshta
 * */
public class Problem$06 extends Application
{
    @Override
    public void start(Stage stage)
    {
        Pane pane = new Pane();

        Ellipse ellipse = new Ellipse(250, 250, 150, 60);

        Circle eye1 = new Circle(200, 220, 20);
        eye1.setFill(Color.WHITE);

        Circle eye2 = new Circle(300, 220, 20);
        eye2.setFill(Color.WHITE);

        pane.getChildren().addAll(ellipse, eye1, eye2);

        Scene scene = new Scene(pane, 500, 500);
        stage.setScene(scene);
        stage.setTitle("Problem$06");
        stage.show();
    }
}
