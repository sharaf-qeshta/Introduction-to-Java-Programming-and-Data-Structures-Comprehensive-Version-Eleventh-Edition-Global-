package chapter_six;

import java.util.Locale;
import java.util.Scanner;

/**
 * *6.21 (Phone keypads)  The international standard letter/number mapping for
 * telephones is given in Programming Exercise 4.15. Write a method that returns a
 * number, given an uppercase letter, as follows:
 * public static int getNumber(char uppercaseLetter)
 * Write a test program that prompts the user to enter a phone number as a string. The input
 * number may contain letters. The program translates a letter (uppercase or lowercase)
 * to a digit and leaves all other characters intact. Here are sample runs of the program:
 *
 *          Enter a string: 1-800-Flowers
 *          1-800-3569377
 *
 *          Enter a string: 1800flowers
 *          18003569377
 * */

public class Problem$21
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in).useLocale(Locale.US);

        System.out.print("Enter a string: ");
        String input = scanner.next();

        StringBuilder output = new StringBuilder();

        for (int i = 0; i < input.length(); i++)
        {
            char x = input.charAt(i);
            if (Character.isLetter(x))
                output.append(getNumber(x));
            else
                output.append(x);
        }
        System.out.println(output);
    }

    public static int getNumber(char uppercaseLetter)
    {
        char letter = Character.toLowerCase(uppercaseLetter);

        if (letter < 97 || letter > 127)
            return -1;
        else
        {
            int code = ((int) letter - 91) / 3;

            boolean problemOccurs = letter == 's' || letter == 'v'
                    || letter == 'y' || letter == 'z';

            if (problemOccurs)
                code--;
            return code;
        }
    }
}
