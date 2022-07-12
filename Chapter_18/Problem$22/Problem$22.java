package chapter_eighteen;

/**
 * *18.22 (Decimal to hex) Write a recursive method that converts a decimal number into
 * a hex number as a string. The method header is
 * public static String dec2Hex(int value)
 * Write a test program that prompts the user to enter a decimal number and displays
 * its hex equivalent.
 *
 *
 * @author Sharaf Qeshta
 * */
public class Problem$22
{
    public static void main(String[] args)
    {
        System.out.println(dec2Hex(10)); // A
        System.out.println(dec2Hex(15)); // F
        System.out.println(dec2Hex(20)); // 14
    }

    public static String dec2Hex(int value)
    {
        if (value == 0)
            return "";
        else
            return dec2Hex(value/16) + getHexValue(value%16);
    }

    private static String getHexValue(int digit)
    {
        if (digit > 9)
            return ((char) (digit + 55)) + "";
        else
            return digit + "";
    }
}
