package chapter_five;

import java.util.Locale;
import java.util.Scanner;

/**
 * *5.14 (Compute the greatest common divisor) Another solution for Listing 5.9 to find the
 * greatest common divisor of two integers n1 and n2 is as follows: First find d to be
 * the minimum of n1 and n2, then check whether d, d–1, d–2, …, 2, or 1 is a
 * divisor for both n1 and n2 in this order. The first such common divisor is the greatest
 * common divisor for n1 and n2. Write a program that prompts the user to enter two
 * positive integers and displays the gcd.
 *
 * @author Sharaf Qeshta
 * */

public class Problem$14
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in).useLocale(Locale.US);

        System.out.print("enter two positive integers: ");
        int n1 = scanner.nextInt(), n2 = scanner.nextInt();

        int d = Math.min(n1, n2);
        for (int i = d; i > 1; i--)
        {
            if (n1 % i == 0 & n2 % i == 0)
            {
                System.out.println(i + " is the greatest common divisor for " + n1 + " and " + n2);
                break;
            }
        }
    }
}
