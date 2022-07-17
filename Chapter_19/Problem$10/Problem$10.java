package chapter_nineteen;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 19.10 (Smallest element in ArrayList) Write the following method that returns the
 * smallest element in an ArrayList:
 * public static <E extends Comparable<E>> E min(ArrayList<E> list)
 *
 *
 * @author Sharaf Qeshta
 * */
public class Problem$10
{
    public static void main(String[] args)
    {
        ArrayList<Integer> integers = new ArrayList<>
                (
                        Arrays.asList(5, 8, -1, 458, 78, -10, 89, 10, 11, 5)
                );
        System.out.println(min(integers)); // -10
    }

    public static <E extends Comparable<E>> E min(ArrayList<E> list)
    {
        E min = list.get(0);
        for (E e : list)
        {
            if (min.compareTo(e) > 0)
                min = e;
        }

        return min;
    }
}
