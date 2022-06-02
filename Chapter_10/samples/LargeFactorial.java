package chapter_ten.samples;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * Listing 10.9 LargeFactorial.java
 */
public class LargeFactorial
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter an integer: ");
        int n = input.nextInt();
        System.out.println(n + "! is \n" + factorial(n));
    }

    public static BigInteger factorial(long n)
    {
        BigInteger result = BigInteger.ONE;
        for (int i = 1; i <= n; i++)
            result = result.multiply(new BigInteger(i + ""));
        return result;
    }
}
