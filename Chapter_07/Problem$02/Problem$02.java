package chapter_seven;

import java.util.Locale;
import java.util.Scanner;

/**
 * 7.2 (Comparing numbers) Write a program that reads 11 integers, compares each
 * integer with the 11th integer, and displays whether the integers are “greater”,
 * “smaller”, or “equal” to the 11th integer
 *
 * @author Sharaf Qeshta
 * */

public class Problem$02
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in).useLocale(Locale.US);

        System.out.print("Enter 11 numbers: ");

        int[] numbers = new int[11];

        for (int i = 0; i < 11; i++)
        {
            int num = scanner.nextInt();
            numbers[i] = num;
        }

        for (int i = 0; i < 10; i++)
        {
            int num = numbers[i];
            if (num > numbers[10])
                System.out.println(num + " is greater than " + numbers[10]);
            else if (num < numbers[10])
                System.out.println(num + " is smaller than " + numbers[10]);
            else
                System.out.println(num + " is equal to " + numbers[10]);
        }
    }

}
