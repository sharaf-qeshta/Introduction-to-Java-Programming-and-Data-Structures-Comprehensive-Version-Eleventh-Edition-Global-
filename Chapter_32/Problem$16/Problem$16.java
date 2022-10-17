package chapter_thirty_two;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;

/**
 * *32.16 (Parallel matrix addition) Programming Exercise 8.5 describes how to perform
 * matrix addition. Suppose you have multiple processors, so you can speed up the
 * matrix addition. Implement the following method in parallel:
 * public static double[][] parallelAddMatrix(
 *  double[][] a, double[][] b)
 * Write a test program that measures the execution time for adding two 2,000 * 2,000
 * matrices using the parallel method and sequential method, respectively.
 *
 *
 * @author Sharaf Qeshta
 * */
public class Problem$16
{
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
        sequentialAddMatrix(a, b);
        long end = System.currentTimeMillis();
        System.out.println("Sequential addition takes: " + (end - start));

        start = System.currentTimeMillis();
        parallelAddMatrix(a, b);
        end = System.currentTimeMillis();
        System.out.println("Parallel addition takes: " + (end - start));
    }

    public static double[][] sequentialAddMatrix(double[][] a, double[][] b)
    {
        double[][] c = new double[a.length][a[0].length];
        for (int i = 0; i < a.length; i++)
            for (int j = 0; j < a[i].length; j++)
                c[i][j] = a[i][j] + b[i][j];
        return c;
    }


    public static double[][] parallelAddMatrix(double[][] a, double[][] b)
    {
        double[][] c = new double[a.length][a[0].length];
        AddAction action = new AddAction(a, b, c, 0, c.length);
        ForkJoinPool pool = new ForkJoinPool();
        pool.invoke(action);
        return c;
    }

    private static class AddAction extends RecursiveAction
    {
        private final static int THRESHOLD = 50;

        double[][] a, b, c;
        int startRow;
        int endRow;

        public AddAction(double[][] a, double[][] b,
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
                    for (int j = 0; j < a[i].length; j++)
                        c[i][j] = a[i][j] + b[i][j];
            }
            else
            {
                int mid = (endRow + startRow) / 2;
                invokeAll(new AddAction(a, b, c, startRow, mid),
                        new AddAction(a, b, c, mid, endRow));
            }
        }
    }
}
