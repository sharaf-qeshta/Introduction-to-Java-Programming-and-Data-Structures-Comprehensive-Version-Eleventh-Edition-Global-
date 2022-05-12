package chapter_five;

import java.util.Locale;
import java.util.Scanner;

/**
 *  **5.38 (Decimal to octal) Write a program that prompts the user to enter a decimal
 * integer and displays its corresponding octal value. Don’t use Java’s Integer.
 * toOctalString(int) in this program.
 *
 * @author Sharaf Qeshta
 * */

public class Problem$38
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in).useLocale(Locale.US);

        System.out.print("enter a decimal value: ");
        int number = scanner.nextInt();

        StringBuilder octal = new StringBuilder();

        if (number < 8)
            octal.append(number);
        else
        {
            while (number > 0)
            {
                octal.append(number % 8);
                number /= 8;
            }
        }
        System.out.println(octal.reverse());
    }
}

