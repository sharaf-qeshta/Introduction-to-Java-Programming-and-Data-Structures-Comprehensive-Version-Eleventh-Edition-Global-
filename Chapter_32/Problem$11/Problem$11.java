package chapter_thirty_two;

/**
 * *32.11 (Demonstrate deadlock) Write a program that demonstrates deadlock.
 *
 *
 * @author Sharaf Qeshta
 * */
public class Problem$11
{
    private static final IntegerHolder HOLDER = new IntegerHolder(0);

    public static void main(String[] args)
    {
        // both threads waiting the other to change
        // the value of x so we get a deadlock
        // that`s it two or more threads waiting
        // each other
        Thread thread1 = new Thread(HOLDER::increment);
        Thread thread2 = new Thread(HOLDER::decrement);

        thread1.start();
        thread2.start();
    }


    private static class IntegerHolder
    {
        int x;

        public IntegerHolder(int x)
        {
            this.x = x;
        }

        public synchronized void increment()
        {
            try
            {
                while (x >= 0)
                {
                    System.out.println("Waiting for thread2 to decrement x : " + x);
                    wait();
                }
                x++;
                notifyAll();
            }
            catch (Exception exception)
            {
                exception.printStackTrace();
            }
        }

        public synchronized void decrement()
        {
            try
            {
                while (x <= 0)
                {
                    System.out.println("Waiting for thread1 to increment x : " + x);
                    wait();
                }
                x--;
                notifyAll();
            }
            catch (Exception exception)
            {
                exception.printStackTrace();
            }

        }
    }
}
