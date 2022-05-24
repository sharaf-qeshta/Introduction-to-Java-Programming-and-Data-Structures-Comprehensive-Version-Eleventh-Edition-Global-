package chapter_eight;

import java.util.Locale;
import java.util.Scanner;

/**
 * **8.8 (All closest pairs of points) Revise Listing 8.3, FindNearestPoints.java, to display
 * all closest pairs of points with the same minimum distance. Here is a sample run:
 *
 *          Enter the number of points: 8
 *          Enter 8 points: 0 0 1 1 -1 -1 2 2 -2 -2 -3 -3 -4 -4 5 5
 *          The closest two points are (0.0, 0.0) and (1.0, 1.0)
 *          The closest two points are (0.0, 0.0) and (−1.0, −1.0)
 *          The closest two points are (1.0, 1.0) and (2.0, 2.0)
 *          The closest two points are (−1.0, −1.0) and (−2.0, −2.0)
 *          The closest two points are (−2.0, −2.0) and (−3.0, −3.0)
 *          The closest two points are (−3.0, −3.0) and (−4.0, −4.0)
 *          Their distance is 1.4142135623730951
 * @author Sharaf Qeshta
 * */

public class Problem$08
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in).useLocale(Locale.US);
        System.out.print("Enter the number of points: ");
        int size = scanner.nextInt();

        double[][] points = new double[size][2];

        System.out.print("Enter " + size + " points: ");

        for (int i = 0;i < points.length;i++)
        {
            points[i][0] = scanner.nextDouble();
            points[i][1] = scanner.nextDouble();
        }

        printSame(findNearest(points), points);
    }

    public static double findNearest(double[][] points)
    {
        double nearest = getDistance(points[0][0], points[0][1]
                , points[1][0], points[1][1]);

        for (int i = 0; i < points.length;i++)
        {
            for (int j = i + 1; j < points.length;j++)
            {
                double distance = getDistance(points[i][0], points[i][1], points[j][0], points[j][1]);
                if (distance < nearest)
                    nearest= distance;
            }
        }
        return nearest;
    }


    public static void printSame(double distance, double[][] points)
    {
        for (int i = 0; i < points.length; i++)
        {
            for (int j = i + 1; j < points.length; j++)
            {
                double distance_ = getDistance( points[i][0], points[i][1], points[j][0], points[j][1]);
                if (distance == distance_)
                    System.out.println("The closest two points are ("
                            +  points[i][0] + ", " + points[i][1] + ") and (" + points[j][0] + ", " + points[j][1] + ")" );
            }
        }
        System.out.println("Their distance is " + distance);
    }


    public static double getDistance(double... data)
    {
        return Math.sqrt(Math.pow(data[2] - data[0], 2) + Math.pow(data[3] - data[1], 2));
    }
}
