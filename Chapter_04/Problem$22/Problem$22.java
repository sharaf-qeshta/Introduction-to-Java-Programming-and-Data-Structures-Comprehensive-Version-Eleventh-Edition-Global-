package chapter_four;


import java.util.Locale;
import java.util.Scanner;

/**
 * 4.22 (Check substring) Write a program that prompts the user to enter two strings, and
 * reports whether the second string is a substring of the first string.
 *
 *          Enter string s1: ABCD
 *          Enter string s2: BC
 *          BC is a substring of ABCD
 *
 *          Enter string s1: ABCD
 *          Enter string s2: BDC
 *          BDC is not a substring of ABCD
 *
 * @author Sharaf Qeshta
 * */

public class Problem$22
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in).useLocale(Locale.US);
        System.out.print("Enter string s1: ");
        String firstInput = scanner.next();

        System.out.print("Enter string s2: ");
        String secondInput = scanner.next();

        if (firstInput.contains(secondInput))
            System.out.println(secondInput + " is a substring of " + firstInput);
        else
            System.out.println(secondInput + " is not a substring of " + firstInput);
    }
}
