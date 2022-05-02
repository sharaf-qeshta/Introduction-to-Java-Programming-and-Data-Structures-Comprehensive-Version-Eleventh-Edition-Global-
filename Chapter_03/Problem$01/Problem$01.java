package chapter_three;

import java.util.Locale;
import java.util.Scanner;


/**
 * *3.1 (Algebra: solve quadratic equations) The two roots of a quadratic equation
 * ax² + bx + c = 0 can be obtained using the following formula:
 * r1 = [-b + √(b² - 4ac)]/2a and [-b + √(b² - 4ac)]/2a
 *  b2 - 4ac is called the discriminant of the quadratic equation. If it is positive, the
 * equation has two real roots. If it is zero, the equation has one root. If it is negative,
 * the equation has no real roots.
 * Write a program that prompts the user to enter values for a, b, and c and displays
 * the result based on the discriminant. If the discriminant is positive, display two
 * roots. If the discriminant is 0, display one root. Otherwise, display “The equation
 * has no real roots.”
 * Note you can use Math.pow(x, 0.5) to compute 2x. Here are some sample
 * runs:
 *          Enter a, b, c: 1.0 3 1
 *          The equation has two roots -0.381966 and -2.61803
 *
 *          Enter a, b, c: 1 2.0 1
 *          The equation has one root -1.0
 *
 *          Enter a, b, c: 1 2 3
 *          The equation has no real roots
 *
 * @author Sharaf Qeshta
 * */

public class Problem$01
{
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in).useLocale(Locale.US);

        System.out.print("Enter a, b, c: ");
        double a = scan.nextDouble(),
                b = scan.nextDouble(),
                c = scan.nextDouble();

        double discriminant = Math.pow(b, 2) - (4 * a * c);

        if (discriminant > 0)
        {
            double firstRoot = (-b + Math.sqrt(discriminant)) / (2 * a);
            double secondRoot = (-b - Math.sqrt(discriminant)) / (2 * a);
            System.out.println("The equation has two roots "
                    + firstRoot + " and "
                    + secondRoot);
        }

        else if (discriminant < 0)
            System.out.println("The equation has no real roots");

        else
        {
            double root = -b / (2 * a);
            System.out.println("The equation has one root " + root);
         }
    }
}
