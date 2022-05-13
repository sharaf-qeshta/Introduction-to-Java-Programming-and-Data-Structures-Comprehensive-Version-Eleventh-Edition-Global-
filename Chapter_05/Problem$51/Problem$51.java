package chapter_five;

import java.util.Locale;
import java.util.Scanner;

/**
 * *5.51 (Longest common prefix) Write a program that prompts the user to enter two
 * strings and displays the largest common prefix of the two strings. Here are some
 * sample runs:
 *
 *          Enter the first string: Welcome to C++
 *          Enter the second string: Welcome to programming
 *          The common prefix is Welcome to
 *
 *          Enter the first string: Atlanta
 *          Enter the second string: Macon
 *          Atlanta and Macon have no common prefix
 *
 * @author Sharaf Qeshta
 * */


public class Problem$51
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in).useLocale(Locale.US);

        System.out.print("Enter the first string: ");
        String s1 = scanner.nextLine();

        System.out.print("Enter the second string: ");
        String s2 = scanner.nextLine();

        StringBuilder prefix = new StringBuilder("");
        StringBuilder tempPrefix = new StringBuilder("");

        for (int i = 0; i < s1.length() & i < s2.length(); i++)
        {
            char x1 = s1.charAt(i);
            char x2 = s2.charAt(i);

            if (x1 == x2)
                tempPrefix.append(x1);
            else
            {
                if (tempPrefix.length() > prefix.length())
                    prefix = tempPrefix;
            }
        }

        if (prefix.length() == 0)
            System.out.println(s1 + " " + s2 + " have no common prefix");
        else
            System.out.println("The common prefix is " + prefix);
    }
}

