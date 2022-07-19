package chapter_twenty;

import java.util.ArrayList;
import java.util.Calendar;

/**
 * *20.4 (Implement Comparable) Implement a new class that implements Comparator
 * of GregorianCalendar class to be able sort the calendar in increasing
 * order based on day, month, and year, in that order. Write a method to display
 * the GregorianCalendar instance in “dd-MMM-yyyy” format using
 * SimpleDateFormat class. Write a test program with 10 GregorianCalendar
 * instances and display the results after the sort.
 *
 *
 * @author Sharaf Qeshta
 * */
public class Problem$04
{
    public static void main(String[] args)
    {
        ArrayList<ComparableDate> dates = new ArrayList<>();
        dates.add(new ComparableDate(2022, Calendar.JANUARY, 13));
        dates.add(new ComparableDate(2012, Calendar.MARCH, 19));
        dates.add(new ComparableDate(2021, Calendar.APRIL, 1));
        dates.add(new ComparableDate(2019, Calendar.JANUARY, 3));
        dates.add(new ComparableDate(2022, Calendar.SEPTEMBER, 15));
        dates.add(new ComparableDate(2015, Calendar.FEBRUARY, 27));
        dates.add(new ComparableDate(2018, Calendar.DECEMBER, 29));
        dates.add(new ComparableDate(2018, Calendar.NOVEMBER, 13));
        dates.add(new ComparableDate(2016, Calendar.OCTOBER, 10));
        dates.add(new ComparableDate(2017, Calendar.MAY, 22));

        dates.sort((d1, d2) -> d1.compare(d1, d2));

        /* [19-3-2012, 27-2-2015, 10-10-2016, 22-5-2017, 13-11-2018, 29-12-2018, 3-1-2019, 1-4-2021, 13-1-2022, 15-9-2022] */
        System.out.println(dates);
    }
}
