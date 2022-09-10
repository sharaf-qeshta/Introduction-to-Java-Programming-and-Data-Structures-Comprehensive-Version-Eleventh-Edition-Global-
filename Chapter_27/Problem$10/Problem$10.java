package chapter_twenty_seven;


import java.util.ArrayList;

/**
 * **27.10 (Compare MyHashSet and MyArrayList) MyArrayList is defined in
 * Listing 24.2. Write a program that generates 1000000 random double values
 * between 0 and 999999 and stores them in a MyArrayList and in a MyHashSet.
 * Generate a list of 1000000 random double values between 0 and 1999999. For
 * each number in the list, test if it is in the array list and in the hash set. Run your
 * program to display the total test time for the array list and for the hash set.
 *
 *
 * @author Sharaf Qeshta
 * */
public class Problem$10
{
    public static void main(String[] args)
    {
        MyHashMap<Double, Double> map = new MyHashMap<>();
        MyArrayList<Double> list = new MyArrayList<>();

        ArrayList<Double> testList = new ArrayList<>();
        for (int i = 0; i < 2_000_000; i++)
            testList.add((Math.random() * 2_000_000) % 2_000_000);

        long start = System.currentTimeMillis();
        for (int i = 0; i < 1_000_000; i++)
        {
            double random = ( Math.random() * 1_000_000 ) % 1_000_000;
            map.put(random, random);
        }
        long end = System.currentTimeMillis();

        System.out.println("HashMap takes " + (end - start) + " MS to insert 1,000,000 values.");

        start = System.currentTimeMillis();
        for (double value: testList)
            map.containsKey(value);
        end = System.currentTimeMillis();

        System.out.println("HashMap takes " + (end - start) + " MS to search 2,000,000 values.");

        start = System.currentTimeMillis();
        for (int i = 0; i < 1_000_000; i++)
        {
            double random = ( Math.random() * 1_000_000 ) % 1_000_000;
            list.add(random);
        }
        end = System.currentTimeMillis();

        System.out.println("ArrayList takes " + (end - start) + " MS to insert 1,000,000 values.");

        start = System.currentTimeMillis();
        for (double value: testList)
            list.contains(value);
        end = System.currentTimeMillis();

        System.out.println("ArrayList takes " + (end - start) + " MS to search 2,000,000 values.");
    }
}
