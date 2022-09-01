package chapter_twenty_five;

import java.util.Iterator;
import java.util.Scanner;

/**
 * *25.15 (Parent reference for BST) Redefine TreeNode by adding a reference to a node’s
 * parent, as shown below:
 * Reimplement the insert and delete methods in the BST class to update the
 * parent for each node in the tree. Add the following new method in BST:
 *
 * private TreeNode<E> getNode(E element)
 * private boolean isLeaf(E element)
 * public ArrayList<E> getPath(E e)
 *
 * Write a test program that prompts the user to enter 10 integers, adds them to
 * the tree, deletes the first integer from the tree, and displays the paths for all leaf
 * nodes. Here is a sample run:
 *
 *          Enter 10 integers: 45 54 67 56 50 45 23 59 23 67
 *          [50, 54, 23]
 *          [59, 56, 67, 54, 23]
 *
 *
 * @author Sharaf Qeshta
 * */
public class Problem$15
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter 10 integers: ");

        BST<Integer> tree = new BST<>();
        int start = scanner.nextInt();
        tree.add(start);
        for (int i = 1; i < 10; i++)
            tree.add(scanner.nextInt());

        // deletes the first integer from the tree
        tree.delete(start);

        // displays the paths for all leaf nodes
        Iterator<Integer> iterator = tree.iterator();

        while (iterator.hasNext())
        {
            int currentNode = iterator.next();
            if (tree.isLeaf(currentNode))
                System.out.println(tree.getPath(currentNode));
        }
    }
}
