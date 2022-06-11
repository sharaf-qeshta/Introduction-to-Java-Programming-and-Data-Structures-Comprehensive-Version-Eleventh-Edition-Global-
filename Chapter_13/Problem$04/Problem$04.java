package chapter_thirteen;

/**
 * **13.4 (Display calendars) Rewrite the PrintCalendar class in Listing 6.12 to display
 * a calendar for a specified month using the Calendar and GregorianCalendar
 * classes. Your program receives the month and year from the command line. For
 * example:
 * java Exercise13_04 5 2016
 *  This displays the calendar shown in Figure 13.9.
 *  You can also run the program without the year. In this case, the year is the current
 * year. If you run the program without specifying a month and a year, the month is
 * the current month.
 *
 * @author Sharaf Qeshta
 * */
public class Problem$04
{
    public static void main(String[] args)
    {
        int month = Integer.parseInt(args[0]);
        int year = Integer.parseInt(args[1]);
        printMonth(year, month);
    }

    /**
     * Print the calendar for a month in a year
     */
    public static void printMonth(int year, int month)
    {
        // Print the headings of the calendar
        printMonthTitle(year, month);

        // Print the body of the calendar
        printMonthBody(year, month);
    }


    /**
     * Print the month title, e.g., March 2012
     */
    public static void printMonthTitle(int year, int month)
    {
        System.out.printf("%18s"," " + getMonthName(month) + " " + year);
        System.out.println();
        System.out.println("−−−−−−−−−−−−−−−−−−−−−−−−−−−−−");
        System.out.println(" Sun Mon Tue Wed Thu Fri Sat");
    }

    /**
     * Get the English name for the month
     */
    public static String getMonthName(int month)
    {
        return switch (month)
        {
            case 1 -> "January";
            case 2 -> "February";
            case 3 -> "March";
            case 4 -> "April";
            case 5 -> "May";
            case 6 -> "June";
            case 7 -> "July";
            case 8 -> "August";
            case 9 -> "September";
            case 10 -> "October";
            case 11 -> "November";
            case 12 -> "December";
            default -> "";
        };
    }


    /**
     * Print month body
     */
    public static void printMonthBody(int year, int month)
    {
        // Get start day of the week for the first date in the month
        int startDay = getStartDay(year, month);

        // Get number of days in the month
        int numberOfDaysInMonth = getNumberOfDaysInMonth(year, month);

        // Pad space before the first day of the month
        int i;
        for (i = 0; i < startDay; i++)
            System.out.print(" ");

        for (i = 1; i <= numberOfDaysInMonth; i++)
        {
            System.out.printf("%4d", i);

            if ((i + startDay) % 7 == 0)
                System.out.println();
        }
        System.out.println();
    }

    /**
     * Get the start day of month/1/year
     */
    public static int getStartDay(int year, int month)
    {
        final int START_DAY_FOR_JAN_1_1800 = 3;
        // Get total number of days from 1/1/1800 to month/1/year
        int totalNumberOfDays = getTotalNumberOfDays(year, month);

        // Return the start day for month/1/year
        return (totalNumberOfDays + START_DAY_FOR_JAN_1_1800) % 7;
    }

    /**
     * Get the total number of days since January 1, 1800
     */
    public static int getTotalNumberOfDays(int year, int month)
    {
        int total = 0;

        // Get the total days from 1800 to 1/1/year
        for (int i = 1800; i < year; i++)
            if (isLeapYear(i))
                total = total + 366;
            else
                total = total + 365;

        // Add days from Jan to the month prior to the calendar month
        for (int i = 1; i < month; i++)
            total = total + getNumberOfDaysInMonth(year, i);
        return total;
    }

    /**
     * Get the number of days in a month
     */
    public static int getNumberOfDaysInMonth(int year, int month)
    {
        if (month == 1 || month == 3 || month == 5 || month == 7 ||
                month == 8 || month == 10 || month == 12)
            return 31;

        if (month == 4 || month == 6 || month == 9 || month == 11)
            return 30;

        if (month == 2) return isLeapYear(year) ? 29 : 28;
        return 0; // If month is incorrect
    }

    /**
     * Determine if it is a leap year
     */
    public static boolean isLeapYear(int year)
    {
        return year % 400 == 0 || (year % 4 == 0 && year % 100 != 0);
    }
}
