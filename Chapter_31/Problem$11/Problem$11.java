package chapter_thirty_one;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Polyline;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * *31.11 (Plot the log function) Write a program that plots the log function, as shown in
 * Figure 31.51a.
 *
 *
 * @author Sharaf Qeshta
 */
public class Problem$11 extends Application
{
    @Override
    public void start(Stage stage)
    {
        Polyline polyline = new Polyline();
        for (double x = 1; x <= 720; x += 10)
            polyline.getPoints().addAll
                    (x, Math.log10(x));

        polyline.setTranslateY(50);
        polyline.setTranslateX(-158);
        polyline.setScaleX(0.5);
        polyline.setScaleY(-28);
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
        stage.setTitle("Problem$11");
        stage.setScene(scene);
        stage.show();
    }
}
