package chapter_twenty;

import java.util.Comparator;
import java.util.GregorianCalendar;

public class ComparableDate extends GregorianCalendar implements Comparator<ComparableDate>
{
    public ComparableDate(int year, int month, int day)
    {
        set(year, month, day);
    }

    @Override
    public int compare(ComparableDate o1, ComparableDate o2)
    {
        if (o1.get(YEAR) == o2.get(YEAR))
        {
            if (o1.get(MONTH) == o2.get(MONTH))
            {
                if (o1.get(DAY_OF_MONTH) == o2.get(DAY_OF_MONTH))
                {
                    return 0;
                }
                else
                    return o1.get(DAY_OF_MONTH) - o2.get(DAY_OF_MONTH);
            }
            else
                return o1.get(MONTH) - o2.get(MONTH);
        }
        else
            return o1.get(YEAR) - o2.get(YEAR);
    }


    @Override
    public String toString()
    {
        return get(DAY_OF_MONTH) + "-" + (get(MONTH)+1) + "-" + get(YEAR);
    }
}
