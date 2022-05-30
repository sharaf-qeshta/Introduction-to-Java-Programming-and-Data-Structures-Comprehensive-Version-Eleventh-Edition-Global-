package chapter_ten;

import java.math.BigInteger;

/**
 * *10.16 (Divisible by 2 or 3) Find the first 10 numbers with 50 decimal digits that are
 * divisible by 2 or 3.
 *
 * @author Sharaf Qeshta
 * */

public class Problem$16
{
    public static void main(String[] args)
    {
        /*
        * 10000000000000000000000000000000000000000000000000
        * 10000000000000000000000000000000000000000000000002
        * 10000000000000000000000000000000000000000000000004
        * 10000000000000000000000000000000000000000000000005
        * 10000000000000000000000000000000000000000000000006
        * 10000000000000000000000000000000000000000000000008
        * 10000000000000000000000000000000000000000000000010
        * 10000000000000000000000000000000000000000000000011
        * 10000000000000000000000000000000000000000000000012
        * 10000000000000000000000000000000000000000000000014
        * */

        int count = 0;
        BigInteger n = new BigInteger(
                "10000000000000000000000000000000000000000000000000");
        while (count < 10)
        {
            if (BigInteger.ZERO.compareTo(n.remainder(new BigInteger("2"))) == 0 ||
                    BigInteger.ZERO.compareTo(n.remainder(new BigInteger("3"))) == 0)
            {
                System.out.println(n);
                count++;
            }
            n = n.add(BigInteger.ONE);
        }
    }
}

