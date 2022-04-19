package chapter_two;

import java.util.*;

/**
 * 2.3 (Convert meters into feet) Write a program that reads a number in meters, converts
 * it to feet, and displays the result. One meter is 3.2786 feet. Here is a sample run:
 *      Enter a value for meter: 10
 *      10.0 meters is 32.786 feet
 *
 * @author Sharaf Qeshta */

public class Problem$03
{
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in).useLocale(Locale.US);
        System.out.print("Enter a value for meter: ");
        double meters = scan.nextDouble();
        double feet = meters * 3.2786;
        System.out.println(meters + " meters is " + feet + " feet");
    }
}
