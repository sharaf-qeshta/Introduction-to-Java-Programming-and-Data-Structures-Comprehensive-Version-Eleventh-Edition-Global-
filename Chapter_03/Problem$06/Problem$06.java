package chapter_three;

import java.util.Locale;
import java.util.Scanner;

/**
 * *3.6 (Health application: BMI) Revise Listing 3.4, ComputeAndInterpretBMI.java, to
 * let the user enter weight, feet, and inches. For example, if a person is 5 feet and 10
 * inches, you will enter 5 for feet and 10 for inches. Here is a sample run:
 *
 *          Enter weight in pounds: 140
 *          Enter feet: 5
 *          Enter inches: 10
 *          BMI is 20.087702275404553
 *          Normal
 *
 * @author Sharaf Qeshta
 * */

public class Problem$06
{
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in).useLocale(Locale.US);

        System.out.print("Enter weight in pounds: ");
        double pounds = scan.nextDouble();
        double kilogram = pounds * 0.45359237;

        System.out.print("Enter feet: ");
        double feet = scan.nextDouble();

        System.out.print("Enter inches:  ");
        double inch = scan.nextDouble();

        double inchToFeet = inch / 12;
        double feetToMetre = (feet + inchToFeet) / 3.281;


        String BMIResult;
        double BMITest = kilogram / Math.pow(feetToMetre, 2);

        if (BMITest < 18.5)
            BMIResult = "Underweight";
        else if (BMITest >= 18.5 & BMITest < 25) // I use short-circuit '&' to make the programme as soft as possible
            BMIResult = "Normal";                // on the hardware "p ^ F is equivalent to F"
        else if (BMITest >= 25 & BMITest < 30)
            BMIResult = "Overweight";
        else
            BMIResult = "Obese";

        System.out.println("BMI is " + BMITest);
        System.out.println(BMIResult);
    }
}
