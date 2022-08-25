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

/**
 * *24.11 (Animation: doubly linked list) Write a program to animate search, insertion,
 * and deletion in a doubly linked list, as shown in Figure 24.24. The Search button
 * searches the specified value in the list. The Delete button deletes the specified
 * value from the list. The Insert button appends the value into the list if the index
 * is not specified; otherwise, it inserts the value into the specified index in the list.
 * Also add two buttons named Forward Traversal and Backward Traversal for
 * displaying the elements in a forward and backward order, respectively, using
 * iterators, as shown in Figure 24.24. The elements are displayed in a label.
 *
 *
 * @author Sharaf Qeshta
 */
public class Problem$11 extends Application
{
    private static final TwoWayLinkedList<Integer> LIST = new TwoWayLinkedList<>();

    @Override
    public void start(Stage primaryStage)
    {
        VBox pane = new VBox(10);
        pane.setAlignment(Pos.CENTER);

        Label status = new Label();
        pane.getChildren().add(status);

        Pane listGUI = drawList(LIST, 50, 50);
        pane.getChildren().add(listGUI);

        HBox settings = new HBox(5);
        settings.setAlignment(Pos.CENTER);

        Label enterValue = new Label("Enter a value: ");
        TextField value = new TextField();
        value.setPrefColumnCount(6);
        Label enterIndex = new Label("Enter an index: ");
        TextField index = new TextField();
        index.setPrefColumnCount(6);

        Button search = new Button("Search");
        Button insert = new Button("Insert");
        Button delete = new Button("Delete");
        Button forward = new Button("Forward Traversal");
        Button backward = new Button("Backward Traversal");

        settings.getChildren().addAll(enterValue, value,
                enterIndex, index, search, insert, delete, forward, backward);
        pane.getChildren().add(settings);


        search.setOnAction(e ->
        {
            status.setText("");
            int value_;
            try
            {
                value_ = Integer.parseInt(value.getText());
            }
            catch (Exception exception)
            {
                return;
            }

            int occurrence = LIST.indexOf(value_);
            if (occurrence == -1)
                status.setText("The value " + value_ + " is not found in the list");
            else
                status.setText("The value " + value_ + " found at index " + occurrence + " in the list");
        });

        insert.setOnAction(e ->
        {
            status.setText("");
            int value_, index_;
            try
            {
                value_ = Integer.parseInt(value.getText());
                try
                {
                    index_ = Integer.parseInt(index.getText());
                    LIST.add(index_, value_);
                }
                catch (Exception exception)
                {
                    LIST.add(value_);
                }
            }
            catch (Exception exception)
            {
                return;
            }

            pane.getChildren().set(1, drawList(LIST, 50, 50));
        });


        delete.setOnAction(e ->
        {
            status.setText("");
            int value_;
            try
            {
                value_ = Integer.parseInt(value.getText());
                LIST.remove(LIST.indexOf(value_));
            }
            catch (Exception exception)
            {
                return;
            }

            pane.getChildren().set(1, drawList(LIST, 50, 50));
        });


        forward.setOnAction(e ->
                status.setText("Forward traversal : " + LIST.forwardToString()));

        backward.setOnAction(e -> status.setText("Backward traversal : " + LIST.backwardToString()));

        Scene scene = new Scene(pane, 800, 400);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Problem$11");
        primaryStage.show();
    }

    public Pane drawList(TwoWayLinkedList<Integer> list, int x, int y)
    {
        Pane pane = new Pane();
        pane.setMinSize(500, 120);

        int x_ = x;
        for (int i = 0; i < list.size(); i++)
        {
            Element element = new Element(x_, y, list.get(i), i == 0, i == list.size() - 1);
            pane.getChildren().add(element);
            pane.getChildren().addAll(element.getDecorations());
            x_ += 80;
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
            super(x, y, 60, 20);
            setFill(Color.WHITE);
            setStroke(Color.BLACK);
            this.value = value;
            this.head = head;
            this.tail = tail;
        }


        public ArrayList<Node> getDecorations()
        {
            ArrayList<Node> decorations = new ArrayList<>();
            Rectangle next = new Rectangle(getX(), getY() + 20, 60, 20);
            next.setFill(Color.WHITE);
            next.setStroke(Color.BLACK);
            Text nextText = new Text(getX() + 10, getY() + 30, "next");

            Rectangle previous = new Rectangle(getX(), getY() + 40, 60, 20);
            previous.setFill(Color.WHITE);
            previous.setStroke(Color.BLACK);
            Text previousText = new Text(getX() + 10, getY() + 50, "previous");

            decorations.add(next);
            decorations.add(nextText);
            decorations.add(previous);
            decorations.add(previousText);

            Text number = new Text(getX() + 10, getY() + 15, value + "");
            decorations.add(number);

            if (tail)
            {
                Line line1 = new Line(getX() + 60, getY(), getX() + 90, getY() - 30);
                Line line2 = new Line(getX() + 60, getY(), getX() + 60, getY() - 10);
                Line line3 = new Line(getX() + 60, getY(), getX() + 70, getY() + 5);
                Text text = new Text(getX() + 90, getY() - 30, "tail");
                decorations.add(line1);
                decorations.add(line2);
                decorations.add(line3);
                decorations.add(text);
            }
            else
            {
                Line line1 = new Line(getX() + 60, next.getY() + 10, getX() + 80, getY() + 10);
                Line line2 = new Line(getX() + 80, getY() + 10, getX() + 80, getY() + 20);
                Line line3 = new Line(getX() + 80, getY() + 10, getX() + 70, getY() + 10);
                decorations.add(line1);
                decorations.add(line2);
                decorations.add(line3);
            }


            if (head)
            {
                Line line1 = new Line(getX(), getY(), getX() - 30, getY() - 30);
                Line line2 = new Line(getX(), getY(), getX(), getY() - 10);
                Line line3 = new Line(getX(), getY(), getX() - 10, getY());
                Text text = new Text(getX() - 40, getY() - 35, "head");
                decorations.add(line1);
                decorations.add(line2);
                decorations.add(line3);
                decorations.add(text);
            }
            else
            {
                Line line1 = new Line(previous.getX(), previous.getY() + 10, getX() - 20, getY() + 10);
                Line line2 = new Line(getX() - 20, getY() + 10, getX() - 10, getY() + 20);
                Line line3 = new Line(getX() - 20, getY() + 10, getX() - 20, getY() + 20);
                decorations.add(line1);
                decorations.add(line2);
                decorations.add(line3);
            }

            return decorations;
        }
    }
}
