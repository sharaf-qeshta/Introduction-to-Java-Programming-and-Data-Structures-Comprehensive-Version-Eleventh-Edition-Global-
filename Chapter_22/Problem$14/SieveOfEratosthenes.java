package chapter_twenty_two;


/** Listing 22.7 SieveOfEratosthenes.java */
public class SieveOfEratosthenes
{
    public static void sieveOfEratosthenes(int n)
    {
        boolean[] primes = new boolean[n + 1];

        for (int i = 0; i < primes.length; i++)
        {
            primes[i] = true;
        }

        for (int k = 2; k <= n / k; k++)
        {
            if (primes[k])
            {
                for (int i = k; i <= n / k; i++)
                    primes[k * i] = false;
            }
        }

        int count = 0;

        for (int i = 2; i < primes.length; i++)
        {
            if (primes[i])
            {
                count++;
            }
        }
    }
}
