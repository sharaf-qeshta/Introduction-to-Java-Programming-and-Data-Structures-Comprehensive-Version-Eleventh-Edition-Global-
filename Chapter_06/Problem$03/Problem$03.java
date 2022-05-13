package chapter_six;

import java.util.Locale;
import java.util.Scanner;

/**
 * **6.3 (Palindrome integer) Write the methods with the following headers:
 * // Return the reversal of an integer, e.g., reverse(456) returns 654
 * public static int reverse(int number)
 * // Return true if number is a palindrome
 * public static boolean isPalindrome(int number)
 * Use the reverse method to implement isPalindrome. A number is a
 * palindrome if its reversal is the same as itself. Write a test program that prompts the
 * user to enter an integer and reports whether the integer is a palindrome.
 *
 * @author Sharaf Qeshta
 * */

public class Problem$03
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in).useLocale(Locale.US);
        System.out.print("Enter an Integer: ");
        int x = scanner.nextInt();

        System.out.println(isPalindrome(x));
    }

    public static int reverse(int number)
    {
        String numberString = number + "";
        String reversed = "";
        for (int i = numberString.length()-1;
             i > -1; i--)
            reversed += numberString.charAt(i);
        return Integer.parseInt(reversed);
    }

    public static boolean isPalindrome(int number)
    {
        return  number == reverse(number);
    }
}
