package chapter_seven;

import java.util.Locale;
import java.util.Scanner;

/**
 * 7.27 (Check whether the array is sorted with constant interval) An array list is sorted
 * with a constant interval if its elements are arranged in an ascending order and there
 * is a constant difference between adjacent elements. Write a method that returns
 * true if list is sorted with a constant interval, using the following header:
 * public static boolean isSortedConstantInterval(int[] list)
 *  Write a test program that prompts the user to enter a list of integers. Note the first
 * number in the input indicates the number of elements in the list. This number is
 * not part of the list.
 *
 *          Enter list: 5 2 5 6 9 10
 *          The list is not sorted with a constant interval
 *
 *          Enter list: 5 2 4 6 8 10
 *          The list is sorted with a constant interval.
 *
 * @author Sharaf Qeshta
 * */


public class Problem$27
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in).useLocale(Locale.US);

        System.out.print("Enter list: ");
        int size = scanner.nextInt();
        int[] list = new int[size];

        for (int i = 0; i < size; i++)
        {
            int input = scanner.nextInt();
            list[i] = input;
        }

        if (isSortedConstantInterval(list))
            System.out.println("The list is sorted with a constant interval.");
        else
            System.out.println("The list is not sorted with a constant interval.");
    }


    public static boolean isSortedConstantInterval(int[] list)
    {
        int constant = list[1] - list[0];
        for (int i = 0; i < list.length-1; i++)
        {
            if (list[i] > list[i+1] || list[i+1] - list[i] != constant )
                return false;
        }
        return true;
    }

}
