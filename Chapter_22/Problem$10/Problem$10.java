package chapter_twenty_two;

import java.io.RandomAccessFile;

/**
 * 22.10 (Number of prime numbers) Programming Exercise 22.8 stores the prime numbers
 * in a file named PrimeNumbers.dat. Write a program that finds the number
 * of prime numbers that are less than or equal to 12, 120, 1,200, 12,000,
 * 100,000, 1,200,000, 12,000,000, 120,000,000, 1,200,000,000, and
 * 12,000,000,000. Your program should read the data from PrimeNumbers.dat.
 *
 *
 * @author Sharaf Qeshta
 * */
public class Problem$10
{
    private static final String FILE_PATH = "src/chapter_twenty_two/PrimeNumbers.dat";
    private static final Long[] RANGES = {12L, 120L, 1_200L, 12_000L, 100_000L, 1_200_00L,
                                            12_000_000L, 120_000_000L, 1_200_000_000L, 12_000_000_000L};

    public static void main(String[] args)
    {
        /*
        * Prime Numbers less than or equal to 12 is 5 Prime Numbers.
        * Prime Numbers less than or equal to 120 is 30 Prime Numbers.
        * Prime Numbers less than or equal to 1200 is 196 Prime Numbers.
        * Prime Numbers less than or equal to 12000 is 1438 Prime Numbers.
        * Prime Numbers less than or equal to 100000 is 6603 Prime Numbers.
        * Prime Numbers less than or equal to 120000 is 6603 Prime Numbers.
        * Prime Numbers less than or equal to 12000000 is 6603 Prime Numbers.
        * Prime Numbers less than or equal to 120000000 is 6603 Prime Numbers.
        * Prime Numbers less than or equal to 1200000000 is 6603 Prime Numbers.
        * Prime Numbers less than or equal to 12000000000 is 6603 Prime Numbers.
        * */
        for (Long range : RANGES)
            System.out.println("Prime Numbers less than or equal to "
                    + range + " is " + getNumberOfPrimes(range) + " Prime Numbers.");

    }

    public static int getNumberOfPrimes(long lessThan)
    {
        int numberOfPrimes = 0;
        try(RandomAccessFile reader = new RandomAccessFile(FILE_PATH, "r"))
        {
            while (true)
            {
                long prime = reader.readLong();
                if (prime <= lessThan)
                    numberOfPrimes++;
                else
                    return numberOfPrimes;
            }
        }
        catch (Exception ignored) { }
        return numberOfPrimes;
    }
}
