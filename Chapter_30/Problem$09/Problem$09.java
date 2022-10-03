package chapter_thirty;

import java.util.Scanner;
import java.util.stream.Stream;

/**
 * 30.9 (Sort students) Rewrite Programming Exercise 7.17 using streams. Define a
 * class named Student with data fields name and score and their getter methods.
 * Store each student in a Student object
 *
 *
 * @author Sharaf Qeshta
 * */
public class Problem$09
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the Number of Students: ");
        Student[] students = new Student[scanner.nextInt()];

        System.out.println("Enter " + students.length + " students: ");
        Stream.of(students).map(e -> e = new Student(scanner.next(), scanner.nextDouble()))
                .sorted((e1 , e2) -> (int) (e2.score - e1.score)).forEach(System.out::println);
    }

    static class Student
    {
        private String name;
        private double score;

        public Student(String name, double score)
        {
            this.name = name;
            this.score = score;
        }

        public String getName()
        {
            return name;
        }

        public double getScore()
        {
            return score;
        }

        public String toString()
        {
            return "Name: " + name + ", Score: " + score;
        }
    }
}
