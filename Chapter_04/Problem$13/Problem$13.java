package chapter_four;

import java.util.Locale;
import java.util.Scanner;


/**
 * *4.13 (Vowel or consonant?) Write a program that prompts the user to enter a letter and
 * check whether the letter is a vowel or consonant. For a nonletter input, display
 * invalid input. Here is a sample run:
 *
 *          Enter a letter: B
 *          B is a consonant
 *
 *          Enter a letter: a
 *          a is a vowel
 *
 *          Enter a letter: #
 *          # is an invalid input
 *
 * @author Sharaf Qeshta
 * */

public class Problem$13
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in).useLocale(Locale.US);

        System.out.print("Enter a letter: ");
        String input = scanner.next();

        char character = input.charAt(0);
        char letter = Character.toUpperCase(character);

        if (letter == 'A' | letter == 'I' | letter == 'O'
                | letter == 'U' | letter == 'E')
            System.out.println(character + " is a vowel");
        else if (letter > 64 & letter < 91)
            System.out.println(character + " is a consonant");
        else
            System.out.println(character + " is an invalid input");
    }
}
