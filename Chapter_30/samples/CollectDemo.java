package chapter_thirty.samples;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Listing 30.5 CollectDemo.java
 * */
public class CollectDemo
{
    public static void main(String[] args)
    {
        String[] names = {"John", "Peter", "Susan", "Kim", "Jen",
                "George", "Alan", "Stacy", "Michelle", "john"};

        System.out.println("The number of characters for all names: " +
                Stream.of(names).collect(StringBuilder::new,
                        StringBuilder::append, StringBuilder::append).length());

        List<String> list = Stream.of(names).collect(ArrayList::new,
                ArrayList::add, ArrayList::addAll);
        System.out.println(list);

        list = Stream.of(names).collect(Collectors.toList());
        System.out.println(list);

        Set<String> set = Stream.of(names).map(e -> e.toUpperCase()).
                collect(Collectors.toSet());
        System.out.println(set);

        Map<String, Integer> map = Stream.of(names).collect(
                Collectors.toMap(e -> e, e -> e.length()));
        System.out.println(map);

        System.out.println("The total number of characters is " +
                Stream.of(names).
                        collect(Collectors.summingInt(e -> e.length())));

        java.util.IntSummaryStatistics stats = Stream.of(names).
                collect(Collectors.summarizingInt(e -> e.length()));
        System.out.println("Max is " + stats.getMax());
        System.out.println("Min is " + stats.getMin());
        System.out.println("Average is " + stats.getAverage());
    }
}
