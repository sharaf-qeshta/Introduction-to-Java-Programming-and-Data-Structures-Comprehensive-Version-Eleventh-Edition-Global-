package chapter_six;

import java.util.Scanner;

/**
 * **6.31 (Financial: credit card number validation) Credit card numbers follow certain
 * patterns. A credit card number must have between 13 and 16 digits. It must start
 * with
 * ■■ 4 for Visa cards
 * ■■ 5 for Master cards
 * ■■ 37 for American Express cards
 * ■■ 6 for Discover cards
 * In 1954, Hans Luhn of IBM proposed an algorithm for validating credit card
 * numbers. The algorithm is useful to determine whether a card number is entered
 * correctly, or whether a credit card is scanned correctly by a scanner. Credit card
 * numbers are generated following this validity check, commonly known as the
 * Luhn check or the Mod 10 check, which can be described as follows
 * (for illustration, consider the card number 4388576018402626):
 * 1. Double every second digit from right to left. If doubling of a digit results in a
 * two-digit number, add up the two digits to get a single-digit number.
 *
 * 2. Now add all single-digit numbers from Step 1.
 * 4 + 4 + 8 + 2 + 3 + 1 + 7 + 8 = 3 7
 * 3. Add all digits in the odd places from right to left in the card number.
 * 6 + 6 + 0 + 8 + 0 + 7 + 8 + 3 = 3 8
 * 4. Sum the results from Step 2 and Step 3.
 * 3 7 + 3 8 = 7 5
 * 5. If the result from Step 4 is divisible by 10, the card number is valid; otherwise,
 * it is invalid. For example, the number 4388576018402626 is invalid, but the
 * number 4388576018410707 is valid.
 * Write a program that prompts the user to enter a credit card number as a long
 * integer. Display whether the number is valid or invalid. Design your program to
 * use the following methods:
 *
 *  public static boolean isValid(long number)
 *
 *  public static int sumOfDoubleEvenPlace(long number)
 *
 *  public static int getDigit(int number)
 *
 *  public static int sumOfOddPlace(long number)
 *
 *  public static boolean prefixMatched(long number, int d)
 *
 *  public static int getSize(long d)
 *
 *  public static long getPrefix(long number, int k)
 *
 *  Here are sample runs of the program: (You may also implement this program by
 * reading the input as a string and processing the string to validate the credit card.)
 *
 *          Enter a credit card number as a long integer: 4388576018410707
 *          4388576018410707 is valid
 *
 *          Enter a credit card number as a long integer: 4388576018402626
 *          4388576018402626 is invalid
 *
 * @author Sharaf Qeshta
 * */

public class Problem$31
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a credit card number as a long integer: ");
        long number = scanner.nextLong();

        boolean valid = isValid(number);

        if (valid)
            System.out.println(number + " is valid.");
        else
            System.out.println(number + " is invalid.");
    }

    /** Return true if the card number is valid */
    public static boolean isValid(long number)
    {
        return (sumOfDoubleEvenPlace(number) + sumOfOddPlace(number)) % 10 == 0;
    }


    /** Get the result from Step 2 */
    public static int sumOfDoubleEvenPlace(long number)
    {
        int sum = 0;
        String temp = new StringBuilder(number + "").reverse().toString();

        for (int i = 0;i < getSize(number);i++)
        {
            if ((i+1) % 2 == 0)
            {
                int digit = Integer.parseInt(temp.charAt(i) + "");
                int doubleNum = digit * 2;
                sum += getDigit(doubleNum);
            }
        }
        return sum;
    }


    /** Return this number if it is a single digit, otherwise,
     * return the sum of the two digits */
    public static int getDigit(int number)
    {
        String temp = number + "";

        if (temp.length() == 1)
            return number;
        else {
            int sum = 0;
            for (int i = 0;i < getSize(number);i++)
            {
                int digit = Integer.parseInt(temp.charAt(i) + "");
                sum += digit;
            }
            return sum;
        }
    }

    /** Return sum of odd-place digits in number */
    public static int sumOfOddPlace(long number)
    {
        int sum = 0;
        String temp = new StringBuilder(number + "").reverse().toString();

        for (int i = 0;i < getSize(number);i++)
        {
            if ((i+1) % 2 == 1)
            {
                int digit = Integer.parseInt(temp.charAt(i) + "");
                sum += digit;
            }
        }
        return sum;
    }

    /** Return true if the number d is a prefix for number */
    public static boolean prefixMatched(long number, int d)
    {
        return d == getPrefix(number, 1);
    }

    /** Return the number of digits in d */
    public static int getSize(long d)
    {
        return (d+"").length();
    }

    /** Return the first k number of digits from number. If the
     * number of digits in number is less than k, return number. */
    public static long getPrefix(long number, int k)
    {
        String temp = number + "";

        if (temp.length() < k)
            return number;

        return Long.parseLong(temp.substring(0, k));
    }

}
