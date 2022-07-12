package chapter_eighteen;

/**
 * *18.21 (Decimal to binary) Write a recursive method that converts a decimal number
 * into a binary number as a string. The method header is
 * public static String dec2Bin(int value)
 * Write a test program that prompts the user to enter a decimal number and displays
 * its binary equivalent.
 *
 *
 * @author Sharaf Qeshta
 * */
public class Problem$21
{
    public static void main(String[] args)
    {
        System.out.println(dec2Bin(10)); // 1010
        System.out.println(dec2Bin(15)); // 1111
        System.out.println(dec2Bin(20)); // 10100
    }

    public static String dec2Bin(int value)
    {
        if (value == 0)
            return "";
        return dec2Bin(value/2) + value%2;
    }
}
