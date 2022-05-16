package chapter_six;

import java.util.Locale;
import java.util.Scanner;

/**
 * 6.37 (Format an integer) Write a method with the following header to format the
 * integer with the specified width.
 * public static String format(int number, int width)
 * The method returns a string for the number with one or more prefix 0s. The size of the
 * string is the width. For example, format(34, 4) returns 0034 and format(34,
 * 5) returns 00034. If the number is longer than the width, the method returns the
 * string representation for the number. For example, format(34, 1) returns 34.
 * Write a test program that prompts the user to enter a number and its width, and
 * displays a string returned by invoking format(number, width).
 *
 * @author Sharaf Qeshta
 * */


public class Problem$37
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in).useLocale(Locale.US);

        System.out.print("enter the number and its width: ");
        int number = scanner.nextInt();
        int width = scanner.nextInt();

        System.out.println(format(number, width));
    }

    public static String format(int number, int width)
    {
        int loop = width - (number+"").length();
        StringBuilder output = new StringBuilder();

        if (loop < 0)
            return number+"";
        else
        {
            for (int i = 0; i < loop; i++)
                output.append(0);
            output.append(number);
            return output.toString();
        }
    }

}
