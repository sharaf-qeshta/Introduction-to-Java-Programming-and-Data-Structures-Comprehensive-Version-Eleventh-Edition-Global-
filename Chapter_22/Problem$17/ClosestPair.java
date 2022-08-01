package chapter_twenty_two;

import javafx.geometry.Point2D;

public class ClosestPair
{
    /** Compute the distance between two points p1 and p2 */
    public static double distance(Point2D p1, Point2D p2)
    {
        return Math.sqrt(Math.pow(p2.getX()-p1.getX(), 2)
                + Math.pow(p2.getY()-p1.getY(), 2));
    }



    /** Return the distance of the closest pair of points
     * in pointsOrderedOnX[low..high]. This is a recursive
     * method. pointsOrderedOnX and pointsOrderedOnY are
     * not changed in the subsequent recursive calls.
     */
    public static Pair distance(Point2D[] pointsOrderedOnX,
                                int low, int high, Point2D[] pointsOrderedOnY,
                                Pair pair, int start)
    {
        if (low == high+1)
            return pair;

        double smallestDistance = pair.getDistance();
        for (int i = start; i < high+1; i++)
        {
            // excluding the same point
            if (pointsOrderedOnX[low].equals(pointsOrderedOnY[i]))
                continue;
            double distance = distance(pointsOrderedOnX[low], pointsOrderedOnY[i]);
            if (distance < smallestDistance)
            {
                smallestDistance = distance;
                pair.p1 = pointsOrderedOnX[low];
                pair.p2 = pointsOrderedOnY[i];
            }
        }
        return distance(pointsOrderedOnX, low+1, high, pointsOrderedOnY, pair, start);
    }

    /** Return the distance of the closest pair of points */
    public static Pair getClosestPair(Point2D[] points)
    {
        /*
         * Step 1: Sort the points in increasing order of x-coordinates. For the
         * points with the same x-coordinates, sort on y-coordinates. This results
         * in a sorted list S of points.
         * */
        boolean sorted = false;
        Point2D[] s = points.clone();
        while (!sorted)
        {
            sorted = true;
            for (int i = 0; i < s.length-1; i++)
            {
                if (s[i].getX() > s[i+1].getX())
                {
                    Point2D temp = s[i];
                    s[i] = s[i+1];
                    s[i+1] = temp;
                    sorted = false;
                }
                else if (s[i].getX() == s[i+1].getX())
                {
                    if (s[i].getY() > s[i+1].getY())
                    {
                        Point2D temp = s[i];
                        s[i] = s[i+1];
                        s[i+1] = temp;
                        sorted = false;
                    }
                }
            }
        }

        /*
         * Step 2: Divide S into two subsets, S1 and S2, of equal size using the
         * midpoint in the sorted list. Let the midpoint be in S1. Recursively find
         * the closest pair in S1 and S2. Let d1 and d2 denote the distance of the
         * closest pairs in the two subsets, respectively.
         * */
        Pair d1 = distance(s,0, s.length/2, s,new Pair(), 0);
        Pair d2 = distance(s,s.length/2 +1, s.length-1, s, new Pair(), s.length/2 +1);


        /*
         * Step 3: Find the closest pair between a point in S1 and a point in S2
         * and denote their distance as d3. The closest pair is the one with the
         * distance min(d1, d2, d3).
         * */
        Pair d3 = distance(s,0,s.length-1, s, new Pair(), 0);

        Pair min = d1;
        if (min.getDistance() > d2.getDistance())
            min = d2;
        if (min.getDistance() > d3.getDistance())
            min = d3;
        return min;
    }


    /** Return the distance of the closest pair of points */
    public static Pair getClosestPair(double[][] points)
    {
        Point2D[] points_ = new Point2D[points.length];
        for (int i = 0; i < points.length; i++)
            points_[i] = new Point2D(points[i][0], points[i][1]);
        return getClosestPair(points_);
    }
}
