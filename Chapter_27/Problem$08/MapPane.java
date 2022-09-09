package chapter_twenty_seven;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;


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
                + map.hashTable.length + ". Number of keys " + map.size() + ".";

        getChildren().add(new Text(20, 20, status));

        int startY = 40;
        for (int i = 0; i < map.hashTable.length; i++)
        {
            getChildren().add(new Text(20, startY, "[" + i + "]"));

            Rectangle rectangle = new Rectangle(40, startY-10, 40, 20);
            rectangle.setFill(Color.WHITE); rectangle.setStroke(Color.BLACK);
            getChildren().add(rectangle);

            if (map.hashTable[i] != null)
            {
                if (!map.hashTable[i].marked)
                {
                    getChildren().add(new Text(50, startY+5,
                            map.hashTable[i].getValue() + ""));
                }
            }
            startY += 40;
        }
    }
}
