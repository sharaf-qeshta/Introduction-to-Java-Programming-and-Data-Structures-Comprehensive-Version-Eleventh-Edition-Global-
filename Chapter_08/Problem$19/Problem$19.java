package chapter_eight;

import java.util.Locale;
import java.util.Scanner;

/**
 * **8.19 (Pattern recognition: four consecutive equal numbers) Write the following
 * method that tests whether a two-dimensional array has four consecutive numbers
 * of the same value, either horizontally, vertically, or diagonally:
 * public static boolean isConsecutiveFour(int[][] values)
 *
 * Write a test program that prompts the user to enter the number of rows and
 * columns of a two-dimensional array then the values in the array, and displays true
 * if the array contains four consecutive numbers with the same value. Otherwise,
 * the program displays false. Here are some examples of the true cases:
 *
 * @author Sharaf Qeshta
 * */


public class Problem$19
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in).useLocale(Locale.US);
        System.out.print("Enter the number of rows and columns: ");
        int rows = scanner.nextInt(), columns = scanner.nextInt();

        int[][] m = new int[rows][columns];
        for (int i = 0; i< m.length;i++)
            for (int j = 0; j< m[i].length;j++)
                m[i][j] = scanner.nextInt();

        System.out.println( checkRows(m) || checkColumns(m) || checkDiagonals(m) );
    }

    public static boolean checkRows(int[][] matrix)
    {
        for (int[] ints : matrix)
        {
            int repeated = 0, element = ints[0];
            for (int j = 0; j < matrix[0].length; j++)
            {
                if (element == ints[j])
                    repeated++;
                else
                {
                    element = ints[j];
                    if (repeated == 4)
                        return true;
                    repeated = 0;
                }
            }
        }
        return false;
    }


    public static boolean checkColumns(int[][] matrix)
    {
        for (int i = 0; i < matrix[0].length; i++)
        {
            int repeated = 1, element = matrix[0][i];
            for (int[] ints : matrix)
            {
                if (element == ints[i])
                {
                    if (++repeated == 4)
                        return true;
                }
                else
                {
                    element = ints[i];
                    repeated = 1;
                }
            }
        }
        return false;
    }



    public static boolean checkDiagonals(int[][] matrix)
    {
        for (int i = 0; i < matrix.length-1;i++)
        {
            int row = i, column = 0, repeated = 0, element = matrix[i][0];
            while (row < matrix.length && column < matrix[i].length)
            {
                if (matrix[row][column] == element)
                {
                    if (++repeated == 4)
                        return true;
                }
                else
                {
                    element = matrix[row][column];
                    repeated = 0;
                }
                row++;column++;
            }
        }

        for (int i = 0; i < matrix.length-1;i++)
        {
            int row = i, column = matrix[0].length-1, repeated = 1, element = matrix[i][0];
            while (row < matrix.length && column > -1)
            {
                if (matrix[row][column] == element)
                {
                    if (++repeated == 4)
                        return true;
                }
                else
                {
                    element = matrix[row][column];
                    repeated = 1;
                }
                row++;column--;
            }
        }
        return false;
    }
}
