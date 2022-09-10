package chapter_twenty_seven;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 * **27.12 (setToList) Write the following method that returns an ArrayList from a set:
 * public static <E> ArrayList<E> setToList(Set<E> s)
 *
 *
 * @author Sharaf Qeshta
 * */
public class Problem$12
{
    public static void main(String[] args)
    {
        HashSet<Integer> set = new HashSet<>();
        set.add(1);
        set.add(2);
        set.add(3);
        set.add(4);

        /*
        * [1, 2, 3, 4]
        * */
        System.out.println(set);

        /*
        * [1, 2, 3, 4]
        * */
        System.out.println(setToList(set));
    }

    public static <E> ArrayList<E> setToList(Set<E> s)
    {
        ArrayList<E> list = new ArrayList<>();
        for (E element: s)
            list.add(element);
        return list;
    }
}
