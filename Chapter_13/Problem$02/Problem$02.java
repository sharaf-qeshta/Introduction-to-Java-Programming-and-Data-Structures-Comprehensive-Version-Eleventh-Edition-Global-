package chapter_thirteen;

import java.util.*;

/**
 * *13.2 (Average ArrayList) Write the following method that averages an ArrayList of
 * integers:
 * public static void average(ArrayList<Integer> list)
 *
 * @author Sharaf Qeshta
 * */
public class Problem$02
{
    public static void main(String[] args)
    {
        List<Integer> integers = new ArrayList<>(
                Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
        average(integers);

        /* [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 5] */
        System.out.println(integers);
    }

    public static void average(List<Integer> list)
    {
        /*
         * the average will be inserted as the last
         * element in the list
         * */
        int total = 0;
        for (int x: list)
            total += x;

        list.add(total/list.size());
    }
}
