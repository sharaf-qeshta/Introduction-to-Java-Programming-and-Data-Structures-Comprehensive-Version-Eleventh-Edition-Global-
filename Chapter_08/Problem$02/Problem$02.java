package chapter_eight;

import java.util.Locale;
import java.util.Scanner;

/**
 * *8.2 (Average the major diagonal in a matrix) Write a method that averages all the
 * numbers in the major diagonal in an n * n matrix of double values using the
 * following header:
 * public static double averageMajorDiagonal(double[][] m)
 *  Write a test program that reads a 4-by-4 matrix and displays the average of all its
 * elements on the major diagonal. Here is a sample run:
 *
 *      Enter a 4−by−4 matrix row by row:
 *      1 2 3 4.0
 *      5 6.5 7 8
 *      9 10 11 12
 *      13 14 15 16
 *
 *      Average of the elements in the major diagonal is 8.625
 *
 * @author Sharaf Qeshta
 * */

public class Problem$02
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in).useLocale(Locale.US);

        System.out.println("Enter a 4−by−4 matrix row by row: ");
        double[][] matrix = new double[4][4];

        for (int i = 0; i < 4;i++)
            for (int j = 0; j < 4;j++)
                matrix[i][j] = scanner.nextDouble();

        System.out.println("Average of the elements in the major diagonal is " + averageMajorDiagonal(matrix));
    }

    public static double averageMajorDiagonal(double[][] m)
    {
        double sum = 0;
        for (int i = 0; i < m.length;i++)
            sum += m[i][i];
        return sum / m.length;
    }
}
