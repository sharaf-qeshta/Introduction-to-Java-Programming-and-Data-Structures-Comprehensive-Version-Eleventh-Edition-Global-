package chapter_twenty_five;

/**
 * **25.4 (Implement preorder traversal without using recursion) Implement the
 * preorder method in BST using a stack instead of recursion. Write a test program
 * that prompts the user to enter 15 integers, stores them in a BST, and
 * invokes the preorder method to display the elements.
 *
 *
 * @author Sharaf Qeshta
 * */
public class Problem$04
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
        * 60 55 45 57 59 100 67 107 101
        * */
        tree.preorderWithoutRecursion();
    }
}
