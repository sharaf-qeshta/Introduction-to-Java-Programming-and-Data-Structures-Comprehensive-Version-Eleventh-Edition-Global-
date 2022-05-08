package chapter_four;


import java.util.Locale;
import java.util.Scanner;

/**
 * 4.19 (Business: check ISBN-10) Rewrite Programming Exercise 3.9 by entering the
 * ISBN number as a string.
 *
 * @author Sharaf Qeshta
 * */

public class Problem$19
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in).useLocale(Locale.US);

        System.out.print("Enter the first 9 digits of an ISBN as integer: ");
        String input = scanner.next();
        int ISBN_9 = Integer.parseInt(input);
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
