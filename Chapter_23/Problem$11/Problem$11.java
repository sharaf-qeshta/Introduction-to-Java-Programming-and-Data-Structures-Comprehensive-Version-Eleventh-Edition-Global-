package chapter_twenty_three;

/**
 * 23.11 (Heap clone and equals) Implement the clone and equals method in the
 * Heap class.
 *
 *
 * @author Sharaf Qeshta
 * */
public class Problem$11
{
    public static void main(String[] args)
    {
        Heap<Integer> heap1 = new Heap<>();
        heap1.add(1);
        heap1.add(2);
        heap1.add(3);
        heap1.add(10);

        Heap<Integer> heap2 = heap1.clone();
        Heap<Integer> heap3 = heap2.clone();
        heap3.add(10);

        System.out.println(heap1.equals(heap2)); // true

        heap2.remove();

        System.out.println(heap1.equals(heap2)); // false

        System.out.println(heap1.list); // [10, 3, 2, 1]
        System.out.println(heap2.list); // [3, 1, 2]
        System.out.println(heap3.list); // [10, 10, 2, 1, 3]
    }
}
