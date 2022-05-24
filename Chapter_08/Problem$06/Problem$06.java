package chapter_eight;

import java.util.Locale;
import java.util.Scanner;

/**
 * **8.6 (Algebra: multiply two matrices) Write a method to multiply two matrices. The
 * header of the method is:
 * public static double[][]
 *  multiplyMatrix(double[][] a, double[][] b)
 *  To multiply matrix a by matrix b, the number of columns in a must be the same as
 * the number of rows in b, and the two matrices must have elements of the same or
 * compatible types. Let c be the result of the multiplication. Assume the column size
 * of matrix a is n. Each element cij is ai1 * b1j + ai2 * b2j + g + ain * bnj.
 * For example, for two 3 * 3 matrices a and b, c is
 * Write a test program that prompts the user to enter two 3 * 3 matrices and
 * displays their product. Here is a sample run:
 *
 *      Enter matrix1: 1 2 3 4 5 6 7 8 9
 *      Enter matrix2: 0 2 4 1 4.5 2.2 1.1 4.3 5.2
 *      The multiplication of the matrices is
 *      1 2 3   0 2.0 4.0    5.3 23.9 24
 *      4 5 6 * 1 4.5 2.2  = 11.6 56.3 58.2
 *      7 8 9   1.1 4.3 5.2  17.9 88.7 92.4
 *
 * @author Sharaf Qeshta
 * */

public class Problem$06
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in).useLocale(Locale.US);

        System.out.print("Enter matrix1: ");
        double[][] matrix1 = new double[3][3];
        for (int i = 0; i < matrix1.length;i++)
            for (int j = 0; j < matrix1[i].length;j++)
                matrix1[i][j] =  scanner.nextDouble();


        System.out.print("Enter matrix2: ");
        double[][] matrix2 = new double[3][3];
        for (int i = 0; i < matrix2.length;i++)
            for (int j = 0; j < matrix2[i].length;j++)
                matrix2[i][j] = scanner.nextDouble();


        System.out.println("The multiplication of the matrices is");

        double[][] multiplication = multiplyMatrix(matrix1, matrix2);

        for (int i = 0; i < multiplication.length;i++)
        {
            String multiSign = " ", equalSign = " ";
            if (i == 1)
            {
                multiSign = "*";
                equalSign = "=";
            }
            System.out.print(matrix1[i][0] + " " + matrix1[i][1] + " " + matrix1[i][2] + "   " + multiSign + "  ");
            System.out.print(matrix2[i][0] + " " + matrix1[i][1] + " " + matrix1[i][2] + "   " + equalSign + "  ");
            System.out.print(multiplication[i][0] + " " + multiplication[i][1] + " " + multiplication[i][2] + "\n");
        }
    }

    public static double[][] multiplyMatrix(double[][] a, double[][] b)
    {
        double[][] out = new double[a.length][a[0].length];
        for (int i = 0; i < a.length;i++)
            for (int j = 0; j < a[i].length;j++)
                out[i][j] = (a[i][0] * b[0][j])  // 0, 2
                        + (a[i][1] * b[1][j])
                        + (a[i][2] * b[2][j]); //  cij = ai1 * b1j + ai2 * b2j + ai3 * b3j
        return out;
    }
}
