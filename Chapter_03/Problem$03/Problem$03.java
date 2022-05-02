package chapter_three;

import java.util.Locale;
import java.util.Scanner;


/**
 * *3.3 (Algebra: solve 2 * 2 linear equations) A linear equation can be solved using
 * Cramer’s rule given in Programming Exercise 1.13. Write a program that prompts
 * the user to enter a, b, c, d, e, and f and displays the result. If ad - bc is 0, report
 * that “The equation has no solution.”
 *
 *      Enter a, b, c, d, e, f: 9.0 4.0 3.0 -5.0 -6.0 -21.0
 *      x is -2.0 and y is 3.0
 *
 *      Enter a, b, c, d, e, f: 1.0 2.0 2.0 4.0 4.0 5.0
 *      The equation has no solution
 *
 * @author Sharaf Qeshta
 *
 **/

public class Problem$03
{
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in).useLocale(Locale.US);

        // i think the book`s sample run have something wrong
        // 9.0 4.0 3.0 -5.0 -6.0 -21.0
        // 9x + 4y = 3 suppose that the value of x is -2 and y = 3 so the equation become
        // false -18 + 12 = -6 not 3;

        System.out.print("Enter a, b, c, d, e, f: ");
        double a = scan.nextDouble(), b = scan.nextDouble(),
                c = scan.nextDouble(), d = scan.nextDouble(),
                e = scan.nextDouble(), f = scan.nextDouble();


        double checker = (a * d) - (b * c);
        if (checker == 0)
            System.out.println("The equation has no solution");
        else
        {
            double determinantOfX = (c * e) - (b * f),
                    determinantOfY = (a * f) - (d * c),
                    determinant = (a * e) - (b * d);

            // cramer`s rule say that x = Dx / D ; y = Dy / D

            double X = determinantOfX / determinant,
                    Y = determinantOfY / determinant;

            System.out.println("x is " + X + " and y is " + Y);
        }
    }
}
