package chapter_thirty_two;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 32.4 (Synchronize threads) Write a program that launches 1,000 threads. Each thread
 * adds 1 to a variable sum that initially is 0. You need to pass sum by reference to
 * each thread. In order to pass it by reference, define an Integer wrapper object to
 * hold sum. Run the program with and without synchronization to see its effect.
 *
 *
 * @author Sharaf Qeshta
 * */
public class Problem$04
{
    private static Integer integer = new Integer(0);

    public static void main(String[] args)
    {
        ExecutorService executor = Executors.newFixedThreadPool(1_000);
        for (int i = 0; i < 1_000; i++)
            executor.execute(Problem$04::add1WithSynchronization);

        executor.shutdown();

        while (executor.isTerminated());

        // output always 1000
        System.out.println(integer);

        integer = new Integer(0);

        ExecutorService executor2 = Executors.newFixedThreadPool(1_000);

        for (int i = 0; i < 1_000; i++)
            executor2.execute(Problem$04::add1WithoutSynchronization);

        executor2.shutdown();

        while (executor2.isTerminated());

        // the output differ
        System.out.println(integer);
    }

    public static synchronized void add1WithSynchronization()
    {
        integer = new Integer(integer.intValue() + 1);
    }

    public static void add1WithoutSynchronization()
    {
        integer = new Integer(integer.intValue() + 1);
    }
}
