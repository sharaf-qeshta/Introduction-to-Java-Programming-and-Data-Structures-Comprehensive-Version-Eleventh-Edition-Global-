package chapter_fourteen;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.stage.Stage;

/**
 * *14.11 (Paint a smiley face) Write a program that paints a smiley face, as shown in
 * Figure 14.46a.
 *
 * @author Sharaf Qeshta
 * */
public class Problem$11 extends Application
{
    public static final double CENTER = 250;
    public static void main(String[] args)
    {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage)
    {
        Pane pane = new Pane();

        // drawing the outer border of the face
        Circle face = new Circle(CENTER, CENTER, 50);
        face.setFill(Color.WHITE); face.setStroke(Color.BLACK);

        // drawing the eye`s container
        Ellipse ellipse1 = new Ellipse(CENTER+20, CENTER-25, 15, 10);
        ellipse1.setFill(Color.WHITE); ellipse1.setStroke(Color.BLACK);

        Ellipse ellipse2 = new Ellipse(CENTER-20, CENTER-25, 15, 10);
        ellipse2.setFill(Color.WHITE); ellipse2.setStroke(Color.BLACK);

        // drawing the eyes
        Circle eye1 = new Circle(CENTER+20, CENTER-25, 8);
        Circle eye2 = new Circle(CENTER-20, CENTER-25, 8);

        // drawing the nose
        Line line1 = new Line(CENTER, CENTER-15, CENTER+20, CENTER+5);
        Line line2 = new Line(CENTER+20, CENTER+5, CENTER, CENTER+5);

        // draw the smile
        Arc arc = new Arc(CENTER, CENTER+10, 25, 15, 0, -180);
        arc.setType(ArcType.OPEN); arc.setFill(Color.WHITE); arc.setStroke(Color.BLACK);

        pane.getChildren().addAll(face,ellipse1, ellipse2, eye1, eye2, line1, line2, arc);
        Scene scene = new Scene(pane, 500, 500);
        primaryStage.setTitle("Problem$11");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
