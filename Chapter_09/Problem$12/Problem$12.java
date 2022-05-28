package chapter_nine;

import java.util.Locale;
import java.util.Scanner;

/**
 * **9.12 (Geometry: intersecting point) Suppose two line segments intersect.
 * The two endpoints for the first line segment are (x1, y1) and (x2, y2) and for the second line
 * segment are (x3, y3) and (x4, y4). Write a program that prompts the user to enter
 * these four endpoints and displays the intersecting point. As discussed in Programming
 * Exercise 3.25, the intersecting point can be found by solving a linear equation.
 * Use the LinearEquation class in Programming Exercise 9.11 to solve this
 * equation. See Programming Exercise 3.25 for sample runs.
 *
 * @author Sharaf Qeshta
 * */

public class Problem$12
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in).useLocale(Locale.US);
        System.out.print("enter x1, y1, x2, y2, x3, y3, x4, y4: ");
        double[] values = new double[8];
        for (int i = 0; i < 8; i++)
            values[i] = scanner.nextDouble();

        // first line equation coefficients
        double a1 = values[1] - values[3];
        double b1 = -values[0] + values[2];
        double c1 = -((values[1] - values[3]) * values[0]) - (values[0] - values[2]) * values[1];

        // second line equation coefficients
        double a2 = values[5] - values[7];
        double b2 = -values[4] + values[6];
        double c2 = ((values[5] - values[7]) * values[4]) - (values[4] - values[6]) * values[5];

        LinearEquation le = new LinearEquation(a1, b1, c1, a2, b2, c2);

        if (!le.isSolvable())
            System.out.println("The equation has no solution.");
        else
            System.out.println("x: " + le.getX() + ", y:" + le.getY());
    }
}
