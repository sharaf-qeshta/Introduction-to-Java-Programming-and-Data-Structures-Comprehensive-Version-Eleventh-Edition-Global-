package chapter_thirteen;

/**
 * *13.6 (The ComparableCircle class) Define a class named ComparableCircle
 * that extends Circle and implements Comparable. Draw the UML diagram
 * and implement the compareTo method to compare the circles on the basis of
 * area. Write a test class to find the larger of two instances of ComparableCircle
 * objects, and the larger between a circle and a rectangle.
 *
 * @author Sharaf Qeshta
 * */
public class Problem$06
{
    public static void main(String[] args)
    {
        Triangle triangle = new Triangle(10, 10, 10);
        Circle circle = new Circle(1, "White", true);

        /*Triangle{side1=10.0, side2=10.0, side3=10.0}*/
        System.out.println(GeometricObject.max(triangle, circle));

        /* -40 */
        System.out.println(circle.compareTo(triangle));
    }
}
