package chapter_five;

import java.util.Locale;
import java.util.Scanner;

/**
 * **5.28 (Display the first days of each month) Write a program that prompts the user to
 * enter the year and first day of the year, then displays the first day of each month in
 * the year. For example, if the user entered the year 2013, and 2 for Tuesday, January
 * 1, 2013, your program should display the following output:
 *
 *      January 1, 2013 is Tuesday
 *      ...
 *      December 1, 2013 is Sunday
 *
 * @author Sharaf Qeshta
 * */

public class Problem$28
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in).useLocale(Locale.US);

        System.out.print("enter a year: ");
        int year = scanner.nextInt();
        System.out.print("enter the first day in the year: ");
        int day = scanner.nextInt();

        System.out.println();
        boolean isLeap = (year % 4 == 0 && year % 100 != 0) || year % 400 == 0;

        for (int i = 0; i < 12; i++)
        {
            String dayString = switch (day)
            {
                case 0 -> "Sunday";
                case 1 -> "Monday";
                case 2 -> "Tuesday";
                case 3 -> "Wednesday";
                case 4 -> "Thursday";
                case 5 -> "Friday";
                case 6 -> "Saturday";
                default -> null;
            };

            String monthName = "";
            int monthDays = -1;
            switch (i)
            {
                case 0 -> { monthName = "January"; monthDays = (isLeap)? 29: 28; }
                case 1 -> { monthName = "February"; monthDays = 31; }
                case 2 -> { monthName = "March"; monthDays = 30; }
                case 3 -> { monthName = "April"; monthDays = 31; }
                case 4 -> { monthName = "May"; monthDays = 30; }
                case 5 -> { monthName = "June"; monthDays = 31; }
                case 6 -> { monthName = "July"; monthDays = 31; }
                case 7 -> { monthName = "August"; monthDays = 30; }
                case 8 -> { monthName = "September"; monthDays = 31; }
                case 9 -> { monthName = "October"; monthDays = 30; }
                case 10 -> { monthName = "November"; monthDays = 31; }
                case 11 -> { monthName = "December"; monthDays = 31; }
            }

            System.out.println(monthName + " 1, " + year + " is " + dayString);
            day = (day + monthDays) % 7;
        }
    }
}

