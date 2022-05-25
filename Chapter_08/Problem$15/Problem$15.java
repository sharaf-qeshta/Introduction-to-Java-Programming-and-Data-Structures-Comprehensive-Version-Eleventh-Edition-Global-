package chapter_eight;

import java.util.Locale;
import java.util.Scanner;

/**
 * *8.15 (Geometry: same line?) Programming Exercise 6.39 gives a method for testing
 * whether three points are on the same line.
 * Write the following method to test whether all the points in the array points are
 * on the same line:
 * public static boolean sameLine(double[][] points)
 *  Write a program that prompts the user to enter five points and displays whether
 * they are on the same line. Here are sample runs:
 *
 *          Enter five points: 3.4 2 6.5 9.5 2.3 2.3 5.5 5 -5 4
 *          The five points are not on the same line
 *
 *          Enter five points: 1 1 2 2 3 3 4 4 5 5
 *          The five points are on the same line
 *
 * @author Sharaf Qeshta
 * */

public class Problem$15
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in).useLocale(Locale.US);

        System.out.print("Enter five points: ");
        double x0 = scanner.nextDouble();
        double y0 = scanner.nextDouble();
        for (int i = 0; i < 2; i++)
        {
            double x1 = scanner.nextDouble();
            double y1 = scanner.nextDouble();
            double x2 = scanner.nextDouble();
            double y2 = scanner.nextDouble();
            double comparison = (x1 - x0)*(y2 - y0) - (x2 - x0)*(y1 - y0);
            if (comparison != 0)
            {
                System.out.println("The five points are not on the same line");
                System.exit(0);
            }
        }
        System.out.println("The five points are on the same line");
    }

}
