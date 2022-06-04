package chapter_eleven;

import java.util.Locale;
import java.util.Scanner;
import java.lang.System;

/**
 * *11.15 (Area of a convex polygon) A polygon is convex if it contains any line segments
 * that connects two points of the polygon. Write a program that prompts the user
 * to enter the number of points in a convex polygon, enter the points clockwise,
 * then displays the area of the polygon. For the formula for computing the area of
 * a polygon, see http://www.mathwords.com/a/area_convex_polygon.htm. Here is
 * a sample run of the program:
 *
 *          Enter the number of points: 7
 *          Enter the coordinates of the points:
 *          -12 0 -8.5 10 0 11.4 5.5 7.8 6 -5.5 0 -7 -3.5 -13.5
 *          The total area is 292.575
 *
 * @author Sharaf Qeshta
 * */
public class Problem$15
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in).useLocale(Locale.US);

        System.out.print("Enter the number of points: ");
        int size = scanner.nextInt();


        double[][] points = new double[size][2];
        System.out.println("Enter the coordinates of the points: ");

        for (int i = 0; i < size;i++)
            for (int j = 0; j < points[i].length;j++)
                points[i][j] = scanner.nextDouble();

        System.out.println("The total area is " + getArea(points));
    }

    public static double getArea(double[][] points)
    {
        double[] startPoint = points[0];

        double firstSegment = 0;
        double secondSegment = 0;
        boolean takeStartPoint = true;

        // start from the end (anti clockwise)
        for (int i = points.length-1; i > 0 ;i--)
        {
            if (takeStartPoint)
            {
                firstSegment += startPoint[0] * points[i][1];
                secondSegment += startPoint[1] * points[i][0];
                takeStartPoint = false;
            }
            firstSegment += points[i][0] * points[i-1][1];
            secondSegment += points[i][1] * points[i-1][0];
        }

        return 0.5 * (firstSegment - secondSegment);
    }
}
