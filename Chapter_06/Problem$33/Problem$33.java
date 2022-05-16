package chapter_six;

/**
 * **6.33 (Current date and time) Invoking System.currentTimeMillis() returns the
 * elapsed time in milliseconds since midnight of January 1, 1970. Write a program
 * that displays the date and time. Here is a sample run:
 *
 * Current date and time is May 16, 2012 10:34:23
 *
 * @author Sharaf Qeshta
 * */

public class Problem$33
{
    public static final int GAZA_TIME_ZONE_OFFSET = 3;
    public static final double MILLISECONDS_PER_YEAR = 3.15569E10;
    public static final double MILLISECONDS_PER_MONTH = 2.63E9;
    public static final double MILLISECOND_PER_DAY = 8.64e+7;

    public static void main(String[] args)
    {
        // Current date and time is May 15, 2022 5:31:59 AM
        System.out.println("Current date and time is " + date() + " " + time());
    }

    public static String time()
    {
        // Obtain the total milliseconds since midnight, Jan 1, 1970
        long totalMilliseconds = System.currentTimeMillis();

        // Obtain the total seconds since midnight, Jan 1, 1970
        long totalSeconds = totalMilliseconds / 1000;

        // Compute the current second in the minute in the hour
        long currentSecond = totalSeconds % 60;

        // Obtain the total minutes
        long totalMinutes = totalSeconds / 60;

        // Compute the current minute in the hour
        long currentMinute = totalMinutes % 60;

        // Obtain the total hours
        long totalHours = (totalMinutes / 60) + GAZA_TIME_ZONE_OFFSET;

        // Compute the current hour
        long currentHour = totalHours % 24;

        // AM and PM
        String dayNight = "AM";
        if ( currentHour > 12 )
        {
            dayNight = "PM";
            currentHour -= 12;
        }

        // return results
        return currentHour + ":"
                + currentMinute + ":" + currentSecond + " " + dayNight;
    }


    public static String date()
    {
        int currentYear =
                (int)(System.currentTimeMillis() / MILLISECONDS_PER_YEAR) + 1970;
        int currentMonth =
                (int)((System.currentTimeMillis() % MILLISECONDS_PER_YEAR)
                        / MILLISECONDS_PER_MONTH) + 1;
        int currentDay = (int) (((System.currentTimeMillis() % MILLISECONDS_PER_YEAR)
                % MILLISECONDS_PER_MONTH) / MILLISECOND_PER_DAY) + 2;

        return getMonthName(currentMonth) + " " + currentDay + ", " + currentYear;
    }

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

}
