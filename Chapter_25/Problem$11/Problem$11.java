package chapter_twenty_five;

import java.util.Iterator;

/**
 * 25.11 (Inorder iterator) Add the following method in the BST class that returns an
 * iterator for traversing the elements in a BST in inorder.
 *
 * java.util.Iterator<E> inorderIterator()
 *
 *
 * @author Sharaf Qeshta
 * */
public class Problem$11
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

        Iterator<Integer> iterator = tree.inorderIterator();

        /*
        * 45 55 57 59 60 67 100 101 107
        * */
        while (iterator.hasNext())
            System.out.print(iterator.next() + " ");
    }
}
