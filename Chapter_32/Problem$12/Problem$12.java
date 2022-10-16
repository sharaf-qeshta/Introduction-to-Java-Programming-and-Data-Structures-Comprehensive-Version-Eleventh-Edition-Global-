package chapter_thirty_two;

import java.util.Random;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

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
     * Time taken by parallel assign: 3
     * Time taken by sequential assign: 198
     *
     * it seems that parallel assigns much
     * better than sequential assigns
     * */
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
        RecursiveTask<Object> task = new AssignTask(list, 0,
                new Random(), list.length);
        ForkJoinPool pool = new ForkJoinPool();
        pool.invoke(task);
    }

    private static class AssignTask extends RecursiveTask<Object>
    {
        double[] list;
        int index;
        Random random;
        int length;

        public AssignTask(double[] list, int index, Random random, int length)
        {
            this.list = list;
            this.index = index;
            this.random = random;
            this.length = length;
        }

        @Override
        protected Object compute()
        {
            if (index < length)
            {
                list[index] = random.nextInt(1_000);

                RecursiveTask<Object> task =
                        new AssignTask(list, index+1, random, length);
                task.fork();
            }
            return null;
        }
    }

    public static void sequentialAssignValues(double[] list)
    {
        Random random = new Random();
        for (int i = 0; i < list.length; i++)
            list[i] = random.nextInt(1_000);
    }
}
