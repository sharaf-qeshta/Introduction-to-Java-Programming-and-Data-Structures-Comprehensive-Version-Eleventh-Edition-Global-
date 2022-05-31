package chapter_ten;

import java.math.BigInteger;

/**
 * *10.19 (Mersenne prime) A prime number is called a Mersenne prime if it can be
 * written in the form 2^p - 1 for some positive integer p. Write a program that finds
 * all Mersenne primes with p … 100 and displays the output as shown below.
 * (Hint: You have to use BigInteger to store the number because it is too big to
 * be stored in long. Your program may take several hours to run.)
 *
 *  p           2^p – 1
 *  ---------------------
 *  2           3
 *  3           7
 *  5           31
 *  ...
 *
 * @author Sharaf Qeshta
 * */

public class Problem$19
{
    public static void main(String[] args)
    {
        System.out.println(String.format("%-10s", "p") + "2^p – 1");
        System.out.println("---------------------");

        for (int p = 2; p < 101;p++)
        {
            if (isPrime(p))
            {
                BigInteger output = new BigInteger("2").pow(p);
                output = output.subtract(BigInteger.ONE);
                System.out.println(String.format("%-10d", p) + output);
            }

        }
    }

    public static boolean isPrime(int value)
    {
        for (int i = 2; i < (value/2)+1; i++)
            if (value % i  == 0)
                return false;
        return true;
    }
}

