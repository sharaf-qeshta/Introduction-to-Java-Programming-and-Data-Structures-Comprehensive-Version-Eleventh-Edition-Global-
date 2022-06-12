package chapter_thirteen;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * *13.15 (Use BigInteger for the Rational class) Redesign and implement the
 * Rational class in Listing 13.13 using BigInteger for the numerator and denominator.
 * Write a test program that prompts the user to enter two rational numbers and
 * display the results as shown in the following sample run:
 *
 *          Enter the first rational number: 3 454
 *          Enter the second second number: 7 2389
 *          3/454 + 7/2389 = 10345/1084606
 *          3/454 – 7/2389 = 3989/1084606
 *          3/454 * 7/2389 = 21/1084606
 *          3/454 / 7/2389 = 7167/3178
 *          7/2389 is 0.0029300962745918793
 *
 * @author Sharaf Qeshta
 * */
public class Problem$15
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the first rational number: ");
        BigInteger numerator = scanner.nextBigInteger();
        BigInteger denominator = scanner.nextBigInteger();

        Rational r1 = new Rational(numerator, denominator);

        System.out.print("Enter the second rational number: ");
        numerator = scanner.nextBigInteger();
        denominator = scanner.nextBigInteger();

        Rational r2 = new Rational(numerator, denominator);


        System.out.println(r1 + " + " + r2 + " = " + (r1.add(r2)));
        System.out.println(r1 + " - " + r2 + " = " + (r1.subtract(r2)));
        System.out.println(r1 + " * " + r2 + " = " + (r1.multiply(r2)));
        System.out.println(r1 + " / " + r2 + " = " + (r1.divide(r2)));

        System.out.println(r2 + " is " + r2.doubleValue());
    }
}