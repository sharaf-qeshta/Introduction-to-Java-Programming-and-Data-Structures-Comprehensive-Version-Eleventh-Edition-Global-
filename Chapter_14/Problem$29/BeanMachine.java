package chapter_fourteen;

import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Polyline;

import java.util.ArrayList;

public class BeanMachine extends Pane
{
    private int slots = 7;

    public BeanMachine()
    {
        draw();
    }

    public BeanMachine(int slots)
    {
        this.slots = slots;
        draw();
    }

    public void draw()
    {
        Polyline cover = new Polyline(240, 250, 240, 270, 180, 340,
                180, 370, 320, 370, 320, 340, 260, 270, 260, 250 );

        getChildren().add(cover);

        double distance = Math.sqrt(Math.pow(180 - 320, 2));
        double part = distance / (slots+1);

        for (int i = 1; i < (slots+1); i++)
        {
            Line line = new Line(180 + (i*part),
                    370, 180 + (i*part), 340);
            getChildren().add(line);
        }

        ArrayList<Circle> circles = new ArrayList<>();
        ArrayList<Circle> circles2 = new ArrayList<>();

        ArrayList<ArrayList<Circle>> c = new ArrayList<>();
        c.add(circles);
        c.add(circles2);

        distance =  Math.sqrt(Math.pow(240 - 180, 2) + Math.pow(270 - 340, 2));
        double rowsVGap = (distance / (slots+1)) / 2;
        for (int i = 0; i < getChildren().size(); i++)
        {
            if (getChildren().get(i) instanceof Line)
            {
                Line line = (Line) getChildren().get(i);
                Circle circle = new Circle(line.getEndX(), line.getEndY()-rowsVGap/1.5, rowsVGap/1.5);
                getChildren().add(circle);
                circles.add(circle);
            }
        }

        int index = 0;
        for (int i = 0; i < slots-1; i++)
        {
            ArrayList<Circle> otherCollection = c.get((index == 1)? 0 : 1);
            ArrayList<Circle> previousRow = c.get(index);
            for (int j = 0; j < previousRow.size()-1; j++)
            {
                double midpointX = (previousRow.get(j).getCenterX() + previousRow.get(j+1).getCenterX())/2;
                double midpointY = (previousRow.get(j).getCenterY() + previousRow.get(j+1).getCenterY())/2;
                Circle circle = new Circle(midpointX, midpointY-(rowsVGap * 2), rowsVGap/1.5);
                getChildren().add(circle);
                otherCollection.add(circle);
            }
            c.get(index).clear();
            index = (index == 1)? 0 : 1;
        }
    }
}
