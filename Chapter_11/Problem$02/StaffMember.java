package chapter_eleven;

public class StaffMember extends Employee
{
    private String title;


    public String getTitle()
    {
        return title;
    }

    public void setTitle(String title)
    {
        this.title = title;
    }


    @Override
    public String toString()
    {
        return "StaffMember{" +
                "name='" + this.getName() + '\'' +
                '}';
    }
}
