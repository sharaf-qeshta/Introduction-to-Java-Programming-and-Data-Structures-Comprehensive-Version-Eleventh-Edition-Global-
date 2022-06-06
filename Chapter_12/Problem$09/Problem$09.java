package chapter_twelve;


import java.util.Scanner;

/**
 * *12.9 (BinaryFormatException) Exercise 12.7 implements the bin2Dec method
 * to throw a BinaryFormatException if the string is not a binary string. Define
 * a custom exception called BinaryFormatException. Implement the bin2Dec
 * method to throw a BinaryFormatException if the string is not a binary string
 *
 * @author Sharaf Qeshta
 * */
public class Problem$09
{
    public static void main(String[] args) throws BinaryFormatException
    {
        System.out.println(bin2Dec("1100100")); // 100
        System.out.println(bin2Dec("hello")); // Exception
    }

    public static int bin2Dec(String binary) throws BinaryFormatException
    {
        if (!isBinary(binary))
            throw new BinaryFormatException(binary + " is not a binary number.");

        int power = 0;
        int decimal = 0;
        for (int i = binary.length() - 1; i >= 0; i--)
        {
            if (binary.charAt(i) == '1')
                decimal += Math.pow(2, power);
            power++;
        }
        return decimal;
    }

    public static boolean isBinary(String binary)
    {
        for (char ch : binary.toCharArray())
            if (ch != '1' && ch != '0')
                return false;
        return true;
    }
}
