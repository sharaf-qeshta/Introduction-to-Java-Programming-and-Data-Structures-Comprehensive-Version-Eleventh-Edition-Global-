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
import java.util.LinkedList;

/**
 * **24.7 (Animation: linked list) Write a program to animate search, insertion, and deletion
 * in a linked list, as shown in Figure 24.1b. The Search button searches the
 * specified value in the list. The Delete button deletes the specified value from the
 * list. The Insert button appends the value into the list if the index is not specified;
 * otherwise, it inserts the value into the specified index in the list.
 *
 *
 * @author Sharaf Qeshta
 * */
public class Problem$07 extends Application
{
    private static final LinkedList<Integer> LIST = new LinkedList<>();
    @Override
    public void start(Stage primaryStage)
    {
        VBox pane = new VBox(10);
        pane.setAlignment(Pos.CENTER);

        Label status = new Label();
        pane.getChildren().add(status);

        Pane linkedList = drawLinkedList(LIST, 50, 50);
        pane.getChildren().add(linkedList);

        HBox settings = new HBox(5);
        Label enterValue = new Label("Enter a value");
        TextField value = new TextField();
        value.setPrefColumnCount(6);
        Label enterIndex = new Label("Enter an index");
        TextField index = new TextField();
        index.setPrefColumnCount(6);

        Button search = new Button("Search");
        Button insert = new Button("Insert");
        Button delete = new Button("Delete");

        settings.getChildren().addAll(enterValue, value, enterIndex,
                index, search, insert, delete);
        settings.setAlignment(Pos.CENTER);
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

            try
            {
                int index_ = Integer.parseInt(index.getText());
                if (LIST.get(index_) == value_)
                    status.setText("value " + value_ + " found at index " + index_);
            }
            catch (Exception exception)
            {
                if (LIST.contains(value_))
                    status.setText("value " + value_ + " found at index " + LIST.indexOf(value_));
                else
                    status.setText("value " + value_ + " is not found in the list ");
            }
            index.setText("");
            value.setText("");
        });

        insert.setOnAction(e ->
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

            try
            {
                int index_ = Integer.parseInt(index.getText());
                LIST.add(index_, value_);
            }
            catch (Exception exception)
            {
                LIST.add(value_);
            }

            pane.getChildren().set(1, drawLinkedList(LIST, 50, 50));
            index.setText("");
            value.setText("");
        });


        delete.setOnAction(e ->
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

            if (LIST.contains(value_))
            {
                LIST.remove(LIST.indexOf(value_));
                pane.getChildren().set(1, drawLinkedList(LIST, 50, 50));
            }
            else
                status.setText("value " + value_ + " is not found in the list");
            index.setText("");
            value.setText("");
        });

        Scene scene = new Scene(pane, 500, 500);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Problem$07");
        primaryStage.show();
    }

    public Pane drawLinkedList(LinkedList<Integer> linkedList, int startX, int startY)
    {
        Pane pane = new Pane();
        pane.setMinSize(500, 100);
        pane.setStyle("-fx-border-color: black");
        int x_ = startX;
        for (int i = 0; i < linkedList.size(); i++)
        {
            LinkedListNode node = new LinkedListNode(linkedList.get(i), x_, startY,
                    linkedList.size() - 1 == i, i == 0);
            pane.getChildren().add(node);
            pane.getChildren().addAll(node.getDecorations());
            x_ += 80;
        }

        return pane;
    }

    private static class LinkedListNode extends Rectangle
    {
        private final int value;
        private final boolean last;
        private final boolean first;

        public LinkedListNode(int value, int x, int y, boolean last, boolean first)
        {
            super(x, y, 60, 20);
            setFill(Color.WHITE); setStroke(Color.BLACK);
            this.value = value;
            this.last = last;
            this.first = first;
        }

        public ArrayList<Node> getDecorations()
        {
            ArrayList<Node> decorations = new ArrayList<>();
            double x = getX() + (getWidth() / 3) * 2;
            Line line = new Line(x, getY(), x, getY()+ getHeight());
            decorations.add(line);

            Text text = new Text(getX() + getWidth()/3,
                    getY() + getHeight()/2 +5, value + "");
            decorations.add(text);


            if (first)
            {
                double x2 = getX()+getWidth()/3;
                Line line1 = new Line(getX(), getY() - 20, x2, getY());
                Line line2 = new Line(x2, getY(), x2-10, getY()-3);
                Line line3 = new Line(x2, getY(), x2+5, getY()-5);
                decorations.add(line1);
                decorations.add(line2);
                decorations.add(line3);

                Text headText = new Text(getX(), getY()-25, "head");
                decorations.add(headText);
            }

            if (last)
            {
                double x2 = getX() + getWidth()/3;
                Line line1 = new Line(getX() + getWidth()/2, getY()-20, x2, getY());
                Line line2 = new Line(x2, getY(), x2-5, getY()-5);
                Line line3 = new Line(x2, getY(), x2+10, getY()-3);
                decorations.add(line1);
                decorations.add(line2);
                decorations.add(line3);

                Text tailText = new Text(getX() + getWidth()/2, getY()-25, "tail");
                decorations.add(tailText);
            }

            if (!last)
            {
                double x1 = getX() + (getWidth() / 3) * 2 + 5;
                double y1 = getY() + getHeight()/2;
                double x2 = x1+(getWidth()/3 - 5) + 20;
                Line line1 = new Line(x1, y1, x2, y1);
                Line line2 = new Line(x2, y1, x2-5, y1-5);
                Line line3 = new Line(x2, y1, x2-5, y1+5);
                decorations.add(line1);
                decorations.add(line2);
                decorations.add(line3);
            }
            return decorations;
        }
    }
}
