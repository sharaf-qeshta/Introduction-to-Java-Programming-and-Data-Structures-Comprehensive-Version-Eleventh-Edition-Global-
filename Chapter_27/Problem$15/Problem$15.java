package chapter_twenty_seven;

import chapter_twenty_seven.samples.MyHashSet;

/**
 * *27.15 (Modify Listing 27.4 MyHashSet.java) The book uses LinkedList for buckets.
 * Replace LinkedList with AVLTree. Assume E is Comparable. Redefine
 * MyHashSet as follows:
 * public class MyHashSet<E extends Comparable<E>> implements
 *  Collection {
 * ...
 * }
 * Test your program using the main method in Listing 27.5.
 *
 *
 * @author Sharaf Qeshta
 * */
public class Problem$15
{
    public static void main(String[] args)
    {
        /*
        * Elements in set: [Anderson, Smith, Lewis, Cook]
        * Number of elements in set: 4
        * Is Smith in set? true
        * Names in set in uppercase are ANDERSON LEWIS COOK
        * Elements in set: []
        * */
        // Create a MyHashSet
        java.util.Collection<String> set = new MyHashSet<>();
        set.add("Smith");
        set.add("Anderson");
        set.add("Lewis");
        set.add("Cook");
        set.add("Smith");

        System.out.println("Elements in set: " + set);
        System.out.println("Number of elements in set: " + set.size());
        System.out.println("Is Smith in set? " + set.contains("Smith"));

        set.remove("Smith");
        System.out.print("Names in set in uppercase are ");
        for (String s : set)
            System.out.print(s.toUpperCase() + " ");

        set.clear();
        System.out.println("\nElements in set: " + set);
    }
}
