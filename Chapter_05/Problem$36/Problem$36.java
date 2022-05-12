package chapter_five;

import java.util.Locale;
import java.util.Scanner;

/**
 * **5.36 (Business application: checking ISBN) Use loops to simplify Programming
 * Exercise 3.9.
 *
 * @author Sharaf Qeshta
 * */

public class Problem$36
{
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in).useLocale(Locale.US);

        System.out.print("Enter the first 9 digits of an ISBN as integer: ");
        int ISBN_9 = scan.nextInt();
        // (d1 * 1 + d2 * 2 + d3 * 3 + d4 * 4 + d5 * 5 +
        //d6 * 6 + d7 * 7 + d8 * 8 + d9 * 9)%11

        int result = 1;
        int temp = ISBN_9 / 10;
        for (int i = 9; i > 1; i--)
        {
            result += (temp % 10) * i;
            temp /= 10;
        }

        result %= 11;

        if (result == 10)
            System.out.println("The ISBN-10 number is 0" + ISBN_9 + "X");
        else
            System.out.println("The ISBN-10 number is 0" + ISBN_9 + "" + result);
    }
}

