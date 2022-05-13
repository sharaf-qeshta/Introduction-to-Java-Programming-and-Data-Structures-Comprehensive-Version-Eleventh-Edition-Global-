package chapter_five;

import java.util.Locale;
import java.util.Scanner;

/**
 * *5.48 (Process string) Write a program that prompts the user to enter a string and displays
 * the characters at even positions. Here is a sample run:
 *
 *      Enter a string: Beijing Chicago
 *      ejnhcg
 *
 * @author Sharaf Qeshta
 * */


public class Problem$48
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in).useLocale(Locale.US);

        System.out.print("Enter a string: ");
        String phrase = scanner.nextLine();
        StringBuilder evenPositions = new StringBuilder("");

        for (int i = 1; i < phrase.length()+1; i++)
        {
            if (i % 2 == 0)
                evenPositions.append(phrase.charAt(i-1));
        }
        System.out.println(evenPositions);
    }
}

