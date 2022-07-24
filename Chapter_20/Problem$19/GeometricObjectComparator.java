package chapter_twenty;

import java.util.Comparator;

public class GeometricObjectComparator
        implements Comparator<GeometricObject>, java.io.Serializable
{
    public int compare(GeometricObject o1, GeometricObject o2)
    {
        double area1 = o1.getArea();
        double area2 = o2.getArea();

        return Double.compare(area1, area2);
    }
}
