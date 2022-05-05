package chapter_three;

import java.util.Locale;
import java.util.Scanner;

/**
 * **3.27 (Geometry: points in triangle?) Suppose a right triangle is placed in a plane as
 * shown below. The right-angle point is placed at (0, 0), and the other two points
 * are placed at (200, 0) and (0, 100). Write a program that prompts the user to enter
 * a point with x- and y-coordinates and determines whether the point is inside the
 * triangle. Here are the sample runs:
 *
 *          Enter a point’s x- and y-coordinates: 100.5 25.5
 *          The point is in the triangle
 *
 *          Enter a point’s x- and y-coordinates: 100.5 50.5
 *          The point is not in the triangle
 *
 * @author Sharaf Qeshta
 * */

public class Problem$27
{
    private static final int AX = 200; // EDGE 1 X-coordinate
    private static final int AY = 0; // EDGE 1 Y-coordinate
    private static final int BX = 0; // EDGE 2 X-coordinate
    private static final int BY = 100; // EDGE 2 Y-coordinate
    private static final int CY = 0; // EDGE 3 X-coordinate
    private static final int CX = 0; // EDGE 3 Y-coordinate
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in).useLocale(Locale.US);

        System.out.print("Enter a point’s x- and y-coordinates: ");
        double x = scanner.nextDouble();
        double y = scanner.nextDouble();

        double determinant = (BX - AX) * (CY - AY) - (BY - AY) * (CX - AX);


        if
        (
           determinant * ((BX - AX) * (y - AY) - (BY - AY) * (x - AX)) >= 0 &&
           determinant * ((CX - BX) * (y - BY) - (CY - BY) * (x - BX)) >= 0 &&
           determinant * ((AX - CX) * (y - CY) - (AY - CY) * (x - CX)) >= 0
        )
            System.out.println("The point is in the triangle!");
        else
            System.out.println("The point is not in the triangle!");
    }
}

