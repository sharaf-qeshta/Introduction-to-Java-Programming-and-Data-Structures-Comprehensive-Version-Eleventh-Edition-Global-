package chapter_thirteen;


public class Course implements Cloneable
{
    private String courseName;
    private String[] students = new String[10];
    private int numberOfStudents;

    public Course(String courseName)
    {
        this.courseName = courseName;
    }

    public void addStudent(String student)
    {
        if (numberOfStudents >= students.length)
        {
            String[] temp = new String[students.length * 2];
            System.arraycopy(students, 0, temp, 0, students.length);
            students = temp;
        }
        students[numberOfStudents++] = student;
    }

    public String[] getStudents()
    {

        return students;
    }

    public int getNumberOfStudents()
    {
        return numberOfStudents;
    }

    public String getCourseName()
    {
        return courseName;
    }

    public void dropStudent(String student)
    {

        for (int i = 0; i < students.length; i++)
        {
            if (student.equalsIgnoreCase(students[i]))
            {
                students[i] = null; // sets dropped student's value to null
                numberOfStudents--;
                while (i < numberOfStudents) {
                    students[i] = students[i + 1];
                    i++;
                }
                break;
            }
        }

    }

    public void clear()
    {
        students = new String[25];
        numberOfStudents = 0;
    }

    public Object clone()
    {
        Course course = new Course(courseName);
        for (String student : students) course.addStudent(student);
        return course;
    }
}
