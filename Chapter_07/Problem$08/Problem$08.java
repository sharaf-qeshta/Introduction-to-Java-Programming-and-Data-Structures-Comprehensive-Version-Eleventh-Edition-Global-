package chapter_seven;


import java.util.Locale;
import java.util.Scanner;

/**
 * 7.8 (Average an array) Write two overloaded methods that return the average of an
 * array with the following headers:
 * public static int average(int[] array)
 * public static double average(double[] array)
 *  Write a test program that prompts the user to enter 10 double values, invokes this
 * method, then displays the average value.
 *
 * @author Sharaf Qeshta
 * */

public class Problem$08
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in).useLocale(Locale.US);

        System.out.print("enter 10 double values: ");

        double[] numbers = new double[10];

        for (int i = 0; i < 10; i++)
        {
            double j = scanner.nextDouble();
            numbers[i] = j;
        }

        System.out.println(average(numbers));
    }

    public static int average(int[] array)
    {
        int sum = 0;
        for (int j : array) sum += j;
        return sum / array.length;
    }


    public static double average(double[] array)
    {
        double sum = 0;
        for (double j : array) sum += j;
        return sum / array.length;
    }
}
