package chapter_twenty_seven;

import javafx.geometry.Insets;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

import java.util.LinkedList;


public class MapPane extends Pane
{
    private MyHashMap<Integer, Integer> map = new MyHashMap<>();

    public MapPane(double width, double height)
    {
        setMinSize(width, height);

        setStyle("-fx-border-color: black");
        draw();
    }

    public void add(int key)
    {
        map.put(key, key);
        draw();
    }

    public void remove(int key)
    {
        map.remove(key);
        draw();
    }

    public void removeAll()
    {
        map.clear();
        draw();
    }

    public String search(int key)
    {
        if (map.containsKey(key))
            return "Key exist in the map";
        return "Key is not exist in the map";
    }

    public void draw()
    {
        getChildren().clear();
        String status = "Current table size: "
                + map.table.length + ". Number of keys " + map.size() + ".";

        getChildren().add(new Text(20, 20, status));

        int startY = 40;
        for (int i = 0; i < map.table.length; i++)
        {
            getChildren().add(new Text(20, startY, "[" + i + "]"));

            Rectangle rectangle = new Rectangle(40, startY-10, 40, 20);
            rectangle.setFill(Color.WHITE); rectangle.setStroke(Color.BLACK);
            getChildren().add(rectangle);

            if (map.table[i] != null)
            {
                LinkedList<MyMap.Entry<Integer, Integer>> list = map.table[i];

                getChildren().add(new Line(60, startY, 100, startY)); // --
                getChildren().add(new Line(100, startY, 95, startY-5)); // \
                getChildren().add(new Line(100, startY, 95, startY+5)); // /

                int x = 100, y = startY-5;
                for (MyMap.Entry<Integer, Integer> entry: list)
                {
                    Rectangle element = new Rectangle(x, y, 30, 15);
                    element.setFill(Color.WHITE); element.setStroke(Color.BLACK);
                    getChildren().add(element);
                    getChildren().add(new Text(x+10, y+12,
                            entry.getKey() + ""));
                    x += 30;
                }
            }
            startY += 40;
        }
    }
}
