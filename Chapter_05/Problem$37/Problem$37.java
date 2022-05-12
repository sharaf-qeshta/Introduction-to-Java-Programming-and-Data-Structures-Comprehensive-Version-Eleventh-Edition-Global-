package chapter_five;

import java.util.Locale;
import java.util.Scanner;

/**
 * **5.37 (Decimal to binary) Write a program that prompts the user to enter a decimal
 * integer then displays its corresponding binary value. Don’t use Java’s Integer
 * .toBinaryString(int) in this program.
 *
 * @author Sharaf Qeshta
 * */

public class Problem$37
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in).useLocale(Locale.US);

        System.out.print("enter a decimal value: ");
        int number = scanner.nextInt();

        StringBuilder binary = new StringBuilder();
        while (number > 0)
        {
            binary.append(number % 2);
            number /= 2;
        }

        System.out.println(binary.reverse());
    }
}

