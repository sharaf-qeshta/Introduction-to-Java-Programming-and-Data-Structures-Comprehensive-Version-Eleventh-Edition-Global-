package chapter_twentyone.samples;

import chapter_twenty.Circle;
import chapter_twenty.GeometricObject;
import chapter_twenty.GeometricObjectComparator;
import chapter_twenty.Rectangle;

import java.util.Set;
import java.util.TreeSet;

/**Listing 21.5 TestTreeSetWithComparator.java */
public class TestTreeSetWithComparator
{
    public static void main(String[] args)
    {
        Set<GeometricObject> set = new TreeSet<>(new GeometricObjectComparator());

        set.add(new Rectangle(4, 5));
        set.add(new Circle(40));
        set.add(new Circle(40));
        set.add(new Rectangle(4, 1));

        System.out.println("A sorted set of geometric objects");
        for (GeometricObject element: set){
            System.out.println("area = " + element.getArea());
        }

    }
}
