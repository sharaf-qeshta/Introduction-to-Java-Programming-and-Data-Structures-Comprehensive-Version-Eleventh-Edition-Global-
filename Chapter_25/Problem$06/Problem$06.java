package chapter_twenty_five;

/**
 * **25.6 (Find the leaves) Add a method in the BST class to return the number of the
 * leaves as follows:
 *
 *  public int getNumberOfLeaves()
 *
 *
 * @author Sharaf Qeshta
 * */
public class Problem$06
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
        * 4
        * */
        System.out.println(tree.getNumberOfLeaves());
    }
}
