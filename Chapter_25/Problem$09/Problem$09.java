package chapter_twenty_five;

/**
 * **25.9 (Tree clone and equals) Implement the clone and equals methods in the
 * BST class. Two BST trees are equal if they contain the same elements. The clone
 * method returns an identical copy of a BST.
 *
 *
 * @author Sharaf Qeshta
 * */
public class Problem$09
{
    public static void main(String[] args)
    {
        BST<Integer> tree1 = new BST<>();
        tree1.add(60);
        tree1.add(100);
        tree1.add(55);
        tree1.add(45);
        tree1.add(57);
        tree1.add(67);
        tree1.add(59);
        tree1.add(107);
        tree1.add(101);

        BST<Integer> tree2 = tree1.clone();
        System.out.println(tree1.getSize()); // 9
        System.out.println(tree2.getSize()); // 9

        System.out.println(tree1.equals(tree2)); // true
        tree2.remove(60);
        System.out.println(tree1.equals(tree2)); // false
    }
}
