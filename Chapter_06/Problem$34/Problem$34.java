package chapter_six;

import java.util.Scanner;

/**
 * **6.34 (Print calendar) Programming Exercise 3.21 uses Zeller’s congruence to
 * calculate the day of the week. Simplify Listing 6.12, PrintCalendar.java, using Zeller’s
 * algorithm to get the start day of the month.
 *
 * @author Sharaf Qeshta
 * */


public class Problem$34
{
    public static void main(String[] args)
    {
        /*
        * Enter full year (e.g., 2012): 2022
        * Enter month as number between 1 and 12: 1
		*        January	2022
            ---------------------------
            Sun	Mon	Tue	Wed	Thu	Fri	Sat
            						1
            2	3	4	5	6	7	8
            9	10	11	12	13	14	15
            16	17	18	19	20	21	22
            23	24	25	26	27	28	29
            30	31
            * * */
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter full year (e.g., 2012): ");
        int year = scanner.nextInt();
        while (year < 0)
        {
            System.out.println("Invalid Year!");
            System.out.print("Enter full year (e.g., 2012): ");
            year = scanner.nextInt();
        }

        System.out.print("Enter month as number between 1 and 12: ");
        int month = scanner.nextInt();
        while (!isValidMonth(month))
        {
            System.out.println("Invalid Month!");
            System.out.print("Enter month as number between 1 and 12: ");
            month = scanner.nextInt();
        }

        printCalendarHeader(month, year);

        printFirstDay(month, year);
        printCalendarItself(month, year);
    }

    public static boolean isValidMonth(int month)
    {
        return month > 0  &&  month <= 12;
    }

    public static void printCalendarHeader(int month, int year)
    {
        String[] months = {"January", "February", "March", "April", "May", "June", "July", "August", "Septemter", "October", "November", "December"};

        System.out.print("\t\t"+months[month-1]+"\t");
        System.out.println(year);
        System.out.println("---------------------------");

        System.out.println("Sun\tMon\tTue\tWed\tThu\tFri\tSat");
    }

    public static void printFirstDay(int month, int year)
    {
        int firstDay = dayOfWeek(1, month, year);

        String leadingTabs = "1";
        for(int i = 1; i<firstDay; i++)
            leadingTabs = "\t" + leadingTabs;
        if(firstDay == 0)
            leadingTabs = "\t\t\t\t\t\t1";

        System.out.print(leadingTabs + "\t");
    }

    public static void printCalendarItself(int month, int year)
    {
        int lastDayOfMonth = lastDayOfMonth(month, year);

        for (int i = 2; i <= lastDayOfMonth; i++) {
            int printedDay = dayOfWeek(i, month, year);
            if (printedDay == 1) {
                System.out.println();
            }
            System.out.print(i + "\t");
        }
    }

    public static int dayOfWeek(int dayOfMonth, int month, int year)
    {
        if (month == 1 || month == 2) {
            month = month + 12;
            year--;
        }
        int q, m, j, k;
        q = dayOfMonth;
        m = month;
        j = year/100;
        k = year%100;
        int dayOfTheWeek = (q + (26*(m+1) /10) + k + k/4 + j/4 + (5*j)) % 7;
        return dayOfTheWeek;
    }

    public static boolean isLeapYear(int year)
    {
        return year % 400 == 0 || (year % 4 == 0 && year % 100 != 0);
    }

    public static int lastDayOfMonth(int month, int year)
    {
        int lastDayOfMonth;
        if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12) {
            lastDayOfMonth = 31;
        } else if (month == 2) {
            if (isLeapYear(year)) {
                lastDayOfMonth = 29;
            } else {
                lastDayOfMonth = 28;
            }
        } else {
            lastDayOfMonth = 30;
        }
        return lastDayOfMonth;
    }

}
