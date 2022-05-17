package chapter_seven;

import java.util.Locale;
import java.util.Scanner;

/**
 * **7.3 (Count occurrence of numbers) Write a program that reads the integers between
 * 1 and 50 and counts the occurrences of each. Assume the input ends with 0. Here
 * is a sample run of the program:
 *
 *          Enter the integers between 1 and 50: 2 5 6 5 4 3 23 43 2 0
 *          2 occurs 2 times
 *          3 occurs 1 time
 *          4 occurs 1 time
 *          5 occurs 2 times
 *          6 occurs 1 time
 *          23 occurs 1 time
 *          43 occurs 1 time
 *
 * @author Sharaf Qeshta
 * */

public class Problem$03
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in).useLocale(Locale.US);

        System.out.print("Enter the integers between 1 and 50: ");

        int[] occurrences = new int[50];
        int num = -1;

        while (num != 0)
        {
            num = scanner.nextInt();

            if (num < 51 & num > 0)
                occurrences[num-1] += 1;
        }

        for (int i = 0; i < 50; i++)
        {
            String output = " time";

            if (occurrences[i] > 1)
                output = " times";

            if (occurrences[i] != 0)
                System.out.println((i+1)+  " occurs " + occurrences[i]  + output);
        }
    }

}
