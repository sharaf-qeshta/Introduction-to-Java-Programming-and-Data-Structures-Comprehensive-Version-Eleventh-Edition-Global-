package chapter_thirty;

import java.util.Scanner;

/**
 * 30.12 (Sum the digits in an integer) Rewrite Programming Exercise 6.2 using streams.
 *
 *
 * @author Sharaf Qeshta
 * */
public class Problem$12
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter an Integer: ");

        int sum = scanner.next().chars().map(Character::getNumericValue).sum();
        System.out.println("The sum of the digits is " + sum);
    }
}
