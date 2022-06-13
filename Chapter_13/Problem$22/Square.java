package chapter_thirteen;


public class Square extends GeometricObject
{
    private double sideLength;

    public Square()
    {
        sideLength = 0;
    }

    public Square(double sideLength)
    {
        this.sideLength = sideLength;
    }

    public Square(String color, boolean filled, double sideLength)
    {
        super(color, filled);
        this.sideLength = sideLength;
    }


    @Override
    public double getArea()
    {
        return sideLength * sideLength;
    }

    @Override
    public double getPerimeter()
    {
        return 4 * sideLength;
    }


    public double getSideLength()
    {
        return sideLength;
    }

    public void setSideLength(double sideLength)
    {
        this.sideLength = sideLength;
    }
}
