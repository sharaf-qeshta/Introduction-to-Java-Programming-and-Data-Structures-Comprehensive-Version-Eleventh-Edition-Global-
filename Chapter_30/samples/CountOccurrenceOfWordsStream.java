package chapter_thirty.samples;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Listing 30.13 CountOccurrenceOfWordsStream.java
 * */
public class CountOccurrenceOfWordsStream
{
    public static void main(String[] args)
    {
        // Set text in a string
        String text = "Good morning. Have a good class. "
                + "Have a good visit. Have fun!";

        Stream.of(text.split("[\\s+\\p{P}]")).parallel()
                .filter(e -> e.length() > 0).collect(
                Collectors.groupingBy(String::toLowerCase, TreeMap::new,
                        Collectors.counting()))
                .forEach((k, v) -> System.out.println(k + " " + v));
    }
}
