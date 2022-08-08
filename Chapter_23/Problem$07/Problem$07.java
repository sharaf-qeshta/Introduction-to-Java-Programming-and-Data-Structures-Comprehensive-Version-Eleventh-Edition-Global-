package chapter_twenty_three;

import java.util.Arrays;

/**
 * 23.7 (Min-heap) The heap presented in the text is also known as a max-heap, in which
 * each node is greater than or equal to any of its children. A min-heap is a heap in
 * which each node is less than or equal to any of its children. Min-heaps are often
 * used to implement priority queues. Revise the Heap class in Listing 23.9 to
 * implement a min-heap.
 *
 *
 * @author Sharaf Qeshta
 * */
public class Problem$07
{
    public static void main(String[] args)
    {
        Integer[] list = {-44, -5, -3, 3, 3, 1, -4, 0, 1, 2, 4, 5, 53};
        heapSort(list);
        /*
         * [53, 5, 4, 3, 3, 2, 1, 1, 0, -3, -4, -5, -44]
         * */
        System.out.println(Arrays.toString(list));
    }

    public static <E extends Comparable<E>> void heapSort(E[] list)
    {
        Heap<E> heap = new Heap<>();

        for (int i = 0; i < list.length; i++)
            heap.add(list[i]);

        for (int i = list.length - 1; i >= 0; i--)
            list[i] = heap.remove();
    }
}
