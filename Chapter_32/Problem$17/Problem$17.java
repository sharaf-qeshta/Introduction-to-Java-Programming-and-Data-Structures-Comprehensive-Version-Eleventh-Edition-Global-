package chapter_thirty_two;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;

/**
 * *32.17 (Parallel matrix multiplication) Programming Exercise 8.6 describes how to
 * perform matrix multiplication. Suppose that you have multiple processors, so
 * you can speed up the matrix multiplication. Implement the following method in
 * parallel:
 * public static double[][] parallelMultiplyMatrix(
 *  double[][] a, double[][] b)
 * Write a test program that measures the execution time for multiplying two
 * 2,000 * 2,000 matrices using the parallel method and sequential method,
 * respectively.
 *
 *
 * @author Sharaf Qeshta
 * */
public class Problem$17
{
    /**
     * output =>
     * Sequential multiplication takes: 82746
     * Parallel multiplication takes: 24274
     * */
    public static void main(String[] args)
    {
        double[][] a = new double[2_000][2_000];
        double[][] b = new double[2_000][2_000];

        for (int i = 0; i < a.length; i++)
        {
            for (int j = 0; j < a[i].length; j++)
            {
                a[i][j] = Math.random() * 10;
                b[i][j] = Math.random() * 10;
            }
        }

        long start = System.currentTimeMillis();
        sequentialMultiplyMatrix(a, b);
        long end = System.currentTimeMillis();
        System.out.println("Sequential multiplication takes: " + (end - start));

        start = System.currentTimeMillis();
        parallelMultiplyMatrix(a, b);
        end = System.currentTimeMillis();
        System.out.println("Parallel multiplication takes: " + (end - start));
    }

    public static double[][] sequentialMultiplyMatrix(double[][] a, double[][] b)
    {
        double[][] c = new double[a.length][b[0].length];
        for (int i = 0; i < a.length; i++)
            for (int j = 0; j < b[0].length; j++)
                for (int k = 0; k < b.length; k++)
                    c[i][j] += a[i][k] * b[k][j];
        return c;
    }


    public static double[][] parallelMultiplyMatrix(double[][] a, double[][] b)
    {
        double[][] c = new double[a.length][b[0].length];
        MultiplyAction action = new MultiplyAction(a, b, c, 0, a.length);
        ForkJoinPool pool = new ForkJoinPool();
        pool.invoke(action);
        return c;
    }

    private static class MultiplyAction extends RecursiveAction
    {
        private final static int THRESHOLD = 50;

        double[][] a, b, c;
        int startRow;
        int endRow;

        public MultiplyAction(double[][] a, double[][] b,
                         double[][] c, int startRow, int endRow)
        {
            this.a = a;
            this.b = b;
            this.c = c;
            this.startRow = startRow;
            this.endRow = endRow;
        }


        @Override
        protected void  compute()
        {
            if (endRow - startRow < THRESHOLD)
            {
                for (int i = startRow; i < endRow; i++)
                    for (int j = 0; j < b[0].length; j++)
                        for (int k = 0; k < b.length; k++)
                            c[i][j] += a[i][k] * b[k][j];
            }
            else
            {
                int mid = (endRow + startRow) / 2;
                invokeAll(new MultiplyAction(a, b, c, startRow, mid),
                        new MultiplyAction(a, b, c, mid, endRow));
            }
        }
    }
}
