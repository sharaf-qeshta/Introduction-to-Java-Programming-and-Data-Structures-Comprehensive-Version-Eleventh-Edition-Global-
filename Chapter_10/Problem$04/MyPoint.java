package chapter_ten;

public class MyPoint
{
    private double x, y;

    public MyPoint() { }

    public MyPoint(double x, double y)
    {
        this.x = x;
        this.y = y;
    }


    public double distance(MyPoint otherPoint)
    {
        double deltaX = Math.pow(x - otherPoint.getX(), 2);
        double deltaY = Math.pow(y - otherPoint.getY(), 2);
        return Math.sqrt(deltaX + deltaY);
    }

    public static double distance(MyPoint p1, MyPoint p2)
    {
        double deltaX = Math.pow(p1.getX() - p2.getX(), 2);
        double deltaY = Math.pow(p1.getY() - p2.getY(), 2);
        return Math.sqrt(deltaX + deltaY);
    }


    public double getX()
    {
        return x;
    }

    public double getY()
    {
        return y;
    }
}
