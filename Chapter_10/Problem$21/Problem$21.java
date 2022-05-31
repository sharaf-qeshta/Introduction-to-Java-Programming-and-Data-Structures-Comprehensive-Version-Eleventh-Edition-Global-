package chapter_ten;

import java.math.BigInteger;

/**
 * 10.21 (Divisible by 5 or 6) Find the first 10 numbers greater than Long.MAX_VALUE
 * that are divisible by 5 or 6.
 *
 * @author Sharaf Qeshta
 * */

public class Problem$21
{
    public static void main(String[] args)
    {
        /*
         * First ten numbers greater than Long.MAX_VALUE that are divisible by 5 or 6:
         * 9223372036854775810
         * 9223372036854775812
         * 9223372036854775815
         * 9223372036854775818
         * 9223372036854775820
         * 9223372036854775824
         * 9223372036854775825
         * 9223372036854775830
         * 9223372036854775835
         * 9223372036854775836
         * */
        int count = 0;
        BigInteger n = new BigInteger(String.valueOf(Long.MAX_VALUE));
        BigInteger five = new BigInteger("5");
        BigInteger six = new BigInteger("6");

        System.out.println("\nFirst ten numbers greater than Long.MAX_VALUE" +
                " that are divisible by 5 or 6:");
        while (count < 10)
        {
            n = n.add(new BigInteger("1"));
            if ((n.remainder(five)).compareTo(BigInteger.ZERO) == 0 ||
                    (n.remainder(six)).compareTo(BigInteger.ZERO) == 0)
            {
                System.out.println(n);
                count++;
            }
        }
    }
}

