package chapter_ten;

import chapter_ten.samples.StackOfIntegers;

import java.util.Scanner;

/**
 * *10.5 (Display the prime factors) Write a program that prompts the user to enter a
 * positive integer and displays all its smallest factors in decreasing order. For
 * example, if the integer is 120, the smallest factors are displayed as 5, 3, 2, 2,
 * 2. Use the StackOfIntegers class to store the factors (e.g., 2, 2, 2, 3, 5) and
 * retrieve and display them in reverse order.
 *
 * @author Sharaf Qeshta
 * */

public class Problem$05
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter a positive integer: ");
        int number = input.nextInt();

        System.out.print("The smallest factors of " + number + " are: ");
        StackOfIntegers stack = new StackOfIntegers();

        smallestFactors(number, stack);

        while (!stack.empty())
            System.out.print(stack.pop() + " ");
    }

    public static void smallestFactors(int number, StackOfIntegers stack)
    {
        int i = 2; // Potential prime factor
        while (number / i != 1)
        {
            if (number % i == 0)
            {
                stack.push(i);
                number /= i;
            }
            else
                i++;
        }
        stack.push(number);
    }
}
