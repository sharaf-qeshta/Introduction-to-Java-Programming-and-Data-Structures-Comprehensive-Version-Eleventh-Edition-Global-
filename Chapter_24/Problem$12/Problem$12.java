package chapter_twenty_four;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * *24.12 (Animation: queue) Write a program to animate the enqueue and dequeue
 * operations on a queue, as shown in Figure 24.20b.
 *
 *
 * @author Sharaf Qeshta
 * */
public class Problem$12 extends Application
{
    private static final Queue<Integer> QUEUE = new PriorityQueue<>();

    @Override
    public void start(Stage primaryStage)
    {
        VBox pane = new VBox(10);
        pane.setAlignment(Pos.CENTER);

        Pane queueGUI = drawQueue(QUEUE, 50, 50);
        pane.getChildren().add(queueGUI);

        HBox settings = new HBox(5);
        settings.setAlignment(Pos.CENTER);
        Label enterValue = new Label("Enter a value: ");
        TextField value = new TextField();
        value.setPrefColumnCount(6);
        Button enqueue = new Button("Enqueue");
        Button dequeue = new Button("Dequeue");
        Button startOver = new Button("Start Over");

        settings.getChildren().addAll(enterValue, value, enqueue, dequeue, startOver);
        pane.getChildren().add(settings);

        enqueue.setOnAction(e ->
        {
             int value_;
             try
             {
                 value_ = Integer.parseInt(value.getText());
                 QUEUE.add(value_);
                 pane.getChildren().set(0, drawQueue(QUEUE, 50, 50));
             }
             catch (Exception ignored) { }
        });


        dequeue.setOnAction(e ->
        {
             if (QUEUE.isEmpty())
                 return;
             QUEUE.remove();
             pane.getChildren().set(0, drawQueue(QUEUE, 50, 50));
        });


        startOver.setOnAction(e ->
        {
             if (QUEUE.isEmpty())
                 return;
             QUEUE.clear();
             pane.getChildren().set(0, drawQueue(QUEUE, 50, 50));
        });

        Scene scene = new Scene(pane, 500, 500);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Problem$12");
        primaryStage.show();
    }

    public Pane drawQueue(Queue<Integer> queue, int x, int y)
    {
        Pane pane = new Pane();
        pane.setMinSize(500, 200);
        pane.setStyle("-fx-border-color: black");

        int x_ = x;
        int i = 0;
        for (int value: queue)
        {
            Element element = new Element(x_, y, value, i == 0, i == queue.size()-1);
            pane.getChildren().add(element);
            pane.getChildren().addAll(element.getDecorations());
            x_ += 40;
            i++;
        }
        return pane;
    }


    private static class Element extends Rectangle
    {
        int value;
        boolean head, tail;

        public Element(double x, double y, int value,
                       boolean head, boolean tail)
        {
            super(x, y, 40, 20);
            setFill(Color.WHITE); setStroke(Color.BLACK);
            this.value = value;
            this.head = head;
            this.tail = tail;
        }


        public ArrayList<Node> getDecorations()
        {
            ArrayList<Node> decorations = new ArrayList<>();
            Text text = new Text(getX() + getWidth()/1.5, getY() + getHeight()/1.5, value + "");
            decorations.add(text);

            double x1 = getX()+getWidth()/2;
            double y1 = getY();

            if (head)
            {
                Line line1 = new Line(x1, y1, x1, y1-20);
                Line line2 = new Line(x1, y1, x1-5, y1-5);
                Line line3 = new Line(x1, y1, x1+5, y1-5);
                Text text1 = new Text(x1-10, y1-25, "head");
                decorations.add(line1); decorations.add(line2);
                decorations.add(line3); decorations.add(text1);
            }

            if (tail)
            {
                Line line1 = new Line(x1, y1, x1+20, y1-20);
                Line line2 = new Line(x1, y1, x1-5, y1-5);
                Line line3 = new Line(x1, y1, x1+5, y1);
                Text text1 = new Text(x1+20, y1-25, "tail");
                decorations.add(line1); decorations.add(line2);
                decorations.add(line3); decorations.add(text1);
            }

            return decorations;
        }
    }
}
