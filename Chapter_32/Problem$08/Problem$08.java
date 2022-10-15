package chapter_thirty_two;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 32.8 (Account synchronization) Rewrite Listing 32.6, ThreadCooperation.java, using the
 * object’s wait() and notifyAll() methods.
 *
 *
 * @author Sharaf Qeshta
 * */
public class Problem$08
{
    private static Account account = new Account();

    /**
     * sample run =>
     * Thread 1		Thread 2		Balance
     * Deposit 7					    7
     * 			    Withdraw 6		    1
     * 			    Wait for a deposit
     * Deposit 2					    3
     * 			    Wait for a deposit
     * Deposit 10					    13
     * 			    Withdraw 9		    4
     * 			    Wait for a deposit
     * Deposit 3					    7
     * 			    Wait for a deposit
     * Deposit 1					    8
     * 			    Withdraw 8		    0
     * 			    Wait for a deposit
     * Deposit 4					    4
     * 			    Wait for a deposit
     * Deposit 4					    8
     * 			    Withdraw 7		    1
     * 			    Wait for a deposit
     * Deposit 9					    10
     * 			    Withdraw 6		    4
     * 			    Withdraw 2		    2
     * 			    Wait for a deposit
     * Deposit 7					    9
     * 			    Withdraw 6		    3
     * 			    Wait for a deposit
     * Deposit 1					    4
     * 			    Wait for a deposit
     * Deposit 3					    7
     * 			    Wait for a deposit
     * Deposit 1					    8
     * 			    Wait for a deposit
     * Deposit 1					    9
     * 			    Wait for a deposit
     * Deposit 5					    14
     * 			    Withdraw 10		    4
     * 			    Wait for a deposit
     * Deposit 5					    9
     * 			    Withdraw 7		    2
     * 			    Wait for a deposit
     * */
    public static void main(String[] args)
    {
        ExecutorService executor = Executors.newFixedThreadPool(2);
        executor.execute(new DepositTask());
        executor.execute(new WithdrawTask());
        executor.shutdown();

        System.out.println("Thread 1\t\tThread 2\t\tBalance");
    }

    public static class DepositTask implements Runnable
    {
        @Override
        public void run()
        {
            try
            {
                while (true)
                {
                    account.deposit((int) (Math.random() * 10) + 1);
                    Thread.sleep(1000);
                }
            }
            catch (InterruptedException ex)
            {
                ex.printStackTrace();
            }
        }
    }

    public static class WithdrawTask implements Runnable
    {
        @Override
        public void run()
        {
            while (true)
                account.withdraw((int) (Math.random() * 10) + 1);
        }
    }

    private static class Account
    {
        private int balance = 0;

        public int getBalance()
        {
            return balance;
        }

        public synchronized void withdraw(int amount)
        {
            try
            {
                while (balance < amount)
                {
                    System.out.println("\t\t\tWait for a deposit");
                    wait();
                }

                balance -= amount;
                System.out.println("\t\t\tWithdraw " + amount +
                        "\t\t" + getBalance());
            }
            catch (InterruptedException ex)
            {
                ex.printStackTrace();
            }
            finally
            {
                notifyAll();
            }
        }

        public synchronized void deposit(int amount)
        {
            try
            {
                balance += amount;
                System.out.println("Deposit " + amount +
                        "\t\t\t\t\t" + getBalance());
            }
            finally
            {
                notifyAll();
            }
        }
    }
}
