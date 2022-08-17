package chapter_twenty_three;

import java.util.Arrays;

/**
 * *23.20 (Modify merge sort) Rewrite the mergeSort method to recursively sort the first
 * half of the array and the second half of the array without creating new temporary
 * arrays, then merge the two into a temporary array and copy its contents to the
 * original array, as shown in Figure 23.6b.
 *
 *
 * @author Sharaf Qeshta
 * */
public class Problem$20
{
    public static void main(String[] args)
    {
        int[] input = {442, 308, 619, 558, 535, 599, 642, 97, 339, 770, 301, 749, 633,
                511, 917, 135, 481, 288, 630, 993, 362, 402, 739, 984, 574};
        mergeSort(input, 0, input.length-1);

        /*
        * [97, 135, 288, 301, 308, 339, 362, 402, 442, 481, 511, 535, 558, 574,
        *  599, 619, 630, 633, 642, 739, 749, 770, 917, 984, 993]
        * */
        System.out.println(Arrays.toString(input));
    }

    public static void mergeSort(int[] list, int start, int end)
    {
        if ((end - start) +1 > 1)
        {
            int middle = (start + end) / 2;
            mergeSort(list, start, middle);
            mergeSort(list, middle + 1, end);
            merge(start, middle,  middle+1, end, list);
        }
    }

    private static void merge(int list1Start, int list1End,
                              int list2Start, int list2End,
                              int[] list)
    {
        int current1 = list1Start;
        int current2 = list2Start;
        int current3 = 0;

        int[] temp = new int[(list1End - list1Start + 1) + (list2End - list2Start + 1)];

        while (current1 < list1End + 1 && current2 < list2End + 1)
        {
            if (list[current1] < list[current2])
                temp[current3++] = list[current1++];
            else
                temp[current3++] = list[current2++];
        }

        while (current1 < list1End + 1)
            temp[current3++] = list[current1++];

        while (current2 < list2End + 1)
            temp[current3++] = list[current2++];

        current3 = 0;
        for (int i = list1Start; i <= list1End; i++, current3++)
            list[i] = temp[current3];

        for (int i = list2Start; i <= list2End; i++, current3++)
            list[i] = temp[current3];
    }
}
