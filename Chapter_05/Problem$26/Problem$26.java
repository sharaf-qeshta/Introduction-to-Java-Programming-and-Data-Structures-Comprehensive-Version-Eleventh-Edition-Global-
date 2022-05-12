package chapter_five;

/**
 * **5.26 (Compute e) You can approximate e using the following summation:
 *  e = 1 + 1/1! + 1/2! + 1/3! + 1/4! + ... + 1/i!
 *  Write a program that displays the e value for i = 10000, 20000, …, and 100000.
 * (Hint: Because i! = i * (i - 1) * c * 2 * 1, then
 *      1/i! = 1/i(i-1)!
 *  Initialize e and item to be 1, and keep adding a new item to e. The new item is
 * the previous item divided by i, for i >= 2.)
 *
 * @author Sharaf Qeshta
 * */

public class Problem$26
{
    public static void main(String[] args)
    {
        double e = 1, previous = 1;
        for (int i = 1; i < 100_001; i++)
        {
            previous = previous/i;
            e += previous;

            if (i <= 50_000)
            {
                if (i == 10_000)
                    System.out.println("e for 10,000: " + e);
                else if (i == 20_000)
                    System.out.println("e for 20,000: " + e);
                else if (i == 30_000)
                    System.out.println("e for 30,000: " + e);
                else if (i == 40_000)
                    System.out.println("e for 40,000: " + e);
                else if (i == 50_000)
                    System.out.println("e for 50,000: " + e);
            }
            else
            {
                if (i == 60_000)
                    System.out.println("e for 60,000: " + e);
                else if (i == 70_000)
                    System.out.println("e for 70,000: " + e);
                else if (i == 80_000)
                    System.out.println("e for 80,000: " + e);
                else if (i == 90_000)
                    System.out.println("e for 90,000: " + e);
                else if (i == 100_000)
                    System.out.println("e for 100,000: " + e);
            }
        }
    }
}

