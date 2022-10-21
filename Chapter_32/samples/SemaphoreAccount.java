package chapter_thirty_two.samples;

import java.util.concurrent.Semaphore;

public class SemaphoreAccount
{
    // Create a semaphore
    private static Semaphore semaphore = new Semaphore(1);
    private int balance = 0;

    public int getBalance()
    {
        return balance;
    }

    public void deposit(int amount)
    {
        try
        {
            semaphore.acquire(); // Acquire a permit
            int newBalance = balance + amount;

            // This delay is deliberately added to magnify the
            // data-corruption problem and make it easy to see
            Thread.sleep(5);

            balance = newBalance;
        }
        catch (InterruptedException ex) { }
        finally
        {
            semaphore.release(); // Release a permit
        }
    }
}

