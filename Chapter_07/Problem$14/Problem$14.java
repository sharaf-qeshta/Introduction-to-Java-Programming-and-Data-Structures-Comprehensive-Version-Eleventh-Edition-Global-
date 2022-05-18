package chapter_seven;

import java.util.Locale;
import java.util.Scanner;

/**
 * 7.14 (Computing lcm) Write a method that returns the lcm (least common multiple) of
 * an unspecified number of integers. The method header is specified as follows:
 * public static int lcm(int... numbers)
 *  Write a test program that prompts the user to enter five numbers, invokes the
 * method to find the lcm of these numbers, and displays the lcm.
 *
 * @author Sharaf Qeshta
 * */

public class Problem$14
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in).useLocale(Locale.US);

        System.out.print("Enter 5 Numbers: ");
        int[] numbers = new int[5];
        for (int i = 0; i < numbers.length; i++)
            numbers[i] = scanner.nextInt();

        System.out.println("The Least Common Multiple is " + lcm(numbers));
    }

    public static int lcm(int... numbers)
    {
        int max = getMax(numbers);
        boolean found = false;
        int counter = 1;
        int lcm = -1;
        while (!found)
        {
            found = true;
            lcm = max * counter;
            for (int i = 0; i < numbers.length; i++)
            {
                if (lcm % numbers[i] != 0)
                {
                    found = false;
                    break;
                }
            }
            counter++;
        }
        return lcm;
    }


    public static int getMax(int... numbers)
    {
        int max = numbers[0];
        for (int i = 0; i < numbers.length; i++)
            if (numbers[i] > max)
                max = numbers[i];
        return max;
    }
}
