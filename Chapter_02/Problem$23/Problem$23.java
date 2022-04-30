package chapter_two;

import java.util.Locale;
import java.util.Scanner;

/**
 * *2.23 (Cost of driving) Write a program that prompts the user to enter the distance to
 * drive, the fuel efficiency of the car in miles per gallon, and the price per gallon
 * then displays the cost of the trip. Here is a sample run:
 *      Enter the driving distance: 900.5
 *      Enter miles per gallon: 25.5
 *      Enter price per gallon: 3.55
 *      The cost of driving is $125.36
 *
 * @author Sharaf Qeshta
 * */

public class Problem$23
{
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in).useLocale(Locale.US);
        // driving distance
        System.out.print("Enter the driving distance: ");
        double drivingDistance = scan.nextDouble();
        // miles per gallon
        System.out.print("Enter miles per gallon: ");
        double milesPerGallon = scan.nextDouble();
        // price per gallon
        System.out.print("Enter price per gallon: ");
        double pricePerGallon = scan.nextDouble();

        double gallonsNeeded = drivingDistance / milesPerGallon;
        double cost = gallonsNeeded * pricePerGallon;

        System.out.println("The cost of driving is $" + cost);
    }
}
