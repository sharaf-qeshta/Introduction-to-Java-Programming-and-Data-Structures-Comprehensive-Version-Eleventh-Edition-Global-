package chapter_eight;

import java.util.Locale;
import java.util.Scanner;

/**
 * **8.14 (Explore matrix) Write a program that prompts the user to enter the length of a
 * square matrix, randomly fills in 0s and 1s into the matrix, prints the matrix, and
 * finds the rows, columns, and diagonals with all 0s or 1s. Here is a sample run of
 * the program:
 *
 *      Enter the size for the matrix: 4
 *      0111
 *      0000
 *      0100
 *      1111
 *      All 0s on row 2
 *      All 1s on row 4
 *      No same numbers on a column
 *      No same numbers on the major diagonal
 *      No same numbers on the sub−diagonal
 *
 * @author Sharaf Qeshta
 * */

public class Problem$14
{
    public final static String[] output = new String[16];
    public static int index = 0;

    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in).useLocale(Locale.US);

        System.out.print("Enter the size for the matrix: ");
        int size = scanner.nextInt();

        int[][] matrix = new int[size][size];


        for (int i = 0; i < size; i++)
            for (int j = 0; j < size; j++)
                matrix[i][j] = (int) ((Math.random() * 10) % 2);

        for (int[] row: matrix)
        {
            for (int element: row)
                System.out.print(element);
            System.out.println();
        }

        checkRows(matrix); checkColumns(matrix); checkDiagonals(matrix); checkMajorDiagonal(matrix);
        for (int i = 0; i < index; i++)
            System.out.println(output[i]);
    }


    public static void checkRows(int[][] matrix)
    {
        boolean noUnique = true;
        for (int i = 0; i < matrix.length;i++)
        {
            boolean unique = true;
            int firstElement = matrix[i][0];
            for (int j = 0; j < matrix[i].length;j++)
            {
                if (matrix[i][j] != firstElement){
                    unique = false;
                    break;
                }
            }
            if (unique){
                noUnique = false;
                output[index] = "All "+ firstElement + "s on row " + i;
                index++;
            }
        }

        if (noUnique){
            output[index] = "No same numbers on a row";
            index++;
        }
    }


    public static void checkColumns(int[][] matrix)
    {
        boolean noUnique = true;
        for (int i = 0; i < matrix[0].length;i++)
        {
            boolean unique = true;
            int firstElement = matrix[0][i];
            for (int[] ints : matrix)
            {
                if (ints[i] != firstElement)
                {
                    unique = false;
                    break;
                }
            }

            if (unique)
            {
                noUnique = false;
                output[index] = "All "+ firstElement + "s on column " + i;
                index++;
            }
        }

        if (noUnique)
        {
            output[index] = "No same numbers on a column";
            index++;
        }
    }


    public static void checkDiagonals(int[][] matrix)
    {
        boolean noUnique = true;
        for (int i = 1; i < matrix.length-1;i++)
        {
            boolean unique = true;
            int row = i, column = 0;
            int firstElement = matrix[row][column];
            while (row < matrix.length-1 && column < matrix[i].length-1)
            {
                if (matrix[row][column] != firstElement)
                {
                    unique = false;
                    break;
                }
                row++;column++;
            }
            if (unique)
            {
                noUnique = false;
                output[index] = "All "+ firstElement + "s on diagonal " + i;
                index++;
            }
        }

        for (int i = 1; i < matrix[0].length-1;i++)
        {
            boolean unique = true;
            int row = 0, column = i;
            int firstElement = matrix[row][column];
            while (row < matrix.length-1 && column < matrix[i].length-1)
            {
                if (matrix[row][column] != firstElement)
                {
                    unique = false;
                    break;
                }
                row++;column++;
            }

            if (unique)
            {
                noUnique = false;
                output[index] = "All "+ firstElement + "s on diagonal " + i;
                index++;
            }
        }

        if (noUnique)
        {
            output[index] = "No same numbers on the sub−diagonal";
            index++;
        }
    }


    public static void checkMajorDiagonal(int[][] matrix)
    {
        boolean unique = true;
        int firstElement = matrix[0][0];
        for (int i = 1; i < matrix.length;i++)
        {
            if (firstElement != matrix[i][i])
            {
                unique =false;
                break;
            }
        }

        if (unique)
            output[index] = "All "+ firstElement + "s on the major diagonal ";
        else
            output[index] = "No same numbers on the major diagonal";
        index++;
    }
}
