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
import java.util.Arrays;

/**
 * *23.18 (Merge animation) Write a program that animates the merge of two sorted lists. Create
 * two arrays, list1 and list2, each of which consists of 8 random numbers from
 * 1 to 999. The array elements are displayed, as shown in Figure 23.22a. Clicking the
 * Step button causes the program to move an element from list1 or list2 to temp.
 * Clicking the Reset button creates two new random arrays for a new start. When the
 * algorithm is finished, clicking the Step button displays a message to inform the user
 *
 *
 * @author Sharaf Qeshta
 * */
public class Problem$18 extends Application
{
    private static final ArrayList<Node> POINTER1 = new ArrayList<>();
    private static final ArrayList<Node> POINTER2 = new ArrayList<>();
    private static final ArrayList<Node> POINTER3 = new ArrayList<>();

    private static final ArrayList<MyRectangle> TEMP = new ArrayList<>();
    private static final ArrayList<MyRectangle> LIST1 = new ArrayList<>();
    private static final ArrayList<MyRectangle> LIST2 = new ArrayList<>();

    private static int list1Current = 0;
    private static int list2Current = 0;
    private static int tempCurrent = 0;

    @Override
    public void start(Stage primaryStage)
    {
        VBox pane = new VBox(10);
        pane.setAlignment(Pos.CENTER);
        Label status = new Label();
        pane.getChildren().add(status);

        Pane gui = getGUI(getArray(8), getArray(8), 50, 50);
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
            pane.getChildren().set(1, getGUI(getArray(8), getArray(8), 50, 50));
        });


        step.setOnAction(e ->
        {
            if (tempCurrent > TEMP.size()-1)
            {
                status.setText("List1 and List2 merged");
                return;
            }

            int number;

            if (list1Current > LIST1.size()-1)
            {
                LIST2.get((list2Current+1 >= LIST2.size()) ? LIST2.size()-1 : list2Current+1).putPointer(POINTER2);
                number = LIST2.get(list2Current++).value;
            }
            else if (list2Current > LIST2.size()-1)
            {
                LIST1.get((list1Current+1 >= LIST1.size()) ? LIST1.size()-1 : list1Current+1).putPointer(POINTER1);
                number = LIST1.get(list1Current++).value;
            }
            else
            {
                if (LIST1.get(list1Current).value < LIST2.get(list2Current).value)
                {
                    LIST1.get((list1Current+1 >= LIST1.size()) ? LIST1.size()-1 : list1Current+1).putPointer(POINTER1);
                    number = LIST1.get(list1Current++).value;
                }
                else
                {
                    LIST2.get((list2Current+1 >= LIST2.size()) ? LIST2.size()-1 : list2Current+1).putPointer(POINTER2);
                    number = LIST2.get(list2Current++).value;
                }
            }
            TEMP.get((tempCurrent+1 >= TEMP.size()) ? TEMP.size()-1 : tempCurrent+1).putPointer(POINTER3);
            TEMP.get(tempCurrent).changeValue(number);
            Pane pane1 = (Pane) pane.getChildren().get(1);
            pane1.getChildren().add(TEMP.get(tempCurrent++).text);
        });

        Scene scene = new Scene(pane, 700, 500);
        primaryStage.setTitle("Problem$18");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static Pane getGUI(int[] list1, int[] list2,
                              int x, int y)
    {
        POINTER1.clear();
        POINTER2.clear();
        POINTER3.clear();

        LIST1.clear();
        LIST2.clear();
        TEMP.clear();

        list1Current = 0;
        list2Current = 0;
        tempCurrent = 0;

        Pane pane = new Pane();
        pane.setStyle("-fx-border-color: black");

        POINTER1.add(new Line());
        POINTER1.add(new Line());
        POINTER1.add(new Line());
        POINTER1.add(new Text("current1"));

        POINTER2.add(new Line());
        POINTER2.add(new Line());
        POINTER2.add(new Line());
        POINTER2.add(new Text("current2"));

        POINTER3.add(new Line());
        POINTER3.add(new Line());
        POINTER3.add(new Line());
        POINTER3.add(new Text("current3"));

        pane.getChildren().addAll(POINTER1);
        pane.getChildren().addAll(POINTER2);
        pane.getChildren().addAll(POINTER3);

        int x_ = x;
        int y_ = y+50;

        Text list1Text = new Text(x-30, y_+20, "List 1");
        pane.getChildren().add(list1Text);
        for (int i = 0; i < list1.length; i++)
        {
            MyRectangle rectangle = new MyRectangle(x_, y_, list1[i]);
            x_ += 30;
            LIST1.add(rectangle);
            pane.getChildren().addAll(rectangle, rectangle.getText());
        }

        LIST1.get(0).putPointer(POINTER1);

        x_ += 100;
        Text list2Text = new Text(x_-30, y_+20, "List 2");
        pane.getChildren().add(list2Text);
        for (int i = 0; i < list2.length; i++)
        {
            MyRectangle rectangle = new MyRectangle(x_, y_, list2[i]);
            x_ += 30;
            LIST2.add(rectangle);
            pane.getChildren().addAll(rectangle, rectangle.getText());
        }

        LIST2.get(0).putPointer(POINTER2);

        y_ += 120;
        x_ = x;
        Text tempText = new Text(x-30, y_+20, "temp");
        pane.getChildren().add(tempText);
        for (int i = 0; i < (list1.length + list2.length); i++)
        {
            MyRectangle rectangle = new MyRectangle(x_, y_, 0);
            x_ += 30;
            TEMP.add(rectangle);
            pane.getChildren().add(rectangle);
        }

        TEMP.get(0).putPointer(POINTER3);
        return pane;
    }

    public static int[] getArray(int size)
    {
        int[] array = new int[size];
        for (int i = 0; i < array.length; i++)
            array[i] = (int) ((Math.random() * 2000) % 1000);
        Arrays.sort(array);
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
            text.setText(value + "");
        }

        public Text getText()
        {
            return text;
        }

        public void putPointer(ArrayList<Node> list)
        {
            Line line1 = (Line) list.get(0); // \
            Line line2 = (Line) list.get(1); // /
            Line line3 = (Line) list.get(2); // |

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
            line3.setEndY(getY()-40);

            Text text = (Text) list.get(3);
            text.setX(getX());
            text.setY(getY()-50);
        }
    }
}
