package chapter_ten;

public class Circle2D
{
    private double x, y, radius;

    public Circle2D()
    {
        x = 0; y=0; radius=1;
    }

    public Circle2D(double x, double y, double radius)
    {
        this.x = x;
        this.y = y;
        this.radius = radius;
    }


    public double getArea()
    {
        return Math.PI * radius * radius;
    }


    public double getPerimeter()
    {
        return 2 * Math.PI * radius;
    }


    public boolean contains(double x, double y)
    {
        double distance = Math.sqrt(Math.pow(x - this.x, 2) + Math.pow(y - this.y, 2));
        return distance <= radius;
    }


    public boolean contains(Circle2D circle)
    {
        double centersDistance = Math.sqrt(Math.pow(this.x - circle.x, 2) + Math.pow(this.y - circle.y, 2));
        return this.radius > (centersDistance + circle.radius);
    }

    public boolean overlaps(Circle2D circle)
    {
        double centersDistance = Math.sqrt(Math.pow(this.x - circle.x, 2) + Math.pow(this.y - circle.y, 2));
        return (circle.radius - this.radius) <= centersDistance
                || (circle.radius + this.radius) >= centersDistance;
    }

    public double getX()
    {
        return x;
    }

    public double getY()
    {
        return y;
    }

    public double getRadius()
    {
        return radius;
    }
}
