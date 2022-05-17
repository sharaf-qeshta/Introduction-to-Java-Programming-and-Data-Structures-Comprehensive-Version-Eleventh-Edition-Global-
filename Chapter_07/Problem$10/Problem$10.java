package chapter_seven;

import java.util.Locale;
import java.util.Scanner;

/**
 * 7.10 (Find the index of the largest element) Write a method that returns the index of the
 * largest element in an array of integers. If there is more than one element, return
 * the largest index. Use the following header:
 * public static int indexOfLargestElement(double[] array)
 *  Write a test program that prompts the user to enter 10 numbers, invokes this
 * method to return the index of the largest element, and displays the index and the
 * element itself.
 *
 * @author Sharaf Qeshta
 * */

public class Problem$10
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in).useLocale(Locale.US);

        System.out.print("enter 10 double values: ");

        double[] numbers = new double[10];

        for (int i = 0; i < 10; i++)
            numbers[i] = scanner.nextDouble();

        int largestIndex = indexOfLargestElement(numbers);
        System.out.println("The Largest element index is " + largestIndex + " ( " + numbers[largestIndex] + " )");
    }

    public static int indexOfLargestElement(double[] array)
    {
        int index = 0;

        for (int i = 1; i < array.length;i++)
            if (array[i] > array[index])
                index = i;

        return index;
    }
}
