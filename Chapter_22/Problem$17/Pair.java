package chapter_twenty_two;

import javafx.geometry.Point2D;

public class Pair
{
    Point2D p1, p2;

    public Pair(Point2D p1, Point2D p2)
    {
        this.p1 = p1;
        this.p2 = p2;
    }

    public Pair() { }


    public double getDistance()
    {
        if (p1 == null || p2 == null)
            return Double.MAX_VALUE;
        return Math.sqrt(Math.pow(p1.getX() - p2.getX(), 2)
                + Math.pow(p1.getY() - p2.getY(), 2));
    }


    public String toString()
    {
        return p1.toString() + ", " + p2.toString();
    }
}
