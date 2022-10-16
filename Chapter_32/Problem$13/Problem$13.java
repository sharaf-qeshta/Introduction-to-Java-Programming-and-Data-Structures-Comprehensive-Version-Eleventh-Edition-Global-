package chapter_thirty_two;


import java.util.Arrays;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;

/**
 * 32.13 (Generic parallel merge sort) Revise Listing 32.10, ParallelMergeSort.java, to
 * define a generic parallelMergeSort method as follows:
 * public static <E extends Comparable<E>> void
 *  parallelMergeSort(E[] list)
 *
 *
 * @author Sharaf Qeshta
 * */
public class Problem$13
{
    public static void main(String[] args)
    {
        Integer[] integers = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
        parallelMergeSort(integers);
        /*
        * [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
        * */
        System.out.println(Arrays.toString(integers));

        String[] cities = {"San Francisco", "Austin", "Dallas", "Tampa", "Seattle", "Boston"};
        parallelMergeSort(cities);
        /*
        * [Austin, Boston, Dallas, San Francisco, Seattle, Tampa]
        * */
        System.out.println(Arrays.toString(cities));
    }

    public static <E extends Comparable<E>> void parallelMergeSort(E[] list)
    {
        RecursiveAction mainTask = new SortTask<E>(list);
        ForkJoinPool pool = new ForkJoinPool();
        pool.invoke(mainTask);
    }

    private static class SortTask<E extends Comparable<E>> extends RecursiveAction
    {
        private final int THRESHOLD = 500;
        private final E[] list;

        SortTask(E[] list)
        {
            this.list = list;
        }

        @Override
        protected void compute()
        {
            if (list.length < THRESHOLD)
                java.util.Arrays.sort(list);
            else
            {
                // Obtain the first half
                E[] firstHalf = (E[]) new Object[list.length / 2];
                System.arraycopy(list, 0, firstHalf,
                        0, list.length / 2);

                // Obtain the second half
                int secondHalfLength = list.length - list.length / 2;
                E[] secondHalf = (E[]) new Object[secondHalfLength];
                System.arraycopy(list, list.length / 2,
                        secondHalf, 0, secondHalfLength);

                // Recursively sort the two halves
                invokeAll(new SortTask<>(firstHalf),
                        new SortTask<>(secondHalf));

                merge(firstHalf, secondHalf, list);
            }
        }

        public static <E extends Comparable<E>>void merge(E[] firstHalf,
                                                          E[] secondHalf, E[] list)
        {
            int firstHalfIndex = 0, secondHalfIndex = 0;
            for (int i = 0; i < list.length; i++)
            {
                if (firstHalfIndex
                        < firstHalf.length
                && secondHalfIndex < secondHalf.length)
                {
                    if (firstHalf[firstHalfIndex]
                            .compareTo(secondHalf[secondHalfIndex]) > 0)
                    {
                        list[i] = secondHalf[secondHalfIndex];
                        secondHalfIndex++;
                    }
                    else
                    {
                        list[i] = firstHalf[firstHalfIndex];
                        firstHalfIndex++;
                    }
                }
                else if (firstHalfIndex < firstHalf.length)
                {
                    list[i] = firstHalf[firstHalfIndex];
                    firstHalfIndex++;
                }
                else
                {
                    list[i] = secondHalf[secondHalfIndex];
                    secondHalfIndex++;
                }
            }
        }
    }
}
