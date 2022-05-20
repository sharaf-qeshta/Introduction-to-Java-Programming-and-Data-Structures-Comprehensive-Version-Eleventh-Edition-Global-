package chapter_seven;


import java.util.Arrays;
import java.util.Locale;
import java.util.Scanner;

/**
 * **7.31 (Merge two sorted lists) Write the following method that merges two sorted lists
 * into a new sorted list:
 * public static int[] merge(int[] list1, int[] list2)
 *  Implement the method in a way that takes at most list1.length + list2.
 * length comparisons. See liveexample.pearsoncmg.com/dsanimation/
 * MergeSortNeweBook.html for an animation of the implementation. Write a test
 * program that prompts the user to enter two sorted lists and displays the merged
 * list. Here is a sample run. Note the first number in the input indicates the number
 * of the elements in the list. This number is not part of the list.
 *
 *
 *          Enter list1 size and contents: 5 1 5 16 61 111
 *          Enter list2 size and contents: 4 2 4 5 6
 *          list1 is 1 5 16 61 111
 *          list2 is 2 4 5 6
 *          The merged list is 1 2 4 5 5 6 16 61 111
 *
 * @author Sharaf Qeshta
 * */


public class Problem$31
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in).useLocale(Locale.US);

        System.out.print("Enter list1 size and contents: ");
        int size = scanner.nextInt();

        int[] list1 = new int[size];
        for (int i = 0; i < size; i++)
            list1[i] = scanner.nextInt();

        System.out.print("Enter list2 size and contents: ");
        size = scanner.nextInt();

        int[] list2 = new int[size];
        for (int i = 0; i < size; i++)
            list2[i] = scanner.nextInt();

        System.out.println("list1 is " + Arrays.toString(list1));
        System.out.println("list2 is " + Arrays.toString(list2));

        System.out.println("The merged list is " + Arrays.toString(merge(list1, list2)));
    }

    public static int[] merge(int[] list1, int[] list2)
    {
        int[] output = new int[list1.length + list2.length];
        int l1Index = 0, l2Index = 0;
        for (int i = 0; i < output.length; i++)
        {
            boolean l1OutBound = l1Index >= list1.length;
            boolean l2OutBound = l2Index >= list2.length;
            if (!l1OutBound && !l2OutBound)
            {
                if (list1[l1Index] < list2[l2Index])
                    output[i] = list1[l1Index++];
                else
                    output[i] = list2[l2Index++];
            }
            else
            {
                if (!l1OutBound)
                    output[i] = list1[l1Index++];
                else
                    output[i] = list2[l2Index++];
            }
        }
        return output;
    }


}
