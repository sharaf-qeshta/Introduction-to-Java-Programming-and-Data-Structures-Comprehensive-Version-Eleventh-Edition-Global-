package chapter_nine;

import java.util.GregorianCalendar;

/**
 * *9.5 (Use the GregorianCalendar class) Java API has the GregorianCalendar
 * class in the java.util package, which you can use to obtain the year, month, and
 * day of a date. The no-arg constructor constructs an instance for the current date, and
 * the methods get(GregorianCalendar.YEAR), get(GregorianCalendar.
 * MONTH), and get(GregorianCalendar.DAY_OF_MONTH) return the year,
 * month, and day. Write a program to perform two tasks:
 * 1. Display the current year, month, and day.
 * 2. The GregorianCalendar class has the setTimeInMillis(long), which
 * can be used to set a specified elapsed time since January 1, 1970. Set the value
 * to 1234567898765L and display the year, month, and day.
 *
 * @author Sharaf Qeshta
 * */

public class Problem$05
{
    public static void main(String[] args)
    {
        GregorianCalendar date = new GregorianCalendar();

        /* 2022/4/27 */
        System.out.print(date.get(GregorianCalendar.YEAR) + "/");
        System.out.print(date.get(GregorianCalendar.MONTH) + "/");
        System.out.print(date.get(GregorianCalendar.DAY_OF_MONTH) + "\n");

        date.setTimeInMillis(1234567898765L);

        /* 2009/1/13 */
        System.out.print(date.get(GregorianCalendar.YEAR) + "/");
        System.out.print(date.get(GregorianCalendar.MONTH) + "/");
        System.out.print(date.get(GregorianCalendar.DAY_OF_MONTH));
    }
}
