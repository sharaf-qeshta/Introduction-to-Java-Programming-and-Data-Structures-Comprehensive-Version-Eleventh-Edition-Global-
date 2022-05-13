package chapter_six;

import java.util.Locale;
import java.util.Scanner;

/**
 * 6.8 (Conversions between mile and kilometer) Write a class that contains the following two methods:
 *
 * public static double mileToKilometer(double mile)
 *
 * public static double kilometerToMile(double kilometer)
 * The formula for the conversion is:
 * 1 mile = 1.6 kilometers
 * Write a test program that invokes these methods to display the following tables:
 *
 *          Miles   Kilometers  |   Kilometers  Miles
 *          1       1.609       |   20          12.430
 *          2       3.218       |   25          15.538
 *          ...
 *          9       14.481      |   60          37.290
 *          10      16.090      |   65          40.398
 *
 * @author Sharaf Qeshta
 * */

public class Problem$08
{
    public static void main(String[] args)
    {
        System.out.println("Miles\t\t\tKilometers\t\t\t|\t\t\t" +
                "Kilometers\t\t\tMiles");

        for (int i =1, j =20; i < 11; i++, j+=5)
        {
            String k = String.format("%.3f", mileToKilometer(i));
            String m = String.format("%.3f", kilometerToMile(j));
            System.out.print(i +"\t\t\t\t" + k+ "\t\t\t\t|\t\t\t\t");
            System.out.print(j +"\t\t\t\t" + m);
            System.out.println();
        }
    }

    /** Convert from Mile to Kilometer */
    public static double mileToKilometer(double mile)
    {
        return mile * 1.609;
    }

    /** Convert from Kilometer to Mile */
    public static double kilometerToMile(double kilometer)
    {
        return kilometer/1.609;
    }

}
