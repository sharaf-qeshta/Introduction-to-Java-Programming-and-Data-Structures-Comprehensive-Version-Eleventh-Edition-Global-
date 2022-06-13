package chapter_thirteen;

import java.util.Locale;
import java.util.Scanner;


/**
 * 13.21 (Algebra: vertex form equations) The equation of a parabola can be expressed in
 * either standard form (y = ax² + bx + c) or vertex form (y = a(x - h)² + k).
 * Write a program that prompts the user to enter a, b, and c as integers in standard
 *
 *      form and displays h ( = -b/2a) and k ( = (4ac - b²) / 4a )
 *
 * and k as rational numbers. Here are some sample runs:
 *
 *          Enter a, b, c: 1 3 1
 *          h is –3/2 k is –5/4
 *
 *          Enter a, b, c: 2 3 4
 *          h is –3/4 k is 23/8
 *
 * @author Sharaf Qeshta
 * */
public class Problem$21
{
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in).useLocale(Locale.US);

        System.out.print("Enter a, b, c: ");
        double a = scan.nextDouble(),
                b = scan.nextDouble(),
                c = scan.nextDouble();

        double h = -b / (2 * a);
        double k = ((4 * a * c) - (b * b)) / (4 * a);


        System.out.println("h is " + Rational.createRational(h)
                + " k is " + Rational.createRational(k));
    }
}


