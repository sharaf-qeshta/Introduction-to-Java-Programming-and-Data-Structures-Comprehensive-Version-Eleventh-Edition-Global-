package chapter_eight;


import java.util.Locale;
import java.util.Scanner;

/**
 * *8.26 (Row sorting) Implement the following method to sort the rows in a
 * two dimensional array. A new array is returned and the original array is intact.
 * public static double[][] sortRows(double[][] m)
 *  Write a test program that prompts the user to enter a 4 * 4 matrix of double
 * values and displays a new row-sorted matrix. Here is a sample run:
 *
 *          Enter a 4−by−4 matrix row by row:
 *          0.15 0.875 0.375 0.225
 *          0.55 0.005 0.225 0.015
 *          0.30 0.12 0.4 0.008
 *          0.07 0.021 0.14 0.2
 *
 *          The row−sorted array is
 *          0.15 0.225 0.375 0.875
 *          0.005 0.015 0.225 0.55
 *          0.008 0.12 0.30 0.4
 *          0.021 0.07 0.14 0.2
 *
 * @author Sharaf Qeshta
 * */

public class Problem$26
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in).useLocale(Locale.US);

        double[][] m = new double[4][4];
        System.out.println("Enter a 4−by−4 matrix row by row:");

        for (int i = 0; i < m.length;i++)
            for (int j = 0; j < m[i].length;j++)
                m[i][j] = scanner.nextDouble();

        double[][] m_ = sortRows(m);

        System.out.println("\nThe row−sorted array is");
        for (double[] row : m_)
        {
            for (double element : row)
                System.out.print(element + " ");
            System.out.println();
        }
    }
    public static double[][] sortRows(double[][] m)
    {
        double[][] m_ = m.clone();
        for (int i = 0; i < m_.length;i++)
        {
            boolean sorted = false;
            while (!sorted)
            {
                sorted = true;
                for (int j = 0; j < m_[i].length-1; j++)
                    if (m_[i][j] > m_[i][j+1])
                    {
                        double temp = m_[i][j];
                        m_[i][j] = m_[i][j+1];
                        m_[i][j+1] = temp;
                        sorted = false;
                    }
            }
        }
        return m_;
    }
}
