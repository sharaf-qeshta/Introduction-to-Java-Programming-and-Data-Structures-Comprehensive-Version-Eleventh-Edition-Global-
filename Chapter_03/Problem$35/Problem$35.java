package chapter_three;

import java.util.Locale;
import java.util.Scanner;

/**
 * 3.35 (Even or odd number) Write a program that prompts the user to enter an integer and
 * displays whether the integer is an odd number or not. Here are the sample runs:
 *
 *          Enter an integer: 200
 *          200 is even number
 *
 *          Enter an integer: 211
 *          211 is odd number
 *
 * @author Sharaf Qeshta
 * */

public class Problem$35
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in).useLocale(Locale.US);

        System.out.print("Enter an integer: ");
        int x = scanner.nextInt();

        System.out.println(x + ((x % 2 == 0)? " even " : " odd ") + "number.");
    }
}

