package chapter_seven;

import java.util.Locale;
import java.util.Scanner;

/**
 * **7.32 (Partition of a list) Write the following method that partitions the list using the
 * first element, called a pivot:
 * public static int partition(int[] list)
 *  After the partition, the elements in the list are rearranged so all the elements before
 * the pivot are less than or equal to the pivot, and the elements after the pivot are
 * greater than the pivot. The method returns the index where the pivot is located in
 * the new list. For example, suppose the list is {5, 2, 9, 3, 6, 8}. After the partition,
 * the list becomes {3, 2, 5, 9, 6, 8}. Implement the method in a way that takes at
 * most list.length comparisons. See liveexample.pearsoncmg.com/dsanimation/QuickSortNeweBook.html
 * for an animation of the implementation. Write a
 * test program that prompts the user to enter the size of the list and the contents of
 * the list and displays the list after the partition. Here is a sample run
 *
 *          Enter list size: 8
 *          Enter list content: 10 1 5 16 61 9 11 1
 *          After the partition, the list is 9 1 5 1 10 61 11 16
 *
 * @author Sharaf Qeshta
 * */

public class Problem$32
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in).useLocale(Locale.US);
        System.out.print("Enter list size: ");
        int size = scanner.nextInt();

        System.out.print("Enter list content: ");
        int[] list = new int[size];

        for (int i = 0; i < size; i++)
            list[i] = scanner.nextInt();

        int[] newArray = partition(list);

        System.out.print("After the partition, the list is ");
        for (int j : newArray) System.out.print(j + " ");
    }

    public static int[] partition(int[] list)
    {
        int[] out = new int[list.length];
        int low = 0, high = list.length-1, pivot = list[0];

        for (int index = 1; index < list.length; index++)
        {
            if (list[index] <= pivot)
                out[low++] = list[index];
            else
                out[high--] = list[index];
        }
        out[low] = pivot;
        return out;
    }
}
