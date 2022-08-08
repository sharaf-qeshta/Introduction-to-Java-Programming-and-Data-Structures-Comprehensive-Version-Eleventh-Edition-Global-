package chapter_twenty_three;

import java.util.Arrays;
import java.util.Comparator;

/**
 * *23.5 (Generic Heap using Comparator) Revise Heap in Listing 23.9, using a generic
 * parameter and a Comparator for comparing objects. Define the class as follows:
 * class HeapWithComparator<E> {
 *  private Comparator<? super E> comparator; // For comparing elements
 *  public HeapWithComparator() {
 *  // Implement no−arg constructor by creating a comparator for
 *  natural order
 *  }
 *  public HeapWithComparator(Comparator<? super E> comparator) {
 *  this.comparator = comparator;
 *  }
 *  // Implement all add, remove, and getSize method
 * }
 *
 *
 * @author Sharaf Qeshta
 * */
public class Problem$05
{
    public static void main(String[] args)
    {
        Integer[] list = {-44, -5, -3, 3, 3, 1, -4, 0, 1, 2, 4, 5, 53};
        heapSort(list, (o1, o2) -> o1 - o2);
        /*
        * [-44, -5, -4, -3, 0, 1, 1, 2, 3, 3, 4, 5, 53]
        * */
        System.out.println(Arrays.toString(list));
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
