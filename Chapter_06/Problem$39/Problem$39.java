package chapter_six;

import java.util.Locale;
import java.util.Scanner;

/**
 * 6.39 (Geometry: point position)  Programming Exercise 3.32 shows how to test
 * whether a point is on the left side of a directed line, on the right, or on the same
 * line. Write the methods with the following headers:
 *
 *  public static boolean leftOfTheLine(double x0, double y0,
 *  double x1, double y1, double x2, double y2)
 *
 *  public static boolean onTheSameLine(double x0, double y0,
 *  double x1, double y1, double x2, double y2)
 *
 *  public static boolean onTheLineSegment(double x0, double y0,
 *  double x1, double y1, double x2, double y2)
 *
 *  Write a program that prompts the user to enter the three points for p0, p1, and p2
 * and displays whether p2 is on the left side of the line from p0 to p1, right side,
 * the same line, or on the line segment. Here are some sample runs:
 *
 *          Enter three points for p0, p1, and p2: 1 1 2 2 1.5 1.5
 *          (1.5, 1.5) is on the line segment from (1.0, 1.0) to (2.0, 2.0)
 *
 *          Enter three points for p0, p1, and p2: 1 1 2 2 3 3
 *          (3.0, 3.0) is on the same line from (1.0, 1.0) to (2.0, 2.0)
 *
 *          Enter three points for p0, p1, and p2: 1 1 2 2 1 1.5
 *          (1.0, 1.5) is on the left side of the line from (1.0, 1.0) to (2.0, 2.0)
 *
 *          Enter three points for p0, p1, and p2: 1 1 2 2 1 –1
 *          (1.0, −1.0) is on the right side of the line from (1.0, 1.0) to (2.0, 2.0)
 *
 * @author Sharaf Qeshta*/


public class Problem$39
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in).useLocale(Locale.US);

        System.out.print("Enter three points for p0, p1, and p2: ");
        double x0 = scanner.nextDouble();double y0 = scanner.nextDouble();
        double x1 = scanner.nextDouble();double y1 = scanner.nextDouble();
        double x2 = scanner.nextDouble();double y2 = scanner.nextDouble();

        if (onTheLineSegment(x0, y0, x1, y1, x2, y2))
            System.out.println("(" + x2 + ", " + y2 + ") " +
                    "is on the line segment from (" + x0 + ", " + y0 + ") " +
                    "to (" + x1 + ", " + y1 + ")");

        else if (onTheSameLine(x0, y0, x1, y1, x2, y2))
            System.out.println("(" + x2 + ", " + y2 + ") is on the same " +
                    "line from (" + x0 + ", " + y0 + ") to (" + x1 + ", " + y1 + ")");

        else
            System.out.println("(" + x2 + ", " + y2 + ") is on the left side of " +
                    "the line from (" + x0 + ", " + y0 + ") to (" + x1 + ", " + y1 + ")");
    }

    public static double getComparison(double x0, double y0,
                                       double x1, double y1,
                                       double x2, double y2)
    {
        return (x1 - x0)*(y2 - y0) - (x2 - x0)*(y1 - y0);
    }


    /** Return true if point (x2, y2) is on the left side of the
     * directed line from (x0, y0) to (x1, y1) */
    public static boolean leftOfTheLine(double x0, double y0,
                                        double x1, double y1,
                                        double x2, double y2)
    {
        return getComparison(x0, y0, x1, y1, x2, y2) > 0;
    }


    /** Return true if point (x2, y2) is on the same
     * line from (x0, y0) to (x1, y1) */
    public static boolean onTheSameLine(double x0, double y0,
                                        double x1, double y1,
                                        double x2, double y2)
    {
        return getComparison(x0, y0, x1, y1, x2, y2) == 0;
    }


    /** Return true if point (x2, y2) is on the
     * line segment from (x0, y0) to (x1, y1) */
    public static boolean onTheLineSegment(double x0, double y0,
                                           double x1, double y1,
                                           double x2, double y2)
    {
        return getComparison(x0, y0, x1, y1, x2, y2) < 0;
    }

}
