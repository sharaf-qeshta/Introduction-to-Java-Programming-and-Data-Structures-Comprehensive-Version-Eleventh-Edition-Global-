package chapter_twenty_two.samples;

import java.util.Scanner;

/** Listing 22.4 GCDEuclid.java */
public class GCDEuclid
{
    public static int gcd(int m, int n)
    {
        if (m % n == 0)
            return n;
        else
            return gcd(n, m % n);
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
