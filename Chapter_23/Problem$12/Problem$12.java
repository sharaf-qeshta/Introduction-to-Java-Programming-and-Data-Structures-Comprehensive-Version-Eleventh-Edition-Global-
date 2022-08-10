package chapter_twenty_three;

import java.util.Arrays;

/**
 * *23.12 (Radix sort) Write a program that randomly generates 1,200,000 integers and
 * sorts them using radix sort.
 *
 *
 * @author Sharaf Qeshta
 * */
public class Problem$12
{
    public static void main(String[] args)
    {
        int[] array = new int[1_200_000];
        for (int i = 0; i < array.length; i++)
            array[i] = (int) (Math.random() * 1000); // 0 => 1000
        radixSort(array);
        System.out.println(Arrays.toString(array));
    }


    public static void radixSort(int[] array)
    {
        int max = array[0];
        for (int i = 1; i < array.length; i++)
            if (array[i] > max)
                max = array[i];

        for (int exp = 1; max / exp > 0; exp *= 10)
            countSort(array, exp);
    }


    public static void countSort(int[] array, int exp)
    {
        int[] output = new int[array.length];
        int i;
        int[] count = new int[10]; // ten buckets

        for (i = 0; i < array.length; i++)
            count[(array[i] / exp) % 10]++;

        for (i = 1; i < 10; i++)
            count[i] += count[i - 1];


        for (i = array.length - 1; i >= 0; i--)
        {
            output[count[(array[i] / exp) % 10] - 1] = array[i];
            count[(array[i] / exp) % 10]--;
        }

        for (i = 0; i < array.length; i++)
            array[i] = output[i];
    }
}
