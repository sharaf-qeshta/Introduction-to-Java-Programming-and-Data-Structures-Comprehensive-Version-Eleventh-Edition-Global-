package chapter_twenty_six;

/**
 * **26.4 (Parent reference for BST) Suppose the TreeNode class defined in BST contains
 * a reference to the node’s parent, as shown in Programming Exercise 25.15.
 * Implement the AVLTree class to support this change. Write a test program that
 * adds numbers 1, 2, . . . , 100 to the tree and displays the paths for all leaf nodes.
 *
 *
 * @author Sharaf Qeshta
 * */
public class Problem$04
{
    public static void main(String[] args)
    {
        AVLTree<Integer> tree = new AVLTree<>();

        for (int i = 1; i < 101; i++)
            tree.add(i);

        for (int x: tree)
        {
            BST.TreeNode<Integer> node = tree.getNode(x);
            if (node.left == null && node.right == null)
                System.out.println(tree.getPath(x));
        }
    }
}
