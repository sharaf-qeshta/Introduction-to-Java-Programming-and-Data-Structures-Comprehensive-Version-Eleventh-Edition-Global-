package chapter_twenty_three;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 23.1 (Generic bubble sort) Write the following two generic methods using bubble
 * sort. The first method sorts the elements using the Comparable interface, and
 * the second uses the Comparator interface.
 * public static <E extends Comparable<E>>
 *  void bubbleSort(E[] list)
 * public static <E> void bubbleSort(E[] list,
 *  Comparator<? super E> comparator)
 *
 *
 * @author Sharaf Qeshta
 * */
public class Problem$01
{
    public static void main(String[] args)
    {
        // test bubbleSort(E[] list)
        Integer[] list = {2, 3, 2, 5, 6, 1, -2, 3, 14, 12};
        bubbleSort(list);
        /* [-2, 1, 2, 2, 3, 3, 5, 6, 12, 14] */
        System.out.println(Arrays.toString(list));

        // test bubbleSort(E[] list, Comparator<? super E> comparator)
        list = new Integer[] {2, 3, 2, 5, 6, 1, -2, 3, 14, 12};
        bubbleSort(list, (o1, o2) -> o1 - o2);
        /* [-2, 1, 2, 2, 3, 3, 5, 6, 12, 14] */
        System.out.println(Arrays.toString(list));
    }


    public static <E extends Comparable<E>> void bubbleSort(E[] list)
    {
        boolean needNextPass = true;
        for (int k = 1; k < list.length && needNextPass; k++)
        {
            // Array may be sorted and next pass not needed
            needNextPass = false;
            for (int i = 0; i < list.length - k; i++)
            {
                if (list[i].compareTo(list[i + 1]) > 0)
                {
                    // Swap list[i] with list[i + 1]
                    E temp = list[i];
                    list[i] = list[i + 1];
                    list[i + 1] = temp;

                    needNextPass = true; // Next pass still needed
                }
            }
        }
    }


    public static <E> void bubbleSort(E[] list,
                                      Comparator<? super E> comparator)
    {
        boolean needNextPass = true;
        for (int k = 1; k < list.length && needNextPass; k++)
        {
            // Array may be sorted and next pass not needed
            needNextPass = false;
            for (int i = 0; i < list.length - k; i++)
            {
                if (comparator.compare(list[i], list[i+1]) > 0)
                {
                    // Swap list[i] with list[i + 1]
                    E temp = list[i];
                    list[i] = list[i + 1];
                    list[i + 1] = temp;

                    needNextPass = true; // Next pass still needed
                }
            }
        }
    }
}
