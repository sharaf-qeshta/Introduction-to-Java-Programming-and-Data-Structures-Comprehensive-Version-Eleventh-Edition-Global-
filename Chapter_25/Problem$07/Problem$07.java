package chapter_twenty_five;

/**
 * **25.7 (Find the nonleaves) Add a method in the BST class to return the number of the
 * nonleaves as follows:
 *
 * public int getNumberofNonLeaves()
 *
 * @author Sharaf Qeshta
 * */
public class Problem$07
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
        * 5
        * */
        System.out.println(tree.getNumberOfNonLeaves());
    }
}
