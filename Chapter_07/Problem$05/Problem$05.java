package chapter_seven;

import java.util.Locale;
import java.util.Scanner;

/**
 * **7.5 (The number of even numbers and odd numbers) Write a program that reads ten
 * integers, and then display the number of even numbers and odd numbers. Assume
 * that the input ends with 0. Here is the sample run of the program
 *
 *          Enter numbers: 1 2 3 2 1 6 3 4 5 2 3 6 8 9 9 0
 *          The number of odd numbers: 8
 *          The number of even numbers: 7
 *
 * @author Sharaf Qeshta
 * */

public class Problem$05
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in).useLocale(Locale.US);

        System.out.print("Enter numbers: ");

        int odds = 0, evens = 0;
        while (true)
        {
            int number = scanner.nextInt();

            if (number == 0)
                break;
            if (number % 2 == 0)
                evens++;
            else
                odds++;
        }

        System.out.println("The number of odd numbers: " + odds);
        System.out.println("The number of even numbers: " + evens);
    }

}
