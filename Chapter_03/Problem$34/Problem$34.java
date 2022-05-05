package chapter_three;

import java.util.Locale;
import java.util.Scanner;

/**
 * *3.34 (Geometry: point on line segment) Exercise 3.32 shows how to test whether a point
 * is on an unbounded line. Revise Exercise 3.32 to test whether a point is on a line
 * segment. Write a program that prompts the user to enter the three points for p0,
 * p1, and p2 and displays whether p2 is on the line segment from p0 to p1. Here are
 * some sample runs:
 *
 *             Enter three points for p0, p1, and p2: 1 1 2.5 2.5 1.5 1.5
 *             (1.5, 1.5) is on the line segment from (1.0, 1.0) to (2.5, 2.5)
 *
 *              Enter three points for p0, p1, and p2: 1 1 2 2 3.5 3.5
 *              (3.5, 3.5) is not on the line segment from (1.0, 1.0) to (2.0, 2.0)
 *
 * @author Sharaf Qeshta
 * */

public class Problem$34
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in).useLocale(Locale.US);

        System.out.print("Enter three points for p0, p1, and p2 : ");
        double x0 = scanner.nextDouble();double y0 = scanner.nextDouble();
        double x1 = scanner.nextDouble();double y1 = scanner.nextDouble();
        double x2 = scanner.nextDouble();double y2 = scanner.nextDouble();


        double comparison = (x1 - x0)*(y2 - y0) - (x2 - x0)*(y1 - y0);

        String output1 = "(" + x2 + ", " + y2 + ") is ";
        String output2 = "on the line segment from (" + x0 + ", " + y0 + ") to "
                + "(" + x1 + ", " + y1 + ").";
        if (comparison == 0)
            System.out.println(output1 + output2);
        else
            System.out.println(output1 + "not " + output2);
    }
}

