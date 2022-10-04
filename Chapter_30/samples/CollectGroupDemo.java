package chapter_thirty.samples;

import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Listing 30.6 CollectGroupDemo.java
 * */
public class CollectGroupDemo
{
    public static void main(String[] args)
    {
        String[] names = {"John", "Peter", "Susan", "Kim", "Jen",
                "George", "Alan", "Stacy", "Steve", "john"};

        Map<String, Long> map1 = Stream.of(names).
                map(e -> e.toUpperCase()).collect(
                Collectors.groupingBy(e -> e, Collectors.counting()));
        System.out.println(map1);

        Map<Character, Long> map2 = Stream.of(names).collect(
                Collectors.groupingBy(e -> e.charAt(0), TreeMap::new,
                        Collectors.counting()));
        System.out.println(map2);

        int[] values = {2, 3, 4, 1, 2, 3, 2, 3, 4, 5, 1, 421};
        IntStream.of(values).mapToObj(e -> e).collect(
                Collectors.groupingBy(e -> e, TreeMap::new,
                        Collectors.counting())).
                forEach((k, v) -> System.out.println(k + " occurs " + v +
                        (v > 1 ? " times " : " time ")));

        MyStudent[] students = {new MyStudent("John", "Lu", "CS", 32, 78),
                new MyStudent("Susan", "Yao", "Math", 31, 85.4),
                new MyStudent("Kim", "Johnson", "CS", 30, 78.1)};

        System.out.printf("%10s%10s\n", "Department", "Average");
        Stream.of(students).collect(Collectors.
                groupingBy(MyStudent::getMajor, TreeMap::new,
                        Collectors.averagingDouble(MyStudent::getScore))).
                forEach((k, v) -> System.out.printf("%10s%10.2f\n", k, v));
    }
}

class MyStudent
{
    private String firstName;
    private String lastName;
    private String major;
    private int age;
    private double score;

    public MyStudent(String firstName, String lastName, String major,
                     int age, double score)
    {
        this.firstName = firstName;
        this.lastName = lastName;
        this.major = major;
        this.age = age;
        this.score = score;
    }

    public String getFirstName()
    {
        return firstName;
    }

    public String getLastName()
    {
        return lastName;
    }

    public String getMajor()
    {
        return major;
    }

    public int getAge()
    {
        return age;
    }

    public double getScore()
    {
        return score;
    }
}
