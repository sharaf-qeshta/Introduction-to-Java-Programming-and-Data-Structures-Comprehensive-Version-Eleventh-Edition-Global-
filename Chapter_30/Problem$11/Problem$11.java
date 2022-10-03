package chapter_thirty;

import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * 30.11 (Convert hex to decimal) Write a program that prompts the user to enter a hex
 * number in string and displays its decimal value. Use Stream’s reduce method
 * to convert a hex number to decimal.
 *
 *
 * @author Sharaf Qeshta
 * */
public class Problem$11
{
    public static int p = 0;
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a hexadecimal value: ");
        String hex = scanner.next().toUpperCase();

        int[] values = new int[hex.length()];
        int j = 0;
        for (int i = hex.length()-1; i > -1; i--)
        {
            int value;
            if (Character.isLetter(hex.charAt(i)))
                value = hex.charAt(i) - 55;
            else
                value = Integer.parseInt(hex.charAt(i) + "");
            values[j++] = value;
        }

        System.out.println("the decimal representation of " + hex + " is "
                + IntStream.of(values).reduce(0, (e1, e2) -> e1 + e2 * (int) Math.pow(16, p++)));
    }
}
