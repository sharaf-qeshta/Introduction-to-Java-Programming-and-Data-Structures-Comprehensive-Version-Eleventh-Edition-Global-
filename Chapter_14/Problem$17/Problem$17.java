package chapter_fourteen;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.stage.Stage;

/**
 * 14.17 (Game: hangman) Write a program that displays a drawing for the popular hangman
 * game, as shown in Figure 14.48a.
 *
 *
 * @author Sharaf Qeshta
 * */
public class Problem$17 extends Application
{
    public static void main(String[] args)
    {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage)
    {
        Pane pane = new Pane();

        // base
        Arc arc = new Arc(150, 500, 150, 150, 45, 90);
        arc.setFill(Color.WHITE);
        arc.setType(ArcType.OPEN);
        arc.setStroke(Color.BLACK);

        // stick
        Line line1 = new Line();
        line1.setStartX(150);
        line1.setStartY(350);
        line1.setEndX(150);
        line1.setEndY(100);

        Line line2 = new Line();
        line2.setStartX(150);
        line2.setStartY(100);
        line2.setEndX(300);
        line2.setEndY(100);

        Line line3 = new Line();
        line3.setStartX(300);
        line3.setStartY(100);
        line3.setEndX(300);
        line3.setEndY(150);

        // head
        Circle circle = new Circle();
        circle.setCenterX(300);
        circle.setCenterY(175);
        circle.setRadius(25);
        circle.setFill(Color.WHITE);
        circle.setStroke(Color.BLACK);


        // body
        Line line4 = new Line();
        line4.setStartX(300);
        line4.setStartY(200);
        line4.setEndX(300);
        line4.setEndY(300);


        // hands
        Line line5 = new Line();
        line5.setStartX(300);
        line5.setStartY(200);
        line5.setEndX(350);
        line5.setEndY(250);

        Line line6 = new Line();
        line6.setStartX(300);
        line6.setStartY(200);
        line6.setEndX(250);
        line6.setEndY(250);


        // legs
        Line line7 = new Line();
        line7.setStartX(300);
        line7.setStartY(300);
        line7.setEndX(350);
        line7.setEndY(350);

        Line line8 = new Line();
        line8.setStartX(300);
        line8.setStartY(300);
        line8.setEndX(250);
        line8.setEndY(350);


        pane.getChildren().addAll(arc, line1, line2, line3, circle,
                line4, line5, line6, line7, line8);

        Scene scene = new Scene(pane, 500, 500);
        primaryStage.setTitle("Problem$17");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
