package chapter_thirteen;

import java.math.BigInteger;


/**
 * 13.18 (Use the Rational class) Write a program that computes the following summation
 * series using the Rational
 *
 *      1/2 + 3/4 + 5/6 + ... + 97/98 + 99/100
 * You will discover that the output is incorrect because of integer overflow (too
 * large). To fix this problem, see Programming Exercise 13.15
 *
 * @author Sharaf Qeshta
 * */
public class Problem$18
{
    public static void main(String[] args)
    {
        Rational result = new Rational();
        int j = 2;
        for (int i = 1; i < 100; i+=2, j+=2)
            result = result.add(new Rational
                    (new BigInteger(i + ""), new BigInteger(j + "")));
        System.out.println(result);
    }
}


