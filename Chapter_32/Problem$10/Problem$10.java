package chapter_thirty_two;

import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * *32.10 (Use synchronized sets) Using synchronization, correct the problem
 * in the preceding exercise so that the second thread does not throw a
 * ConcurrentModificationException.
 *
 *
 * @author Sharaf Qeshta
 * */
public class Problem$10
{
    public static void main(String[] args)
    {
        Set<Object> set = Collections.synchronizedSet(new HashSet<>());

        // adding a number to the set every second
        new Thread( () ->
        {
            while (true)
            {
                try
                {
                    synchronized (set)
                    {
                        set.add(set.size()+1);
                    }
                    Thread.sleep(1000);
                }
                catch (Exception exception)
                {
                    exception.printStackTrace();
                }
            }
        }).start();

        // traverse the set back and forth every second
        new Thread( () ->
        {
            while (true)
            {
                try
                {
                    synchronized (set)
                    {
                        Iterator<Object> setIterator = set.iterator();
                        while (setIterator.hasNext())
                            System.out.print(setIterator.next() + " ");
                        System.out.println();

                        Object[] objects = set.toArray();
                        for (int i = objects.length-1; i > -1; i--)
                            System.out.print(objects[i] + " ");
                        System.out.println();
                    }
                    Thread.sleep(1000);
                }
                catch (Exception exception)
                {
                    exception.printStackTrace();
                }
            }
        }).start();
    }
}
