package chapter_twenty_five;

import java.util.Iterator;

/**
 * 25.10 (Preorder iterator) Add the following method in the BST class that returns an
 * iterator for traversing the elements in a BST in preorder.
 *
 * java.util.Iterator<E> preorderIterator()
 *
 *
 * @author Sharaf Qeshta
 * */
public class Problem$10
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

        Iterator<Integer> iterator = tree.preorderIterator();

        /*
        * 60 55 45 57 59 100 67 107 101
        * */
        while (iterator.hasNext())
            System.out.print(iterator.next() + " ");
    }
}
