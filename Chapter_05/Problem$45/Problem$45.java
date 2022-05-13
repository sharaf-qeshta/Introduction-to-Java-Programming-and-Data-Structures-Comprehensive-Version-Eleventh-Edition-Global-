package chapter_five;

import java.util.Locale;
import java.util.Scanner;

/**
 * **5.45 (Statistics: compute mean and standard deviation) In business applications, you
 * are often asked to compute the mean and standard deviation of data. The mean is
 * simply the average of the numbers. The standard deviation is a statistic that tells
 * you how tightly all the various data are clustered around the mean in a set of data.
 * For example, what is the average age of the students in a class? How close are the
 * ages? If all the students are the same age, the deviation is 0.
 * Write a program that prompts the user to enter 10 numbers and displays the mean
 * and standard deviations of these numbers using the following formula:
 * Here is a sample run:
 *
 *          Enter 10 numbers: 1 2 3 4.5 5.6 6 7 8 9 10
 *          The mean is 5.61
 *          The standard deviation is 2.99794
 *
 * @author Sharaf Qeshta
 * */


public class Problem$45
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in).useLocale(Locale.US);

        System.out.print("Enter 10 numbers: ");

        double mean = 0, deviation;

        double summation1 = 0, summation2;

        for (int i = 0; i < 10; i++)
        {
            double x = scanner.nextDouble();

            summation1 += Math.pow(x, 2);
            mean += x;
        }

        summation2 = Math.pow(mean, 2);

        mean /= 10.0;
        deviation = Math.sqrt((summation1 - (summation2/10.0)) / 9.0);

        System.out.println("The mean is " + mean);
        System.out.println("The standard deviation is " + deviation);
    }
}

