package chapter_twenty.samples;

import java.util.Comparator;

/**
 * Listing 20.5 GeometricObjectComparator.java
 * */
public class GeometricObjectComparator
        implements Comparator<GeometricObject>, java.io.Serializable
{
    public int compare(GeometricObject o1, GeometricObject o2)
    {
        double area1 = o1.getArea();
        double area2 = o2.getArea();

        if (area1 < area2)
            return -1;
        else if (area1 == area2)
            return 0;
        else
            return 1;
    }
}
