package chapter_thirteen;

/**
 * *13.13 (Enable the Course class cloneable) Rewrite the Course class in Listing 10.6 to
 * add a clone method to perform a deep copy on the students field.
 *
 * @author Sharaf Qeshta
 * */
public class Problem$13
{
    public static void main(String[] args)
    {
        Course course = new Course("Linear Algebra");
        course.addStudent("Sharaf Qeshta");
        course.addStudent("John Smith");

        Course cloned = (Course) course.clone();
        cloned.dropStudent("Sharaf Qeshta");

        /* Original Students: Sharaf Qeshta, John Smith,  */
        System.out.print("Original Students: ");
        String[] originalStudents = course.getStudents();
        for (int i = 0; i < originalStudents.length && originalStudents[i] != null;)
            System.out.print(originalStudents[i++] + ", ");

        System.out.println();

        /* Cloned Students: John Smith,  */
        System.out.print("Cloned Students: ");
        String[] clonedStudents = cloned.getStudents();
        for (int i = 0; i < clonedStudents.length && clonedStudents[i] != null;)
            System.out.print(clonedStudents[i++] + ", ");
    }
}