package chapter_fourteen;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

/**
 * 14.14 (Display a rectanguloid) Write a program that displays a rectanguloid, as
 * shown in Figure 14.47a. The cube should grow and shrink as the window grows
 * or shrinks.
 *
 * @author Sharaf Qeshta
 * */
public class Problem$14 extends Application
{
    public static void main(String[] args)
    {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage)
    {
        Pane pane = new Pane();

        Rectangle rectangle1 = new Rectangle();
        rectangle1.setX(0);
        rectangle1.setY(0);
        rectangle1.setFill(Color.WHITE);
        rectangle1.setStroke(Color.BLACK);
        rectangle1.setHeight(100);
        rectangle1.setWidth(150);


        Rectangle rectangle2 = new Rectangle();
        rectangle2.setX(50);
        rectangle2.setY(50);
        rectangle2.setFill(Color.WHITE);
        rectangle2.setStroke(Color.BLACK);
        rectangle2.setHeight(100);
        rectangle2.setWidth(150);

        Line line1 = new Line();
        line1.setStartX(0);
        line1.setStartY(0);

        line1.setEndX(50);
        line1.setEndY(50);

        Line line2 = new Line();
        line2.setStartX(150);
        line2.setStartY(0);

        line2.setEndX(200);
        line2.setEndY(50);

        Line line3 = new Line();
        line3.setStartX(0);
        line3.setStartY(100);

        line3.setEndX(50);
        line3.setEndY(150);

        Line line4 = new Line();
        line4.setStartX(150);
        line4.setStartY(100);

        line4.setEndX(200);
        line4.setEndY(150);

        Line line5 = new Line();
        line5.setStartX(50);
        line5.setStartY(100);

        line5.setEndX(150);
        line5.setEndY(100);

        Line line6 = new Line();
        line6.setStartX(150);
        line6.setStartY(50);

        line6.setEndX(150);
        line6.setEndY(100);

        pane.getChildren().addAll(rectangle1, rectangle2, line1,
                line2, line3, line4, line5, line6);

        Scene scene = new Scene(pane, 500, 500);
        primaryStage.setTitle("Problem$14");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
