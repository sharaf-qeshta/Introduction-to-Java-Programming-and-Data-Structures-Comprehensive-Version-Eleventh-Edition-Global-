package chapter_seven;


import java.util.Locale;
import java.util.Scanner;

/**
 * *7.30 (Pattern recognition: consecutive four equal numbers) Write the following method
 * that tests whether the array has four consecutive numbers with the same value:
 * public static boolean isConsecutiveFour(int[] values)
 * Write a test program that prompts the user to enter a series of integers and
 * displays it if the series contains four consecutive numbers with the same value. Your
 * program should first prompt the user to enter the input size—i.e., the number of
 * values in the series. Here are sample runs:
 *
 *          Enter the number of values: 8
 *          Enter the values: 3 4 5 5 5 5 4 5
 *          The list has consecutive fours
 *
 *          Enter the number of values: 9
 *          Enter the values: 3 4 5 5 6 5 5 4 5
 *          The list has no consecutive fours
 *
 * @author Sharaf Qeshta
 * */


public class Problem$30
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in).useLocale(Locale.US);
        System.out.print("Enter the number of values: ");
        int size = scanner.nextInt();

        System.out.print("Enter the values: ");
        int previousInput = scanner.nextInt();
        int occurrence = 0;
        boolean occurs = false;
        for (int i = 1; i < size; i++)
        {
            int input = scanner.nextInt();
            if (previousInput == input)
                occurrence++;
            else
            {
                if (occurrence >= 3)
                {
                    System.out.println("The list has consecutive fours");
                    occurs = true;
                    break;
                }
                occurrence = 0;
            }
            previousInput = input;
        }

        if (!occurs)
            System.out.println("The list has no consecutive fours");
    }

}
