package chapter_fifteen;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;

public class LatticePane extends Pane
{
    private int rows = 16;
    private int columns = 16;


    public LatticePane()
    {
        setPrefSize(500, 500);
        draw();
    }

    public LatticePane(int rows, int columns)
    {
        this.rows = rows;
        this.columns = columns;
        setPrefSize(500, 500);
        draw();
    }


    public void draw()
    {
        double part = getPrefWidth()/columns;
        for (int i = 0; i < columns;i++)
        {
            Line line = new Line(i*part, 0, i*part, getPrefHeight());
            line.setStroke(Color.SKYBLUE);
            getChildren().add(line);
        }

        part = getPrefHeight()/rows;
        for (int i = 0; i < rows;i++)
        {
            Line line = new Line(0, i*part, getPrefWidth(), i*part);
            line.setStroke(Color.SKYBLUE);
            getChildren().add(line);
        }
    }


    public double getVerticalStep()
    {
        return getPrefHeight()/rows;
    }

    public double getHorizontalStep()
    {
        return getPrefWidth()/columns;
    }
}
