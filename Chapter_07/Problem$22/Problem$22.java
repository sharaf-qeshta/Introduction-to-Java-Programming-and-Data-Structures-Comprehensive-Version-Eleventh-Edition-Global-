package chapter_seven;

import java.util.Locale;
import java.util.Scanner;

/**
 * *7.22 (Count the number of vowels in a string) Write a program that prompts the user to enter
 * a string, and counts and displays the number of both lowercase and uppercase vowels
 * in the string.
 *
 * @author Sharaf Qeshta
 * */


public class Problem$22
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in).useLocale(Locale.US);
        System.out.print("enter a string: ");
        String x = scanner.next();
        countVowels(x);
    }

    // a, e, i, o, u, y
    public static void countVowels(String string)
    {
        int upperVowels = 0, lowerVowels = 0;
        char[] x = string.toCharArray();
        for (char i : x)
        {
            char newChar = Character.toLowerCase(i);
            if (newChar == 'a' || newChar == 'e' || newChar == 'i' ||
                    newChar == 'o' || newChar == 'u' || newChar == 'y')
            {
                if (i < 91)
                    upperVowels++;
                else
                    lowerVowels++;
            }
        }
        System.out.println(string + "have an upper case vowels: " +  upperVowels);
        System.out.println(string + "have an lower case vowels: " +  lowerVowels);
    }
}
