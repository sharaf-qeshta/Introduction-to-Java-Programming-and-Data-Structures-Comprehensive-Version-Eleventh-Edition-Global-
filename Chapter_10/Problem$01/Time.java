package chapter_ten;

import java.util.Calendar;
import java.util.Date;

public class Time
{
    private int hour, minute, second;

    public Time()
    {
        Date date = Calendar.getInstance().getTime();
        this.hour = date.getHours();
        this.minute = date.getMinutes();
        this.second = date.getSeconds();
    }

    public Time(long elapseTime)
    {
        this.second = (int) ((elapseTime / 1000) % 60);
        this.minute = (int) ((elapseTime / (1000 * 60)) % 60);
        this.hour = (int) ((elapseTime / (1000 * 60 * 60)) % 24);
    }

    public Time(int hour, int minute, int second)
    {
        this.hour = hour;
        this.minute = minute;
        this.second = second;
    }

    public void setTime(long elapseTime)
    {
        this.second = (int) ((elapseTime / 1000) % 60);
        this.minute = (int) ((elapseTime / (1000 * 60)) % 60);
        this.hour = (int) ((elapseTime / (1000 * 60 * 60)) % 24);
    }


    public String getString()
    {
        return hour+":" + minute+":"+second;
    }


    public int getHour()
    {
        return hour;
    }

    public int getMinute()
    {
        return minute;
    }

    public int getSecond()
    {
        return second;
    }
}
