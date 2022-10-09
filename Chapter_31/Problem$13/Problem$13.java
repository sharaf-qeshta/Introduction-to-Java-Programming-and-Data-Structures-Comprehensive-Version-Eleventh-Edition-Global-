package chapter_thirty_one;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Line;
import javafx.scene.shape.Polyline;
import javafx.scene.text.Text;
import javafx.stage.Stage;


/**
 * *31.13 (Plot the log, n, nlogn, and n² functions) Write a program that plots the log, n, nlogn,
 * and n² functions, as shown in Figure 31.52b.
 *
 *
 *  @author Sharaf Qeshta
 *  */
public class Problem$13 extends Application
{
    @Override
    public void start(Stage stage)
    {
        // Draw Log n
        Polyline logN = new Polyline();
        for (double x = 1; x <= 720; x += 10)
            logN.getPoints().addAll
                    (x, Math.log10(x));

        logN.setTranslateY(50);
        logN.setTranslateX(-158);
        logN.setScaleX(0.5);
        logN.setScaleY(-28);
        logN.setStrokeWidth(1.0 / 25);


        // Draw n Log n
        Polyline nLogN = new Polyline();
        for (double x = 50; x <= 100; x++)
            nLogN.getPoints().addAll
                    (x, x * Math.log10(x));

        nLogN.setTranslateY(8);
        nLogN.setTranslateX(-158);
        nLogN.setScaleX(20);
        nLogN.setScaleY(-5);
        nLogN.setStrokeWidth(1.0 / 25);


        // Draw n²
        Polyline nSquared = new Polyline();
        for (double x = 0; x <= 20; x++)
            nSquared.getPoints().addAll
                    (x, -x * x);


        nSquared.setTranslateX(200);
        nSquared.setScaleX(20);
        nSquared.setScaleY(1.5);
        nSquared.setStrokeWidth(1.0 / 25);


        Line line1 = new Line(10, 100, 420, 100);
        Line line2 = new Line(420, 100, 400, 90);
        Line line3 = new Line(420, 100, 400, 110);

        Line line4 = new Line(20, 10, 20, 200);
        Line line5 = new Line(20, 10, 10, 30);
        Line line6 = new Line(20, 10, 30, 30);

        Text text1 = new Text(380, 70, "X");
        Text text2 = new Text(40, 20, "Y");

        Pane pane = new Pane();
        pane.getChildren().addAll(logN, nLogN, nSquared, line1, line2, line3, line4,
                line5, line6, text1, text2);

        Scene scene = new Scene(pane, 450, 200);
        stage.setTitle("Problem$13");
        stage.setScene(scene);
        stage.show();
    }
}
