package chapter_eighteen;

/**
 * *18.23 (Binary to decimal) Write a recursive method that parses a binary number as a
 * string into a decimal integer. The method header is
 * public static int bin2Dec(String binaryString)
 * Write a test program that prompts the user to enter a binary string and displays
 * its decimal equivalent.
 *
 *
 * @author Sharaf Qeshta
 */
public class Problem$23
{
    public static void main(String[] args)
    {
        System.out.println(bin2Dec("1010")); // 10
        System.out.println(bin2Dec("1111")); // 15
        System.out.println(bin2Dec("10100")); // 20
    }


    public static int bin2Dec(String binaryString)
    {
        if (binaryString.length() == 0)
            return 0;

        int digit = Integer.parseInt(binaryString.charAt(0) + "");
        int value = (int) (digit * (Math.pow(2, binaryString.length() - 1)));
        return bin2Dec(binaryString.substring(1)) + value;
    }
}
