package chapter_ten;


public class MyDate
{
    private int year, month, day;

    public static final double MILLISECONDS_PER_YEAR = 3.15569E10;
    public static final double MILLISECONDS_PER_MONTH = 2.63E9;
    public static final double MILLISECOND_PER_DAY = 8.64e+7;

    public MyDate()
    {
        year = (int)(System.currentTimeMillis() / MILLISECONDS_PER_YEAR) + 1970;

        month =
                (int)((System.currentTimeMillis() % MILLISECONDS_PER_YEAR)
                        / MILLISECONDS_PER_MONTH) + 1;
        day = (int) (((System.currentTimeMillis() % MILLISECONDS_PER_YEAR)
                % MILLISECONDS_PER_MONTH) / MILLISECOND_PER_DAY) + 2;
    }


    public MyDate(long milliseconds)
    {
        year = (int)(milliseconds / MILLISECONDS_PER_YEAR) + 1970;

        month =
                (int)((milliseconds % MILLISECONDS_PER_YEAR)
                        / MILLISECONDS_PER_MONTH) + 1;
        day = (int) (((milliseconds % MILLISECONDS_PER_YEAR)
                % MILLISECONDS_PER_MONTH) / MILLISECOND_PER_DAY) + 2;
    }


    public MyDate(int year, int month, int day)
    {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public void setDate(long elapsedTime)
    {
        year = (int)(elapsedTime / MILLISECONDS_PER_YEAR) + 1970;

        month =
                (int)((elapsedTime % MILLISECONDS_PER_YEAR)
                        / MILLISECONDS_PER_MONTH) + 1;
        day = (int) (((elapsedTime % MILLISECONDS_PER_YEAR)
                % MILLISECONDS_PER_MONTH) / MILLISECOND_PER_DAY) + 2;
    }

    public int getYear()
    {
        return year;
    }

    public int getMonth()
    {
        return month;
    }

    public int getDay()
    {
        return day;
    }
}
