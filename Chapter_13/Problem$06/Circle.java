package chapter_thirteen;

public class Circle extends GeometricObject
{
    private double radius;

    public Circle() { }

    public Circle(double radius)
    {
        this.radius = radius;
    }

    public Circle(double radius,
                  String color, boolean filled)
    {
        this.radius = radius;
        setColor(color);
        setFilled(filled);
    }

    /** Return radius */
    public double getRadius()
    {
        return radius;
    }

    /** Set a new radius */
    public void setRadius(double radius)
    {
        this.radius = radius;
    }

    /** Return area */
    @Override
    public double getArea()
    {
        return radius * radius * Math.PI;
    }

    /** Return diameter */
    public double getDiameter()
    {
        return 2 * radius;
    }

    @Override /** Return perimeter */
    public double getPerimeter()
    {
        return 2 * radius * Math.PI;
    }

    @Override /** Implement the toString method in GeometricObject */
    public String toString()
    {
        return super.toString() + "\nDate created: " + getDateCreated() +
                "\nRadius: " + radius;
    }

    @Override
    public int compareTo(GeometricObject o)
    {
        return (int) (getArea() - o.getArea());
    }
}