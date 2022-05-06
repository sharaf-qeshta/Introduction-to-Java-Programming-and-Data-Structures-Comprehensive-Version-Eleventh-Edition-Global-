package chapter_four;

import java.util.Locale;
import java.util.Scanner;


/**
 * *4.11 (Binary to decimal) Write a program that prompts the user to enter binary digits
 * and displays its corresponding decimal value. Here are some sample runs:
 *
 *      Enter binary digits (0000 to 1111): 0111
 *      The decimal value is 7
 *
 *      Enter binary digits (0000 to 1111): 1001
 *      The decimal value is 9
 *
 *      Enter binary digits (0000 to 1111): 1100
 *      The decimal value is 12
 *
 * @author Sharaf Qeshta
 * */

public class Problem$11
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in).useLocale(Locale.US);

        System.out.print("Enter binary digits (0000 to 1111): ");
        String binary = scanner.next();


        int char1 = Integer.parseInt(binary.charAt(0) + "");
        int char2 = Integer.parseInt(binary.charAt(1) + "");
        int char3 = Integer.parseInt(binary.charAt(2) + "");
        int char4 = Integer.parseInt(binary.charAt(3) + "");

        int decimalValue = (char4) + (char3 * 2) + (char2 * 4)  + (char1 * 8);

        System.out.println("The decimal value is " + decimalValue);
    }
}
