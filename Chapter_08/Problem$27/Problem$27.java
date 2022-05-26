package chapter_eight;


import java.util.Locale;
import java.util.Scanner;

/**
 * *8.27 (Column sorting) Implement the following method to sort the columns in a two
 * dimensional array. A new array is returned and the original array is intact.
 * public static double[][] sortColumns(double[][] m)
 * Write a test program that prompts the user to enter a 4 * 4 matrix of double
 * values and displays a new column-sorted matrix. Here is a sample run:
 *
 *              Enter a 4−by−4 matrix row by row:
 *              0.15 0.875 0.375 0.225
 *              0.55 0.005 0.225 0.015
 *              0.30 0.12 0.4 0.008
 *              0.07 0.021 0.14 0.2
 *
 *              The column−sorted array is
 *              0.07 0.005 0.14 0.008
 *              0.15 0.021 0.225 0.015
 *              0.30 0.12 0.375 0.2
 *              0.55 0.875 0.4 0.225
 *
 * @author Sharaf Qeshta
 * */



public class Problem$27
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in).useLocale(Locale.US);

        double[][] m = new double[4][4];
        System.out.println("Enter a 4−by−4 matrix row by row:");

        for (int i = 0; i < m.length;i++)
            for (int j = 0; j < m[i].length;j++)
                m[i][j] = scanner.nextDouble();

        double[][] m_ = sortColumns(m);

        System.out.println("\nThe column−sorted array is");
        for (double[] row : m_)
        {
            for (double element : row)
                System.out.print(element + " ");
            System.out.println();
        }
    }

    public static double[][] sortColumns(double[][] m)
    {
        double[][] m_ = m.clone();
        for (int i = 0; i < m_[0].length;i++)
        {
            boolean sorted = false;
            while (!sorted)
            {
                sorted = true;
                for (int j = 0; j < m_.length-1;j++)
                    if (m_[j][i] > m_[j+1][i])
                    {
                        double temp = m_[j][i];
                        m_[j][i] = m_[j+1][i];
                        m_[j+1][i] = temp;
                        sorted = false;
                    }
            }
        }
        return m_;
    }
}
