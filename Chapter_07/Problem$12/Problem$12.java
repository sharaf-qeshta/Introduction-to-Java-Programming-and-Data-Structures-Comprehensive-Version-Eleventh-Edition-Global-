package chapter_seven;

import java.util.Arrays;
import java.util.Locale;
import java.util.Scanner;

/**
 * *7.12 (Reverse an array) The reverse method in Section 7.7 reverses an array by
 * copying it to a new array. Rewrite the method that reverses the array passed in
 * the argument and returns this array. Write a test program that prompts the user to
 * enter 10 numbers, invokes the method to reverse the numbers, and displays the
 * numbers.
 *
 * @author Sharaf Qeshta
 * */

public class Problem$12
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in).useLocale(Locale.US);

        System.out.print("Enter 10 numbers: ");

        double[] numbers = new double[10];

        for (int i = 0; i < 10; i++)
            numbers[i] = scanner.nextDouble();

        System.out.println(Arrays.toString(reverse(numbers)));
    }

    /** reverse an array  */
    public static double[] reverse(double[] in)
    {
        double[] out = new double[in.length];

        for (int i = 0, j = in.length-1;i < in.length;i++, j--)
            out[j] = in[i];

        return out;
    }
}
