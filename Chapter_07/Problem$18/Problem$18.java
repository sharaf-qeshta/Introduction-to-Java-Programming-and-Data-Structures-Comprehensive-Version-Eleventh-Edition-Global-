package chapter_seven;

import java.util.Arrays;
import java.util.Locale;
import java.util.Scanner;

/**
 * **7.18 (Bubble sort) Write a sort method that uses the bubble-sort algorithm.
 * The bubble-sort algorithm makes several passes through the array. On each pass,
 * successive neighboring pairs are compared. If a pair is not in order, its values are
 * swapped; otherwise, the values remain unchanged. The technique is called a
 * bubble sort or sinking sort because the smaller values gradually “bubble” their
 * way to the top, and the larger values “sink” to the bottom. Write a test program
 * that reads in 10 double numbers, invokes the method, and displays the sorted
 * numbers.
 *
 * @author Sharaf Qeshta
 * */


public class Problem$18
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in).useLocale(Locale.US);
        System.out.print("Enter 10 Doubles: ");

        double[] numbers = new double[10];
        for (int i = 0; i < numbers.length; i++)
            numbers[i] = scanner.nextInt();
        sort(numbers);

        System.out.println(Arrays.toString(numbers));
    }

    public static void sort(double[] numbers)
    {
        boolean sorted = false;
        while (!sorted)
        {
            sorted = true;
            for (int i = 0; i < numbers.length-1; i++)
            {
                if (numbers[i] > numbers[i+1])
                {
                    double temp = numbers[i];
                    numbers[i] = numbers[i+1];
                    numbers[i+1] = temp;
                    sorted = false;
                }
            }
        }
    }

}
