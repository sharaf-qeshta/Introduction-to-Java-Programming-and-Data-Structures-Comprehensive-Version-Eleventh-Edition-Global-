package chapter_twenty.samples;

/**
 * Listing 20.8 SortStringIgnoreCase.java
 */
public class SortStringIgnoreCase
{
    public static void main(String[] args)
    {
        java.util.List<String> cities = java.util.Arrays.asList
                ("Atlanta", "Savannah", "New York", "Dallas");
        cities.sort((s1, s2) -> s1.compareToIgnoreCase(s2));

        for (String s : cities)
        {
            System.out.print(s + " ");
        }
    }
}
