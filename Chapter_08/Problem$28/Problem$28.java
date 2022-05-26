package chapter_eight;


import java.util.Locale;
import java.util.Scanner;

/**
 * 8.28 (Strictly identical arrays) The two-dimensional arrays m1 and m2 are strictly
 * identical if their corresponding elements are equal. Write a method that returns
 * true if m1 and m2 are strictly identical, using the following header:
 * public static boolean equals(int[][] m1, int[][] m2)
 *  Write a test program that prompts the user to enter two 3 * 3 arrays of integers
 * and displays whether the two are strictly identical. Here are the sample runs:
 *
 *          Enter list1: 51 22 25 6 1 4 24 54 6
 *          Enter list2: 51 22 25 6 1 4 24 54 6
 *          The two arrays are strictly identical
 *
 *          Enter list1: 51 25 22 6 1 4 24 54 6
 *          Enter list2: 51 22 25 6 1 4 24 54 6
 *          The two arrays are not strictly identical
 * @author Sharaf Qeshta
 * */



public class Problem$28
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in).useLocale(Locale.US);

        int[][] m1 = new int[3][3];
        int[][] m2 = new int[3][3];
        System.out.print("Enter list1: ");

        for (int i = 0; i < m1.length;i++)
            for (int j = 0; j < m1[i].length;j++)
                m1[i][j] = scanner.nextInt();

        System.out.print("Enter list2: ");
        for (int i = 0; i < m2.length;i++)
            for (int j = 0; j < m2[i].length;j++)
                m2[i][j] = scanner.nextInt();

        if (equals(m1, m2))
            System.out.println("The two arrays are strictly identical");
        else
            System.out.println("The two arrays are not strictly identical");
    }

    public static boolean equals(int[][] m1, int[][] m2)
    {
        for (int i = 0; i < m1.length;i++)
        {
            for (int j = 0; j < m1[i].length;j++)
            {
                if (m1[i][j] != m2[i][j])
                    return false;
            }
        }
        return true;
    }
}
