package chapter_fifteen;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.geometry.Point2D;
import javafx.scene.shape.Line;
import javafx.util.Duration;

import java.util.ArrayList;

public class Path
{
    private final Point2D center;
    private final ArrayList<Point2D> visited = new ArrayList<>();
    private final LatticePane pane;
    private final double verticalStep;
    private final double horizontalStep;
    private int index = 0;


    public Path(LatticePane pane, double verticalStep, double horizontalStep)
    {
        center = new Point2D(pane.getPrefWidth()/2, pane.getPrefHeight()/2);
        this.pane = pane;
        this.horizontalStep = horizontalStep;
        this.verticalStep = verticalStep;
        drawPath();
    }


    public Path(LatticePane pane, double verticalStep, double horizontalStep, Point2D endPoint)
    {
        center = new Point2D(pane.getPrefWidth()/2, pane.getPrefHeight()/2);
        this.pane = pane;
        this.horizontalStep = horizontalStep;
        this.verticalStep = verticalStep;
        drawPath(endPoint);
    }

    public void drawPath()
    {
        Point2D currentPoint = center;
        ArrayList<Line> lines = new ArrayList<>();

        while (!hitTheBorder(currentPoint))
        {
            int move = (int) ((Math.random() * 10) % 2);
            int direction = (int) ((Math.random() * 10) % 2);
            int factor = (direction == 0)? 1 : -1;
            Point2D nextPoint;
            if (move == 0)
                nextPoint = new Point2D(currentPoint.getX(),
                        currentPoint.getY() + (verticalStep*factor));
            else
                nextPoint = new Point2D(currentPoint.getX() + (horizontalStep*factor),
                        currentPoint.getY());

            if (visited.contains(nextPoint))
                continue;

            visited.add(nextPoint);
            Line line = new Line(currentPoint.getX(), currentPoint.getY(), nextPoint.getX(), nextPoint.getY());
            lines.add(line);
            currentPoint = nextPoint;
        }

        Timeline animation = new Timeline(
                new KeyFrame(Duration.millis(500), actionEvent -> pane.getChildren().add(lines.get(index++)))
        );
        animation.setCycleCount(lines.size());
        animation.play();
    }


    public void drawPath(Point2D endPoint)
    {
        Point2D currentPoint = center;
        ArrayList<Line> lines = new ArrayList<>();
        int numberOfLags = 0;

        while (!currentPoint.equals(endPoint) && !hitTheBorder(currentPoint))
        {
            int move = (int) ((Math.random() * 10) % 2);
            int direction = (int) ((Math.random() * 10) % 2);
            int factor = (direction == 0)? 1 : -1;
            Point2D nextPoint;
            if (move == 0)
                nextPoint = new Point2D(currentPoint.getX(),
                        currentPoint.getY() + (verticalStep*factor));
            else
                nextPoint = new Point2D(currentPoint.getX() + (horizontalStep*factor),
                        currentPoint.getY());

            if (visited.contains(nextPoint))
            {
                numberOfLags++;
                if (move == 0) // revise the direction
                    nextPoint = new Point2D(currentPoint.getX(),
                            currentPoint.getY() + (verticalStep*factor*-1));
                else
                    nextPoint = new Point2D(currentPoint.getX()
                            + (horizontalStep*factor*-1), currentPoint.getY());

                if (visited.contains(nextPoint))
                    continue;

                if (numberOfLags == 4)
                    break;
            }

            visited.add(nextPoint);
            Line line = new Line(currentPoint.getX(), currentPoint.getY(), nextPoint.getX(), nextPoint.getY());
            lines.add(line);
            currentPoint = nextPoint;
            numberOfLags = 0;
        }

        Timeline animation = new Timeline(
                new KeyFrame(Duration.millis(500), actionEvent -> pane.getChildren().add(lines.get(index++)))
        );
        animation.setCycleCount(lines.size());
        animation.play();
    }


    private boolean hitTheBorder(Point2D point)
    {
        if (point.getX() >= pane.getPrefWidth() || point.getX() <= 0)
            return true;
        return point.getY() >= pane.getPrefHeight() || point.getY() <= 0;
    }
}
