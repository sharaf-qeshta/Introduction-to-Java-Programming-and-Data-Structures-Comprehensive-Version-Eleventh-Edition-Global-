package chapter_twenty_two;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * *22.5 (Fill and sort array) Write a program that randomly fills an array of integers and
 * then sorts it. The array size is entered by the user and the values are chosen at random
 * in {-1, 0, 1}. Analyze the time complexity of your program. Here is a sample run:
 *
 *          Enter the size: 10
 *          1 0 1 −1 0 1 −1 0 0 0
 *          −1 −1 0 0 0 0 0 1 1 1
 *
 *
 * @author Sharaf Qeshta
 * */
public class Problem$05
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the size: ");
        int size = scanner.nextInt();

        int[] array = new int[size];

        fill(array); // O(n)
        print(array); // O(n)
        sort(array); // O(n²)
        print(array); // O(n)
        // the full time complexity is O(n²)
    }


    private static final ArrayList<Integer> randomRange = new ArrayList<>(Arrays.asList(-1, 0, 1));

    /** Time Complexity O(n) 'Linear Algorithm' */
    public static void fill(int[] array)
    {
        for (int i = 0; i < array.length; i++)
        {
            int randomIndex = (int) ((Math.random() * (randomRange.size()*2)) % randomRange.size());
            array[i] = randomRange.get(randomIndex);
        }
    }


    /** Time Complexity O(n²) 'Quadratic Algorithm' */
    public static void sort(int[] array)
    {
        for (int i = 0; i < array.length; i++)
        {
            int min = i;
            for (int j = i+1; j < array.length; j++)
                if (array[min] > array[j])
                    min = j;
            int temp = array[min];
            array[min] = array[i];
            array[i] = temp;
        }
    }

    /** Time Complexity O(n) 'Linear Algorithm' */
    public static void print(int[] array)
    {
        System.out.println();
        for (int i : array)
            System.out.print(i + " ");
        System.out.println();
    }
}
