package chapter_six;

import java.util.Locale;
import java.util.Scanner;

/**
 * *6.20 (Count the letters in a string) Write a method that counts the number of letters in
 * a string using the following header:
 * public static int countLetters(String s)
 * Write a test program that prompts the user to enter a string and displays the
 * number of letters in the string.
 *
 * @author Sharaf Qeshta
 * */

public class Problem$20
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in).useLocale(Locale.US);

        System.out.print("enter a string: ");
        String s = scanner.next();

        System.out.println(countLetters(s));
    }

    public static int countLetters(String s)
    {
        int letters = 0;
        for (int i = 0; i < s.length(); i++)
            if (Character.isLetter(s.charAt(i)))
                letters++;
        return letters;
    }
}
