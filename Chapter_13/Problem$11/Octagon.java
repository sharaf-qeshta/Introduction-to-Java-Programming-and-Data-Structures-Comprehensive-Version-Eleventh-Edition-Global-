package chapter_thirteen;


public class Octagon extends GeometricObject implements Cloneable
{
    private double side;

    public Octagon()
    {
        side = 0;
    }

    public Octagon(double side)
    {
        this.side = side;
    }

    @Override
    public double getArea()
    {
        return (2 + 4 *  Math.sqrt(2)) * side * side;
    }

    @Override
    public double getPerimeter()
    {
        return side * 8;
    }

    @Override
    public int compareTo(GeometricObject o)
    {
        return (int) (getArea() - o.getArea());
    }


    public double getSide()
    {
        return side;
    }

    public void setSide(double side)
    {
        this.side = side;
    }

    @Override
    protected Object clone()
    {
        return new Octagon(this.side);
    }
}
