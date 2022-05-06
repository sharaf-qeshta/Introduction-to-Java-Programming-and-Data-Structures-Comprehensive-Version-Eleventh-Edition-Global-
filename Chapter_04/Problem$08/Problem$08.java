package chapter_four;

import java.util.Locale;
import java.util.Scanner;

/**
 * *4.8 (Find the character of an ASCII code) Write a program that receives a character
 * and displays its ASCII code (an integer between 0 and 127). Here is a sample run:
 *
 *          Enter a character: E
 *          The ASCII code for character E is 69
 *
 * @author Sharaf Qeshta
 * */

public class Problem$08
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
