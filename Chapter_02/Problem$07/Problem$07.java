package chapter_two;

import java.util.*;

/**
 * *2.7 (Find the number of years) Write a program that prompts the user to enter the
 * minutes (e.g., 1 billion), and displays the number of years and remaining days for
 * the minutes. For simplicity, assume that a year has 365 days. Here is a sample run:
 *
 *      Enter the number of minutes: 1000000000
 *      1000000000 minutes is approximately 1902 years and 214 days
 *
 * @author Sharaf Qeshta */

public class Problem$07
{
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in).useLocale(Locale.US);
        System.out.print("Enter the number of minutes: ");
        long minutes = scan.nextLong();
        int days = (int) ((minutes / 60) / 24);
        int years = days / 365;
        int remainingDays = days % 365;
        System.out.println(minutes + " minutes is approximately " + years + " years and "
                + remainingDays + " days");
    }
}
