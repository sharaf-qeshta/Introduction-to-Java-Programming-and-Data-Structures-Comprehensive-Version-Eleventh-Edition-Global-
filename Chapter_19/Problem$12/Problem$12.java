package chapter_nineteen;

import java.util.Arrays;

/**
 * *19.12 (Revising Listing 23.4) to make it be generic bubble sort.
 *
 *
 * @author Sharaf Qeshta
 * */
public class Problem$12
{
    public static void main(String[] args)
    {
        String[] strings = {"London", "Liverpool", "Manchester",
                "Bristol", "Birmingham", "Glasgow", "Plymouth"};
        Integer[] integers = {5, 8, -1, 458, 78, -10, 89, 10, 11, 5};

        sort(strings);
        /* [Birmingham, Bristol, Glasgow, Liverpool, London, Manchester, Plymouth] */
        System.out.println(Arrays.toString(strings));

        sort(integers);
        /* [-10, -1, 5, 5, 8, 10, 11, 78, 89, 458] */
        System.out.println(Arrays.toString(integers));
    }

    public static <E extends Comparable<E>> void sort(E[] list)
    {
        boolean needNextPass = true;
        for (int k = 1; k < list.length && needNextPass; k++)
        {
            needNextPass = false;
            for (int i = 0; i < list.length - k; i++)
            {
                if (list[i].compareTo(list[i + 1]) > 0)
                {
                    E temp = list[i];
                    list[i] = list[i + 1];
                    list[i + 1] = temp;
                    needNextPass = true;
                }
            }
        }
    }
}
