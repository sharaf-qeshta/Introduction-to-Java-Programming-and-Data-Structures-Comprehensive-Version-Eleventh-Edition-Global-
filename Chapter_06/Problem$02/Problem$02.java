package chapter_six;

import java.util.Locale;
import java.util.Scanner;

/**
 * *6.2 (Sum the digits in an integer) Write a method that computes the sum of the digits
 * in an integer. Use the following method header:
 * public static int sumDigits(long n)
 * For example, sumDigits(234) returns 9 (= 2 + 3 + 4). (Hint: Use the % operator
 * to extract digits and the / operator to remove the extracted digit. For instance,
 * to extract 4 from 234, use 234 % 10 (= 4 ). To remove 4 from 234, use 234 / 10
 * (= 2 3 ). Use a loop to repeatedly extract and remove the digit until all the digits
 * are extracted. Write a test program that prompts the user to enter an integer then
 * displays the sum of all its digits.
 *
 * @author Sharaf Qeshta
 * */

public class Problem$02
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in).useLocale(Locale.US);
        System.out.print("Enter an Integer: ");
        long x = scanner.nextLong();

        System.out.println(sumDigits(x));
    }

    public static int sumDigits(long n)
    {
        int total = 0;
        for (long i = n; i > 0; i/=10)
            total += i % 10;
        return total;
    }
}
