package chapter_twenty_seven;

/**
 * **27.5 (Implement MyHashSet using MyHashMap) Implement MyHashSet using
 * MyHashMap. Note you can create entries with (key, key), rather than (key,
 * value).
 *
 *
 * @author Sharaf Qeshta
 * */
public class Problem$05
{
    public static void main(String[] args)
    {
        MyHashSet<Integer> set = new MyHashSet<>();
        set.add(1); set.add(2); set.add(3); set.add(4);
        set.add(5); set.add(6); set.add(7); set.add(7);
        set.add(5); set.add(6); set.add(7); set.add(7);
        set.add(5); set.add(6); set.add(7); set.add(7);
        set.add(5); set.add(6); set.add(7); set.add(7);

        /*
        * [1, 2, 3, 4, 5, 6, 7]
        * */
        System.out.println(set);
    }
}
