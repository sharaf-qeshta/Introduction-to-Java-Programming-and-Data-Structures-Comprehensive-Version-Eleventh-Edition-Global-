package chapter_thirteen;

/**
 * *13.7 (The Colorable interface) Design an interface named Colorable with a void
 * method named howToColor(). Every class of a colorable object must implement
 * the Colorable interface. Design a class named Square that extends
 * GeometricObject and implements Colorable. Implement howToColor to
 * display the message Color all four sides. The Square class contains a
 * data field side with getter and setter methods, and a constructor for constructing
 * a Square with a specified side. The Square class has a private double data
 * field named side with its getter and setter methods. It has a no-arg constructor
 * to create a Square with side 0, and another constructor that creates a Square
 * with the specified side.
 * Draw a UML diagram that involves Colorable, Square, and GeometricObject.
 * Write a test program that creates an array of five GeometricObjects. For each
 * object in the array, display its area and invoke its howToColor method if it is
 * colorable.
 *
 * @author Sharaf Qeshta
 * */
public class Problem$07
{
    public static void main(String[] args)
    {
        GeometricObject[] geometricObjects =
        {
                new Triangle(),
                new Triangle(5, 5, 5),
                new Triangle(5, 7, 5),
                new Square(7),
                new Square("red", true, 12),
                new Square("green", false, 4),
        };

        /*
        * 0.4330127018922193
        * 10.825317547305483
        * 12.497499749949988
        * 49.0
        * Color all four sides
        * 144.0
        * Color all four sides
        * 16.0
        * Color all four sides
        * */
        for (GeometricObject object: geometricObjects)
        {
            System.out.println(object.getArea());
            if (object instanceof Colorable)
                ((Colorable) object).howToColor();
        }
    }
}
