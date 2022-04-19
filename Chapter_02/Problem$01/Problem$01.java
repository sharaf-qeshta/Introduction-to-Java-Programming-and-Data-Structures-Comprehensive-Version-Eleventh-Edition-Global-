package chapter_two;

import java.util.*;

/**
 * 2.1 (Convert mile to kilometer) Write a program that reads a mile in a double value
 * from the console, converts it to kilometers, and displays the result. The formula
 * for the conversion is as follows:
 *  1 mile = 1.6 kilometers
 *  Here is a sample run:
 *      Enter miles: 96
 *      96 miles is 153.6 kilometers
 *
 * @author Sharaf Qeshta
 * */

public class Problem$01
{
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in).useLocale(Locale.US);
        System.out.print("Enter Miles : ");
        double miles = scan.nextDouble();
        double kilometers = miles * 1.6;
        System.out.println(miles + " miles is "+ kilometers + " kilometers");
    }
}
