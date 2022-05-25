package chapter_eight;

import java.util.Locale;
import java.util.Scanner;

/**
 * *8.13 (Locate the smallest element) Write the following method that returns the location
 * of the smallest element in a two-dimensional array.
 *  public static int[] locateSmallest(double[][] a)
 *  The return value is a one-dimensional array that contains two elements. These
 * two elements indicate the row and column indices of the smallest element in the
 * two-dimensional array. Write a test program that prompts the user to enter a two
 * dimensional array and displays the location of the smallest element in the array.
 * Here is a sample run:
 *
 *      Enter the number of rows and columns of the array: 3 4
 *      Enter the array:
 *      23.5 35 2 10
 *      4.5 3 45 3.5
 *      35 44 5.5 9.6
 *      The location of the smallest element is at (0, 2)
 *
 * @author Sharaf Qeshta
 * */

public class Problem$13
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in).useLocale(Locale.US);

        System.out.print("Enter the number of rows and columns of the array: ");
        int rows = scanner.nextInt(), columns = scanner.nextInt();

        System.out.println("Enter the array: ");
        int x = 0, y = 0;
        double smallest = Double.MAX_VALUE;

        for (int i = 0; i < rows; i++)
            for (int j = 0; j < columns; j++)
            {
                double input = scanner.nextDouble();
                if (input < smallest)
                {
                    smallest = input;
                    x = i; y = j;
                }
            }

        System.out.println("The location of the smallest element is at ("
                + x + ", " + y + ")");
    }
}
