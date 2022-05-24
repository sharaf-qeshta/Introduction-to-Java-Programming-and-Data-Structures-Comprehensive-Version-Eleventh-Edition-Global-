package chapter_eight;

import java.util.Locale;
import java.util.Scanner;

/**
 * 8.5 (Algebra: add two matrices) Write a method to add two matrices. The header of
 * the method is as follows:
 * public static double[][] addMatrix(double[][] a, double[][] b)
 * In order to be added, the two matrices must have the same dimensions and the
 * same or compatible types of elements. Let c be the resulting matrix.
 * Each element cij is aij + bij. For example, for two 2 * 2 matrices a and b, c is
 *
 * Write a test program that prompts the user to enter two 2 * 2 matrices and
 * displays their sum. Here is a sample run:
 *
 *      Enter matrix1: 1 2 3 4
 *      Enter matrix2: 0 2 4 1
 *      The matrices are added as follows
 *      1.0 2.0   0.0 2.0   1.0 4.0
 *      3.0 4.0 + 4.0 1.0 = 7.0 5.0
 *
 * @author Sharaf Qeshta
 * */

public class Problem$05
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in).useLocale(Locale.US);

        System.out.print("Enter matrix1: ");
        double[][] matrix1 = new double[2][2];
        for (int i = 0; i < matrix1.length;i++)
            for (int j = 0; j < matrix1[i].length;j++)
                matrix1[i][j] = scanner.nextDouble();

        System.out.print("Enter matrix2: ");
        double[][] matrix2 = new double[2][2];
        for (int i = 0; i < matrix2.length;i++)
            for (int j = 0; j < matrix2[i].length;j++)
                matrix2[i][j] = scanner.nextDouble();


        System.out.println("The matrices are added as follows");

        double[][] sum = addMatrix(matrix1, matrix2);
        String sumSign = " ";
        String equalSign = " ";
        for (int i = 0; i < matrix2.length;i++)
        {
            System.out.print(matrix1[i][0] + " " + matrix1[i][1] +"   " + sumSign + "  ");
            System.out.print(matrix2[i][0] + " " + matrix1[i][1] +"   " + equalSign + "  ");
            System.out.print(sum[i][0] + " " + sum[i][1] + "\n");
            sumSign = "+";equalSign = "=";
        }
    }

    public static double[][] addMatrix(double[][] a, double[][] b)
    {
        double[][] out = new double[a.length][a[0].length];
        for (int i = 0; i < a.length;i++)
            for (int j = 0; j < a[i].length;j++)
                out[i][j] = a[i][j] + b[i][j];
        return out;
    }
}
