package chapter_ten;

import java.math.BigDecimal;

/**
 * *10.17 (Square numbers) Find the first 10 square numbers that are greater than Long.
 * MAX_VALUE. A square number is a number in the form of n²
 * . For example, 4, 9,
 * and 16 are square numbers. Find an efficient approach to run your program fast.
 *
 * @author Sharaf Qeshta
 * */

public class Problem$17
{
    public static void main(String[] args)
    {
        /*
        * 9223372037000250000
        * 9223372043074251001
        * 9223372049148252004
        * 9223372055222253009
        * 9223372061296254016
        * 9223372067370255025
        * 9223372073444256036
        * 9223372079518257049
        * 9223372085592258064
        * 9223372091666259081
        * */
        int count = 0;
        BigDecimal longMaxValue = new BigDecimal(Long.MAX_VALUE);
        long start = (long) Math.sqrt(Long.MAX_VALUE);
        BigDecimal n = new BigDecimal(start);

        while (count < 10)
        {
            BigDecimal squared = n.multiply(n);
            if (squared.compareTo(longMaxValue) > 0)
            {
                System.out.println(squared);
                count++;
            }
            n = n.add(BigDecimal.ONE);
        }
    }
}

