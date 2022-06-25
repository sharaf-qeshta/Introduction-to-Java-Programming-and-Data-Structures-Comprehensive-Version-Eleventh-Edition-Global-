package chapter_fifteen;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Polyline;
import javafx.util.Duration;

import java.util.ArrayList;

public class BeanMachine extends Pane
{
    private int slots = 7;
    private int ballsToFall = 10;
    private double horizontalStep;
    private double verticalStep;
    private Circle currentCircle = createBall();
    private static final ArrayList<Circle> fallingBalls = new ArrayList<>();

    public BeanMachine()
    {
        draw();
    }

    public BeanMachine(int slots)
    {
        this.slots = slots;
        draw();
    }

    public BeanMachine(int slots, int ballsToFall)
    {
        this.slots = slots;
        this.ballsToFall = ballsToFall;
        draw();
    }

    public void draw()
    {
        Polyline cover = new Polyline(240, 250, 240, 270, 180, 340,
                180, 370, 320, 370, 320, 340, 260, 270, 260, 250);

        getChildren().add(cover);

        double distance = Math.sqrt(Math.pow(180 - 320, 2));
        double part = distance / (slots + 1);
        for (int i = 1; i < (slots + 1); i++)
        {
            Line line = new Line(180 + (i * part),
                    370, 180 + (i * part), 340);
            getChildren().add(line);
        }

        ArrayList<Circle> circles = new ArrayList<>();
        ArrayList<Circle> circles2 = new ArrayList<>();

        ArrayList<ArrayList<Circle>> c = new ArrayList<>();
        c.add(circles);
        c.add(circles2);

        // first row
        distance = Math.sqrt(Math.pow(240 - 180, 2) + Math.pow(270 - 340, 2));
        double rowsVGap = (distance / (slots + 1)) / 2;
        for (int i = 0; i < getChildren().size(); i++)
        {
            if (getChildren().get(i) instanceof Line)
            {
                Line line = (Line) getChildren().get(i);
                Circle circle = new Circle(line.getEndX(), line.getEndY() - rowsVGap / 1.5, rowsVGap / 1.5);
                getChildren().add(circle);
                circles.add(circle);
            }
        }

        // other rows
        int index = 0;
        for (int i = 0; i < slots - 1; i++)
        {
            ArrayList<Circle> otherCollection = c.get((index == 1) ? 0 : 1);
            ArrayList<Circle> previousRow = c.get(index);
            for (int j = 0; j < previousRow.size() - 1; j++)
            {
                double midpointX = (previousRow.get(j).getCenterX() + previousRow.get(j + 1).getCenterX()) / 2;
                double midpointY = (previousRow.get(j).getCenterY() + previousRow.get(j + 1).getCenterY()) / 2;
                Circle circle = new Circle(midpointX, midpointY - (rowsVGap * 2), rowsVGap / 1.5);
                getChildren().add(circle);
                otherCollection.add(circle);
            }
            c.get(index).clear();
            index = (index == 1) ? 0 : 1;
        }

        horizontalStep = part;
        verticalStep = rowsVGap;
        setAnimation();
    }


    public void setAnimation()
    {
        EventHandler<ActionEvent> event = e ->
        {
            if (currentCircle.getCenterY() >= 340)
            {
                double raise = verticalStep;
                do
                {
                    currentCircle.setCenterY(370 - raise);
                    raise += currentCircle.getRadius() * 2;
                }
                while (!isThereASpace(currentCircle));
                fallingBalls.add(currentCircle);
                currentCircle = createBall();
            }
            int step = (int) ((Math.random() * 10) % 2); // 0 right 1 left

            if (step == 0)
                currentCircle.setCenterX(currentCircle.getCenterX() + horizontalStep / 4);
            else
                currentCircle.setCenterX(currentCircle.getCenterX() - horizontalStep / 4);
            currentCircle.setCenterY(currentCircle.getCenterY() + verticalStep * 2);

            if (currentCircle.getCenterY() >= 340)
            {
                double raise = verticalStep;
                do
                {
                    currentCircle.setCenterY(370 - raise);
                    raise += currentCircle.getRadius() * 2;
                }
                while (!isThereASpace(currentCircle));

                fallingBalls.add(currentCircle);
                currentCircle = createBall();
            }
        };
        Timeline animation = new Timeline(
                new KeyFrame(Duration.millis(100), event)
        );
        animation.setCycleCount((ballsToFall + 1) * (slots + 1));
        animation.play();

        animation.setOnFinished(e -> getChildren().remove(currentCircle));
    }


    public Circle createBall()
    {
        Circle circle = new Circle(250, 250, verticalStep / 1.5);
        getChildren().add(circle);
        circle.setFill(Color.BLUE);
        return circle;
    }

    public boolean isThereASpace(Circle circle)
    {
        for (Circle x : fallingBalls)
            if (x.contains(circle.getCenterX(), circle.getCenterY()))
                return false;
        return true;
    }
}
