package chapter_two;

import java.util.*;

/**
 * *2.14 (Health application: computing BMI) Body Mass Index (BMI) is a measure of
 * health on weight. It can be calculated by taking your weight in kilograms and
 * dividing, by the square of your height in meters. Write a program that prompts the
 * user to enter a weight in pounds and height in inches and displays the BMI. Note
 * one pound is 0.45359237 kilograms and one inch is 0.0254 meters. Here is a
 * sample run:
 *          Enter weight in pounds: 95.5
 *          Enter height in inches: 50
 *          BMI is 26.8573
 *
 * @author Sharaf Qeshta
 * */

public class Problem$14
{
    static final double POUND_TO_KILO = 0.45359237;
    static final double INCH_TO_METER = 0.0254;
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in).useLocale(Locale.US);


        System.out.print("Enter weight in pounds : ");
        double weightInPounds = scan.nextDouble();
        double weightInKilogram = weightInPounds * POUND_TO_KILO;

        System.out.print("Enter height in inches: ");
        double heightInInches = scan.nextDouble();
        double heightInMeters = heightInInches * INCH_TO_METER;

        System.out.println("BMI is " + (weightInKilogram / Math.pow(heightInMeters, 2)));
    }
}
