package chapter_three;

import java.util.Locale;
import java.util.Scanner;

/**
 * 3.12 (Palindrome integer) Write a program that prompts the user to enter a three-digit
 * integer and determines whether it is a palindrome integer. An integer is palindrome
 * if it reads the same from right to left and from left to right. A negative integer is
 * treated the same as a positive integer. Here are sample runs of this program:
 *
 *      Enter a three-digit integer: 121
 *      121 is a palindrome
 *
 *      Enter a three-digit integer: 123
 *      123 is not a palindrome
 *
 * @author Sharaf Qeshta
 * */

public class Problem$12
{
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in).useLocale(Locale.US);

        System.out.print("enter a three-digit integer : ");
        int integer = scan.nextInt();

        int thirdDigit = integer % 10,
                secondDigit = (integer / 10) % 10,
                firstDigit = (integer / 100);

        int x = Integer.parseInt((thirdDigit + ""
                + secondDigit + ""
                + firstDigit + ""));

        String result = (integer == x) ? "Palindrome"  : "not Palindrome";
        System.out.println(integer + " is " + result);
    }
}
