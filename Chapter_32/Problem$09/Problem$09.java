package chapter_thirty_two;

import java.util.HashSet;
import java.util.Iterator;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 32.9 (Demonstrate ConcurrentModificationException) The iterator is fail-fast.
 * Write a program to demonstrate it by creating two threads that concurrently access
 * and modify a set. The first thread creates a hash set filled with numbers and adds
 * a new number to the set every second. The second thread obtains an iterator for
 * the set and traverses the set back and forth through the iterator every second. You
 * will receive a ConcurrentModificationException because the underlying
 * set is being modified in the first thread while the set in the second thread is being
 * traversed.
 *
 *
 * @author Sharaf Qeshta
 * */
public class Problem$09
{
    public static void main(String[] args)
    {
        HashSet<Integer> set = new HashSet<>();

        // adding a number to the set every second
        new Thread( () ->
        {
            while (true)
            {
                try
                {
                    set.add(set.size()+1);
                    // if you don`t receive ConcurrentModificationException
                    // try to decrease sleeping time
                    Thread.sleep(1_000);
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
                    Iterator<Integer> setIterator = set.iterator();
                    while (setIterator.hasNext())
                        System.out.print(setIterator.next() + " ");
                    System.out.println();

                    Object[] objects = set.toArray();
                    for (int i = objects.length-1; i > -1; i--)
                        System.out.print(objects[i] + " ");
                    System.out.println();

                    // if you don`t receive ConcurrentModificationException
                    // try to decrease sleeping time
                    Thread.sleep(1_000);
                }
                catch (Exception exception)
                {
                    exception.printStackTrace();
                }
            }
        }).start();
    }
}
