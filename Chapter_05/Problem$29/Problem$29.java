package chapter_five;

import java.util.Locale;
import java.util.Scanner;

/**
 * **5.29 (Display calendars) Write a program that prompts the user to enter the year and
 * first day of the year and displays the calendar table for the year on the console. For
 * example, if the user entered the year 2013, and 2 for Tuesday, January 1, 2013,
 * your program should display the calendar for each month in the year, as follows:
 *
 *                January 2013
 *          Sun Mon Tue Wed Thu Fri Sat
 *                  1   2   3   4   5
 *          6   7   8   9   10  11  12
 *          13  14  15  16  17  18  19
 *          20  21  22  23  24  25  26
 *          27  28  29  30  31
 *                  . . .
 *              December 2013
 *         Sun Mon Tue Wed Thu Fri Sat
 *         1   2   3   4   5   6   7
 *         8   9   10  11  12  13  14
 *         15  16  17  18  19  20  21
 *         22  23  24  25  26  27  28
 *         29  30  31
 *
 * @author Sharaf Qeshta
 * */

public class Problem$29
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in).useLocale(Locale.US);
        System.out.print("enter a year: ");
        int year = scanner.nextInt();
        System.out.print("enter the first day in the year: ");
        int day = scanner.nextInt();

        boolean isLeap = (year % 4 == 0 & year % 100 != 0) | year % 400 == 0;

        int[] monthDays = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        String[] monthNames = {"January", "February", "March", "April", "May", "June",
                "July", "August",  "September", "October",  "November", "December"};

        if (isLeap)
            monthDays[1] += 1;


        for (int i = 0; i < 12;i++)
        {
            System.out.println("\t\t\t" + monthNames[i] + " " + year);
            System.out.println("------------------------------------------");
            System.out.println("Sun\tMon\tTue\tWed\tThu\tFri\tSat");

            for (int k = 0; k < day; k++)
                System.out.print("\t ");


            int customDay = day;
            for (int j = 1; j < monthDays[i]+1;j++)
            {
                customDay = (customDay+1) % 7;
                System.out.print(j + "\t");

                if (customDay == 0)
                    System.out.println();
            }


            int afterNDays =  (day+monthDays[i]) % 7;
            for (int h = 0; h < 6-afterNDays; h++)
                System.out.print("  ");

            System.out.println("\n");

            if (i == 11)
                break;
            day = (day+monthDays[i+1]) % 7;
        }
    }
}

