package chapter_twenty_seven;

public class Date
{
    private int year, month, day;

    public Date(int year, int month, int day)
    {
        this.year = year;
        this.month = month;
        this.day = day;
    }


    public boolean equals(Date otherObject)
    {
        return hashCode() == otherObject.hashCode();
    }

    @Override
    public int hashCode()
    {
        return Integer.parseInt(year + "" + month + "" + day);
    }
}
