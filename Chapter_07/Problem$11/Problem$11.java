package chapter_seven;

import java.util.Locale;
import java.util.Scanner;

/**
 * *7.11 (Statistics: compute deviation) Programming Exercise 5.45 computes the standard
 * deviation of numbers. This exercise uses a different but equivalent formula to
 * compute the standard deviation of n numbers.
 * To compute the standard deviation with this formula, you have to store
 * the individual numbers using an array, so they can be used after the mean is obtained.
 * Your program should contain the following methods:
 *
 * public static double deviation(double[] x)
 *
 * public static double mean(double[] x)
 *
 * Write a test program that prompts the user to enter 10 numbers and displays the
 * mean and standard deviation, as presented in the following sample run:
 *
 *          Enter 10 numbers: 1.9 2.5 3.7 2 1 6 3 4 5 2
 *          The mean is 3.11
 *          The standard deviation is 1.55738
 *
 * @author Sharaf Qeshta
 * */

public class Problem$11
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in).useLocale(Locale.US);

        System.out.print("Enter 10 numbers: ");

        double[] x = new double[10];

        for (int i = 0; i < 10; i++)
            x[i] = scanner.nextDouble();

        System.out.println("The mean is " + String.format("%.2f",  mean(x)));
        System.out.println("The standard deviation is " + String.format("%.2f", deviation(x)));
    }

    /** Compute the deviation of double values */
    public static double deviation(double[] x)
    {
        double numerator = 0, denominator = x.length-1, mean = mean(x);

        for (double i : x)
            numerator += Math.pow(i - mean, 2);


        return Math.sqrt(numerator / denominator);
    }

    /** Compute the mean of an array of double values */
    public static double mean(double[] x)
    {
        double sum = 0;

        for (double i : x)
            sum += i;

        return sum / x.length;
    }
}
