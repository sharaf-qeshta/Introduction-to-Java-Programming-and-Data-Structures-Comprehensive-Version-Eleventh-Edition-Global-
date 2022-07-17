package chapter_nineteen;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 19.9 (Sort ArrayList) Write the following method that sorts an ArrayList:
 * public static <E extends Comparable<E>>
 * void sort(ArrayList<E> list)
 *
 * @author Sharaf Qeshta
 */
public class Problem$09
{
    public static void main(String[] args)
    {
        ArrayList<String> strings = new ArrayList<>
                (
                        Arrays.asList("London", "Liverpool", "Manchester", "Bristol"
                                , "Birmingham", "Glasgow", "Plymouth")
                );
        sort(strings);
        /* [Birmingham, Bristol, Glasgow, Liverpool, London, Manchester, Plymouth] */
        System.out.println(strings);
    }


    public static <E extends Comparable<E>>
                    void sort(ArrayList<E> list)
    {
        boolean sorted = false;
        while (!sorted)
        {
            sorted = true;
            for (int i = 0; i < list.size()-1; i++)
            {
                if (list.get(i).compareTo(list.get(i+1)) > 0)
                {
                    E temp = list.get(i);
                    list.set(i, list.get(i+1));
                    list.set(i+1, temp);
                    sorted = false;
                }
            }
        }
    }
}
