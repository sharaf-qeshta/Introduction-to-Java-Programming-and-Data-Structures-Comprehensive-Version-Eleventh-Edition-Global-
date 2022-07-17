package chapter_nineteen;

public abstract class GenericMatrix<E>
{
    protected abstract E add(E o1, E o2);

    protected abstract E multiply(E o1, E o2);

    protected abstract E zero();

    public E[][] addMatrix(E[][] matrix1, E[][] matrix2)
    {
        if ((matrix1.length != matrix2.length) ||
                (matrix1[0].length != matrix2[0].length))
            throw new RuntimeException("The matrices do not have the same size");

        E[][] result = (E[][]) new Object[matrix1.length][matrix1[0].length];

        for (int i = 0; i < result.length; i++)
            for (int j = 0; j < result[i].length; j++)
                result[i][j] = add(matrix1[i][j], matrix2[i][j]);
        return result;
    }


    public E[][] multiplyMatrix(E[][] matrix1, E[][] matrix2)
    {
        if (matrix1[0].length != matrix2.length)
            throw new RuntimeException("The matrices do not have compatible size");

        E[][] result = (E[][])new Object[matrix1.length][matrix2[0].length];

        for (int i = 0; i < result.length; i++)
        {
            for (int j = 0; j < result[0].length; j++)
            {
                result[i][j] = zero();
                for (int k = 0; k < matrix1[0].length; k++)
                    result[i][j] = add(result[i][j], multiply(matrix1[i][k], matrix2[k][j]));
            }
        }
        return result;
    }


    public static void printResult(Object[][] m1, Object[][] m2, Object[][] m3, char op)
    {
        for (int i = 0; i < m1.length; i++)
        {
            for (int j = 0; j < m1[0].length; j++)
                System.out.print(" " + String.format("%10s", m1[i][j]));

            if (i == m1.length / 2)
                System.out.print(" " + op + " ");
            else
                System.out.print("   ");

            for (int j = 0; j < m2.length; j++)
                System.out.print(" " + String.format("%10s", m2[i][j]));

            if (i == m1.length / 2)
                System.out.print(" = ");
            else
                System.out.print("   ");
            for (int j = 0; j < m3.length; j++)
                System.out.print(String.format("%10s", m3[i][j]) + " ");
            System.out.println();
        }
    }
}
