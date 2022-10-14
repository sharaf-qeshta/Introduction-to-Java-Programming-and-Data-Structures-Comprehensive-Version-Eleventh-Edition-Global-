package chapter_thirty_two;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.scene.shape.Circle;

public class FanPane extends Pane
{
    private double w = 200;
    private double h = 200;
    private double radius = w * 0.45;
    private final Arc[] arc = new Arc[4];
    private double startAngle = 30;
    private final Circle circle = new Circle(w / 2, h / 2, radius);

    public FanPane()
    {
        circle.setStroke(Color.BLACK);
        circle.setFill(Color.WHITE);
        getChildren().add(circle);

        for (int i = 0; i < 4; i++)
        {
            arc[i] = new Arc(w / 2, h / 2, radius * 0.9,
                    radius * 0.9, startAngle + i * 90, 35);
            arc[i].setFill(Color.RED);
            arc[i].setType(ArcType.ROUND);
            getChildren().addAll(arc[i]);
        }
    }

    private double increment = 5;

    public void reverse()
    {
        increment = -increment;
    }

    public void move()
    {
        setStartAngle(startAngle + increment);
    }

    public void setStartAngle(double angle)
    {
        startAngle = angle;
        setValues();
    }

    public void setValues()
    {
        radius = Math.min(w, h) * 0.45;
        circle.setRadius(radius);
        circle.setCenterX(w / 2);
        circle.setCenterY(h / 2);

        for (int i = 0; i < 4; i++)
        {
            arc[i].setRadiusX(radius * 0.9);
            arc[i].setRadiusY(radius * 0.9);
            arc[i].setCenterX(w / 2);
            arc[i].setCenterY(h / 2);
            arc[i].setStartAngle(startAngle + i * 90);
        }
    }

    public void setW(double w)
    {
        this.w = w;
        setValues();
    }

    public void setH(double h)
    {
        this.h = h;
        setValues();
    }
}