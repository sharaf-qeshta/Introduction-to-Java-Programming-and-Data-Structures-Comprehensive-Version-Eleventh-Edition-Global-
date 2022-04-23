package chapter_two;

import java.util.*;

/**
 * *2.8 (Current time) Listing 2.7, ShowCurrentTime.java, gives a program that displays
 * the current time in GMT. Revise the program so it prompts the user to enter the
 * time zone offset to GMT and displays the time in the specified time zone. Here is
 * a sample run:
 *          Enter the time zone offset to GMT: -5
 *          The current time is 4:50:34
 *
 * @author Sharaf Qeshta
 * */

public class Problem$08
{
    public static void main(String[] args)
    {
        // GMT -5 for chicago
        Scanner scan = new Scanner(System.in).useLocale(Locale.US);

        System.out.print("Enter the time zone offset to GMT: ");

        int timeZone = scan.nextInt();

        long milliseconds = System.currentTimeMillis();

        long seconds =  milliseconds / 1000;
        long currentSeconds =  seconds % 60;

        long minutes = seconds / 60;
        long currentMinutes =  minutes % 60;

        long hours = minutes / 60;
        long currentHours = hours % 24;

        currentHours += timeZone;

        System.out.println("the current time is "+ currentHours + ":" +
                currentMinutes + ":" + currentSeconds);
    }
}
