package chapter_eight;


import java.util.Locale;
import java.util.Scanner;

/**
 * *8.23 (Game: find the flipped cell) Suppose you are given a 6-by-6 matrix filled with
 * 0s and 1s. All rows and all columns have an even number of 1s. Let the user flip
 * one cell (i.e., flip from 1 to 0 or from 0 to 1) and write a program to find which
 * cell was flipped. Your program should prompt the user to enter a 6-by-6 array
 * with 0s and 1s and find the first row r and first column c where the even number
 * of the 1s property is violated (i.e., the number of 1s is not even). The flipped cell
 * is at (r, c). Here is a sample run:
 *
 *          Enter a 6−by−6 matrix row by row:
 *          1 1 1 0 1 1
 *          1 1 1 1 0 0
 *          0 1 0 1 1 1
 *          1 1 1 1 1 1
 *          0 1 1 1 1 0
 *          1 0 0 0 0 1
 *          The flipped cell is at (0, 1)
 *
 * @author Sharaf Qeshta
 * */


public class Problem$23
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in).useLocale(Locale.US);
        int[][] matrix = new int[6][6];
        System.out.println("Enter a 6−by−6 matrix row by row: ");

        for (int i = 0; i < matrix.length;i++)
            for (int j = 0; j < matrix[i].length;j++)
                matrix[i][j] = scanner.nextInt();


        System.out.println("The flipped cell is at (" + getFlippedRow(matrix)
                + ", " + getFlippedColumn(matrix) + ")");
    }

    public static int getFlippedRow(int[][] matrix)
    {

        for (int j = 0; j < matrix.length;j++)
        {
            int numberOf1s = 0;
            for (int i = 0; i < matrix[j].length;i++)
                if (matrix[j][i] == 1)
                    numberOf1s++;

            if (numberOf1s % 2 == 1)
                return j;
        }
        return -1;
    }


    public static int getFlippedColumn(int[][] matrix)
    {

        for (int i = 0; i < matrix[0].length;i++)
        {
            int numberOf1s = 0;
            for (int j = 0; j < matrix.length;j++)
                if (matrix[j][i] == 1)
                    numberOf1s++;

            if (numberOf1s % 2 == 1)
                return i;
        }
        return -1;
    }
}
