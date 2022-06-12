package chapter_thirteen;

public class Rectangle extends GeometricObject
{
    private double width;
    private double height;

    public Rectangle() { }

    public Rectangle(
            double width, double height)
    {
        this.width = width;
        this.height = height;
    }

    public Rectangle(
            double width, double height, String color, boolean filled)
    {
        this.width = width;
        this.height = height;
        setColor(color);
        setFilled(filled);
    }

    /** Return width */
    public double getWidth()
    {
        return width;
    }

    /** Set a new width */
    public void setWidth(double width)
    {
        this. width = width;
    }

    /** Return height */
    public double getHeight()
    {
        return height;
    }

    /** Set a new height */
    public void setHeight(double height) {
        this.height = height;
    }

    @Override /** Return area */
    public double getArea(){
        return width * height;
    }

    @Override /** Return perimeter */
    public double getPerimeter()
    {
        return 2 * (width * height);
    }


    @Override /** Return true if both objects are equal */
    public boolean equals(Object o)
    {
        return this.compareTo((Rectangle)o) == 0;
    }

    @Override /** Return String discription of this rectangle */
    public String toString()
    {
        return super.toString() + "\nWidth: " + width + "\nHeight: " + height
                + "\nArea: " + getArea() + "\nPerimeter: " + getPerimeter();
    }

    @Override
    public int compareTo(GeometricObject o)
    {
        return (int) (getArea() - o.getArea());
    }
}
