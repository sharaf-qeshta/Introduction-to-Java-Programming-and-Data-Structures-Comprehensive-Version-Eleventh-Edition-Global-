package chapter_eight;

import java.util.Locale;
import java.util.Scanner;

/**
 * **8.35 (Largest block) Given a square matrix with the elements 0 or 1, write a program to
 * find a maximum square submatrix whose elements are all 1s. Your program should
 * prompt the user to enter the number of rows in the matrix. The program then
 * displays the location of the first element in the maximum square submatrix and the
 * number of rows in the submatrix. Here is a sample run:
 *
 *          Enter the number of rows in the matrix: 5
 *          Enter the matrix row by row:
 *          1 0 1 0 1
 *          1 1 1 0 1
 *          1 0 1 1 1
 *          1 0 1 1 1
 *          1 0 1 1 1
 *
 *          The maximum square submatrix is at (2, 2) with size 3
 *
 * Your program should implement and use the following method to find the maximum square submatrix:
 * public static int[] findLargestBlock(int[][] m)
 *  The return value is an array that consists of three values. The first two values are
 * the row and column indices for the first element in the submatrix, and the third
 * value is the number of the rows in the submatrix.
 *
 * @author Sharaf Qeshta
 * */

public class Problem$35
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in).useLocale(Locale.US);

        System.out.print("Enter the number of rows in the matrix: ");
        int size = scanner.nextInt();

        int[][] m = new int[size][size];
        System.out.println("Enter the matrix row by row: ");

        for (int i = 0;i <  m.length;i++)
            for (int j = 0; j < m[i].length;j++)
                m[i][j] = scanner.nextInt();

        int[] largeSubMatrix = findLargestBlock(m);

        if (largeSubMatrix[0] != -1)
            System.out.println("The maximum square submatrix is at ("
                    + largeSubMatrix[0] + ", "  + largeSubMatrix[1] + ") with size "
                    + largeSubMatrix[2]);
    }



    public static int[] findLargestBlock(int[][] m)
    {
        int[] output = new int[3];
        for (int i = 0;i <  m.length;i++)
        {

            for (int j = 0; j < m[i].length-1;j++)
            {
                if (m[i][j] == 1)
                {
                    int rows = check(m, i, j);
                    if (rows > 1)
                    {
                        output[0] = i;
                        output[1] = j;
                        output[2] = rows;
                        return output;
                    }
                }
            }
        }
        output[0] = -1;
        return output;
    }

    public static int check(int[][] m, int row, int column)
    {
        int rows = 0;
        for (int i = row;i <  m.length;i++)
        {
            for (int j = column; j < m[i].length;j++)
            {
                if (m[i][j] != 1)
                {
                    return rows;
                }
            }
            rows++;
        }
        return rows;
    }
}
