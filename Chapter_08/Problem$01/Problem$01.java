package chapter_eight;

import java.util.Locale;
import java.util.Scanner;

/**
 * *8.1 (Sum elements row by row) Write a method that returns the sum of all the elements
 * in a specified row in a matrix using the following header:
 * public static double sumRow(double[][] m, int rowIndex)
 * Write a test program that reads a 3-by-4 matrix and displays the sum of each row.
 * Here is a sample run:
 *
 *      Enter a 3−by−4 matrix row by row:
 *      1.5 2 3 4
 *      5.5 6 7 8
 *      9.5 1 3 1
 *
 *     Sum of the elements at row 0 is 10.5
 *     Sum of the elements at row 1 is 26.5
 *     Sum of the elements at row 2 is 14.5
 *
 * @author Sharaf Qeshta
 * */

public class Problem$01
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in).useLocale(Locale.US);

        System.out.println("Enter a 3−by−4 matrix row by row: ");
        double[][] matrix = new double[3][4];

        for (int i = 0; i < 3;i++)
            for (int j = 0; j < 4;j++)
                matrix[i][j] = scanner.nextDouble();

        System.out.println("Sum of the elements at row 0 is " + sumRow(matrix, 0));
        System.out.println("Sum of the elements at row 1 is " + sumRow(matrix, 1));
        System.out.println("Sum of the elements at row 2 is " + sumRow(matrix, 2));
    }

    public static double sumRow(double[][] m, int rowIndex)
    {
        double sum = 0;
        for (int i = 0; i < m[rowIndex].length;i++)
            sum += m[rowIndex][i];
        return sum;
    }
}
