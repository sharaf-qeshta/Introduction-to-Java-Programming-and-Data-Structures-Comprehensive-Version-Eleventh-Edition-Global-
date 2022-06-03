package chapter_eleven;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * *11.9 (Largest rows and columns) Write a program that randomly fills in 0s and 1s
 * into an n-by-n matrix, prints the matrix, and finds the rows and columns with the
 * most 1s. (Hint: Use two ArrayLists to store the row and column indices with
 * the most 1s.) Here is a sample run of the program:
 *
 *          Enter the array size n: 4
 *          The random array is
 *          0011
 *          0011
 *          1101
 *          1010
 *          The largest row index: 2
 *          The largest column index: 2, 3
 *
 * @author Sharaf Qeshta
 * */
public class Problem$09
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the array size n: ");
        int n = scanner.nextInt();

        int[][] matrix = new int[n][n];
        fill(matrix);

        for (int[] row : matrix)
        {
            for (int element : row) System.out.print(element);
            System.out.println();
        }

        ArrayList<Integer> most = new ArrayList<>();
        findRowColumn(most, matrix);

        System.out.println("The largest row index: " + most.get(0));
        System.out.println("The largest column index: " + most.get(1));
    }


    public static void fill(int[][] matrix)
    {
        for (int i = 0; i < matrix.length;i++)
            for(int j = 0; j < matrix[i].length;j++)
                matrix[i][j] = (int) ((Math.random() * 10) % 2);
    }


    public static void findRowColumn(ArrayList<Integer> most, int[][] matrix)
    {

        int max = 0;
        int numberOf1s = 0;
        for (int i = 0; i < matrix.length;i++)
        {
            int numberOf1s_ = 0;
            for(int j = 0; j < matrix[i].length;j++)
                if (matrix[i][j] == 1)
                    numberOf1s_++;
            if (numberOf1s_ > numberOf1s)
            {
                numberOf1s = numberOf1s_;
                max = i;
            }
        }

        most.add(max); // row

        numberOf1s = 0; max = 0;

        for (int j = 0; j < matrix[0].length;j++)
        {
            int numberOf1s_ = 0;
            for (int[] ints : matrix)
                if (ints[j] == 1)
                    numberOf1s_++;
            if (numberOf1s_ > numberOf1s)
            {
                numberOf1s = numberOf1s_;
                max = j;
            }
        }
        most.add(max); // column
    }
}
