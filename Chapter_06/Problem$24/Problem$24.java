package chapter_six;

/**
 * **6.24 (Display current date and time) Listing 2.7, ShowCurrentTime.java, displays the
 * current time. Revise this example to display the current date and time.
 * The calendar example in Listing 6.12, PrintCalendar.java, should give you some ideas on
 * how to find the year, month, and day.
 *
 * @author Sharaf Qeshta
 */

public class Problem$24
{
    public static final int GAZA_TIME_ZONE_OFFSET = 3;
    public static final double MILLISECONDS_PER_YEAR = 3.15569E10;
    public static final double MILLISECONDS_PER_MONTH = 2.63E9;
    public static final double MILLISECOND_PER_DAY = 8.64e+7;

    public static void main(String[] args)
    {
        // Display current date and time
        System.out.println(time()); // 4:39:59 AM
        System.out.println(date()); // 2022/5/15
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

        return currentYear + "/" + currentMonth + "/" + currentDay;
    }

}
