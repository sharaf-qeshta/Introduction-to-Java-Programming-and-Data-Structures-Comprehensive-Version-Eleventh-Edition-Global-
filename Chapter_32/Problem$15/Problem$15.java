package chapter_thirty_two;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

/**
 * *32.15 (Parallel sum) Implement the following method using Fork/Join to find the sum of
 * a list.
 * public static double parallelSum(double[] list)
 * Write a test program that finds the sum in a list of 9,000,000 double values.
 *
 *
 * @author Sharaf Qeshta
 * */
public class Problem$15
{
    public static void main(String[] args)
    {
        double[] list = new double[9_000_000];
        for (int i = 0; i < 9_000_000; i++)
            list[i] = Math.random() * 10;
        System.out.println(parallelSum(list));
    }

    public static double parallelSum(double[] list)
    {
        RecursiveTask<Double> task = new SumTask(list,0, list.length-1);
        ForkJoinPool pool = new ForkJoinPool();
        return pool.invoke(task);
    }

    private static class SumTask extends RecursiveTask<Double>
    {
        private final static int THRESHOLD = 1000;
        double[] list;
        int start;
        int end;

        public SumTask(double[] list, int start, int end)
        {
            this.list = list;
            this.start = start;
            this.end = end;
        }

        @Override
        protected Double compute()
        {
            if (end - start < THRESHOLD)
            {
                double sum = 0;
                for (int i = start; i < end; i++)
                    sum += list[i];
                return sum;
            }
            else
            {
                int mid = (start + end) / 2;
                RecursiveTask<Double> left = new SumTask(list, start, mid);
                RecursiveTask<Double> right = new SumTask(list, mid, end);
                left.fork();
                right.fork();

                return left.join() + right.join();
            }
        }
    }
}
