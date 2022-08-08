package chapter_twenty_three;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 23.6 (Generic insertion sort) Write the following two generic methods using insertion
 * sort. The first method sorts the elements using the Comparable interface and the
 * second uses the Comparator interface.
 * public static <E extends Comparable<E>> void insertionSort
 * (E[] list)
 * public static <E> void insertionSort(E[] list,
 * Comparator<?super E> comparator)
 *
 *
 * @author Sharaf Qeshta
 * */
public class Problem$06
{
    public static void main(String[] args)
    {
        // test insertionSort(E[] list)
        Integer[] list = {-44, -5, -3, 3, 3, 1, -4, 0, 1, 2, 4, 5, 53};
        insertionSort(list);
        /*
         * [-44, -5, -4, -3, 0, 1, 1, 2, 3, 3, 4, 5, 53]
         * */
        System.out.println(Arrays.toString(list));

        // test insertionSort(E[] list, Comparator<?super E> comparator)
        Integer[] list2 = {-44, -5, -3, 3, 3, 1, -4, 0, 1, 2, 4, 5, 53};
        insertionSort(list2, (o1, o2) -> o1 - o2);
        /*
         * [-44, -5, -4, -3, 0, 1, 1, 2, 3, 3, 4, 5, 53]
         * */
        System.out.println(Arrays.toString(list2));
    }


    public static <E extends Comparable<E>> void insertionSort(E[] list)
    {
        for (int i = 1; i < list.length; i++)
        {
            E currentElement = list[i];
            int k;
            for (k = i - 1; k >= 0 && list[k].compareTo(currentElement) > 0; k--)
                list[k + 1] = list[k];

            list[k + 1] = currentElement;
        }
    }


    public static <E> void insertionSort(E[] list, Comparator<?super E> comparator)
    {
        for (int i = 1; i < list.length; i++)
        {
            E currentElement = list[i];
            int k;
            for (k = i - 1; k >= 0 && comparator.compare(list[k], currentElement) > 0; k--)
                list[k + 1] = list[k];

            list[k + 1] = currentElement;
        }
    }
}
