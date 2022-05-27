package chapter_eight;

import java.util.Arrays;
import java.util.Locale;
import java.util.Scanner;

/**
 * *8.31 (Geometry: intersecting point) Write a method that returns the intersecting point of
 * two lines. The intersecting point of the two lines can be found by using the formula
 * given in Programming Exercise 3.25. Assume that (x1, y1) and (x2, y2) are the
 * two points on line 1 and (x3, y3) and (x4, y4) are on line 2. The method header is:
 * public static double[] getIntersectingPoint(double[][] points)
 *  The points are stored in a 4-by-2 two-dimensional array points with (points
 * [0][0], points[0][1]) for (x1, y1). The method returns the intersecting point
 * or null if the two lines are parallel. Write a program that prompts the user to enter
 * four points and displays the intersecting point. See Programming Exercise 3.25
 * for a sample run.
 *
 * @author Sharaf Qeshta
 * */

public class Problem$31
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in).useLocale(Locale.US);

        double[][] points = new double[4][2];
        System.out.print("enter 4 points: ");

        for (int i = 0; i < points.length;i++)
            for (int j = 0; j < points[i].length;j++)
                points[i][j] = scanner.nextDouble();
        System.out.println(Arrays.toString(getIntersectingPoint(points)));
    }


    public static double[] getIntersectingPoint(double[][] points)
    {
        double x1 = points[0][0];double y1 = points[0][1];
        double x2 = points[0][2];double y2 = points[0][3];
        double x3 = points[1][0];double y3 = points[1][1];
        double x4 = points[1][2];double y4 = points[1][3];

        double[] out = new double[2];

        double ML1 = (y2 - y1) / (x2 -x1);
        double ML2 = (y4 - y3) / (x4 - x3);

        if (ML1 == ML2)
            return null;

        else
        {
            // first line equation coefficients
            double a1 = y1 - y2;
            double b1 = -x1 + x2;
            double c1 = -((y1 - y2) * x1) - (x1 - x2) * y1;
            // second line equation coefficients
            double a2 = y3 - y4;
            double b2 = -x3 + x4;
            double c2 = ((y3 - y4) * x3) - (x3 - x4) * y3;


            double x0 = (b1 * c2) - (b2 * c1) / (a1 * b2) - (a2 * b1);
            double y0 = (c1 * a2) - (c2 * a1) / (a1 * b2) - (a2 * b1);
            out[0] = x0; out[1] = y0;
            return out;
        }
    }
}
