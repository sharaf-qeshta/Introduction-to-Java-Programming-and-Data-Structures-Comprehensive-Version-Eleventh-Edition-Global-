package chapter_five;

import java.util.Locale;
import java.util.Scanner;

/**
 * *5.49 (Count vowels and consonants) Assume that the letters A, E, I, O, and U are vowels.
 * Write a program that prompts the user to enter a string, and displays the number of
 * vowels and consonants in the string.
 *
 *      Enter a string: Programming is fun
 *      The number of vowels is 5
 *      The number of consonants is 11
 *
 * @author Sharaf Qeshta
 * */


public class Problem$49
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in).useLocale(Locale.US);

        System.out.print("Enter a string: ");
        String string = scanner.nextLine();

        int vowelsOccurrence = 0;
        int consonantsOccurrence = 0;

        for (int i = 0; i < string.length(); i++)
        {
            char x = Character.toLowerCase(string.charAt(i));
            if ( x =='a' || x == 'e' || x == 'i'
                    || x == 'o' || x == 'u')
                vowelsOccurrence++;
            else if (Character.isLetter(x))
                consonantsOccurrence++;
        }

        System.out.println("The number of vowels is " + vowelsOccurrence);
        System.out.println("The number of consonants " + consonantsOccurrence);
    }
}

