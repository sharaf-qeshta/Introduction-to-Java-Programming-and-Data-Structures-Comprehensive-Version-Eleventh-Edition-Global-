package chapter_thirty_two.samples;

/**
 * Listing 32.1 TaskThreadDemo.java
 * */
public class TaskThreadDemo
{
    public static void main(String[] args)
    {
        // Create tasks
        Runnable printA = new PrintChar('a', 100);
        Runnable printB = new PrintChar('b', 100);
        Runnable print100 = new PrintNum(100);

        // Create threads
        Thread thread1 = new Thread(printA);
        Thread thread2 = new Thread(printB);
        Thread thread3 = new Thread(print100);

        // Start threads
        thread1.start();
        thread2.start();
        thread3.start();
    }
}

// The task for printing a character a specified number of times
class PrintChar implements Runnable
{
    private char charToPrint; // The character to print
    private int times; // The number of times to repeat

    /**
     * Construct a task with a specified character and number of
     * times to print the character
     */
    public PrintChar(char c, int t)
    {
        charToPrint = c;
        times = t;
    }

    /**
     * Override the run() method to tell the system
     * what task to perform
     */
    @Override
    public void run()
    {
        for (int i = 0; i < times; i++)
        {
            System.out.print(charToPrint);
        }
    }
}

// The task class for printing numbers from 1 to n for a given n
class PrintNum implements Runnable
{
    private int lastNum;

    /**
     * Construct a task for printing 1, 2, ..., n
     */
    public PrintNum(int n)
    {
        lastNum = n;
    }

    /**
     * Tell the thread how to run
     */
    @Override
    public void run()
    {
        for (int i = 1; i <= lastNum; i++)
        {
            System.out.print(" " + i);
        }
    }
}
