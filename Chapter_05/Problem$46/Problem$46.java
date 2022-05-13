package chapter_five;

import java.util.Locale;
import java.util.Scanner;

/**
 * *5.46 (Reverse a string) Write a program that prompts the user to enter a string and
 * displays the string in reverse order.
 *
 *      Enter a string: ABCD
 *      The reversed string is DCBA
 *
 * @author Sharaf Qeshta*/


public class Problem$46
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in).useLocale(Locale.US);

        System.out.print("Enter a string: ");
        String word = scanner.next();

        String reversed = "";

        for (int i = word.length()-1; i > -1; i--)
            reversed += word.charAt(i);

        System.out.println("The reversed string is " + reversed);
    }
}

