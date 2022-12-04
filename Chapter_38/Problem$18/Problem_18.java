package chapter38;

import java.math.BigInteger;

/**
 * *38.18 (Large factorial) Rewrite Listing 38.11 to handle a large factorial. Use the
 * BigInteger class introduced in §14.12.
 *
 * @author Sharaf Qeshta
 * */
public class Problem_18
{
    private int number;

    /**
     * Return number property
     */
    public int getNumber()
    {
        return number;
    }

    /**
     * Set number property
     */
    public void setNumber(int newValue)
    {
        number = newValue;
    }

    /**
     * Obtain factorial
     */
    public BigInteger getFactorial()
    {
        BigInteger factorial = new BigInteger("1");
        for (int i = 1; i <= number; i++)
            factorial = factorial.multiply(new BigInteger(i + ""));
        return factorial;
    }
}