package chapter_eight;

import java.util.Scanner;

/**
 * *8.34 (Geometry: rightmost lowest point) In computational geometry, often you need
 * to find the rightmost lowest point in a set of points. Write the following method
 * that returns the rightmost lowest point in a set of points:
 * public static double[]
 *  getRightmostLowestPoint(double[][] points)
 *  Write a test program that prompts the user to enter the coordinates of six points
 * and displays the rightmost lowest point. Here is a sample run:
 *
 *      Enter 6 points: 1.5 2.5 -3 4.5 5.6 -7 6.5 -7 8 1 10 2.5
 *      The rightmost lowest point is (6.5, −7.0)
 *
 * @author Sharaf Qeshta
 * */

public class Problem$34
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        double[][] points = new double[6][2];
        System.out.print("Enter 6 points: ");

        for (int i = 0; i < points.length; i++)
            for (int j = 0; j < points[i].length; j++)
                points[i][j] = scanner.nextDouble();

        double[] point = getRightMostLowestPoint(points);
        double[] point2 = getLeftMostLowestPoint(points);

        System.out.println("The rightmost lowest point is (" + point[0] + ", " + point[1] + ")");
        System.out.println("The leftmost lowest point is (" + point2[0] + ", " + point2[1] + ")");
    }


    public static double[] getLeftMostLowestPoint(double[][] p)
    {
        double[] leftMost;
        leftMost = p[0];

        for (int i = 1; i < p.length; i++)
        {
            if (p[i][1] < leftMost[1])
                leftMost = p[i];
            else if (p[i][1] == leftMost[1] && p[i][0] < leftMost[0])
                leftMost = p[i];
        }
        return leftMost;
    }


    public static double[] getRightMostLowestPoint(double[][] p)
    {
        double[] rightMost;
        rightMost = p[0];

        for (int i = 1; i < p.length; i++)
        {
            if (p[i][1] < rightMost[1])
                rightMost = p[i];
            else if (p[i][1] == rightMost[1] && p[i][0] > rightMost[0])
                rightMost = p[i];
        }
        return rightMost;
    }
}
