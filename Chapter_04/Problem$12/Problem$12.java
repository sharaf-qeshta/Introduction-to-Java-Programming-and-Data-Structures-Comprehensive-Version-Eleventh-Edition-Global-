package chapter_four;

import java.util.Locale;
import java.util.Scanner;


/**
 * 4.12 (Hex to binary) Write a program that prompts the user to enter a hex digit and
 * displays its corresponding binary number. For an incorrect input, display invalid
 * input. Here is a sample run:
 *
 *      Enter a hex digit: B
 *      The binary value is 1011
 *
 *      Enter a hex digit: G
 *      G is an invalid input
 *
 * @author Sharaf Qeshta
 * */

public class Problem$12
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in).useLocale(Locale.US);

        System.out.print("Enter a hex digit: ");
        String hexDigit = scanner.next();

        char digit = hexDigit.charAt(0);
        if (Character.isLetter(digit))
            digit = Character.toUpperCase(digit);

        String binary = switch (digit)
        {
            case '0' -> "0000";
            case '1' -> "0001";
            case '2' -> "0010";
            case '3' -> "0011";
            case '4' -> "0100";
            case '5' -> "0101";
            case '6' -> "0110";
            case '7' -> "0111";
            case '8' -> "1000";
            case '9' -> "1001";
            case 'A' -> "1010";
            case 'B' -> "1011";
            case 'C' -> "1100";
            case 'D' -> "1101";
            case 'E' -> "1110";
            case 'F' -> "1111";
            default -> null;
        };

        if (binary == null)
            System.out.println(digit + " is an invalid input");
        else
            System.out.println("The binary value is " + binary);
    }
}
