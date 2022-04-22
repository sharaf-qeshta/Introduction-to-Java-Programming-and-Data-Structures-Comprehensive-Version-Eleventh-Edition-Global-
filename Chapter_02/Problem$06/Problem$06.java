package chapter_two;

import java.util.*;

/**
 * **2.6 (Multiply the digits in an integer) Write a program that reads an integer between
 * 0 and 1000 and multiplies all the digits in the integer. For example, if an integer
 * is 932, the multiplication of all its digits is 54.
 *  Hint: Use the % operator to extract digits, and use the / operator to remove the
 * extracted digit. For instance, 932 % 10 = 2 and 932 / 10 = 93.
 *
 * Here is a sample run:
 *      Enter a number between 0 and 1000: 999
 *      The multiplication of all digits in 999 is 729
 *
 * @author Sharaf Qeshta */

public class Problem$06
{
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in).useLocale(Locale.US);
        System.out.print("Enter a number between 0 and 1000 : ");
        int value = scan.nextInt();
        int swap = value / 10;
        int value_ones = value % 10;
        int value_tens = swap % 10;
        swap /= 10;
        int value_hundreds = swap;

        System.out.println("The multiplication of all digits in " + value + " is "
                + (value_ones * value_tens * value_hundreds));
    }
}
