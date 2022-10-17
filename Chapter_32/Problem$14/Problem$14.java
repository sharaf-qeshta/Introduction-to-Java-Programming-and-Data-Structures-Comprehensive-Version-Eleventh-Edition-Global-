package chapter_thirty_two;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;

/**
 * *32.14 (Parallel quick sort) Implement the following method in parallel to
 * sort a list using
 * quick sort (see Listing 23.7):
 * public static void parallelQuickSort(int[] list)
 * Write a test program that times the execution time for a list of size
 * 9,000,000 using
 * this parallel method and a sequential method.
 *
 *
 * @author Sharaf Qeshta
 * */
public class Problem$14
{
    public static void main(String[] args)
    {
        int[] list = new int[9_000_000];
        for (int i = 0; i < 9_000_000; i++)
            list[i] = (int) (Math.random() * 100);

        long start = System.currentTimeMillis();
        parallelQuickSort(list);
        long end = System.currentTimeMillis();
        System.out.println("Time taken for parallel quick sort: " + (end - start));

        int[] list2 = new int[9_000_000];
        for (int i = 0; i < 9_000_000; i++)
            list2[i] = (int) (Math.random() * 100);

        start = System.currentTimeMillis();
        sequentialQuickSort(list2);
        end = System.currentTimeMillis();
        System.out.println("Time taken for sequential quick sort: " + (end - start));
    }

    public static void parallelQuickSort(int[] list)
    {
        RecursiveAction mainTask = new SortTask(list, 0, list.length-1);
        ForkJoinPool pool = new ForkJoinPool();
        pool.invoke(mainTask);
    }

    public static void sequentialQuickSort(int[] list)
    {
        sequentialQuickSort(list, 0, list.length-1);
    }

    public static void sequentialQuickSort(int[] list, int first, int last)
    {
        if (last > first)
        {
            int pivot = partition(list, first, last);
            sequentialQuickSort(list, first, pivot-1);
            sequentialQuickSort(list, pivot+1, last);
        }
    }

    private static class SortTask extends RecursiveAction
    {
        int[] list;
        int first, last;

        public SortTask(int[] list, int first, int last)
        {
            this.list = list;
            this.first = first;
            this.last = last;
        }

        @Override
        protected void compute()
        {
            if (last > first)
            {
                int pivotIndex = partition(list, first, last);
                invokeAll(new SortTask(list, first, pivotIndex-1),
                        new SortTask(list, pivotIndex+1, last));
            }
        }
    }

    public static int partition(int[] list, int first, int last)
    {
        int pivot = list[first];
        int low = first + 1;
        int high = last;

        while (high > low)
        {
            while (low <= high && list[low] <= pivot)
                low++;

            while (low <= high && list[high] > pivot)
                high--;

            if (high > low)
            {
                int temp = list[high];
                list[high] = list[low];
                list[low] = temp;
            }
        }

        while (high > first && list[high] >= pivot)
            high--;

        if (pivot > list[high])
        {
            list[first] = list[high];
            list[high] = pivot;
            return high;
        }
        else
        {
            return first;
        }
    }
}
