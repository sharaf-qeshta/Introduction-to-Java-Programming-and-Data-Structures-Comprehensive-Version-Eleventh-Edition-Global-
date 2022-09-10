package chapter_twenty_seven;

/**
 * **27.11 (Implement set operations in MyHashSet) The implementations of the methods
 * addAll, removeAll, retainAll, toArray(), and toArray(T[]) are omitted
 * in the MyHashSet class. Implement these methods. Also add a new constructor
 * MyHashSet(E[] list) in the MyHashSet class. Test your new MyHashSet
 * class using the code at liveexample.pearsoncmg.com/test/Exercise27_11Test.txt.
 *
 *
 * @author Sharaf Qeshta
 * */
public class Problem$11
{
    public static void main(String[] args)
    {
        MyHashSet<Integer> set1 = new MyHashSet<>(new Integer[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10});
        MyHashSet<Integer> set2 = new MyHashSet<>(new Integer[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10});
        MyHashSet<Integer> set3 = new MyHashSet<>(new Integer[] {1, 2, 3, 4, 5});

        System.out.println(set1.containsAll(set2)); // true
        System.out.println(set3.containsAll(set1)); // false

        set1.retainAll(set3);
        /*
        * [1, 2, 3, 4, 5]
        * */
        System.out.println(set1);

        set1.addAll(set2);
        /*
        * [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
        * */
        System.out.println(set1);

        set1.removeAll(set2);
        /*
        * []
        * */
        System.out.println(set1);
    }
}
