package chapter_thirteen;

/**
 * *13.10 (Enable Rectangle comparable) Rewrite the Rectangle class in Listing 13.3 to
 * extend GeometricObject and implement the Comparable interface. Override
 * the equals method in the Object class. Two Rectangle objects are equal if
 * their areas are the same. Draw the UML diagram that involves Rectangle,
 * GeometricObject, and Comparable.
 *
 * @author Sharaf Qeshta
 * */
public class Problem$10
{
    public static void main(String[] args)
    {
        Rectangle rectangle1 = new Rectangle(25, 27);
        Rectangle rectangle2 = new Rectangle(25, 26);

        // 25
        System.out.println(rectangle1.compareTo(rectangle2));
    }
}