package chapter_seven;


/**
 * 7.6 (The Sieve of Eratosthenes) The Sieve of Eratosthenes is an algorithm that finds all
 * prime numbers up to a given limit, n. It works by creating an array of Booleans,
 * flag, of size n+1, initializing the array to true (assuming every number is a
 * prime number in the beginning), and iteratively traversing the numbers from 2
 * to n, setting the values of indices that are multiples of other numbers to false.
 * Write a program using the algorithm above, and display all the prime numbers
 * up to 50.
 *
 * @author Sharaf Qeshta
 * */

public class Problem$06
{
    public static void main(String[] args)
    {
        boolean[] flag = sieveOfEratosthenes(50);

        /* 2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, */
        for (int i = 0; i < flag.length; i++)
        {
            if (flag[i])
                System.out.print((i+1) + ", ");
        }
    }

    public static boolean[] sieveOfEratosthenes(int n)
    {
        boolean[] flag = new boolean[n];
        flag[0] = false; // for 1
        flag[1] = true; // for 2

        for (int i = 3; i < n+1;i++)
        {
            boolean prime = true;
            for (int j = 2; j < i;j++)
            {
                if (i % j == 0)
                {
                    prime = false;
                    break;
                }
            }
            flag[i-1] = prime;
        }
        return flag;
    }

}
