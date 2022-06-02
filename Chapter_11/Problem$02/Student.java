package chapter_eleven;

public class Student extends Person
{
    public static final String FRESHMAN = "freshman";
    public static final String SOPHOMORE = "sophomore";
    public static final String JUNIOR = "junior";
    public static final String SENIOR = "senior";
    private String class_status;

    public Student(int status)
    {
        if (status == 1)
            this.class_status = FRESHMAN;
        else if (status == 2)
            this.class_status = SOPHOMORE;
        if (status == 3)
            this.class_status = JUNIOR;
        if (status == 4)
            this.class_status = SENIOR;
    }


    @Override
    public String toString()
    {
        return "Student{" +
                "name='" + this.getName() + '\'' +
                '}';
    }
}
