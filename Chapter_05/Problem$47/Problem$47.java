package chapter_five;

import java.util.Locale;
import java.util.Scanner;

/**
 * *5.47 (Business: check ISBN-13) ISBN-13 is a new standard for identifying books. It uses
 * 13 digits d1d2d3d4d5d6d7d8d9d10d11d12d13. The last digit d13 is a checksum, which is
 * calculated from the other digits using the following formula:
 * 10 - (d1 + 3d2 + d3 + 3d4 + d5 + 3d6 + d7 + 3d8 + d9 + 3d10 + d11 + 3d12),10
 *  If the checksum is 10, replace it with 0. Your program should read the input as a
 * string. Here are sample runs:
 *
 *          Enter the first 12 digits of an ISBN-13 as a string: 978013213080
 *          The ISBN-13 number is 9780132130806
 *
 *          Enter the first 12 digits of an ISBN-13 as a string: 978013213079
 *          The ISBN-13 number is 9780132130790
 *
 *          Enter the first 12 digits of an ISBN-13 as a string: 97801320
 *          97801320 is an invalid input
 *
 * @author Sharaf Qeshta
 * */


public class Problem$47
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in).useLocale(Locale.US);

        System.out.print("Enter the first 12 digits of an ISBN-13 as a string: ");
        String ISBN_12 = scanner.next();

        if (ISBN_12.length() != 12)
        {
            System.out.println(ISBN_12 + " is an invalid input");
            System.exit(-1);
        }

        int lastChar = 0;

        // 10 - (d1 + 3d2 + d3 + 3d4 + d5 + 3d6 + d7 + 3d8 + d9 + 3d10 + d11 + 3d12) % 10

        int summation = 0;

        for (int i = 0; i < ISBN_12.length(); i++)
        {
            int x = Integer.parseInt(ISBN_12.charAt(i) + "");

            if (i % 2 == 0)
                summation += 3 * x;
            else
                summation += x;
        }

        summation = 10 - summation % 10;

        if (summation != 10)
            lastChar = summation;

        ISBN_12 = ISBN_12 + lastChar;

        System.out.println("The ISBN-13 number is " + ISBN_12);
    }
}

