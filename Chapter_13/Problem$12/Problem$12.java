package chapter_thirteen;

/**
 * *13.12 (Sum the areas of geometric objects) Write a method that sums the areas of all the
 * geometric objects in an array. The method signature is:
 * public static double sumArea(GeometricObject[] a)
 *  Write a test program that creates an array of four objects (two circles and two
 * rectangles) and computes their total area using the sumArea method.
 *
 * @author Sharaf Qeshta
 * */
public class Problem$12
{
    public static void main(String[] args)
    {
        GeometricObject[] a = {new Circle(5), new Circle(10)
                , new Rectangle(10, 10), new Rectangle(15, 5)};

        /* 567.6990816987242 */
        System.out.println(sumArea(a));
    }

    public static double sumArea(GeometricObject[] a)
    {
        double areas = 0;
        for (GeometricObject geometricObject : a)
            areas += geometricObject.getArea();
        return areas;
    }
}