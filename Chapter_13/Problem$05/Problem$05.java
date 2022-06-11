package chapter_thirteen;

/**
 * *13.5 (Enable GeometricObject comparable) Modify the GeometricObject class
 * to implement the Comparable interface and define a static max method in the
 * GeometricObject class for finding the larger of two GeometricObject objects.
 * Draw the UML diagram and implement the new GeometricObject class. Write
 * a test program that uses the max method to find the larger of two circles, the larger
 * of two rectangles.
 *
 * @author Sharaf Qeshta
 * */
public class Problem$05
{
    public static void main(String[] args)
    {
        /*i will try it for triangle class*/
        Triangle t1 = new Triangle(10, 10, 10);
        Triangle t2 = new Triangle(1, 1, 1);

        /*Triangle{side1=10.0, side2=10.0, side3=10.0}*/
        System.out.println(GeometricObject.max(t1, t2));

        /* 42 */
        System.out.println(t1.compareTo(t2));
    }
}
