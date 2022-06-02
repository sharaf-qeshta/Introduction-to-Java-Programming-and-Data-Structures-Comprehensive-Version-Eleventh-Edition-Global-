package chapter_eleven;


/**
 * 11.2 (The Person, Student, Employee, Faculty, and Staff classes) Design a
 * class named Person and its two subclasses named Student and Employee.
 * Make Faculty and Staff subclasses of Employee. A person has a name,
 * address, phone number, and e-mail address. A student has a class status (freshman,
 * sophomore, junior, or senior). Define the status as a constant. An employee
 * has an office, salary, and date hired. Use the MyDate class defined in Programming
 * Exercise 10.14 to create an object for date hired. A faculty member has
 * office hours and a rank. A staff member has a title. Override the toString
 * method in each class to display the class name and the person’s name.
 * Draw the UML diagram for the classes and implement them. Write a test program
 * that creates a Person, Student, Employee, Faculty, and Staff, and invokes
 * their toString() methods.
 *
 * @author Sharaf Qeshta
 * */

public class Problem$02
{
    public static void main(String[] args)
    {
        Person person = new Person();
        person.setName("Ahmed");

        Person employee = new Employee();
        employee.setName("Ahmed");

        Person student = new Student(1);
        student.setName("Ahmed");

        Person facultyMember = new FacultyMember();
        facultyMember.setName("Ahmed");

        Person staffMember = new StaffMember();
        staffMember.setName("Ahmed");

        /* Person{name='Ahmed'} */
        System.out.println(person);

        /* Student{name='Ahmed'} */
        System.out.println(student);

        /* Employee{name='Ahmed'} */
        System.out.println(employee);

        /* StaffMember{name='Ahmed'} */
        System.out.println(staffMember);

        /* FacultyMember{name=Ahmed} */
        System.out.println(facultyMember);
    }
}
