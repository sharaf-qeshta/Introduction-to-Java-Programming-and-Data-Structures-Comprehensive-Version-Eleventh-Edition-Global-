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

/**
 * *24.9 (Animation: array list in slow motion) Improve the animation in the preceding
 * programming exercise by showing the insertion and deletion operations in a slow
 * motion.
 *
 *
 * @author Sharaf Qeshta
 * */
public class Problem$09 extends Application
{
    public static MyArrayList<Integer> list = new MyArrayList<>();

    @Override
    public void start(Stage primaryStage)
    {
        VBox pane = new VBox(10);
        pane.setAlignment(Pos.CENTER);

        Label status = new Label();
        pane.getChildren().add(status);

        Pane arrayListGUI = drawArrayList(list, 20, 30);
        pane.getChildren().add(arrayListGUI);

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
        Button trim = new Button("TrimToSize");

        settings.getChildren().addAll(enterValue, value, enterIndex, index,
                search, insert, delete, trim);
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

            int index_ = list.indexOf(value_);
            if (index_ != -1)
                status.setText("The value " + value_ + " is at index " + index_ + " in the list");
            else
                status.setText("The value " + value_ + " is not in the list");
        });

        insert.setOnAction(e ->
        {
            status.setText("");
            int value_;
            int index_;
            try
            {
                value_ = Integer.parseInt(value.getText());
                try
                {
                    index_ = Integer.parseInt(index.getText());
                }
                catch (Exception exception)
                {
                    index_ = list.capacity;
                }
            }
            catch (Exception exception)
            {
                return;
            }

            if (index_ < list.capacity)
                list.add(index_, value_);
            else
                list.add(value_);
            pane.getChildren().set(1, drawArrayList(list, 20, 30));
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

            int index_ = list.indexOf(value_);
            if (index_ != -1)
                list.remove(index_);
            pane.getChildren().set(1, drawArrayList(list, 20, 30));
        });


        trim.setOnAction(e ->
        {
            status.setText("");
            list.trimToSize();
            pane.getChildren().set(1, drawArrayList(list, 20, 30));
        });


        Scene scene = new Scene(pane, 600, 500);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Problem$09");
        primaryStage.show();
    }

    public Pane drawArrayList(MyArrayList<Integer> list, int x, int y)
    {
        Pane pane = new Pane();
        pane.setMinSize(500, 100);
        pane.setStyle("-fx-border-color: black");

        String status = (list.size() == 0) ? "array list is empty " : "";
        status += "size = " + list.size() + " and capacity is " + list.capacity;
        Text text = new Text(x+5, y+5, status);
        pane.getChildren().add(text);

        int x_ = x+10;
        int y_ = y+20;
        for (int i = 0; i < list.capacity; i++)
        {
            Integer currentElement = null;
            if (i < list.size())
                currentElement = list.get(i);
            Element element = new Element(x_, y_, currentElement);
            pane.getChildren().addAll(element, element.getDecorations());
            x_ += 40;
        }

        return pane;
    }


    private static class Element extends Rectangle
    {
        Integer value;

        public Element(int x, int y, Integer value)
        {
            super(x, y, 40, 20);
            setFill(Color.WHITE); setStroke(Color.BLACK);
            this.value = value;
        }

        public Node getDecorations()
        {
            if (value == null)
                return new Line(getX() + getWidth(), getY(), getX(), getY()+getHeight());
            else
                return new Text(getX() + getWidth()/2 - 5, getY() + getHeight()/2 + 5, value + "");
        }
    }
}
