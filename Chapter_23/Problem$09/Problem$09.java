package chapter_twenty_three;

import java.util.Arrays;
import java.util.Comparator;

/**
 * *23.9 (Generic heap sort) Write the following two generic methods using heap sort.
 * The first method sorts the elements using the Comparable interface, and the
 * second uses the Comparator interface. (Hint: Use the Heap class in Programming
 * Exercise 23.5.)
 * public static <E extends Comparable<E>>
 *  void heapSort(E[] list)
 * public static <E> void heapSort(E[] list,
 *  Comparator<? super E> comparator)
 *
 *
 * @author Sharaf Qeshta
 * */
public class Problem$09
{
    public static void main(String[] args)
    {
        // test heapSort(E[] list)
        Integer[] list = {-44, -5, -3, 3, 3, 1, -4, 0, 1, 2, 4, 5, 53};
        heapSort(list);
        /*
        * [-44, -5, -4, -3, 0, 1, 1, 2, 3, 3, 4, 5, 53]
        * */
        System.out.println(Arrays.toString(list));

        // test heapSort(E[] list, Comparator<? super E> comparator)
        Integer[] list2 = {-44, -5, -3, 3, 3, 1, -4, 0, 1, 2, 4, 5, 53};
        heapSort(list2, (o1, o2) -> o1 - o2);
        /*
        * [-44, -5, -4, -3, 0, 1, 1, 2, 3, 3, 4, 5, 53]
        * */
        System.out.println(Arrays.toString(list2));
    }

    public static <E extends Comparable<E>> void heapSort(E[] list)
    {
        Heap<E> heap = new Heap<>();

        for (int i = 0; i < list.length; i++)
            heap.add(list[i]);

        for (int i = list.length - 1; i >= 0; i--)
            list[i] = heap.remove();
    }

    public static <E> void heapSort(E[] list, Comparator<? super E> comparator)
    {
        HeapWithComparator<E> heap = new HeapWithComparator<>(comparator);

        for (int i = 0; i < list.length; i++)
            heap.add(list[i]);

        for (int i = list.length - 1; i >= 0; i--)
            list[i] = heap.remove();
    }
}
