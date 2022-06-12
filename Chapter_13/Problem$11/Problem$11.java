package chapter_thirteen;

/**
 * *13.11 (The Octagon class) Write a class named Octagon that extends
 * GeometricObject  and implements the Comparable and Cloneable interfaces.
 * Assume all eight sides of the octagon are of equal length. The area can be
 * computed using the following formula:
 *
 *      area = (2 + 4√2) * side * side
 *
 * The Octagon class has a private double data field named side with its getter and
 * setter methods. The class has a no-arg constructor that creates an Octagon with
 * side 0, and a constructor to create an Octagon with a specified side.
 * Draw the UML diagram that involves Octagon, GeometricObject, Comparable,
 * and Cloneable. Write a test program that creates an Octagon object with side
 * value 5 and displays its area and perimeter. Create a new object using the clone
 * method, and compare the two objects using the compareTo method.
 *
 * @author Sharaf Qeshta
 * */
public class Problem$11
{
    public static void main(String[] args)
    {
        Octagon octagon = new Octagon(5);

        /* Area: 191.4213562373095 */
        System.out.println("Area: " + octagon.getArea());

        /* Perimeter: 40.0 */
        System.out.println("Perimeter: " + octagon.getPerimeter());

        Octagon cloned = (Octagon) octagon.clone();

        /* 0 */
        System.out.println(cloned.compareTo(octagon));
    }
}