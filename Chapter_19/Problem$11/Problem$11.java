package chapter_nineteen;

import java.util.Arrays;

/**
 * 19.11 (ComplexMatrix) Use the Complex class introduced in Programming Exercise 13.17
 * to develop the ComplexMatrix class for performing matrix operations involving
 * complex numbers. The ComplexMatrix class should extend the GenericMatrix
 * class and implement the add, multiple, and zero methods. You need to modify
 * GenericMatrix and replace every occurrence of Number by Object because Complex
 * is not a subtype of Number. Write a test program that creates the following
 * two matrices and displays the result of addition and multiplication of the matrices by
 * invoking the printResul19.
 *
 *
 * @author Sharaf Qeshta
 * */
public class Problem$11
{
    public static void main(String[] args)
    {
        Complex[][] matrix1 = new Complex[2][2];
        Complex[][] matrix2 = new Complex[2][2];

        for (int i = 0; i < 2; i++)
        {
            for (int j = 0; j < 2; j++)
            {
                matrix1[i][j] = new Complex(i, j);
                matrix2[i][j] = new Complex(j, i);
            }
        }

        ComplexMatrix matrix = new ComplexMatrix();
        Object[][] result = matrix.multiplyMatrix(matrix1, matrix2);

        /*
        *  0.0 (0.0 + 1.0i)    0.0          1.0            -1.0          (-1.0 + 1.0i)
        *  1.0 (1.0 + 1.0i)  * (0.0 + 1.0i) (1.0 + 1.0i) = (-1.0 + 1.0i) (1.0 + 2.0i)
        * */
        GenericMatrix.printResult(matrix1, matrix2, result, '*');
    }
}
