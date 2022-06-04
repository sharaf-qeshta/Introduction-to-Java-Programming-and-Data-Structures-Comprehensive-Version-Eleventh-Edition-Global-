package chapter_eleven.samples;

/**
 * Listing 11.6 DynamicBindingDemo.java
 */
public class DynamicBindingDemo
{
    public static void main(String[] args)
    {
        m(new GraduateStudent());
        m(new Student());
        m(new Person());
        m(new Object());
    }

    public static void m(Object x)
    {
        System.out.println(x.toString());
    }
}

class GraduateStudent extends Student { }

class Student extends Person
{
    @Override
    public String toString()
    {
        return "Student";
    }
}

class Person extends Object
{
    @Override
    public String toString()
    {
        return "Person";
    }
}
