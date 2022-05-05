package chapter_three;

import java.util.Locale;
import java.util.Scanner;

/**
 * 3.26 (Use the &&, || and ^ operators) Write a program that prompts the user to enter
 * an integer and determines whether it is divisible by 4 and 5, whether it is divisible
 * by 4 or 5, and whether it is divisible by 4 or 5 but not both. Here is a sample run of
 * this program:
 *
 *          Enter an integer: 10
 *          Is 10 divisible by 4 and 5? false
 *          Is 10 divisible by 4 or 5? true
 *          Is 10 divisible by 4 or 5 but not both? true
 *
 * @author Sharaf Qeshta
 * */

public class Problem$26
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in).useLocale(Locale.US);

        System.out.print("Enter an integer: ");
        int x = scanner.nextInt();

        boolean xDivisibleBy4 = x % 4 == 0;
        boolean xDivisibleBy5 = x % 5 == 0;

        System.out.println("Is 10 divisible by 4 and 5? " + (xDivisibleBy4 && xDivisibleBy5));
        System.out.println("Is 10 divisible by 4 or 5? " + (xDivisibleBy4 || xDivisibleBy5));
        System.out.println("Is 10 divisible by 4 or 5 but not both? " + (xDivisibleBy4 ^ xDivisibleBy5));
    }
}

