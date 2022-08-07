package chapter_twenty_three;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 23.3 (Generic quick sort) Write the following two generic methods using quick sort.
 * The first method sorts the elements using the Comparable interface, and the
 * second uses the Comparator interface.
 * public static <E extends Comparable<E>>
 *  void quickSort(E[] list)
 * public static <E> void quickSort(E[] list,
 *  Comparator<? super E> comparator)
 *
 *
 * @author Sharaf Qeshta
 * */
public class Problem$03
{
    public static void main(String[] args)
    {
        // test quickSort(E[] list)
        Integer[] list = {2, 3, 2, 5, 6, 1, -2, 3, 14, 12};
        /*
        * [-2, 1, 2, 2, 3, 3, 5, 6, 12, 14]
        * */
        quickSort(list);
        System.out.println(Arrays.toString(list));

        // test quickSort(E[] list, Comparator<? super E> comparator)
        Integer[] list2 = {2, 3, 2, 5, 6, 1, -2, 3, 14, 12};
        quickSort(list2, (o1, o2) -> o1 - o2);
        /*
        * [-2, 1, 2, 2, 3, 3, 5, 6, 12, 14]
        * */
        System.out.println(Arrays.toString(list2));
    }


    public static <E extends Comparable<E>> void quickSort(E[] list)
    {
        quickSort(list, 0, list.length - 1);
    }

    public static <E extends Comparable<E>> void quickSort(E[] list, int first, int last)
    {
        if (last > first)
        {
            int pivotIndex = partition(list, first, last);
            quickSort(list, first, pivotIndex - 1);
            quickSort(list, pivotIndex + 1, last);
        }
    }


    public static <E extends Comparable<E>> int partition(E[] list, int first, int last)
    {
        E pivot = list[first]; // Choose the first element as the pivot
        int low = first + 1; // Index for forward search
        int high = last; // Index for backward search

        while (high > low)
        {
            // Search forward from left
            while (low <= high && list[low].compareTo(pivot) <= 0)
                low++;

            // Search backward from right
            while (low <= high && list[high].compareTo(pivot) > 0)
                high--;

            // Swap two elements in the list
            if (high > low)
            {
                E temp = list[high];
                list[high] = list[low];
                list[low] = temp;
            }
        }

        while (high > first && list[high].compareTo(pivot) >= 0)
            high--;

        // Swap pivot with list[high]
        if (pivot.compareTo(list[high]) > 0)
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


    public static <E> void quickSort(E[] list,
                                     Comparator<? super E> comparator)
    {
        quickSort(list, 0, list.length - 1, comparator);
    }

    public static <E> void quickSort(E[] list, int first,
                                     int last, Comparator<? super E> comparator)
    {
        if (last > first)
        {
            int pivotIndex = partition(list, first, last, comparator);
            quickSort(list, first, pivotIndex - 1, comparator);
            quickSort(list, pivotIndex + 1, last, comparator);
        }
    }

    public static <E> int partition(E[] list, int first,
                                    int last, Comparator<? super E> comparator)
    {
        E pivot = list[first];
        int low = first + 1;
        int high = last;

        while (high > low)
        {
            while (low <= high && comparator.compare(list[low], pivot) <= 0)
                low++;

            while (low <= high && comparator.compare(list[high], pivot) > 0)
                high--;

            if (high > low)
            {
                E temp = list[high];
                list[high] = list[low];
                list[low] = temp;
            }
        }

        while (high > first && comparator.compare(list[high], pivot) >= 0)
            high--;

        if (comparator.compare(pivot, list[high]) > 0)
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
