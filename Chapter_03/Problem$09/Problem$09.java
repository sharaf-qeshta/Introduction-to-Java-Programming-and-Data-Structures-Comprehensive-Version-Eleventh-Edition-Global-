package chapter_three;

import java.util.Locale;
import java.util.Scanner;

/**
 * **3.9 (Business: check ISBN-10) An ISBN-10 (International Standard Book Number)
 * consists of 10 digits: d1d2d3d4d5d6d7d8d9d10. The last digit, d10, is a checksum,
 * which is calculated from the other 9 digits using the following formula:
 * (d1 * 1 + d2 * 2 + d3 * 3 + d4 * 4 + d5 * 5 +
 * d6 * 6 + d7 * 7 + d8 * 8 + d9 * 9),11
 *  If the checksum is 10, the last digit is denoted as X according to the ISBN-10
 * convention. Write a program that prompts the user to enter the first 9 digits and
 * displays the 10-digit ISBN (including leading zeros). Your program should read
 * the input as an integer. Here are sample runs:
 *
 *      Enter the first 9 digits of an ISBN as integer: 013601267
 *      The ISBN-10 number is 0136012671
 *
 *      Enter the first 9 digits of an ISBN as integer: 013031997
 *      The ISBN-10 number is 013031997X
 *
 * @author Sharaf Qeshta
 * */

public class Problem$09
{
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in).useLocale(Locale.US);

        System.out.print("Enter the first 9 digits of an ISBN as integer: ");
        int ISBN_9 = scan.nextInt();
        // (d1 * 1 + d2 * 2 + d3 * 3 + d4 * 4 + d5 * 5 +
        //d6 * 6 + d7 * 7 + d8 * 8 + d9 * 9)%11
        int result = (ISBN_9 % 10) * 9;
        int temp = ISBN_9 / 10;

        result += (temp % 10) * 8;
        temp /= 10;

        result += (temp % 10) * 7;
        temp /= 10;

        result += (temp % 10) * 6;
        temp /= 10;

        result += (temp % 10) * 5;
        temp /= 10;

        result += (temp % 10) * 4;
        temp /= 10;

        result += (temp % 10) * 3;
        temp /= 10;

        result += (temp % 10) * 2;

        result %= 11;

        if (result == 10)
            System.out.println("The ISBN-10 number is 0" + ISBN_9 + "X");
        else
            System.out.println("The ISBN-10 number is 0" + ISBN_9 + "" + result);
    }
}
