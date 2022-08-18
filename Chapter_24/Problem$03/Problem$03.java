package chapter_twenty_four;

import java.util.Iterator;
import java.util.ListIterator;

/**
 * *24.3 (Implement a doubly linked list) The MyLinkedList class used in Listing 24.5 is
 * a one-way directional linked list that enables one-way traversal of the list. Modify
 * the Node class to add the new data field name previous to refer to the previous
 * node in the list, as follows:
 * public class Node<E> {
 *  E element;
 *  Node<E> next;
 *  Node<E> previous;
 *  public Node(E e) {
 *  element = e;
 *  }
 * }
 * Implement a new class named TwoWayLinkedList that uses a doubly linked list
 * to store elements. Define TwoWayLinkedList to implements MyList. You need
 * to implement all the methods defined in MyLinkedList as well as the methods
 * listIterator() and listIterator(int index). Both return an instance of
 * java.util.ListIterator<E> (see Figure 20.4). The former sets the cursor to
 * the head of the list and the latter to the element at the specified index.
 *
 *
 * @author Sharaf Qeshta
 * */
public class Problem$03
{
    public static void main(String[] args)
    {
        TwoWayLinkedList<Integer> linkedList = new TwoWayLinkedList<>();
        linkedList.addFirst(1);
        linkedList.addFirst(3);
        linkedList.addFirst(5);
        linkedList.addFirst(7);
        linkedList.addFirst(9);
        linkedList.addLast(1);
        linkedList.removeFirst(); // remove 9
        linkedList.removeFirst(); // remove 7
        linkedList.removeLast();  // remove 1

        Iterator<Integer> iterator1 = linkedList.iterator();
        // 5 3 1
        while (iterator1.hasNext())
            System.out.print(iterator1.next() + " ");
        System.out.println();

        Iterator<Integer> iterator2 = linkedList.iterator(1);
        // 3 1
        while (iterator2.hasNext())
            System.out.print(iterator2.next() + " ");
    }
}
