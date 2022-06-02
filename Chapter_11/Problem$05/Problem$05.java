package chapter_eleven;

/**
 * 11.5 (The Course class) Rewrite the Course class in Listing 10.6. Use an
 * ArrayList to replace an array to store students. Draw the new UML diagram for the
 * class. You should not change the original contract of the Course class (i.e., the
 * definition of the constructors and methods should not be changed, but the private
 * members may be changed.)
 *
 * @author Sharaf Qeshta
 * */
public class Problem$05
{
    public static void main(String[] args)
    {
        Course course = new Course("Mathematics");

        course.addStudent("Sharaf Qeshta");
        System.out.println(course.getNumberOfStudents()); // 1

        course.dropStudent("Sharaf Qeshta");
        System.out.println(course.getNumberOfStudents()); // 0
    }
}
