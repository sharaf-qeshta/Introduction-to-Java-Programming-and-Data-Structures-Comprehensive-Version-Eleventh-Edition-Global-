package chapter_eighteen;

import java.util.Scanner;

/**
 * *18.13 (Find the largest number in an array) Write a recursive method that returns the
 * largest integer in an array. Write a test program that prompts the user to enter a
 * list of eight integers and displays the largest element.
 *
 *
 * @author Sharaf Qeshta
 */
public class Problem$13
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        int[] array = new int[8];
        System.out.print("Enter 8 integers: ");

        for (int i = 0; i < array.length; i++)
            array[i] = scanner.nextInt();

        System.out.println(Max(array, array[0], 0));
    }

    public static int Max(int[] array, int max, int index)
    {
        if (index < array.length)
        {
            if (array[index] > max)
                max = array[index];
            return Max(array, max, index + 1);
        }
        return max;
    }
}
