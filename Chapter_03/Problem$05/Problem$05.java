package chapter_three;

import java.util.Locale;
import java.util.Scanner;

/**
 * *3.5 (Find future dates) Write a program that prompts the user to enter an integer for
 * today’s day of the week (Sunday is 0, Monday is 1, . . . , and Saturday is 6). Also
 * prompt the user to enter the number of days after today for a future day and display
 * the future day of the week. Here is a sample run:
 *
 *      Enter today’s day: 1
 *      Enter the number of days elapsed since today: 3
 *      Today is Monday and the future day is Thursday
 *
 *      Enter today’s day: 0
 *      Enter the number of days elapsed since today: 31
 *      Today is Sunday and the future day is Wednesday
 *
 * @author Sharaf Qeshta
 * */

public class Problem$05
{
    public static String dayString(int today)
    {
        return switch (today)
        {
            case 0 -> "Sunday";
            case 1 -> "Monday";
            case 2 -> "Tuesday";
            case 3 -> "Wednesday";
            case 4 -> "Thursday";
            case 5 -> "Friday";
            case 6 -> "Saturday";
            default -> "";
        };
    }

    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in).useLocale(Locale.US);

        System.out.print("Enter today’s day: ");
        int today = scan.nextInt();
        String todayString = dayString(today);

        System.out.print("Enter the number of days elapsed since today: ");
        int afterNDays = scan.nextInt();
        int afterNDaysNumber = (today + afterNDays) % 7;
        String afterNDaysString = dayString(afterNDaysNumber);

        System.out.println("Today is " + todayString
                + " and the future day is " + afterNDaysString);
    }
}
