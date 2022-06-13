package chapter_thirteen;

import java.util.Locale;
import java.util.Scanner;


/**
 * 13.20 (Algebra: solve quadratic equations) Rewrite Programming Exercise 3.1 to obtain
 * imaginary roots if the determinant is less than 0 using the Complex class in
 * Programming Exercise 13.17. Here are some sample runs:
 *
 *          Enter a, b, c: 1 3 1
 *          The roots are –0.381966 and –2.61803
 *
 *          Enter a, b, c: 1 2 1
 *          The root is –1
 *
 *          Enter a, b, c: 1 2 3
 *          The roots are –1.0 + 1.4142i and –1.0 + –1.4142i
 *
 * @author Sharaf Qeshta
 * */
public class Problem$20
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

            System.out.println("The equation has two real roots "
                    + firstRoot + " and "
                    + secondRoot);
        }
        else if (discriminant < 0)
        {
            Complex firstRoot = new Complex (-b / (2 * a) ,
                    Math.sqrt(discriminant*-1) / (2 * a));
            Complex secondRoot = new Complex(-b  / (2 * a),
                    - Math.sqrt(discriminant*-1) / (2 * a));

            System.out.println("The equation has two complex roots "
                    + firstRoot + " and "
                    + secondRoot);
        }
        else
        {
            double root = -b / (2 * a);
            System.out.println("The equation has one root " + root);
        }
    }
}


