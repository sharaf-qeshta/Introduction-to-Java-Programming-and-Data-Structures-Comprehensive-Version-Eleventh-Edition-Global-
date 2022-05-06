package chapter_four;

import java.util.Locale;
import java.util.Scanner;


/**
 * *4.9 (Find the Unicode of a character) Write a program that receives a character and
 * displays its Unicode. Here is a sample run:
 *
 *      Enter a character: E
 *      The Unicode for the character E is 69
 *
 * @author Sharaf Qeshta
 * */

public class Problem$09
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in).useLocale(Locale.US);

        System.out.print("Enter a character: ");
        String character = scanner.next();

        System.out.println("The ASCII code for character "
                + character + " is " + (int) (character.charAt(0)));
    }
}
