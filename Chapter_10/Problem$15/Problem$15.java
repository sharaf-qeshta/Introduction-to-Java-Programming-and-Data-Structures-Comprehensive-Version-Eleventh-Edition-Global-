package chapter_ten;

import java.util.Locale;
import java.util.Scanner;

/**
 * *10.15 (Geometry: the bounding rectangle) A bounding rectangle is the minimum
 * rectangle that encloses a set of points in a two-dimensional plane, as shown in
 * Figure 10.24d. Write a method that returns a bounding rectangle for a set of
 * points in a two-dimensional plane, as follows:
 * public static MyRectangle2D getRectangle(double[][] points)
 * The Rectangle2D class is defined in Programming Exercise 10.13. Write a test
 * program that prompts the user to enter five points and displays the bounding
 * rectangle’s center, width, and height. Here is a sample run:
 *
 *          Enter five points: 1.0 2.5 3 4 5 6 7 8 9 10
 *          The bounding rectangle's center (5.0, 6.25), width 8.0, height 7.5
 *
 * @author Sharaf Qeshta
 * */

public class Problem$15
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in).useLocale(Locale.US);

        System.out.print("Enter five points: ");

        double[][] points = new double[5][2];
        for (int i = 0; i < points.length;i++)
            for (int j = 0; j < points[i].length;j++)
                points[i][j] = scanner.nextDouble();

        MyRectangle2D r = MyRectangle2D.getRectangle(points);
        System.out.println("The bounding rectangle's center (" + r.getX() + ", " + r.getY() + "),  " +
                "width " +  r.getWidth() + ", height " + r.getHeight());
    }
}

