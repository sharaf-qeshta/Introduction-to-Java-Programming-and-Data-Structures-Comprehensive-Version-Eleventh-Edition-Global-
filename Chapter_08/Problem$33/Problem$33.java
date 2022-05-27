package chapter_eight;

import java.util.Locale;
import java.util.Scanner;

/**
 * *8.33 (Geometry: polygon subareas) A convex four-vertex polygon is divided into four
 * triangles, as shown in Figure 8.9.
 * Write a program that prompts the user to enter the coordinates of four vertices and
 * displays the areas of the four triangles in increasing order. Here is a sample run:
 *
 *              Enter x1, y1, x2, y2, x3, y3, x4, y4:
 *              -2.5 2 4 4 3 -2 -2 -3.5
 *              The areas are 6.17 7.96 8.08 10.42
 *
 * @author Sharaf Qeshta
 * */

public class Problem$33
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in).useLocale(Locale.US);

        double[][] points = new double[4][2];
        double[] midPoint = new double[2];
        System.out.println("Enter x1, y1, x2, y2, x3, y3, x4, y4: ");

        for (int i = 0; i < points.length;i++)
            for (int j = 0; j < points[i].length;j++)
                points[i][j] = scanner.nextDouble();

        midPoint[0] = (points[0][0] + points[2][0]) / 2;
        midPoint[1] = (points[0][1] + points[2][1]) / 2;

        double[] areas = getArea(points, midPoint);
        System.out.println("The areas are " + areas[0] + " " + areas[1]
                + " " + areas[2] + " " + areas[3]);
    }


    public static double[] getArea(double[][] points, double[] midPoint)
    {
        double[] polygonArea = new double[4];
        polygonArea[0] = getTriangleArea(points[0], midPoint, points[1]);
        polygonArea[1] = getTriangleArea(points[1],  midPoint,points[2]);
        polygonArea[2] = getTriangleArea(points[2], midPoint, points[3]);
        polygonArea[3] = getTriangleArea(points[3], midPoint, points[0]);
        return polygonArea;
    }


    public static double getTriangleArea(double[] p1, double[] p2,
                                         double[] p3)
    {
        // side 1
        double sideOne = Math.sqrt(Math.pow(p1[0] - p2[0], 2)
                + Math.pow(p1[1] - p2[1], 2));

        // side 2
        double sideTwo = Math.sqrt(Math.pow(p2[0] - p3[0], 2)
                + Math.pow(p2[1] - p3[1], 2));

        // side 3
        double sideThree = Math.sqrt(Math.pow(p3[0] - p1[0], 2)
                + Math.pow(p3[1] - p1[1], 2));

        double s = (sideOne + sideTwo + sideThree) / 2;

        return Math.sqrt(s * (s - sideOne)
                * (s - sideTwo) * (s - sideThree));
    }
}
