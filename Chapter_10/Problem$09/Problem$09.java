package chapter_ten;

import java.util.Arrays;

/**
 * **10.9 (The Course class) Revise the Course class as follows:
 * ■■ Revise the getStudents() method to return an array whose length is the
 * same as the number of students in the course. (Hint: create a new array and
 * copy students to it.)
 * ■■ The array size is fixed in Listing 10.6. Revise the addStudent method to
 * automatically increase the array size if there is no room to add more students.
 * This is done by creating a new larger array and copying the contents of the
 * current array to it.
 * ■■ Implement the dropStudent method.
 * ■■ Add a new method named clear() that removes all students from the course.
 * Write a test program that creates a course, adds three students, removes one, and
 * displays the students in the course.
 * */

public class Problem$09
{
    public static void main(String[] args)
    {
        Course course = new Course("Mathematics");
        course.addStudent("John");
        course.addStudent("Adam");
        course.addStudent("Noah");
        course.dropStudent("Adam");
        /* [John, Noah] */
        System.out.println(Arrays.toString(course.getStudents()));
    }
}

