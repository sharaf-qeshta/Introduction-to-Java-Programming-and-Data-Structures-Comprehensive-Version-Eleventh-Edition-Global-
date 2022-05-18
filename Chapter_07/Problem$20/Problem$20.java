package chapter_seven;

import java.util.Arrays;
import java.util.Locale;
import java.util.Scanner;

/**
 * *7.20 (Descending Bubble Sort) Modify the bubble sort method of Programming
 * Exercise 7.18, and sort the elements in the array in descending order instead of
 * ascending order. Write a test program that reads 10 double numbers, invokes the
 * method, and displays the sorted numbers in descending order
 *
 * @author Sharaf Qeshta
 * */


public class Problem$20
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in).useLocale(Locale.US);
        System.out.print("enter 10 values: ");

        double[] values = new double[10];

        for (int i = 0; i < 10; i++)
            values[i] =  scanner.nextInt();

        bubbleSort(values);
        /*  1 2 3 4 5 6 7 8 9 10 => [10.0, 9.0, 8.0, 7.0, 6.0, 5.0, 4.0, 3.0, 2.0, 1.0] */
        System.out.println(Arrays.toString(values));
    }


    public static void bubbleSort(double[] array)
    {
        boolean sorted = false;
        while (!sorted)
        {
            sorted = true;
            for (int i = 0; i < array.length-1; i++)
            {
                if (array[i] < array[i+1])
                {
                    double temp = array[i];
                    array[i] = array[i+1];
                    array[i+1] = temp;
                    sorted = false;
                }
            }
        }
    }



}
