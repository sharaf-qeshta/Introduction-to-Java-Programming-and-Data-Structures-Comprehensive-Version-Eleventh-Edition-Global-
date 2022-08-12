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
 * *23.15 (Selection-sort animation) Write a program that animates the selection sort algorithm.
 * Create an array that consists of 25 distinct numbers from 1 to 25 in a random
 * order. The array elements are displayed in a histogram, as shown in Figure 23.20a.
 * Clicking the Step button causes the program to perform an iteration of the outer
 * loop in the algorithm and repaints the histogram for the new array. Color the last
 * bar in the sorted subarray. When the algorithm is finished, display a message to
 * inform the user. Clicking the Reset button creates a new random array for a new
 * start. (You can easily modify the program to animate the insertion algorithm.)
 *
 *
 * @author Sharaf Qeshta
 * */
public class Problem$15 extends Application
{
    private static final ArrayList<MyRectangle> RECTANGLES = new ArrayList<>();
    private static int currentIteration = 0;
    private static int lastIndex = -1;

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
             if (currentIteration == RECTANGLES.size()-1)
             {
                 status.setText("The array is sorted");
                 return;
             }

            int index = currentIteration;
            for (int j = currentIteration+1; j < RECTANGLES.size(); j++)
                if (RECTANGLES.get(j).number < RECTANGLES.get(index).number)
                    index = j;

            // change the x coordinate of the rectangle
            double rectangle1X = RECTANGLES.get(index).getX();
            RECTANGLES.get(index).setX(RECTANGLES.get(currentIteration).getX());
            RECTANGLES.get(currentIteration).setX(rectangle1X);

            // change the x coordinate of the text
            double text1X = RECTANGLES.get(index).text.getX();
            RECTANGLES.get(index).text.setX(RECTANGLES.get(currentIteration).text.getX());
            RECTANGLES.get(currentIteration).text.setX(text1X);

            MyRectangle temp = RECTANGLES.get(index);
            RECTANGLES.set(index, RECTANGLES.get(currentIteration));
            RECTANGLES.set(currentIteration, temp);

            if (lastIndex != -1)
            {
                RECTANGLES.get(lastIndex).setFill(Color.WHITE);
                RECTANGLES.get(currentIteration).setFill(Color.BLACK);
            }

            lastIndex = currentIteration;

            currentIteration++;
        });


        Scene scene = new Scene(pane, 500, 500);
        primaryStage.setTitle("Problem$15");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static Pane getHistogram(int[] array, int paneWidth,
                                    Point2D northCorner, Point2D southCorner)
    {
        int width = paneWidth/array.length;
        RECTANGLES.clear();
        currentIteration = 0;
        lastIndex = -1;
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
