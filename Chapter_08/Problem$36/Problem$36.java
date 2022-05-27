package chapter_eight;

import java.util.Locale;
import java.util.Scanner;

/**
 * **8.36 (Latin square) A Latin square is an n-by-n array
 * filled with n different Latin letters, each occurring exactly once in each row and once in each column.
 * Write a program that prompts the user to enter the number n and the array of characters,
 * as shown in the sample output, and checks if the input array is a Latin square.
 * The characters are the first n characters starting from A.
 *
 *              Enter number n: 4
 *              Enter 4 rows of letters separated by spaces:
 *              A B C D
 *              B A D C
 *              C D B A
 *              D C A B
 *              The input array is a Latin square
 *
 *              Enter number n: 3
 *              Enter 3 rows of letters separated by spaces:
 *              A F D
 *              Wrong input: the letters must be from A to C
 *
 * @author Sharaf Qeshta
 * */

public class Problem$36
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in).useLocale(Locale.US);

        System.out.print("Enter number n: ");
        int size = scanner.nextInt();


        char[][] m = new char[size][size];
        System.out.println("Enter "+  size +" rows of letters separated by spaces: ");

        String wrongMessage = "Wrong input: the letters must be from "
                + 'A' + " to " +  ((char) (65 + (size-1)));

        for (int i = 0;i <  m.length;i++)
        {
            for (int j = 0; j < m[i].length;j++)
            {
                String input = scanner.next();
                char x = input.charAt(0);
                if (!checkInRange(size, x))
                {
                    System.out.println(wrongMessage);
                    System.exit(-1);
                }
                m[i][j] = x;
            }
        }

        if (isLatinSquare(m))
            System.out.println("The input array is a Latin square ");
        else
            System.out.println("The input array isn`t a Latin square ");
    }


    public static boolean isLatinSquare(char[][] latinMatrix)
    {
        for (int i = 0;i <  latinMatrix.length;i++)
            for (int j = 0; j < latinMatrix[i].length;j++)
                if (!occursOnce(latinMatrix, i, j))
                    return false;
        return true;
    }


    public static boolean occursOnce(char[][] matrix, int row, int column)
    {
        int occursVertical = 0, occursHorizontal = 0;
        for (int i = 0; i < matrix[row].length;i++)
            if (matrix[row][i] == matrix[row][column])
                occursHorizontal++;

        for (int i = 0; i < matrix.length;i++)
            if (matrix[i][column] == matrix[row][column])
                occursVertical++;

        return occursHorizontal < 2 & occursVertical < 2;
    }


    public static char[] createRange(int n)
    {
        char[] range = new char[n];
        for (int i = 0; i < n;i++)
            range[i] = (char) (65 + i);
        return range;
    }


    public static boolean checkInRange(int n, char element)
    {
        return element > 64 & element < (65 + n);
    }
}
