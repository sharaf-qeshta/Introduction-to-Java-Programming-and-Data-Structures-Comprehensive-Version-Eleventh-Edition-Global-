package chapter_eight;

import java.util.Locale;
import java.util.Scanner;

/**
 * *8.32 (Geometry: area of a triangle) Write a method that returns the area of a triangle
 * using the following header:
 * public static double getTriangleArea(double[][] points)
 *  The points are stored in a 3-by-2 two-dimensional array points with points
 * [0][0] and points[0][1] for (x1, y1). The triangle area can be computed
 * using the formula in Programming Exercise 2.19. The method returns 0 if the
 * three points are on the same line. Write a program that prompts the user to enter
 * three points of a triangle and displays the triangle’s area. Here are the sample runs:
 *
 *              Enter x1, y1, x2, y2, x3, y3: 2.5 2 5 −1.0 4.0 2.0
 *              The area of the triangle is 2.25
 *
 *              Enter x1, y1, x2, y2, x3, y3: 2 2 4.5 4.5 6 6
 *              The three points are on the same line
 *
 * @author Sharaf Qeshta
 * */

public class Problem$32
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in).useLocale(Locale.US);

        double[][] points = new double[3][2];
        System.out.print("Enter x1, y1, x2, y2, x3, y3: ");

        for (int i = 0; i < points.length;i++)
            for (int j = 0; j < points[i].length;j++)
                points[i][j] = scanner.nextDouble();
        System.out.println("The area of the triangle is " + getTriangleArea(points));
    }


    public static double getTriangleArea(double[][] points)
    {

        // side 1
        double sideOne = Math.sqrt(Math.pow(points[1][0] - points[0][0], 2)
                + Math.pow(points[1][1] - points[0][1], 2));

        // side 2
        double sideTwo = Math.sqrt(Math.pow(points[2][0] - points[1][0], 2)
                + Math.pow(points[2][1] - points[1][1], 2));

        // side 3
        double sideThree = Math.sqrt(Math.pow(points[0][0] - points[2][0], 2)
                + Math.pow(points[0][1] - points[2][1], 2));

        double s = (sideOne + sideTwo + sideThree) / 2;

        return Math.sqrt(s * (s - sideOne)
                * (s - sideTwo) * (s - sideThree));
    }
}
