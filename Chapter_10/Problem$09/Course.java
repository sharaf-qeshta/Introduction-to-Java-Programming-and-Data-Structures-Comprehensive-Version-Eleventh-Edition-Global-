package chapter_ten;

public class Course
{
    private String courseName;
    private String[] students = new String[100];
    private int numberOfStudents;

    public Course(String courseName)
    {
        this.courseName = courseName;
    }


    public void addStudent(String student)
    {
        if (numberOfStudents >= students.length)
        {
            String[] newArray = new String[numberOfStudents*2];
            System.arraycopy(students, 0, newArray,
                    0, numberOfStudents+1);
            students = newArray;
        }
        students[numberOfStudents++] = student;
    }

    public String[] getStudents()
    {
        String[] realStudents = new String[numberOfStudents];
        System.arraycopy(students, 0, realStudents,
                0, numberOfStudents);
        return realStudents;
    }


    public int getNumberOfStudents()
    {
        return numberOfStudents;
    }


    public String getCourseName()
    {
        return courseName;
    }

    public void clear()
    {
        students = new String[students.length];
    }


   public void dropStudent(String studentName)
    {
        boolean reach = false;
        for (int i = 0; i <= numberOfStudents-1;i++) {
            if (!reach)
                if (students[i].equals(studentName))
                    reach = true;

            if (reach)
                if (i < numberOfStudents - 1)
                    students[i] = students[i + 1];
        }
        numberOfStudents--;
    }
}
