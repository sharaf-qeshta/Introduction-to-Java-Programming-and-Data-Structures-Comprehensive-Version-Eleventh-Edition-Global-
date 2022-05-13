package chapter_six;

/**
 * 6.10 (Use the isPrime Method) Listing 6.7, PrimeNumberMethod.java, provides the
 * isPrime(int number) method for testing whether a number is prime. Use this
 * method to find the number of prime numbers less than 10000.
 *
 * @author Sharaf Qeshta
 * */

public class Problem$10
{
    public static void main(String[] args)
    {
        int primeCounts = 0;
        for (int i = 2; i < 10_000;i++)
        {
            if (isPrime(i))
                primeCounts++;
        }
        System.out.println(primeCounts); // 1229
    }

    public static boolean isPrime(int number)
    {
        if (number < 2)
            return false;

        if (number == 2)
            return true;

        for (int i = 2; i < (number/2)+1;i++)
        {
            if (number % i == 0)
            {
                return false;
            }
        }
        return true;
    }
}
