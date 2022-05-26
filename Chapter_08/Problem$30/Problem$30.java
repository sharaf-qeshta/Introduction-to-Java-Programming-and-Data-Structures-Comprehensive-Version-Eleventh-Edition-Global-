package chapter_eight;

import java.util.Arrays;
import java.util.Locale;
import java.util.Scanner;

/**
 * *8.30 (Algebra: solve linear equations) Write a method that solves the following 2 * 2
 * system of linear equations: exist as photo
 * The method header is:
 * public static double[] linearEquation(double[][] a, double[] b)
 *  The method returns null if a00a11 - a01a10 is 0. Write a test program that
 * prompts the user to enter a00, a01, a10, a11, b0, and b1 and displays the result. If
 * a00a11 - a01a10 is 0, report that “The equation has no solution.” A sample run is
 * similar to Programming Exercise 3.3.
 *
 * @author Sharaf Qeshta
 * */

public class Problem$30
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in).useLocale(Locale.US);

        double[][] a = new double[2][2];
        double[] b = new double[2];
        System.out.print("enter a00, a01, a10, a11, b0, and b1: ");

        for (int i = 0; i < a.length;i++)
            for (int j = 0; j < a[i].length;j++)
                a[i][j] = scanner.nextDouble();

        for (int i = 0; i < a.length;i++)
            b[i] = scanner.nextDouble();

        System.out.println(Arrays.toString(linearEquation(a, b)));
    }


    public static double[] linearEquation(double[][] a, double[] b)
    {
        double[] xy = {0, 0};
        double denominator = a[0][0] * a[1][1] - a[0][1] * a[1][0];
        double x_numerator  = b[0] * a[1][1] - b[1] * a[0][1];
        double x = 0;

        double y_numerator  = b[1] * a[0][0] - b[0] * a[1][0];
        double y = 0;

        if (denominator != 0)
        {
            x = x_numerator / denominator;
            y = y_numerator / denominator;
        }
        else
            System.out.println("The equation has no solution");

        xy[0] = x; xy[1] = y;

        return xy;
    }
}
