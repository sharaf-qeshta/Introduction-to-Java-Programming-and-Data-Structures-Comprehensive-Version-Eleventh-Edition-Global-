package chapter_twenty_three;

import javafx.application.Application;
import javafx.geometry.Point2D;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.ArrayList;

/**
 * *23.16 (Bubble-sort animation) Write a program that animates the bubble sort algorithm.
 * Create an array that consists of 25 distinct numbers from 1 to 25 in a
 * random order. The array elements are displayed in a histogram, as shown in
 * Figure 23.20b. Clicking the Step button causes the program to perform one comparison
 * in the algorithm and repaints the histogram for the new array. Color the
 * bar that represents the number being considered in the swap. When the algorithm
 * is finished, display a message to inform the user. Clicking the Reset button
 * creates a new random array for a new start.
 *
 *
 * @author Sharaf Qeshta
 * */
public class Problem$16 extends Application
{
    private static final ArrayList<MyRectangle> RECTANGLES = new ArrayList<>();
    private static boolean needNextPass = true;
    private static int k = 1;
    private static int i = 0;
    private static int lastColored = -1;

    @Override
    public void start(Stage primaryStage)
    {
        VBox pane = new VBox(10);
        pane.setAlignment(Pos.CENTER);

        // status bar
        Label status = new Label();
        pane.getChildren().add(status);

        // histogram
        Point2D northCorner = new Point2D(10, 40);
        Point2D southCorner = new Point2D(10, 150);
        Pane histogram = getHistogram(getArray(25), 480, northCorner, southCorner);
        pane.getChildren().add(histogram);

        HBox settings = new HBox(5);
        Button step = new Button("Step");
        Button reset = new Button("Reset");
        settings.setAlignment(Pos.CENTER);
        settings.getChildren().addAll(step, reset);
        pane.getChildren().add(settings);

        reset.setOnAction(e ->
        {
            pane.getChildren().set(1,
                    getHistogram(getArray(25), 480, northCorner, southCorner));
            status.setText("");
        });


        step.setOnAction(e ->
        {
            if (i == RECTANGLES.size() - k)
            {
                i = 0;
                k++;
            }


            if (i == 0)
            {
                if (k == RECTANGLES.size() || !needNextPass)
                {
                    status.setText("The array is sorted");
                    RECTANGLES.get(lastColored).setFill(Color.WHITE);
                    return;
                }
                needNextPass = false;
            }

            if (RECTANGLES.get(i).number > RECTANGLES.get(i+1).number)
            {
                // change the x coordinate of the rectangle
                double rectangle1X = RECTANGLES.get(i).getX();
                RECTANGLES.get(i).setX(RECTANGLES.get(i+1).getX());
                RECTANGLES.get(i+1).setX(rectangle1X);

                // change the x coordinate of the text
                double text1X = RECTANGLES.get(i).text.getX();
                RECTANGLES.get(i).text.setX(RECTANGLES.get(i+1).text.getX());
                RECTANGLES.get(i+1).text.setX(text1X);

                MyRectangle temp = RECTANGLES.get(i);
                RECTANGLES.set(i, RECTANGLES.get(i+1));
                RECTANGLES.set(i+1, temp);

                if (lastColored != -1)
                {
                    RECTANGLES.get(lastColored).setFill(Color.WHITE);
                    RECTANGLES.get(i+1).setFill(Color.BLACK);
                }

                lastColored = i+1;
                needNextPass = true;
            }
            i++;
        });


        Scene scene = new Scene(pane, 500, 500);
        primaryStage.setTitle("Problem$16");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static Pane getHistogram(int[] array, int paneWidth,
                                    Point2D northCorner, Point2D southCorner)
    {
        int width = paneWidth/array.length;
        RECTANGLES.clear();
        needNextPass = true;
        k = 1;
        i = 0;
        lastColored = -1;
        double yFactor = northCorner.distance(southCorner) / array.length;

        Pane pane = new Pane();
        pane.setStyle("-fx-border-color: black");
        pane.getChildren().add(new Rectangle());
        for (int i = 0; i < array.length; i++)
        {
            double x = i * width + southCorner.getX();
            double y = southCorner.getY() - yFactor * array[i];

            MyRectangle rectangle = new MyRectangle(x, y, width,
                    Math.abs(y - southCorner.getY()), array[i]);
            RECTANGLES.add(rectangle);
            rectangle.text = new Text(x + width/3.0, y-5, array[i] + "");
            pane.getChildren().addAll(rectangle, rectangle.text);
        }

        return pane;
    }


    public static int[] getArray(int length)
    {
        int[] array = new int[length];
        for (int i = 0; i < length; i++)
            array[i] =  i + 1;

        // shuffle
        for (int i = 0; i < length; i++)
        {
            int randomIndex = (int) (( Math.random() * length * 2) % length);
            int temp = array[i];
            array[i] = array[randomIndex];
            array[randomIndex] = temp;
        }
        return array;
    }


    private static class MyRectangle extends Rectangle
    {
        int number;
        Text text;
        public MyRectangle(double x, double y,
                           double width, double height, int number)
        {
            super(x, y, width, height);
            this.number = number;
            setFill(Color.WHITE);
            setStroke(Color.BLACK);
        }
    }
}
