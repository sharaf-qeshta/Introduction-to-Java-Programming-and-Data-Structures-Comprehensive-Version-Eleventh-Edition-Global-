package chapter_two;


import java.util.Locale;
import java.util.Scanner;

/**
 * *2.22 (Financial application: monetary units) Rewrite Listing 2.10, ComputeChange.
 * java, to fix the possible loss of accuracy when converting a double value to an
 * int value. Enter the input as an integer whose last two digits represent the cents.
 * For example, the input 1156 represents 11 dollars and 56 cents.
 *
 * @author Sharaf Qeshta
 * */

public class Problem$22
{
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in).useLocale(Locale.US);

        // Compute Change
        // penny = 1 cent
        // nickel = 5 cents
        // dime = 10 cents
        // quarter = 25 cents
        // half dollar = 50 cents
        // dollar = 100 cents

        System.out.print("how many cents do you have : ");
        int cents = scan.nextInt();
        // dollars
        int dollars = cents / 100;
        int swap = cents % 100;
        // half dollars
        int halfDollars = swap / 50;
        swap %= 50;
        // quarter
        int quarters = swap / 25;
        swap %= 25;
        // dimes
        int dimes = swap / 10;
        swap %= 10;
        // nickels
        int nickels = swap / 5;
        swap %= 5;
        System.out.println(cents + " contains "+ dollars + " Dollars and "
                + halfDollars + " Half-Dollars and "
                + quarters + " Quarters and "
                + dimes + " Dimes and "
                + nickels + " Nickels and "
                + swap + " Pennies! ");
    }
}
