package chapter_twenty_two;

import java.util.Scanner;

/**
 * **22.2 (Efficient polynomial calculation) For a polynomial f(x) = an xn + an-1xn-1 +
 * an-2 xn-2 + c + a1x + a0, write an efficient program that prompts the user
 * to enter the degree n, the coefficients a0 to an, and the value for x, and computes
 * and displays ƒ(x). Here is a sample run:
 *
 *          Enter n: 3
 *          Enter x: 2
 *          Enter a0: 1
 *          Enter a1: 2
 *          Enter a2: 3
 *          Enter a3: 4
 *          f(2.000000) = 49.000000
 *
 *
 * @author Sharaf Qeshta
 * */
public class Problem$02
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter n: ");
        int degree = scanner.nextInt();

        System.out.print("Enter x: ");
        double x = scanner.nextDouble();

        double[] coefficients = new double[degree+1];
        for (int i = coefficients.length-1; i > -1; i--)
        {
            System.out.print("Enter a"+(coefficients.length -1 - i) + ": ");
            coefficients[i] = scanner.nextDouble();
        }

        System.out.printf("f(%.6f) = %.6f", x, f(degree, x, coefficients));
    }

    public static double f(int degree, double x, double[] coefficients)
    {
        double out = 0;
        for (double coefficient : coefficients)
            out += coefficient * Math.pow(x, degree--);
        return out;
    }
}
