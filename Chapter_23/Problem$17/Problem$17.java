package chapter_twenty_three;

import javafx.application.Application;
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
 * *23.17 (Radix-sort animation) Write a program that animates the radix sort algorithm.
 * Create an array that consists of 20 random numbers from 0 to 800. The array elements
 * are displayed, as shown in Figure 23.21. Clicking the Step button causes the program
 * to place a number in a bucket. The number that has just been placed is displayed in
 * red. Once all the numbers are placed in the buckets, clicking the Step button collects
 * all the numbers from the buckets and moves them back to the array. When the
 * algorithm is finished, clicking the Step button displays a message to inform the user.
 * Clicking the Reset button creates a new random array for a new start.
 *
 *
 * @author Sharaf Qeshta
 * */
public class Problem$17 extends Application
{
    private static final int RADIX = 10;
    private static final ArrayList<Bucket> BUCKETS = new ArrayList<>();
    private static final ArrayList<MyRectangle> RECTANGLES = new ArrayList<>();
    private static int[] currentArray = getArray(20);
    private static int i = 0;
    private static int placement = 1;

    @Override
    public void start(Stage primaryStage)
    {
        VBox pane = new VBox(10);
        pane.setAlignment(Pos.CENTER);

        Label status = new Label();
        pane.getChildren().add(status);


        Pane gui = getGUI(currentArray, 20, 50);
        pane.getChildren().add(gui);

        HBox settings = new HBox(5);
        Button step = new Button("Step");
        Button reset = new Button("Reset");
        settings.setAlignment(Pos.CENTER);
        settings.getChildren().addAll(step, reset);
        pane.getChildren().add(settings);

        reset.setOnAction(e ->
        {
            currentArray = getArray(20);
            i = 0;
            placement = 1;
            status.setText("");
            pane.getChildren().set(1, getGUI(currentArray, 20, 50));
        });

        step.setOnAction(e ->
        {
            if (i == RECTANGLES.size())
            {
                if (placement == 1000) // since the largest number will be consist of three digits
                {
                    status.setText("Array is sorted");
                    pane.getChildren().set(1, getGUI(currentArray, 20, 50));
                    return;
                }

                int x = 0;
                for (Bucket bucket: BUCKETS)
                {
                    for (int value: bucket.values)
                        currentArray[x++] = value;
                }

                pane.getChildren().set(1, getGUI(currentArray, 20, 50));
                placement *= RADIX;
                i = 0;
                return;
            }

            int order = currentArray[i] / placement;
            Pane pane1 = (Pane) pane.getChildren().get(1);
            pane1.getChildren().add(BUCKETS.get(order % RADIX).addNumber(currentArray[i]));

            if (i != 0)
                RECTANGLES.get(i-1).setFill(Color.WHITE);
            RECTANGLES.get(i).setFill(Color.RED);
            i++;
        });


        Scene scene = new Scene(pane, 700, 500);
        primaryStage.setTitle("Problem$17");
        primaryStage.setScene(scene);
        primaryStage.show();
    }


    public static Pane getGUI(int[] array, int x, int y)
    {
        Pane pane = new Pane();
        pane.setStyle("-fx-border-color: black");
        BUCKETS.clear();
        RECTANGLES.clear();

        int x_ = x;
        for (int i = 0; i < array.length; i++)
        {
            MyRectangle rectangle = new MyRectangle(x_, y, array[i]);
            x_ += 30;
            RECTANGLES.add(rectangle);
            pane.getChildren().addAll(rectangle, rectangle.getText());
        }

        int y_ = 100;
        x_ = x;
        for (int i = 0; i < 10; i++)
        {
            Bucket bucket = new Bucket(x_, y_);
            pane.getChildren().add(bucket);
            BUCKETS.add(bucket);
            pane.getChildren().add(bucket.getName(i));
            x_ += 65;
        }
        return pane;
    }


    public static int[] getArray(int size)
    {
        int[] array = new int[size];
        for (int i = 0; i < size; i++)
            array[i] = (int) ((Math.random() * 1000) % 800);
        return array;
    }

    private static class MyRectangle extends Rectangle
    {
        private Text text;
        int value;

        public MyRectangle(double cornerX, double cornerY, int value)
        {
            super(cornerX, cornerY, 30, 30);
            text = new Text(cornerX+2, cornerY+20, value + "");
            setFill(Color.WHITE); setStroke(Color.BLACK);
            this.value = value;
        }

        public void changeValue(int value)
        {
            text.setText(value + "");
        }

        public Text getText()
        {
            return text;
        }
    }


    private static class Bucket extends Rectangle
    {
        ArrayList<Text> texts = new ArrayList<>();
        ArrayList<Integer> values = new ArrayList<>();
        double startX, startY;

        public Bucket(int x, int y)
        {
            super(x, y, 50, 100);
            setFill(Color.WHITE); setStroke(Color.BLACK);
            startX = x+5; startY = y+15;
        }

        public Text addNumber(int value)
        {
            Text text = new Text(startX, startY, value+ "");
            values.add(value);
            texts.add(text);
            startY += 15;
            return text;
        }

        public Text getName(int order)
        {
            return new Text(getX(), getY()+120, "bucket[" + order + "]");
        }
    }
}
