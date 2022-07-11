package chapter_eighteen;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class CircleFractal extends Pane
{
    private int order = 0;

    public CircleFractal(int order)
    {
        this.order = order;
        paint();
    }

    public CircleFractal()
    {
        paint();
    }

    public void paint()
    {
        double centerX = getWidth()/2;
        double centerY = getHeight()/2;
        double radius = Math.sqrt((centerX * centerX) + (centerY * centerY)) / 2;

        this.getChildren().clear();

        displayCircle(order, centerX, centerY, radius);
    }


    private void displayCircle(int order, double centerX, double centerY, double radius)
    {
        if (order == 0)
        {
            Circle circle = new Circle(centerX, centerY, radius);
            circle.setFill(Color.WHITE);
            circle.setStroke(Color.BLACK);
            this.getChildren().add(circle);

        }
        else
        {
            Circle circle = new Circle(centerX, centerY, radius);
            circle.setFill(Color.WHITE);
            circle.setStroke(Color.BLACK);
            this.getChildren().add(circle);
            displayCircle(order - 1, centerX, centerY, radius-10);
        }
    }


    public int getOrder()
    {
        return order;
    }

    public void setOrder(int order)
    {
        this.order = order;
        paint();
    }
}
