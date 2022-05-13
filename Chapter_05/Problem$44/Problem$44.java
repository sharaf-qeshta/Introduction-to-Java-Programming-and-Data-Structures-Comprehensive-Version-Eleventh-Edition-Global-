package chapter_five;

import java.util.Locale;
import java.util.Scanner;

/**
 * *5.44 (Computer architecture: bit-level operations) A byte value is stored in 8 bits. Write
 * a program that prompts the user to enter a byte integer and displays the 8 bits for
 * the integer. Here are sample runs:
 *
 *              Enter an integer: 5
 *              The 8 bits are 00000101
 *
 *              Enter an integer: –5
 *              The 8 bits are 11111011
 *
 * @author Sharaf Qeshta*/


public class Problem$44
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in).useLocale(Locale.US);

        System.out.print("Enter an integer: ");
        byte input = scanner.nextByte();

        StringBuilder bits = new StringBuilder();

        for (int i = 0; i < 8; i++)
        {
            bits.insert(0, (input & 1));
            input >>= 1;
        }

        System.out.println("The bits are " + bits);
    }
}

