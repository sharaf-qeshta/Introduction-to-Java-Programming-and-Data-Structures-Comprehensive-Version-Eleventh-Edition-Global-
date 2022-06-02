package chapter_eleven;

import java.util.ArrayList;

public class Course
{
    private ArrayList<String> courseName = new ArrayList<String>();
    private ArrayList<String> students = new ArrayList<String>();

    public Course() { }

    public Course(String myCourseName)
    {
        courseName.add(myCourseName);
    }

    public void addStudent(String student)
    {
        students.add(student);
    }

    public String getStudents(int num)
    {
        return students.get(num);
    }

    public int getNumberOfStudents()
    {
        return students.size();
    }

    public void CourseName(String newCourseName)
    {
        courseName.add(newCourseName);
    }

    public void getCourseName(int num)
    {
        System.out.println(courseName.get(num));
    }

    public void dropStudent(String student)
    {
        students.remove(student);
    }
}
