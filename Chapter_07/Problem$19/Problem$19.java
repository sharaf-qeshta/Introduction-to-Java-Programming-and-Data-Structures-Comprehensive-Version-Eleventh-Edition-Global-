package chapter_seven;

import java.util.Arrays;
import java.util.Locale;
import java.util.Scanner;

/**
 * **7.19 (Sorted?) Write the following method that returns true if the list is already sorted
 * in decreasing order.
 * public static boolean isSorted(int[] list)
 *  Write a test program that prompts the user to enter a list and displays whether
 * the list is sorted or not. Here is a sample run. Note that the first number in the
 * input indicates the number of the elements in the list. This number is not part
 * of the list
 *
 *      Enter list: 8 10 1 5 16 61 9 11 1
 *      The list is not sorted
 *
 *      Enter list: 10 21 11 9 7 5 4 4 3 1 1
 *      The list is already sorted
 *
 * @author Sharaf Qeshta
 * */


public class Problem$19
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in).useLocale(Locale.US);
        System.out.print("Enter list: ");
        int length = scanner.nextInt();

        int[] values = new int[length];

        for (int i = 0; i < length; i++)
            values[i] = scanner.nextInt();

        if (isSorted(values))
            System.out.println("The list is already sorted ");
        else
            System.out.println("The list is not sorted ");
    }

    public static boolean isSorted(int[] list)
    {
        for (int i = 0;i < list.length-1; i++)
            if (list[i] < list[i+1])
                return false;
        return true;
    }

}
