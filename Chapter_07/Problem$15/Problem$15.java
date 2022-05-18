package chapter_seven;

import java.util.Arrays;
import java.util.Locale;
import java.util.Scanner;

/**
 * 7.15 (Eliminate duplicates) Write a method that returns a new array by eliminating the
 * duplicate values in the array using the following method header:
 * public static int[] eliminateDuplicates(int[] list)
 *  Write a test program that reads in 10 integers, invokes the method, and displays
 * the distinct numbers separated by exactly one space. Here is a sample run of the
 * program:
 *
 *      Enter 10 numbers: 1 2 3 2 1 6 3 4 5 2
 *      The distinct numbers are: 1 2 3 6 4 5
 *
 * @author Sharaf Qeshta
 * */


public class Problem$15
{
    public static void main(String[] args)
    {

        Scanner scanner = new Scanner(System.in).useLocale(Locale.US);

        System.out.print("Enter 10 numbers: ");

        int[] list = new int[10];

        for (int i = 0; i < 10; i++)
        {
            int j = scanner.nextInt();
            list[i] = j;
        }

        /* 1 2 3 4 5 6 7 8 1 1 => [1, 2, 3, 4, 5, 6, 7, 8] */
        System.out.println(Arrays.toString(eliminateDuplicates(list)));
    }

    public static int[] eliminateDuplicates(int[] list)
    {
        int[] temp = new int[list.length];
        int index = 0;
        for (int x: list)
        {
            if (!isIn(temp, x))
            {
                temp[index] = x;
                index++;
            }
        }

        // to eliminate the unoccupied indices
        int[] temp2 = new int[index];
        int index2 = 0;

        for (int x : temp)
        {
            if (x != 0)
            {
                temp2[index2] = x;
                index2++;
            }
        }
        return temp2;
    }

    public static boolean isIn(int[] list, int element)
    {
        for (int x: list)
            if (x == element)
                return true;
        return false;
    }
}
