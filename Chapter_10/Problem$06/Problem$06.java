package chapter_ten;

import chapter_ten.samples.StackOfIntegers;

import java.util.Scanner;

/**
 * *10.6 (Display the prime numbers) Write a program that displays all the prime numbers
 * less than 120 in decreasing order. Use the StackOfIntegers class to
 * store the prime numbers (e.g., 2, 3, 5, . . . ) and retrieve and display them in
 * reverse order.
 *
 * @author Sharaf Qeshta
 * */

public class Problem$06
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter a positive integer: ");
        int number = input.nextInt();

        System.out.print("prime numbers less than " + number + " is ");
        StackOfIntegers stack = new StackOfIntegers();

        getAllPrimes(number, stack);
        stack.reverse();

        while (!stack.empty())
            System.out.print(stack.pop() + " ");
    }

    public static void getAllPrimes(int number, StackOfIntegers stack)
    {
        for (int i = 2; i < (number+1);i++)
            if (isPrime(i))
                stack.push(i);
    }

    public static boolean isPrime(int number)
    {
        if (number == 2)
            return true;
        for (int i = 2; i < number;i++)
            if (number % i == 0)
                return false;
        return true;
    }
}
