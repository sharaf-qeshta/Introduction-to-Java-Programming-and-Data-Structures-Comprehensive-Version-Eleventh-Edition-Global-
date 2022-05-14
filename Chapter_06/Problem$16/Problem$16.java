package chapter_six;

/**
 * *6.16 (Number of days in a year) Write a method that returns the number of days in a
 * year using the following header:
 * public static int numberOfDaysInAYear(int year)
 * Write a test program that displays the number of days in the years between 2014
 * and 2034.
 *
 * @author Sharaf Qeshta
 * */

public class Problem$16
{
    public static void main(String[] args)
    {
        System.out.println("year\t\t\t\tdays");
        System.out.println("-----------------------------");

        for (int i = 2014; i < 2035;i++)
            System.out.println(i + "\t\t\t\t" + numberOfDaysInAYear(i));
    }


    public static int numberOfDaysInAYear(int year)
    {
        return ((year % 4 == 0 & year % 100 != 0) | year % 400 == 0)? 366 : 365;
    }
}
