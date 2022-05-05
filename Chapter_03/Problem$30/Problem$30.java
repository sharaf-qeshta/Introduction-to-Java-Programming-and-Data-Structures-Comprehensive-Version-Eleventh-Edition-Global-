package chapter_three;

import java.util.Locale;
import java.util.Scanner;

/**
 * *3.30 (Current time) Revise Programming Exercise 2.8 to display the hour using a
 * 12-hour clock. Here is a sample run:
 *
 *          Enter the time zone offset to GMT: -5
 *          The current time is 4:50:34 AM
 *
 * @author Sharaf Qeshta
 * */

public class Problem$30
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in).useLocale(Locale.US);

        System.out.print("Enter the time zone offset to GMT: ");
        int timeZone = scanner.nextInt();

        long milliseconds = System.currentTimeMillis();

        long seconds =  milliseconds / 1000;
        long currentSeconds =  seconds % 60;

        long minutes = seconds / 60;
        long currentMinutes =  minutes % 60;

        long hours = minutes / 60;
        long currentHours = hours % 24;

        currentHours += timeZone;

        String standard;

        if (currentHours >= 12)
        {
            currentHours -= 12;
            standard = "PM";
        }
        else
            standard = "AM";


        System.out.println("the current time is "+ currentHours + ":" +
                currentMinutes + ":" + currentSeconds + " " + standard);
    }
}

