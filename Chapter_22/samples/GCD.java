package chapter_twenty_two.samples;

import java.util.Scanner;

/** Listing 22.3 GCD.java */
public class GCD
{
    public static int gcd(int m, int n)
    {
        int gcd = 1;

        if (m % n == 0) return n;

        for (int k = n / 2; k >= 1; k--)
        {
            if (m % k == 0 && n % k == 0)
            {
                gcd = k;
                break;
            }
        }
        return gcd;
    }


    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter first integer: ");
        int m = input.nextInt();
        System.out.print("Enter second integer: ");
        int n = input.nextInt();

        System.out.println("The greatest common divisor for " + m +
                " and " + n + " is " + gcd(m, n));
    }
}
