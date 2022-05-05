package chapter_three;

import java.util.Locale;
import java.util.Scanner;

/**
 * *3.25 (Geometry: intersecting point) Two points on line 1 are given as (x1, y1) and (x2,
 * y2) and on line 2 as (x3, y3) and (x4, y4), as shown in Figure 3.8a and b.
 * The intersecting point of the two lines can be found by solving the following linear
 * equations:
 *  (y1 - y2)x - (x1 - x2)y = (y1 - y2)x1 - (x1 - x2)y1
 *  (y3 - y4)x - (x3 - x4)y = (y3 - y4)x3 - (x3 - x4)y3
 *  This linear equation can be solved using Cramer’s rule
 *  (see Programming Exercise 3.3). If the equation has no solutions,
 *  the two lines are parallel (see Figure 3.8c)
 *  Write a program that prompts the user to enter four points and displays the
 *  intersecting point. Here are sample runs
 *
 *          Enter x1, y1, x2, y2, x3, y3, x4, y4: 2 2 5 -1.0 4.0 2.0 -1.0 -2.0
 *          The intersecting point is at (2.88889, 1.1111)
 *
 *          Enter x1, y1, x2, y2, x3, y3, x4, y4: 2 2 7 6.0 4.0 2.0 -1.0 -2.0
 *          The two lines are parallel
 *
 * @author Sharaf Qeshta
 *  */

public class Problem$25
{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in).useLocale(Locale.US);
        System.out.print("Enter x1, y1, x2, y2, x3, y3, x4, y4: ");
        // the first line
        double x1 = scanner.nextDouble();
        double y1 = scanner.nextDouble();
        double x2 = scanner.nextDouble();
        double y2 = scanner.nextDouble();

        // the second line
        double x3 = scanner.nextDouble();
        double y3 = scanner.nextDouble();
        double x4 = scanner.nextDouble();
        double y4 = scanner.nextDouble();


        double ML1 = (y2 - y1) / (x2 - x1);
        double ML2 = (y4 - y3) / (x4 - x3);

        if (ML1 == ML2)
            System.out.println("The two lines are parallel");

        else
        {
            // construct first line equation
            double a = y1 - y2;
            double b = -(x1 - x2);
            double c = (y1 - y2) * x1 - (x1 - x2) * y1;
            // second line equation coefficients
            double d = y3 - y4;
            double e = -(x3 - x4);
            double f = (y3 - y4) * x3 - (x3 - x4) * y3;

            double determinantOfX = (c * e) - (b * f),
                    determinantOfY = (a * f) - (d * c),
                    determinant = (a * e) - (b * d);

            System.out.println("The intersecting point is at (" + (determinantOfX/determinant) +
                    ", " + (determinantOfY/determinant) + ")");
        }
    }
}
