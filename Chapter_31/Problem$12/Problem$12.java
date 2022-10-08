package chapter_thirty_one;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Line;
import javafx.scene.shape.Polyline;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * *31.12 (Plot the n² function) Write a program that plots the n²
 * function, as shown in Figure 31.51b 2a.
 *
 * @author Sharaf Qeshta
 */
public class Problem$12 extends Application
{
    @Override
    public void start(Stage stage)
    {
        Polyline polyline = new Polyline();
        for (double x = 0; x <= 20; x++)
            polyline.getPoints().addAll
                    (x, -x * x);


        polyline.setTranslateX(200);
        polyline.setScaleX(20);
        polyline.setScaleY(1.5);
        polyline.setStrokeWidth(1.0 / 25);


        Line line1 = new Line(10, 100, 420, 100);
        Line line2 = new Line(420, 100, 400, 90);
        Line line3 = new Line(420, 100, 400, 110);

        Line line4 = new Line(20, 10, 20, 200);
        Line line5 = new Line(20, 10, 10, 30);
        Line line6 = new Line(20, 10, 30, 30);

        Text text1 = new Text(380, 70, "X");
        Text text2 = new Text(40, 20, "Y");

        Pane pane = new Pane();
        pane.getChildren().addAll(polyline, line1, line2, line3, line4,
                line5, line6, text1, text2);

        Scene scene = new Scene(pane, 450, 200);
        stage.setTitle("Problem$12");
        stage.setScene(scene);
        stage.show();
    }
}
