package chapter_thirty_two;

import java.util.Arrays;
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
        int[] list = {-1, 54, 14, 5, 7, 2, 21, -3};
        parallelQuickSort(list);

        /*
        * [-3, -1, 2, 5, 7, 14, 21, 54]
        * */
        System.out.println(Arrays.toString(list));
    }

    public static void parallelQuickSort(int[] list)
    {
        RecursiveAction mainTask = new SortTask(list, 0, list.length-1);
        ForkJoinPool pool = new ForkJoinPool();
        pool.invoke(mainTask);
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
}
