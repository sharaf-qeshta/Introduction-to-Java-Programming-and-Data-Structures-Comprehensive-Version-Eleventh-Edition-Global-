package chapter_fourteen;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Line;
import javafx.stage.Stage;

/**
 * **14.20 (Draw an arrow line) Write a static method that draws an arrow line from a
 * starting point to an ending point in a pane using the following method header:
 * public static void drawArrowLine(double startX, double startY,
 *  double endX, double endY, Pane pane)
 * Write a test program that randomly draws an arrow line, as shown in Figure 14.49a
 *
 *
 * @author Sharaf Qeshta
 * */
public class Problem$20 extends Application
{
    public static void main(String[] args)
    {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage)
    {

        Pane pane = new Pane();

        drawArrowLine(300, 300, 300, 150, pane);

        Scene scene = new Scene(pane, 500, 500);
        primaryStage.setTitle("Problem$20");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void drawArrowLine(double startX, double startY,
                                     double endX, double endY, Pane pane)
    {
        Line mainLine = new Line(startX, startY, endX, endY);
        double middleX = (startX + endX) / 2;
        double middleY = (startY + endY) / 2;

        Line rightArrow = new Line(endX, endY, middleX+20, middleY);
        Line leftArrow = new Line(endX, endY, middleX-20, middleY);
        pane.getChildren().addAll(mainLine, rightArrow, leftArrow);
    }
}
