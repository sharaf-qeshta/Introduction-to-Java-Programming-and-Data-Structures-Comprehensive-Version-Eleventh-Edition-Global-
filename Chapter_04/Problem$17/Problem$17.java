package chapter_four;


import java.util.Locale;
import java.util.Scanner;

/**
 * *4.17 (Days of a month) Write a program that prompts the user to enter the year and the
 * first three letters of a month name (with the first letter in uppercase) and displays
 * the number of days in the month. If the input for month is incorrect, display a
 * message as presented in the following sample runs
 *
 *          Enter a year: 2001
 *          Enter a month: Jan
 *          Jan 2001 has 31 days
 *
 *          Enter a year: 2016
 *          Enter a month: jan
 *          jan is not a correct month name
 *
 * @author Sharaf Qeshta
 * */

public class Problem$17
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in).useLocale(Locale.US);

        System.out.print("Enter a year: ");
        int year = scanner.nextInt();

        System.out.print("Enter a month: ");
        String month = scanner.next();

        char firstCode = month.charAt(0);
        char secondCode = month.charAt(1);

        boolean thirtyOne = secondCode == 'a' || secondCode == 'u'
                || firstCode == 'O' || firstCode == 'D'; // pattern between months that have 31 days

        int days;

        if (month.equals("Feb"))
            days = 28;
        else if (thirtyOne)
            days = 31;
        else
            days = 30;

        System.out.println(month + " " + year + " has " + days + " days");
    }
}
