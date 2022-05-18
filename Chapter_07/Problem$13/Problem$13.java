package chapter_seven;

import java.util.Locale;
import java.util.Scanner;

/**
 * *7.13 (Random number selector) Write a method that returns a random number from a
 * list of numbers passed in the argument. The method header is specified as follows:
 * public static int getRandom(int... numbers)
 *
 * @author Sharaf Qeshta
 * */

public class Problem$13
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in).useLocale(Locale.US);

        System.out.print("Enter 10 numbers: ");

        int[] numbers = new int[10];

        for (int i = 0; i < 10; i++)
            numbers[i] = scanner.nextInt();

        System.out.println("The Random Number selected is " + getRandom(numbers));
    }

    /** get random element  */
    public static int getRandom(int... numbers)
    {
        return numbers[(int) ((Math.random() * (numbers.length*2)) % numbers.length)];
    }
}
