package chapter_twenty_two.samples;

import java.util.Scanner;

/** Listing 22.5 PrimeNumbers.java */
public class PrimeNumbers
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);

        System.out.print("Find all prime numbers <= n, enter n: ");
        int n = input.nextInt();

        final int NUMBER_PER_LINE = 10;
        int count = 0;
        int number = 2;

        System.out.println("The prime numbers are:");

        while (number <= n)
        {
            boolean isPrime = true;
            for (int divisor = 2; divisor <= (int)(Math.sqrt(number));
                 divisor++)
            {
                if (number % divisor == 0)
                {
                    isPrime = false;
                    break;
                }
            }

            if (isPrime)
            {
                count++;
                if (count % NUMBER_PER_LINE == 0)
                    System.out.printf("%7d\n", number);
                else
                    System.out.printf("%7d", number);
            }
            number++;
        }


        System.out.println("\n" + count +
                " prime(s) less than or equal to " + n);
    }
}
