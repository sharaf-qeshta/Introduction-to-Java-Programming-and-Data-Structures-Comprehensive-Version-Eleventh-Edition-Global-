package chapter_three;

import java.util.Locale;
import java.util.Scanner;

/**
 * *3.11 (Find the number of days in a month) Write a program that prompts the user to enter
 * the month and year and displays the number of days in the month. For example, if
 * the user entered month 2 and year 2012, the program should display that February
 * 2012 has 29 days. If the user entered month 3 and year 2015, the program should
 * display that March 2015 has 31 days.
 *
 * @author Sharaf Qeshta
 * */

public class Problem$11
{
    // method for checking a leap year
    public static int isLeap(int year)
    {
        if (year % 4 == 0 & year % 100 != 0)
            return 29;
        else  if (year % 400 == 0)
            return 29;
        return 28;
    }

    public static int dayPerMonth(int month, int year)
    {
        return switch (month)
        {
            case 1, 3, 5, 7, 8, 10, 12 -> 31;
            case 2 -> isLeap(year);
            case 4, 6, 9, 11 -> 30;
            default -> -1;
        };
    }

    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in).useLocale(Locale.US);

        System.out.print("enter month : ");
        int month = scan.nextInt();

        System.out.print("enter a year : ");
        int year = scan.nextInt();

        System.out.println("month " + month + " in year " + year
                + " have " + dayPerMonth(month, year) + " days");
    }
}
