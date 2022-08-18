package chapter_twenty_four;

/**
 * *24.2 (Implement MyLinkedList) The implementations of the methods contains(E
 * e), get(int index), indexOf(E e), lastIndexOf(E e), and set(int
 * index, E e) are omitted in the MyLinkedList class. Implement these methods.
 *
 *
 * @author Sharaf Qeshta
 * */
public class Problem$02
{
    public static void main(String[] args)
    {
        MyLinkedList<Integer> linkedList = new MyLinkedList<>();
        linkedList.addFirst(1);
        linkedList.addFirst(3);
        linkedList.addFirst(5);
        linkedList.addFirst(7);
        linkedList.addFirst(9);
        linkedList.addLast(1);

        System.out.println(linkedList.contains(1)); // true
        System.out.println(linkedList.contains(10)); // false

        System.out.println(linkedList.get(0)); // 9
        System.out.println(linkedList.get(1)); // 7

        System.out.println(linkedList.indexOf(9)); // 0
        System.out.println(linkedList.indexOf(7)); // 1
        System.out.println(linkedList.indexOf(1)); // 4

        System.out.println(linkedList.lastIndexOf(1)); // 5

        System.out.println(linkedList.get(0)); // 9
        linkedList.set(0, 13);
        System.out.println(linkedList.get(0)); // 13
    }
}
