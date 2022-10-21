package chapter_thirty_two;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Point2D;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;


/**
 * ***32.19 (Sorting animation) Write an animation for selection sort, insertion sort, and
 * bubble sort, as shown in Figure 32.31. Create an array of integers 1, 2, . . . , 50.
 * Shuffle it randomly. Create a pane to display the array in a histogram. You should
 * invoke each sort method in a separate thread. Each algorithm uses two nested
 * loops. When the algorithm completes an iteration in the outer loop, put the thread
 * to sleep for 0.5 seconds and redisplay the array in the histogram. Color the last
 * bar in the sorted subarray.
 *
 *
 * @author Sharaf Qeshta
 * */
public class Problem$19 extends Application
{
    @Override
    public void start(Stage stage)
    {
        HBox hBox = new HBox(10);
        Histogram selectionSort = new Histogram("Selection Sort", 50);
        Histogram insertionSort = new Histogram("Insertion Sort", 50);
        Histogram bubbleSort = new Histogram("Bubble Sort", 50);

        new Thread(new Sort(selectionSort, 0)).start();
        new Thread(new Sort(insertionSort, 1)).start();
        new Thread(new Sort(bubbleSort, 2)).start();

        hBox.getChildren().addAll(selectionSort, insertionSort, bubbleSort);

        Scene scene = new Scene(hBox, 1000, 500);
        stage.setScene(scene);
        stage.setTitle("Problem$19");
        stage.show();
    }
}


class Sort implements Runnable
{
    Histogram histogram;
    int algorithm;

    public Sort(Histogram histogram, int algorithm)
    {
        this.histogram = histogram;
        this.algorithm = algorithm;
    }


    public void selectionSort()
    {
        try
        {
            for (int i = 0; i < histogram.array.length-1; i++)
            {
                int minIndex = i;
                for (int j = i+1; j < histogram.array.length; j++)
                    if (histogram.array[j] < histogram.array[minIndex])
                        minIndex = j;

                int temp = histogram.array[minIndex];
                histogram.array[minIndex] = histogram.array[i];
                histogram.array[i] = temp;

                Thread.sleep(500);
                int finalMinIndex = minIndex;
                Platform.runLater(() -> histogram.display(finalMinIndex));
            }
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
        }
    }


    public void insertionSort()
    {
        try
        {
            for (int i = 1; i < histogram.array.length; ++i)
            {
                int key = histogram.array[i];
                int j = i - 1;

                while (j >= 0 && histogram.array[j] > key)
                {
                    histogram.array[j + 1] = histogram.array[j];
                    j = j - 1;
                }
                histogram.array[j + 1] = key;

                Thread.sleep(500);
                int finalI = i;
                Platform.runLater(() -> histogram.display(finalI));
            }
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
        }
    }


    public void bubbleSort()
    {
        try
        {
            boolean sorted = false;
            while (!sorted)
            {
                sorted = true;
                int marked = -1;
                for (int i = 0; i < histogram.array.length-1; i++)
                {
                    if (histogram.array[i] > histogram.array[i+1])
                    {
                        int temp = histogram.array[i];
                        histogram.array[i] = histogram.array[i+1];
                        histogram.array[i+1] = temp;
                        marked = i+1;
                        sorted = false;
                    }
                }
                Thread.sleep(500);
                int finalMarked = marked;
                Platform.runLater(() -> histogram.display(finalMarked));
            }
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
        }
    }

    @Override
    public void run()
    {
        if (algorithm == 0)
            selectionSort();
        else if (algorithm == 1)
            insertionSort();
        else if (algorithm == 2)
            bubbleSort();
    }
}

class Histogram extends VBox
{
    private static final Point2D NORTH_WEST_CORNER = new Point2D(50, 0);
    private static final Point2D SOUTH_WEST_CORNER = new Point2D(50, 150);
    private final String title;
    private final int max;
    int[] array;

    public Histogram(String title, int max)
    {
        this.title = title;
        this.max = max;
        array = new int[max];
        setAlignment(Pos.CENTER);
        assign();
        shuffle();
        display(-1);
    }

    private void assign()
    {
        for (int i = 1; i <= max; i++)
            array[i-1] = i;
    }

    private void shuffle()
    {
        for (int i = 0; i < max; i++)
        {
            int randomIndex = (int) ((Math.random() * max * 2) % max);
            int temp = array[randomIndex];
            array[randomIndex] = array[i];
            array[i] = temp;
        }
    }

    public void display(int marked)
    {
        getChildren().clear();
        getChildren().add(new Label(title));

        double yFactor = NORTH_WEST_CORNER.distance(SOUTH_WEST_CORNER) / array.length;

        Pane pane = new Pane();
        for (int i = 0; i < array.length; i++)
        {
            double x = i * 5 + SOUTH_WEST_CORNER.getX();
            double y = SOUTH_WEST_CORNER.getY() - yFactor * array[i];

            Rectangle rectangle = new Rectangle(x, y, 5,
                    Math.abs(y - SOUTH_WEST_CORNER.getY()));
            if (marked == i)
                rectangle.setFill(Color.BLACK);
            else
                rectangle.setFill(Color.GREY);

            pane.getChildren().add(rectangle);
        }

        getChildren().add(pane);
    }
}
