package chapter_twenty_seven;


/**
 * *27.14 (The Point class) Design a class named Point that meets the following
 * requirements:
 * ■■ Two data fields x and y for representing a point with getter methods
 * ■■ A no-arg constructor that constructs a point for (0, 0)
 * ■■ A constructor that constructs a point with the specified x and y values
 * ■■ Override the equals method. Point p1 is said to be equal to point p2 if
 * p1.x = = p2.x and p1.y = = p2.y.
 * ■■ Override the hashCode method. (For reference, see the implementation of the
 * Point2D class in the Java API.)
 *
 *
 * @author Sharaf Qeshta
 * */
public class Problem$14
{
    public static void main(String[] args)
    {
        Point p1 = new Point(1, 1);
        Point p2 = new Point(10, 13);
        Point p3 = new Point(10, 13);

        System.out.println(p1.hashCode()); // -33547705
        System.out.println(p2.hashCode()); // 75897415
        System.out.println(p3.hashCode()); // 75897415

        System.out.println(p1.equals(p2)); // false
        System.out.println(p2.equals(p3)); // true
    }
}
