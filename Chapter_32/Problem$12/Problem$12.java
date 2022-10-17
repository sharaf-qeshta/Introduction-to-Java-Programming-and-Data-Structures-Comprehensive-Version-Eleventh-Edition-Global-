package chapter_thirty_two;

import jdk.jfr.Threshold;

import java.util.Random;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;
import java.util.concurrent.RecursiveTask;
import java.util.concurrent.TimeUnit;

/**
 * *32.12 (Parallel array initializer) Implement the following method
 * using the Fork/Join
 * Framework to assign random values to the list.
 * public static void parallelAssignValues(double[] list)
 * Write a test program that creates a list with 9,000,000 elements and invokes
 * parallelAssignValues to assign random values to the list. Also implement a
 * sequential algorithm and compare the execution time of the two. Note if you use
 * Math.random(), your parallel code execution time will be worse than the sequential
 * code execution time because Math.random() is synchronized and cannot be
 * executed in parallel. To fix this problem, create a Random object for assigning
 * random values to a small list.
 *
 *
 * @author Sharaf Qeshta
 * */
public class Problem$12
{
    /**
     * output =>
     * Time taken by parallel assign: 208
     * Time taken by sequential assign: 106
     **/
    public static void main(String[] args)
    {
        double[] list1 = new double[9_000_000];
        long start = System.currentTimeMillis();
        parallelAssignValues(list1);
        long end = System.currentTimeMillis();
        System.out.println("Time taken by parallel assign: " + (end - start));

        double[] list2 = new double[9_000_000];
        start = System.currentTimeMillis();
        sequentialAssignValues(list2);
        end = System.currentTimeMillis();
        System.out.println("Time taken by sequential assign: " + (end - start));
    }

    public static void parallelAssignValues(double[] list)
    {
        AssignAction task = new AssignAction(list, 0, list.length, new Random());
        ForkJoinPool pool = new ForkJoinPool();
        pool.invoke(task);
    }

    private static class AssignAction extends RecursiveAction
    {
        private final static int THRESHOLD = 1000;
        double[] list;
        int start, end;
        Random random;

        public AssignAction(double[] list, int start, int end, Random random)
        {
            this.list = list;
            this.start = start;
            this.end = end;
            this.random = random;
        }


        @Override
        protected void compute()
        {
            if (end - start < THRESHOLD)
            {
                for (int i = start; i < end; i++)
                    list[i] = random.nextInt(1_000);
            }
            else
            {
                int mid = (end + start) / 2;
                RecursiveAction left = new AssignAction(list, start, mid, random);
                RecursiveAction right = new AssignAction(list, mid, end, random);

                left.fork();
                left.join();
                right.fork();
                right.join();
            }
        }
    }

    public static void sequentialAssignValues(double[] list)
    {
        Random random = new Random();
        for (int i = 0; i < list.length; i++)
            list[i] = random.nextInt(1_000);
    }
}
