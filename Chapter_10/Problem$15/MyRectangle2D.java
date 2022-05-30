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


    public static MyRectangle2D getRectangle(double[][] points)
    {
        final int COLUMN_X = 0;
        final int COLUMN_Y = 1;
        double[] minMaxX = minMax(points, COLUMN_X);
        double[] minMaxY = minMax(points, COLUMN_Y);
        double x = (minMaxX[1] + minMaxX[0]) / 2;
        double y = (minMaxY[1] + minMaxY[0]) / 2;
        double height = Math.sqrt(Math.pow(minMaxY[1] - minMaxY[0], 2));;
        double width = Math.sqrt(Math.pow(minMaxX[1] - minMaxX[0], 2));
        return new MyRectangle2D(x, y, width, height);
    }

    private static double[] minMax(double[][] points, int col)
    {
        double[] minMax = new double[2];
        minMax[0] = minMax[1] = points[0][col];
        for (double[] point : points)
        {
            if (point[col] < minMax[0])
                minMax[0] = point[col];
            else if (point[col] > minMax[1])
                minMax[0] = point[col];
        }
        return minMax;
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
