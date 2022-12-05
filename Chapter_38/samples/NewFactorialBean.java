package chapter38;

import java.text.*;

public class NewFactorialBean
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
    public long getFactorial()
    {
        long factorial = 1;
        for (int i = 1; i <= number; i++)
            factorial *= i;
        return factorial;
    }

    /**
     * Format number
     */
    public static String format(long number)
    {
        NumberFormat format = NumberFormat.getNumberInstance();
        return format.format(number);
    }
}
