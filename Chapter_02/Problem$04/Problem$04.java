package chapter_two;

import java.util.*;

/**
 * 2.4 (Convert square meter into ping) Write a program that converts square meter into ping.
 * The program prompts the user to enter a number in square meter, converts it to ping,
 * and displays the result. One square meter is 0.3025 ping.
 * Here is a sample run:
 *      Enter a number in square meters: 50
 *      50.0 square meters is 15.125 pings
 *
 * @author Sharaf Qeshta
 * */

public class Problem$04
{
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in).useLocale(Locale.US);
        System.out.print("Enter a number in square meters: ");
        double squareMeters = scan.nextDouble();
        double pings =  0.3025 * squareMeters;
        System.out.println(squareMeters + " square meters is "+ pings + " pings");
    }
}
