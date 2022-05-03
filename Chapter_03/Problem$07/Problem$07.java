package chapter_three;

import java.util.Locale;
import java.util.Scanner;

/**
 * 3.7 (Financial application: monetary units) Modify Listing 2.10, ComputeChange.
 * java, to display the nonzero denominations only, using singular words for single
 * units such as 1 dollar and 1 penny, and plural words for more than one unit such as
 * 2 dollars and 3 pennies
 *
 * @author Sharaf Qeshta
 * */

public class Problem$07
{
    public static String coinFormat(int value)
    {
        if (value > 1)
            return "s";
        return "";
    }

    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in).useLocale(Locale.US);
        System.out.print("enter cents : ");
        int cents = scan.nextInt();

        int halfDollars = cents / 50;
        int temp = cents % 50;
        int quarters = temp / 25;
        temp %= 25;
        int dimes = temp / 10;
        temp %= 10;
        int nickels = temp / 5;
        temp %= 5;

        System.out.println(cents + " cent" + coinFormat(cents) + " contain " +
                + halfDollars +" half-dollar" + coinFormat(halfDollars)
                + " and " + quarters +" Quarter" +  coinFormat(quarters)
                + " and " + dimes + " Dime" + coinFormat(dimes)
                + " and " + nickels + " Nickel" + coinFormat(nickels)
                + " and " + temp + " cent" + coinFormat(temp));
    }
}
