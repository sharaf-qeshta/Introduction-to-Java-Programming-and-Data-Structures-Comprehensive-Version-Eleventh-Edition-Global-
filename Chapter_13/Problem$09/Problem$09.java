package chapter_thirteen;

/**
 * *13.9 (Enable Circle comparable) Rewrite the Circle class in Listing 13.2 to extend
 * GeometricObject and implement the Comparable interface. Override the
 * equals method in the Object class. Two Circle objects are equal if their radii
 * are the same. Draw the UML diagram that involves Circle, GeometricObject,
 * and Comparable.
 *
 * @author Sharaf Qeshta
 * */
public class Problem$09
{
    public static void main(String[] args)
    {
        Circle circle1 = new Circle(7, "blue", true);
        Circle circle2 = new Circle(14, "blue", false);

        // -461
        System.out.println(circle1.compareTo(circle2));
    }
}