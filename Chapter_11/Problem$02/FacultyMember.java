package chapter_eleven;

public class FacultyMember  extends Employee
{
    private int officeHours;
    private double rank;

    public int getOfficeHours()
    {
        return officeHours;
    }

    public void setOfficeHours(int officeHours)
    {
        this.officeHours = officeHours;
    }

    public double getRank()
    {
        return rank;
    }

    public void setRank(double rank)
    {
        this.rank = rank;
    }

    @Override
    public String toString()
    {
        return "FacultyMember{" +
                "name=" + this.getName() +
                '}';
    }
}
