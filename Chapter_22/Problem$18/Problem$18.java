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
 * **22.18 (Binary search animation) Write a program that animates the binary search
 * algorithm. Create an array with numbers from 1 to 25 in this order. The array
 * elements are displayed in a histogram, as shown in Figure 22.13. You need to
 * enter a search key in the text field. Clicking the Step button causes the program
 * to perform one comparison in the algorithm. Use a light-gray color to paint
 * the bars for the numbers in the current search range and use a black color to
 * paint the bar indicating the middle number in the search range. The Step button
 * also freezes the text field to prevent its value from being changed. When the
 * algorithm is finished, display the status in a label at the top of a border pane.
 * Clicking the Reset button enables a new search to start. This button also makes
 * the text field editable.
 *
 *
 * @author Sharaf Qeshta
 */
public class Problem$18 extends Application
{
    private static final ArrayList<MyRectangle> RECTANGLES = new ArrayList<>();
    private static int start = 0;
    private static int end = 0;
    private static int previousStart = 0;
    private static int previousEnd = 0;
    private static int middle = 0;
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
        Pane histogram = getHistogram(getArray(25),
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
                {
                    status.setText("");
                    keyField.setEditable(true);
                    pane.getChildren().set(1, getHistogram(getArray(25),
                            480, northCorner, southCorner));
                });


        step.setOnAction(e ->
        {
            if (found)
            {
                keyField.setEditable(true);
                return;
            }

            if (start == end)
            {
                keyField.setEditable(true);
                status.setText("The key is not in the array");
                return;
            }

            keyField.setEditable(false);
            int key;
            try
            {
                key = Integer.parseInt(keyField.getText());
            }
            catch (Exception ignored)
            {
                return;
            }

            for (int i = previousStart; i <= previousEnd; i++)
                RECTANGLES.get(i).setFill(Color.WHITE);

            for (int i = start; i <= end; i++)
                RECTANGLES.get(i).setFill(Color.LIGHTGRAY);

            RECTANGLES.get(middle).setFill(Color.BLACK);

            if (RECTANGLES.get(middle).number == key)
            {
                for (int i = start; i <= end; i++)
                    RECTANGLES.get(i).setFill(Color.WHITE);
                RECTANGLES.get(middle).setFill(Color.BLACK);
                found = true;
                status.setText("The key is found in the array at index " + middle);
            }
            else
            {
                previousStart = start; previousEnd = end;
                if (RECTANGLES.get(middle).number < key)
                {
                    start = middle;
                    middle = (int) (Math.ceil((end - start)/2.0) + start);
                }
                else
                {
                    end = middle;
                    middle = (int) (Math.floor((end - start)/2.0) + start);
                }
            }

        });


        Scene scene = new Scene(pane, 500, 500);
        primaryStage.setTitle("Problem$18");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static Pane getHistogram(int[] array, int paneWidth,
                                    Point2D northCorner, Point2D southCorner)
    {
        int width = paneWidth / array.length;
        RECTANGLES.clear();
        start = 0;
        previousStart = 0;
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
            Text text = new Text(x + width / 3.0, y - 5, array[i] + "");
            pane.getChildren().addAll(rectangle, text);
        }

        end = RECTANGLES.size()-1;
        previousEnd = RECTANGLES.size()-1;
        middle = RECTANGLES.size()/2;
        return pane;
    }


    public static int[] getArray(int length)
    {
        int[] array = new int[length];
        for (int i = 0; i < length; i++)
            array[i] = i + 1;
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
