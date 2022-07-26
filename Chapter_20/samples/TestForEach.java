package chapter_twenty.samples;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Listing 20.3 TestForEach.java
 * */
public class TestForEach
{
    public static void main(String[] args)
    {
        Collection<String> collection = new ArrayList<>();
        collection.add("New York");
        collection.add("Atlanta");
        collection.add("Dallas");
        collection.add("Madison");

        collection.forEach(e -> System.out.print(e.toUpperCase() + " "));
    }
}
