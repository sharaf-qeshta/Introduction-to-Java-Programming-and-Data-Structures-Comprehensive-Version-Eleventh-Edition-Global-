package chapter_three;

import java.util.Locale;
import java.util.Scanner;

/**
 * **3.21 (Science: day of the week) Zeller’s congruence is an algorithm developed by
 * Christian Zeller to calculate the day of the week. The formula is
 * h = [q + (26(m+1)/10) + k + k/4 + j/4 + 5j)%7]
 * where
 * ■■ h is the day of the week (0: Saturday, 1: Sunday, 2: Monday, 3: Tuesday, 4:
 * Wednesday, 5: Thursday, and 6: Friday).
 * ■■ q is the day of the month.
 * ■■ m is the month (3: March, 4: April, . . ., 12: December). January and February
 * are counted as months 13 and 14 of the previous year.
 * ■■ j is year
 * 100 .
 * ■■ k is the year of the century (i.e., year % 100).
 * Note all divisions in this exercise perform an integer division. Write a program that
 * prompts the user to enter a year, month, and day of the month, and displays the
 * name of the day of the week. Here are some sample runs:
 *
 *      Enter year: (e.g., 2012): 2015
 *      Enter month: 1-12: 1
 *      Enter the day of the month: 1-31: 25
 *      Day of the week is Sunday
 *
 *      Enter year: (e.g., 2012): 2012
 *      Enter month: 1-12: 5
 *      Enter the day of the month: 1-31: 12
 *      Day of the week is Saturday
 *
 * (Hint: January and February are counted as 13 and 14 in the formula, so you need
 * to convert the user input 1 to 13 and 2 to 14 for the month and change the year to
 * the previous year. For example, if the user enters 1 for m and 2015 for year, m will
 * be 13 and year will be 2014 used in the formula.)
 *
 *
 * @author Sharaf Qeshta
 * */

public class Problem$21
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in).useLocale(Locale.US);

        System.out.print("Enter year: (e.g., 2012): ");
        int year = scanner.nextInt();

        System.out.print("Enter month: 1-12: ");
        int month = scanner.nextInt();

        if (month < 3)
        {
            month += 12;
            year--;
        }

        System.out.print("Enter the day of the month: 1-31: ");


        // Zeller’s congruence algorithm
        int q = scanner.nextInt();
        int m = month;
        int j = year/100;
        int k = year%100;


        int h = (q + ((26* (m + 1)) / 10) + k + (k/4) + (j/4) + (5 * j))%7;

        String dayName = "";
        switch (h)
        {
            case 0 -> dayName += "Saturday";
            case 1 -> dayName = "Sunday";
            case 2 -> dayName = "Monday";
            case 3 -> dayName = "Tuesday";
            case 4 -> dayName = "Wednesday";
            case 5 -> dayName = "Thursday";
            case 6 -> dayName = "Friday";
        }
        System.out.println("Day of the week is " + dayName);
    }
}
