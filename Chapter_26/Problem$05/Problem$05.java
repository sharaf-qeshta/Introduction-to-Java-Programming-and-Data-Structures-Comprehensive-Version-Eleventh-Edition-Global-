package chapter_twenty_six;

import java.util.Scanner;

/**
 * **26.5 (The kth smallest element) You can find the kth smallest element in a BST in
 * O(n) time from an inorder iterator. For an AVL tree, you can find it in O(log n)
 * time. To achieve this, add a new data field named size in AVLTreeNode to
 * store the number of nodes in the subtree rooted at this node. Note the size of a
 * node v is one more than the sum of the sizes of its two children. Figure 26.12
 * shows an AVL tree and the size value for each node in the tree
 * In the AVLTree class, add the following method to return the kth smallest element
 * in the tree:
 * public E find(int k)
 * The method returns null if k < 1 or k > the size of the tree. This
 * method can be implemented using the recursive method find(k, root), which
 * returns the kth smallest element in the tree with the specified root. Let A and B
 * be the left and right children of the root, respectively. Assuming the tree is not
 * empty and k … root.size, find(k, root) can be recursively defined as follows:
 * Modify the insert and delete methods in AVLTree to set the correct value
 * for the size property in each node. The insert and delete methods will still
 * be in O(log n) time. The find(k) method can be implemented in O(log n) time.
 * Therefore, you can find the kth smallest element in an AVL tree in O(log n) time.
 * Test your program using the code at
 * liveexample.pearsoncmg.com/test/Exercise26_05Test.txt.
 *
 *
 * @author Sharaf Qeshta
 * */
public class Problem$05
{
    public static void main(String[] args)
    {
        AVLTree<Double> tree = new AVLTree<>();
        Scanner input = new Scanner(System.in);
        System.out.print("Enter 15 numbers: ");
        for (int i = 0; i < 15; i++)
            tree.insert(input.nextDouble());


        System.out.print("Enter k: ");
        int k = input.nextInt();
        System.out.println("The " + k + "th smallest number is "
                + tree.find(k));
    }
}
