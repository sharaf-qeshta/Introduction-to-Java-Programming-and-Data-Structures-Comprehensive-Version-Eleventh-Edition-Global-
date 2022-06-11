package chapter_thirteen;

import java.util.*;

/**
 * *13.3 (Sort ArrayList) Write the following method that sorts an ArrayList of numbers:
 * public static void sort(ArrayList<Number> list)
 *
 * @author Sharaf Qeshta
 * */
public class Problem$03
{
    public static void main(String[] args)
    {
        List<Number> numbers = new ArrayList<>(
                Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
        sort(numbers);

        /* [10, 9, 8, 7, 6, 5, 4, 3, 2, 1] */
        System.out.println(numbers);
    }

    public static void sort(List<Number> list)
    {
        for (int i = 1; i < list.size(); i++)
        {
            Number key = list.get(i);
            int j = i -1;
            while (j > -1 && key.doubleValue() > list.get(j).doubleValue())
                list.set(j+1, list.get(j--));
            list.set(j+1, key);
        }
    }
}
