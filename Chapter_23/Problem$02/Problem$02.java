package chapter_twenty_three;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 23.2 (Generic merge sort) Write the following two generic methods using merge sort.
 * The first method sorts the elements using the Comparable interface and the
 * second uses the Comparator interface.
 * public static <E extends Comparable<E>>
 *  void mergeSort(E[] list)
 * public static <E> void mergeSort(E[] list,
 *  Comparator<? super E> comparator)
 *
 *
 * @author Sharaf Qeshta
 * */
public class Problem$02
{
    public static void main(String[] args) {
        Integer[] list = {2, 3, 2, 5, 6, 1, -2, 3, 14, 12};
        mergeSort(list);
        /* [-2, 1, 2, 2, 3, 3, 5, 6, 12, 14] */
        System.out.println(Arrays.toString(list));

        Integer[] list2 = {2, 3, 2, 5, 6, 1, -2, 3, 14, 12};
        mergeSort(list2, (o1, o2) -> o1 - o2);
        /* [-2, 1, 2, 2, 3, 3, 5, 6, 12, 14] */
        System.out.println(Arrays.toString(list2));
    }


    public static <E extends Comparable<E>> void mergeSort(E[] list)
    {
        if (list.length > 1)
        {
            Comparable[] firstHalf = new Comparable[list.length / 2];
            System.arraycopy(list, 0, firstHalf, 0, list.length / 2);
            mergeSort(firstHalf);

            int secondHalfLength = list.length - list.length / 2;
            Comparable[] secondHalf = new Comparable[secondHalfLength];
            System.arraycopy(list, list.length / 2,
                    secondHalf, 0, secondHalfLength);
            mergeSort(secondHalf);

            merge(firstHalf, secondHalf, list);
        }
    }

    public static void merge(Comparable[] list1, Comparable[] list2, Comparable[] temp)
    {
        int current1 = 0;
        int current2 = 0;
        int current3 = 0;

        while (current1 < list1.length && current2 < list2.length)
        {
            if (list1[current1].compareTo(list2[current2]) < 0)
                temp[current3++] = list1[current1++];
            else
                temp[current3++] = list2[current2++];
        }

        while (current1 < list1.length)
            temp[current3++] = list1[current1++];

        while (current2 < list2.length)
            temp[current3++] = list2[current2++];
    }


    public static <E> void mergeSort(E[] list,
                                     Comparator<? super E> comparator)
    {
        if (list.length > 1)
        {
            Object[] firstHalf = new Object[list.length / 2];
            System.arraycopy(list, 0, firstHalf, 0, list.length / 2);
            mergeSort((E[]) firstHalf, comparator);

            int secondHalfLength = list.length - list.length / 2;
            Object[] secondHalf = new Object[secondHalfLength];
            System.arraycopy(list, list.length / 2,
                    secondHalf, 0, secondHalfLength);
            mergeSort((E[]) secondHalf, comparator);

            merge((E[]) firstHalf, (E[]) secondHalf, list, comparator);
        }
    }

    public static <E> void merge(E[] list1, E[] list2,
                                 E[] temp,  Comparator<? super E> comparator)
    {
        int current1 = 0;
        int current2 = 0;
        int current3 = 0;

        while (current1 < list1.length && current2 < list2.length)
        {
            if (comparator.compare(list1[current1], list2[current2]) < 0)
                temp[current3++] = list1[current1++];
            else
                temp[current3++] = list2[current2++];
        }

        while (current1 < list1.length)
            temp[current3++] = list1[current1++];

        while (current2 < list2.length)
            temp[current3++] = list2[current2++];
    }
}
