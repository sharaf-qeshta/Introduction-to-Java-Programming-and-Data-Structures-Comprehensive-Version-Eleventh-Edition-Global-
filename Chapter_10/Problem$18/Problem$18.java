package chapter_ten;

import java.math.BigInteger;

/**
 * *10.18 (Large prime numbers) Write a program that finds five prime numbers larger
 * than Long.MAX_VALUE.
 *
 * @author Sharaf Qeshta
 * */

public class Problem$18
{
    public static void main(String[] args)
    {
        int count = 0;
        BigInteger n = new BigInteger(Long.MAX_VALUE + "");

        while (count < 10)
        {
            if (isPrime(n))
            {
                System.out.println(n);
                count++;
            }
            n = n.add(BigInteger.TWO);
        }
    }

    public static boolean isPrime(BigInteger num)
    {
        BigInteger half = num.divide(BigInteger.TWO);
        half = half.add(BigInteger.ONE);
        BigInteger start = BigInteger.TWO;

        while (start.compareTo(half) < 0)
        {
            if (num.remainder(start).compareTo(BigInteger.ZERO) == 0)
                return false;
            start = start.add(BigInteger.ONE);
        }
        return true;
    }
}

