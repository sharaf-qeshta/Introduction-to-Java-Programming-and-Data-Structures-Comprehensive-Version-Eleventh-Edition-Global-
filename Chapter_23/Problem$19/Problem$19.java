package chapter_twenty_three;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.ArrayList;

/**
 * *23.19 (Quick-sort partition animation) Write a program that animates the partition for
 * a quick sort. The program creates a list that consists of 25 random numbers from
 * 1 to 999. The list is displayed, as shown in Figure 23.22b. Clicking the Step button
 * causes the program to move low to the right or high to the left, or swap the
 * elements at low and high. Clicking the Reset button creates a new list of random
 * numbers for a new start. When the algorithm is finished, clicking the Step button
 * displays a message to inform the user.
 *
 *
 * @author Sharaf Qeshta
 * */
public class Problem$19 extends Application
{
    private static final ArrayList<Node> PIVOT_POINTER = new ArrayList<>();
    private static final ArrayList<Node> LOW_POINTER = new ArrayList<>();
    private static final ArrayList<Node> HIGH_POINTER = new ArrayList<>();

    private static final ArrayList<MyRectangle> RECTANGLES = new ArrayList<>();

    private static int pivot = 0;
    private static int low = 1;
    private static int high = 24;

    private static boolean firstTime = true;
    @Override
    public void start(Stage primaryStage)
    {
        VBox pane = new VBox(10);
        pane.setAlignment(Pos.CENTER);
        Label status = new Label();
        pane.getChildren().add(status);

        Pane gui = getGUI(getArray(25), 50, 50);
        pane.getChildren().add(gui);

        HBox settings = new HBox(5);
        Button step = new Button("Step");
        Button reset = new Button("Reset");
        settings.setAlignment(Pos.CENTER);
        settings.getChildren().addAll(step, reset);
        pane.getChildren().add(settings);


        reset.setOnAction(e ->
        {
            status.setText("");
            pane.getChildren().set(1, getGUI(getArray(25), 50, 50));
        });


        step.setOnAction(e ->
        {
            if (high <= low)
            {
                if (firstTime)
                {
                    while (high > 0 && RECTANGLES.get(high).value >= pivot)
                        high--;
                    if (pivot > RECTANGLES.get(high).value)
                    {
                        RECTANGLES.get(0).changeValue(RECTANGLES.get(high).value);
                        RECTANGLES.get(high).changeValue(pivot);
                        RECTANGLES.get(0).putPointer(HIGH_POINTER, 20);
                        RECTANGLES.get(high).putPointer(PIVOT_POINTER, 30);
                    }
                }
                firstTime = false;
                status.setText("Partitioning completed");
                return;
            }

            while (low <= high && RECTANGLES.get(low).value <= pivot)
                low++;
            while (low <= high && RECTANGLES.get(high).value > pivot)
                high--;

            if (high > low)
            {
                int temp = RECTANGLES.get(low).value;
                RECTANGLES.get(low).changeValue(RECTANGLES.get(high).value);
                RECTANGLES.get(high).changeValue(temp);
                RECTANGLES.get(high).putPointer(HIGH_POINTER, 20);
                RECTANGLES.get(low).putPointer(LOW_POINTER, 10);
            }
        });

        Scene scene = new Scene(pane, 700, 500);
        primaryStage.setTitle("Problem$19");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static Pane getGUI(int[] array, int x, int y)
    {
        RECTANGLES.clear();

        PIVOT_POINTER.clear();
        LOW_POINTER.clear();
        HIGH_POINTER.clear();

        pivot = array[0];
        low = 1;
        high = 24;
        firstTime = true;

        Pane pane = new Pane();
        pane.setStyle("-fx-border-color: black");

        PIVOT_POINTER.add(new Line());
        PIVOT_POINTER.add(new Line());
        PIVOT_POINTER.add(new Line());
        PIVOT_POINTER.add(new Text("pivot"));

        LOW_POINTER.add(new Line());
        LOW_POINTER.add(new Line());
        LOW_POINTER.add(new Line());
        LOW_POINTER.add(new Text("low"));

        HIGH_POINTER.add(new Line());
        HIGH_POINTER.add(new Line());
        HIGH_POINTER.add(new Line());
        HIGH_POINTER.add(new Text("high"));

        pane.getChildren().addAll(PIVOT_POINTER);
        pane.getChildren().addAll(LOW_POINTER);
        pane.getChildren().addAll(HIGH_POINTER);

        int x_ = x;
        int y_ = y + 80;
        for (int i = 0; i < array.length; i++)
        {
            MyRectangle rectangle = new MyRectangle(x_, y_, array[i]);
            RECTANGLES.add(rectangle);
            pane.getChildren().addAll(rectangle, rectangle.getText());
            x_ += 30;
        }

        RECTANGLES.get(0).putPointer(PIVOT_POINTER, 30);
        RECTANGLES.get(low).putPointer(LOW_POINTER, 10);
        RECTANGLES.get(high).putPointer(HIGH_POINTER, 20);
        return pane;
    }

    public static int[] getArray(int size)
    {
        int[] array = new int[size];
        for (int i = 0; i < size; i++)
            array[i] = (int) ((Math.random() * 1000) % 999) + 1;
        return array;
    }

    private static class MyRectangle extends Rectangle
    {
        private final Text text;
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
            this.value = value;
            text.setText(value + "");
        }

        public Text getText()
        {
            return text;
        }

        public void putPointer(ArrayList<Node> list, int length)
        {
            Line line1 = (Line) list.get(0);
            Line line2 = (Line) list.get(1);
            Line line3 = (Line) list.get(2);

            line1.setStartX(getX());
            line1.setStartY(getY()-20);
            line1.setEndX(getX()+(getWidth()/2));
            line1.setEndY(getY());

            line2.setStartX(getX()+(getWidth()/2));
            line2.setStartY(getY());
            line2.setEndX(getX() + getWidth());
            line2.setEndY(getY()-20);

            line3.setStartX(getX()+(getWidth()/2));
            line3.setStartY(getY());
            line3.setEndX(getX()+(getWidth()/2));
            line3.setEndY(getY()-40-length);

            Text text = (Text) list.get(3);
            text.setX(getX());
            text.setY(getY()-50-length);
        }
    }
}
