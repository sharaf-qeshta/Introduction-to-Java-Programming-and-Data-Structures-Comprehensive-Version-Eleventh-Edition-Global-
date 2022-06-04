package chapter_eleven.samples;

import java.util.ArrayList;

/**
 * Listing 11.8 TestArrayList.java
 */
public class TestArrayList
{
    public static void main(String[] args)
    {
        // Create a list to store cities
        ArrayList<String> cityList = new ArrayList<>();

        // Add some cities in the list
        cityList.add("London");
        // cityList now contains [London]
        cityList.add("Denver");
        // cityList now contains [London, Denver]
        cityList.add("Paris");
        // cityList now contains [London, Denver, Paris]
        cityList.add("Miami");
        // cityList now contains [London, Denver, Paris, Miami]
        cityList.add("Seoul");
        // Contains [London, Denver, Paris, Miami, Seoul]
        cityList.add("Tokyo");
        // Contains [London, Denver, Paris, Miami, Seoul, Tokyo]

        System.out.println("List size? " + cityList.size());
        System.out.println("Is Miami in the list? " +
                cityList.contains("Miami"));
        System.out.println("The location of Denver in the list? "
                + cityList.indexOf("Denver"));
        System.out.println("Is the list empty? " +
                cityList.isEmpty()); // Print false

        // Insert a new city at index 2
        cityList.add(2, "Xian");
        // Contains [London, Denver, Xian, Paris, Miami, Seoul, Tokyo]

        // Remove a city from the list
        cityList.remove("Miami");
        // Contains [London, Denver, Xian, Paris, Seoul, Tokyo]

        // Remove a city at index 1
        cityList.remove(1);
        // Contains [London, Xian, Paris, Seoul, Tokyo]

        // Display the contents in the list
        System.out.println(cityList.toString());

        // Display the contents in the list in reverse order
        for (int i = cityList.size() -1;
        i >= 0;
        i--)
        System.out.print(cityList.get(i) + " ");
        System.out.println();

        // Create a list to store two circles
        ArrayList<Circle> list = new ArrayList<>();

        // Add two circles
        list.add(new Circle(2));
        list.add(new Circle(3));

        // Display the area of the first circle in the list
        System.out.println("The area of the circle? " +
                list.get(0).getArea());
    }
}
