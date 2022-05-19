package chapter_seven;

import java.util.Arrays;
import java.util.Locale;
import java.util.Scanner;

/**
 * 7.25 (Algebra: solve quadratic equations) Write a method for solving a quadratic
 * equation using the following header:
 * public static int solveQuadratic(double[] eqn, double[] roots)
 *  The coefficients of a quadratic equation ax2 + bx + c = 0 are passed to the array
 * eqn and the real roots are stored in roots. The method returns the number of real
 * roots. See Programming Exercise 3.1 on how to solve a quadratic equation.
 * Write a program that prompts the user to enter values for a, b, and c and displays
 * the number of real roots and all real roots.
 *
 * @author Sharaf Qeshta
 * */


public class Problem$25
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in).useLocale(Locale.US);

        System.out.print("Enter a, b, c: ");
        double[] eqn = new double[3], roots = new double[2];

        for (int i = 0; i < 3; i++)
            eqn[i] = scanner.nextDouble();

        System.out.println("there are " + solveQuadratic(eqn, roots) + " real roots");
        System.out.println(Arrays.toString(roots));
    }


    public static int solveQuadratic(double[] eqn,
                                     double[] roots)
    {
        double discriminant = (eqn[1] * eqn[1]) - (4 * eqn[0] * eqn[2]);

        if (discriminant > 0)
        {
            roots[0] = (-eqn[1] + Math.sqrt(discriminant)) / (2 * eqn[0]);
            roots[1] = (-eqn[1] - Math.sqrt(discriminant)) / (2 * eqn[0]);
            return 2;
        }

        else if (discriminant < 0 )
            return -1;
        else
        {
            roots[0] = (-eqn[1]) / (2 * eqn[0]);
            return 1;
        }
    }


}
