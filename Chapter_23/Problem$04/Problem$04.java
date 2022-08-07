package chapter_twenty_three;

import java.util.Arrays;

/**
 * 23.4 (Improve quick sort) The quick-sort algorithm presented in the book selects the
 * first element in the list as the pivot. Revise it by selecting the median among the
 * first, middle, and the last elements in the list.
 *
 *
 * @author Sharaf Qeshta
 * */
public class Problem$04
{
    public static void main(String[] args)
    {
        int[] list = {2, 3, 2, 5, 6, 1, -2, 3, 14, 12};
        /*
         * [-2, 1, 2, 2, 3, 3, 5, 6, 12, 14]
         * */
        quickSort(list);
        System.out.println(Arrays.toString(list));
    }


    public static void quickSort(int[] list)
    {
        quickSort(list, 0, list.length - 1);
    }


    public static void quickSort(int[] list, int first, int last)
    {
        if (last > first)
        {
            int pivotIndex = partition(list, first, last);
            quickSort(list, first, pivotIndex - 1);
            quickSort(list, pivotIndex + 1, last);
        }
    }


    public static int partition(int[] list, int first, int last)
    {
        int middle = (last + first) / 2;
        if (list[first] > list[last])
        {
            int temp = list[first];
            list[first] = list[last];
            list[last] = temp;
        }

        if (list[first] > list[middle])
        {
            int temp = list[first];
            list[first] = list[middle];
            list[middle] = temp;
        }

        if (list[middle] > list[last])
        {
            int temp = list[middle];
            list[middle] = list[last];
            list[last] = temp;
        }

        int temp_ = list[middle];
        list[middle] = list[first];
        list[first] = temp_;

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
