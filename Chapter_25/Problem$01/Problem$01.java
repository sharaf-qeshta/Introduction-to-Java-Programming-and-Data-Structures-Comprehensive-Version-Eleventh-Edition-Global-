package chapter_twenty_five;

/**
 * *25.1 (Add new methods in BST) Add the following new methods in BST.
 *
 * public void breadthFirstTraversal()
 * public int height()
 *
 *
 * @author Sharaf Qeshta
 * */
public class Problem$01
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
        * 60 55 100 45 57 67 107 59 101
        * */
        tree.breadthFirstTraversal();
        System.out.println();
        System.out.println(tree.height()); // 4
    }
}
