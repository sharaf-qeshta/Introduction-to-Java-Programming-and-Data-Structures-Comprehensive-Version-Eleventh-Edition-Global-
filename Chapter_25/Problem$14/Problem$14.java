package chapter_twenty_five;

/**
 * *25.14 (Modify BST using Comparator) Revise BST in Listing 25.4 using a Comparator
 * for comparing objects. Define the new class as BST<E> with two
 * constructors:
 * BST(); // Compare elements using their natural order
 * BST(Comparator<? super E> comparator)
 * Hint: You need to add a data field for Comparator in the BST class as follows:
 * protected Comparator<E> c = (e1, e2) ->
 *  ((Comparable<E>)e1).compareTo(e2);
 *  The lambda expression gives the default comparator using a natural order. You
 * need to use comparator c to replace e.compareTo(anotherElement) with
 * c.compare(e, anotherElement) in Listing 25.4.
 *
 *
 * @author Sharaf Qeshta
 * */
public class Problem$14
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

        /*
        * 45 55 57 59 60 67 100 101 107
        * */
        tree.inorder();
    }
}
