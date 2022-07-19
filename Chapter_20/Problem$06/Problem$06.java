package chapter_twenty;

import java.util.ArrayList;
import java.util.ListIterator;

/**
 * 20.6 (Use iterators on ArrayList) Write a test program that stores 10 million integers
 * in ascending order (i.e., 1,2, . . ., 10m) in an ArrayList, displays the execution
 * time taken to traverse the list, and searches for the 10 millionth element using
 * the get(index) vs using the iterator method
 *
 *
 * @author Sharaf Qeshta
 * */
public class Problem$06
{
    public static void main(String[] args)
    {
        ArrayList<Integer> integers = new ArrayList<>();

        // add 10m elements
        for (int i = 1; i < 10000001; i++)
            integers.add(i);

        // traverse the list
        ListIterator<Integer> iterator = integers.listIterator();

        long startTime = System.nanoTime();
        while (iterator.hasNext())
            iterator.next();

        long endTime = System.nanoTime();

        /* Time taking to traverse the list is 14896100 */
        System.out.println("Time taking to traverse the list is " + (endTime - startTime));

        // searching comparison
        // 1- get(index) method
        startTime = System.nanoTime();
        for (int i = 0; i < 10000000; i++)
            if (integers.get(i) == 10000000)
                endTime = System.nanoTime();

        /* Time taking for searching using get(index) is 37727600 */
        System.out.println("Time taking for searching using get(index) is " + (endTime - startTime));

        // 2- iterator method
        iterator = integers.listIterator();

        startTime = System.nanoTime();
        while (iterator.hasNext())
            if (iterator.next() == 10000000)
                endTime = System.nanoTime();

        /* Time taking for searching using iterator is 32174300 */
        System.out.println("Time taking for searching using iterator is " + (endTime - startTime));

        // it seems that the iterator method faster
    }
}
