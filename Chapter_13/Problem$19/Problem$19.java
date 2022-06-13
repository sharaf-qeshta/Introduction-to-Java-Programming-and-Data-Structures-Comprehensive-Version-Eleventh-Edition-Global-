package chapter_thirteen;

import java.math.BigInteger;
import java.util.Locale;
import java.util.Scanner;


/**
 * 13.19 (Convert decimals to fractions) Write a program that prompts the user to enter a
 * decimal number and displays the number in a fraction. (Hint: read the decimal
 * number as a string, extract the integer part and fractional part from the string,
 * and use the BigInteger implementation of the Rational class in Programming
 * Exercise 13.15 to obtain a rational number for the decimal number.) Here are some
 * sample runs:
 *
 *          Enter a decimal number: 3.25
 *          The fraction number is 13/4
 *
 *          Enter a decimal number: –0.45452
 *          The fraction number is –11363/25000
 *
 * @author Sharaf Qeshta
 * */
public class Problem$19
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in).useLocale(Locale.US);

        System.out.print("Enter a decimal number: ");
        double decimal = scanner.nextDouble();

        int denominator = (decimal + "").split("\\.")[1].length() * 10;
        int numerator = (int) (decimal * denominator);
        int gcd = findGCD(numerator, denominator);

        System.out.println((numerator/gcd) + "/" + (denominator/gcd));
    }

    public static int findGCD(int number1, int number2)
    {
        //base case
        if(number2 == 0)
            return number1;
        return findGCD(number2, number1%number2);
    }
}


