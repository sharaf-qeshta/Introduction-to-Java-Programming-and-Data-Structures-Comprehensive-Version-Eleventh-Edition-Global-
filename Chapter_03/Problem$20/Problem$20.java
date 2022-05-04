package chapter_three;

import java.util.Locale;
import java.util.Scanner;

/**
 * *3.20 (Science: wind-chill temperature) Programming Exercise 2.17 gives a formula to
 * compute the wind-chill temperature. The formula is valid for temperatures in the
 * range between -58°F and 41°F and wind speed greater than or equal to 2. Write
 * a program that prompts the user to enter a temperature and a wind speed.
 * The program displays the wind-chill temperature if the input is valid; otherwise, it displays
 * a message indicating whether the temperature and/or wind speed is invalid.
 *
 * @author Sharaf Qeshta
 * */

public class Problem$20
{
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in).useLocale(Locale.US);

        System.out.print("Enter the temperature in Fahrenheit between -58°F and 41°F: ");
        double temperature = scan.nextDouble();

        System.out.print("Enter the wind speed (>= 2) in miles per hour: ");
        double windSpeed = scan.nextDouble();


        boolean validTemperature = temperature > -58 && temperature < 41;
        boolean validWindSpeed = windSpeed >= 2;

        if (validTemperature && validWindSpeed)
        {
            double WCI = 35.74 + (0.6215 * temperature) - 35.75 * Math.pow(windSpeed , 0.16)
                    + 0.4275 * temperature * Math.pow(windSpeed, 0.16);
            System.out.println("The wind chill index is " + WCI);
        }
        else
        {
            if (!validTemperature)
                System.out.println("Temperature must be less than 41 and greater than -58 !!");
            if (!validWindSpeed)
                System.out.println("Wind Speed must be greater or equal to 2 !!");
        }
    }
}
