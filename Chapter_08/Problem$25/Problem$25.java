package chapter_eight;


import java.util.Locale;
import java.util.Scanner;

/**
 * *8.25 (Markov matrix) An n * n matrix is called a positive Markov matrix if each
 * element is positive and the sum of the elements in each column is 1. Write the
 * following method to check whether a matrix is a Markov matrix:
 * public static boolean isMarkovMatrix(double[][] m)
 *  Write a test program that prompts the user to enter a 3 * 3 matrix of double
 * values and tests whether it is a Markov matrix. Here are sample runs:
 *
 *          Enter a 3−by−3 matrix row by row:
 *          0.15 0.875 0.375
 *          0.55 0.005 0.225
 *          0.30 0.12 0.4
 *          It is a Markov matrix
 *
 *          Enter a 3−by−3 matrix row by row:
 *          0.95 -0.875 0.375
 *          0.65 0.005 0.225
 *          0.30 0.22 -0.4
 *          It is not a Markov matrix
 *
 * @author Sharaf Qeshta
 * */



public class Problem$25
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in).useLocale(Locale.US);

        double[][] m = new double[3][3];
        System.out.println("Enter a 3−by−3 matrix row by row:");

        for (int i = 0; i < m.length;i++)
            for (int j = 0; j < m[i].length;j++)
                m[i][j] = scanner.nextDouble();

        if (isMarkovMatrix(m))
            System.out.println("It is a Markov matrix");
        else
            System.out.println("It is not a Markov matrix");
    }

    public static boolean isMarkovMatrix(double[][] m)
    {
        for (int i = 0; i < m[0].length;i++)
        {
            int sum = 0;
            for (int j = 0; j < m.length;j++)
            {
                if (m[j][i] < 0)
                    return false;

                sum += m[j][i];
            }
            if (Math.round(sum) == 1)
                return false;
        }
        return true;
    }
}
