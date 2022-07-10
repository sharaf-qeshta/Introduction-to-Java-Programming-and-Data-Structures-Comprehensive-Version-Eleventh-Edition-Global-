package chapter_eighteen;

import java.util.Arrays;
import java.util.Scanner;

/**
 * *18.11 Write a recursive method that displays all permutations of a given array of
 * integers. Here is a sample run:
 *
 *          Enter the array size : 3
 *          [1, 2, 3]
 *          [1, 3, 2]
 *          [2, 1, 3]
 *          [2, 3, 1]
 *          [3, 1, 2]
 *          [3, 2, 1]
 *
 *
 * @author Sharaf Qeshta
 * */
public class Problem$11
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the array size : ");
        int size = scanner.nextInt();

        printAllPermutations(createArray(size), 0);
    }

    public static void printAllPermutations(int[] array, int index)
    {
        for(int i = index; i < array.length; i++)
        {
            int temp = array[i];
            array[i] = array[index];
            array[index] = temp;

            printAllPermutations(array, index+1);

            temp = array[i];
            array[i] = array[index];
            array[index] = temp;
        }
        if (index == array.length - 1)
            System.out.println(Arrays.toString(array));
    }


    public static int[] createArray(int size)
    {
        int[] array = new int[size];
        for (int i = 1; i <= size; i++)
            array[i-1] = i;
        return array;
    }
}
