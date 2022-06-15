package chapter_fourteen;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Line;
import javafx.stage.Stage;

/**
 * *14.10 (Display a cylinder) Write a program that draws a cylinder, as shown in Figure 14.45b.
 * You can use the following method to set the dashed stroke for an arc:
 * arc.getStrokeDashArray().addAll(6.0, 21.0);
 * The solution posted on the website enables the cylinder to resize horizontally.
 * Can you revise it to resize vertically as well?
 *
 * @author Sharaf Qeshta
 * */
public class Problem$10 extends Application
{
    public static void main(String[] args)
    {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage)
    {
        Pane pane = new Pane();

        Ellipse ellipse = new Ellipse(250, 250, 50, 20);
        ellipse.setStroke(Color.BLACK);
        ellipse.setFill(Color.WHITE);

        double line1StartX = ellipse.getCenterX() + ellipse.getRadiusX();
        double line1StartY = ellipse.getCenterY();
        Line line1 = new Line(line1StartX, line1StartY
                        , line1StartX, line1StartY+100);

        double line2StartX = ellipse.getCenterX() - ellipse.getRadiusX();
        double line2StartY = ellipse.getCenterY();
        Line line2 = new Line(line2StartX, line2StartY, line2StartX, line2StartY+100);


        Arc arc1 = new Arc(ellipse.getCenterX(), ellipse.getCenterY()+100, 50, 20,
                0, -180);
        arc1.setType(ArcType.OPEN);
        arc1.setFill(Color.WHITE);
        arc1.setStroke(Color.BLACK);

        Arc arc2 = new Arc(ellipse.getCenterX(), ellipse.getCenterY()+100, 50, 20,
                0, 180);
        arc2.setType(ArcType.OPEN);
        arc2.setFill(Color.WHITE);
        arc2.setStroke(Color.BLACK);
        arc2.getStrokeDashArray().addAll(6.0, 21.0);

        pane.getChildren().addAll(ellipse, line1, line2, arc1, arc2);

        Scene scene = new Scene(pane, 500, 500);
        primaryStage.setTitle("Problem$10");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
