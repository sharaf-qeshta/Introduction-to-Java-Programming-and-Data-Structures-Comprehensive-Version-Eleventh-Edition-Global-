package chapter_twenty_two;


/** Listing 22.5 PrimeNumbers.java */
public class PrimeNumbers
{
    public static void primeNumbers(int n)
    {
        int number = 2;
        int count = 0;
        while (number <= n)
        {
            boolean isPrime = true;
            for (int divisor = 2; divisor <= (int)(Math.sqrt(number));
                 divisor++)
            {
                if (number % divisor == 0)
                {
                    isPrime = false;
                    break;
                }
            }

            if (isPrime)
            {
                count++;
            }
            number++;
        }
    }
}
