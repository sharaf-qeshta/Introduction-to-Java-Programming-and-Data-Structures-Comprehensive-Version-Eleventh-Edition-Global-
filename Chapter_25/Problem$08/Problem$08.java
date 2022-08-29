package chapter_twenty_five;

import java.util.ListIterator;

/**
 * ***25.8 (Implement bidirectional iterator) The java.util.Iterator interface defines
 * a forward iterator. The Java API also provides the java.util.ListIterator
 * interface that defines a bidirectional iterator. Study ListIterator and define
 * a bidirectional iterator for the BST class.
 *
 *
 * @author Sharaf Qeshta
 * */
public class Problem$08
{
    public static void main(String[] args)
    {
        BST<Integer> tree = new BST<>();
        tree.add(60);
        tree.add(100);
        tree.add(55);
        tree.add(45);
        tree.add(57);
        tree.add(67);
        tree.add(59);
        tree.add(107);
        tree.add(101);

        ListIterator<Integer> listIterator = tree.bidirectionalIterator();

        /*
        * 45 55 57 59 60 67 100 101 107
        * */
        while (listIterator.hasNext())
            System.out.print(listIterator.next() + " ");

        System.out.println();

        /*
        * 107 101 100 67 60 59 57 55 45
        * */
        while (listIterator.hasPrevious())
            System.out.print(listIterator.previous() + " ");
    }
}
