package chapter_seven;

import java.util.Locale;
import java.util.Scanner;

/**
 * 7.9 (Find the largest element) Write a method that finds the largest element in an array
 * of double values using the following header:
 * public static double max(double[] array)
 *  Write a test program that prompts the user to enter ten numbers, invokes this
 * method to return the maximum value, and displays the maximum value. Here is
 * a sample run of the program:
 *
 *          Enter ten numbers: 1.9 2.5 3.7 2 1.5 6 3 4 5 2
 *          The maximum number is: 6
 *
 * @author Sharaf Qeshta
 * */

public class Problem$09
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in).useLocale(Locale.US);

        System.out.print("Enter ten numbers: ");

        double[] numbers = new double[10];

        for (int i = 0; i < 10; i++)
            numbers[i] = scanner.nextDouble();

        System.out.println("The maximum number is " + max(numbers));
    }

    public static double max(double[] array)
    {
        double max = array[0];

        for (int i = 1; i < array.length;i++)
            if (array[i] > max)
                max = array[i];

        return max;
    }
}
