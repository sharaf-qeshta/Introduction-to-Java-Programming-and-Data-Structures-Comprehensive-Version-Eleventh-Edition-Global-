package chapter_twenty_five;

/**
 * *25.2 (Test perfect binary tree) A perfect binary tree is a complete binary tree with
 * all levels fully filled. Add a method in the BST class to return true if the tree is
 * a perfect binary tree. (Hint: The number of nodes in a nonempty perfect binary
 * tree is 2height - 1)
 *
 * boolean isPerfectBST()
 *
 *
 * @author Sharaf Qeshta
 * */
public class Problem$02
{
    public static void main(String[] args) {
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

        BST<Integer> tree2 = new BST<>();
        tree2.add(60);
        tree2.add(55);
        tree2.add(100);

        // false
        System.out.println(tree1.isPerfectBST());
        // true
        System.out.println(tree2.isPerfectBST());
    }
}
