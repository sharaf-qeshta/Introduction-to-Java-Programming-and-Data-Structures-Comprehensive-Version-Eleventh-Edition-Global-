package chapter_two;

import java.util.*;

/**
 * 2.10 (Science: calculating energy) Write a program that calculates the energy needed
 * to heat water from an initial temperature to a final temperature. Your program
 * should prompt the user to enter the amount of water in kilograms and the initial
 * and final temperatures of the water. The formula to compute the energy is
 *  Q = M * (finalTemperature – initialTemperature) * 4184
 *  where M is the weight of water in kilograms, initial and final temperatures are in
 * degrees Celsius, and energy Q is measured in joules. Here is a sample run:
 *          Enter the amount of water in kilograms: 55.5
 *          Enter the initial temperature: 3.5
 *          Enter the final temperature: 10.5
 *          The energy needed is 1625484.0
 *
 * @author Sharaf Qeshta */

public class Problem$10
{
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in).useLocale(Locale.US);

        System.out.print("Enter the amount of water in kilograms: ");
        double M = scan.nextDouble();

        System.out.print("Enter the initial temperature: ");
        double initialTemperature = scan.nextDouble();

        System.out.print("Enter the final temperature: ");
        double finalTemperature = scan.nextDouble();

        double Q = M * (finalTemperature - initialTemperature) * 4184;
        System.out.println("The energy needed is " + Q );
    }
}
