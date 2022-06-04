package chapter_eleven;

import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;
import java.lang.System;

/**
 * **11.17 (Algebra: perfect square) Write a program that prompts the user to enter an
 * integer m and find the smallest integer n such that m * n is a perfect square. (Hint:
 * Store all smallest factors of m into an array list. n is the product of the factors that
 * appear an odd number of times in the array list. For example, consider m = 90,
 * store the factors 2, 3, 3, and 5 in an array list. 2 and 5 appear an odd number of
 * times in the array list. Thus, n is 10.) Here are some sample runs:
 *
 *          Enter an integer m: 1500
 *          The smallest number n for m * n to be a perfect square is 15
 *          m * n is 22500
 *
 *          Enter an integer m: 63
 *          The smallest number n for m * n to be a perfect square is 7
 *          m * n is 441
 *
 * @author Sharaf Qeshta
 * */
public class Problem$17
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in).useLocale(Locale.US);

        System.out.print("Enter an integer m: ");
        int m = scanner.nextInt();

        ArrayList<Integer> factors = getAllFactors(m);

        int n = 1;
        ArrayList<Integer> multiplied = new ArrayList<>();
        for (int item: factors)
            if (!multiplied.contains(item) && countOccurrence(factors, item) % 2 == 1 )
            {
                n *= item;
                multiplied.add(item);
            }

        System.out.println("The smallest number n for m * n to be a perfect square is " + n);

        System.out.println("m * n is " + (m*n));
    }

    public static ArrayList<Integer> getAllFactors(int m)
    {
        ArrayList<Integer> factors = new ArrayList<>();
        int i = 2; // Potential prime factor
        while (m / i != 1)
        {
            if (m % i == 0)
            {
                factors.add(i);
                m /= i;
            }
            else
                i++;
        }
        factors.add(m);
        return factors;
    }


    public static int countOccurrence(ArrayList<Integer> list, int element)
    {
        int count = 0;
        for (int item: list)
            if (item == element)
                count++;
        return count;
    }
}
