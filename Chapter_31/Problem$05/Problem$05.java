package chapter_thirty_one;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.CubicCurve;
import javafx.stage.Stage;

/**
 * *31.5 (Cubic curve) Write a program that creates two shapes: a circle and a path consisting
 * of two cubic curves, as shown in Figure 31.49b.
 *
 *
 * @author Sharaf Qeshta
 * */
public class Problem$05 extends Application
{
    @Override
    public void start(Stage stage)
    {
        Pane pane = new Pane();

        Circle circle = new Circle(250, 250, 50);
        circle.setFill(Color.BLACK);

        CubicCurve curve1 = new CubicCurve(250, 250, 300, 200, 200, 200, 250, 250);
        curve1.setFill(Color.WHITE);

        CubicCurve curve2 = new CubicCurve(250, 250, 300, 300, 200, 300, 250, 250);
        curve2.setFill(Color.WHITE);

        pane.getChildren().addAll(circle, curve1, curve2);

        Scene scene = new Scene(pane, 500, 500);
        stage.setTitle("Problem$05");
        stage.setScene(scene);
        stage.show();
    }
}
