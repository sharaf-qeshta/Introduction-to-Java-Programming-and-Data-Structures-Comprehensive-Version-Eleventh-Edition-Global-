package chapter_nine;

import java.util.Locale;
import java.util.Scanner;

/**
 * **9.13 (The Location class) Design a class named Location for locating a maximal
 * value and its location in a two-dimensional array. The class contains public data
 * fields row, column, and maxValue that store the maximal value and its indices in
 * a two-dimensional array with row and column as int types and maxValue as a
 * double type.
 * Write the following method that returns the location of the largest element in a
 * two-dimensional array:
 * public static Location locateLargest(double[][] a)
 *  The return value is an instance of Location. Write a test program that prompts
 * the user to enter a two-dimensional array and displays the location of the largest
 * element in the array. Here is a sample run:
 *
 *              Enter the number of rows and columns in the array: 3 4
 *              Enter the array:
 *              23.5 35 2 10
 *              4.5 3 45 3.5
 *              35 44 5.5 9.6
 *              The location of the largest element is 45 at (1, 2)
 *
 * @author Sharaf Qeshta
 * */

public class Problem$13
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in).useLocale(Locale.US);

        System.out.print("Enter the number of rows and columns in the array: ");
        int rows = scanner.nextInt(), columns = scanner.nextInt();

        System.out.println("Enter the array:");
        double[][] a = new double[rows][columns];

        for (int i = 0; i < a.length; i++)
            for (int j = 0; j < a[i].length;j++)
                a[i][j] = scanner.nextDouble();

        Location maxValue = locateLargest(a);
        System.out.println("The location of the largest element is " + maxValue.maxValue
                + " at (" + maxValue.row + ", " + maxValue.column+ ")");
    }

    public static Location locateLargest(double[][] a)
    {
        Location location = new Location();
        int row = 0,  column = 0;
        double maxValue = a[row][column];
        for (int i = 0; i < a.length; i++)
        {
            for (int j = 0; j < a[i].length;j++)
            {
                if (a[i][j] > maxValue)
                {
                    maxValue = a[i][j];
                    row = i; column = j;
                }
            }
        }

        location.column = column;location.row = row;
        location.maxValue = maxValue;
        return location;
    }
}
