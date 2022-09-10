package chapter_twenty_seven;

public class Point
{
    private double x, y;

    public Point () { }

    public Point(double x, double y)
    {
        this.x = x;
        this.y = y;
    }

    public double getX()
    {
        return x;
    }

    public double getY()
    {
        return y;
    }

    public boolean equals(Point point)
    {
        return hashCode() == point.hashCode();
    }

    public int hashCode()
    {
        long hash = 7L;
        hash = 31L * hash + Double.doubleToLongBits(getX());
        hash = 31L * hash + Double.doubleToLongBits(getY());
        return (int) (hash ^ hash >> 32);
    }
}
