package chapter_eleven;

import java.util.Calendar;
import java.util.Date;

public class MyDate
{
    int year, month, day;

    public MyDate()
    {
        Date date = new Date();
        year = date.getYear();
        month = date.getMonth();
        day = date.getDay();
    }


    public MyDate(long milliseconds)
    {
        Calendar c= Calendar.getInstance();
        c.setTimeInMillis(milliseconds);
        year = c.get(Calendar.YEAR);
        month = c.get(Calendar.MONTH);
        day = c.get(Calendar.DAY_OF_MONTH);

    }


    public MyDate(int year, int month, int day)
    {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public void setDate(long elapsedTime)
    {
        Calendar c= Calendar.getInstance();
        c.setTimeInMillis(elapsedTime);
        year = c.get(Calendar.YEAR);
        month = c.get(Calendar.MONTH);
        day = c.get(Calendar.DAY_OF_MONTH);
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
