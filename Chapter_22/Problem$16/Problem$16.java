package chapter_twenty_two;

import javafx.application.Application;
import javafx.geometry.Point2D;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.ArrayList;

/**
 * **22.16 (Linear search animation) Write a program that animates the linear search
 * algorithm. Create an array that consists of 25 distinct numbers from 1 to 25
 * in a random order. The array elements are displayed in a histogram, as shown
 * in Figure 22.12. You need to enter a search key in the text field. Clicking the
 * Step button causes the program to perform one comparison in the algorithm
 * and repaints the histogram with a bar indicating the search position. This button
 * also freezes the text field to prevent its value from being changed. When the
 * algorithm is finished, display the status in the label at the top of the border pane
 * to inform the user. Clicking the Reset button creates a new random array for a
 * new start. This button also makes the text field editable.
 *
 *
 * @author Sharaf Qeshta
 * */
public class Problem$16 extends Application
{
    private static final ArrayList<MyRectangle> RECTANGLES = new ArrayList<>();
    private static int currentRectangle = 0;
    private static boolean found = false;
    @Override
    public void start(Stage primaryStage)
    {
        VBox pane = new VBox(10);
        // status bar
        Label status = new Label();
        status.setAlignment(Pos.CENTER);
        pane.getChildren().add(status);

        // drawing histogram
        Point2D northCorner = new Point2D(10, 40);
        Point2D southCorner = new Point2D(10, 150);
        Pane histogram = getHistogram(getArray(25, 25),
                480, northCorner, southCorner);

        pane.getChildren().add(histogram);


        // inputs
        HBox settings = new HBox(5);
        Label insertKeyLabel = new Label("Key (in double) ");
        TextField keyField = new TextField();
        keyField.setPrefColumnCount(12);
        Button step = new Button("Step");
        Button reset = new Button("Reset");

        settings.getChildren().addAll(insertKeyLabel, keyField, step, reset);
        pane.getChildren().add(settings);

        reset.setOnAction(e ->
                pane.getChildren().set(1, getHistogram(getArray(25, 25),
                        480, northCorner, southCorner)));


        step.setOnAction(e ->
        {
            if (found)
                return;

            if (currentRectangle >= RECTANGLES.size())
            {
                status.setText("The key is not in the array");
                return;
            }

            int key;
            try
            {
                key = Integer.parseInt(keyField.getText());
            }
            catch (Exception ignored)
            {
                return;
            }

            if (currentRectangle >= 1)
                RECTANGLES.get(currentRectangle-1).setFill(Color.WHITE);

            RECTANGLES.get(currentRectangle).setFill(Color.BLACK);
            if (RECTANGLES.get(currentRectangle).number == key)
            {
                found = true;
                status.setText("The key is found in the array at index " + currentRectangle);
            }
            currentRectangle++;
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
        currentRectangle = 0;
        found = false;
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
            Text text = new Text(x + width/3.0, y-5, array[i] + "");
            pane.getChildren().addAll(rectangle, text);
        }

        return pane;
    }


    public static int[] getArray(int length, int maxValue)
    {
        int[] array = new int[length];
        for (int i = 0; i < length; i++)
            array[i] = (int) ((Math.random() * maxValue) % maxValue + 1);
        return array;
    }


    private static class MyRectangle extends Rectangle
    {
        int number;
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
