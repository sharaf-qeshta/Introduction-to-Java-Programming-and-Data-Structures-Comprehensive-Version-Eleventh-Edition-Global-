package chapter_ten;

public class MyRectangle2D
{
    private double x, y ,width, height;

    public MyRectangle2D()
    {
        x = 0; y=0;
        width = 1; height = 1;
    }


    public MyRectangle2D(double x, double y, double width, double height)
    {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public double getArea()
    {
        return width * height;
    }

    public double getPerimeter()
    {
        return 2 * width + 2 * height;
    }


    public boolean contains(double x, double y)
    {
        double distance = Math.sqrt(Math.pow(x - this.x, 2) + Math.pow(y - this.y, 2));
        return distance <= width && distance <= height;
    }

    public boolean contains(MyRectangle2D r)
    {
        return height >= r.height && width >= r.width && contains(r.x, r.y);
    }

    public boolean overlaps(MyRectangle2D r)
    {
        double distance =Math.sqrt(Math.pow(x - r.x, 2) + Math.pow(y - r.y, 2));

        return distance <= (height+r.height) / 2 & distance <= (width+r.width) / 2;
    }


    public double getX()
    {
        return x;
    }

    public void setX(double x)
    {
        this.x = x;
    }

    public double getY()
    {
        return y;
    }

    public void setY(double y)
    {
        this.y = y;
    }

    public double getWidth()
    {
        return width;
    }

    public void setWidth(double width)
    {
        this.width = width;
    }

    public double getHeight()
    {
        return height;
    }

    public void setHeight(double height)
    {
        this.height = height;
    }
}
