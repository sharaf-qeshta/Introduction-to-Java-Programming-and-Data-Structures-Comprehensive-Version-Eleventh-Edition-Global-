package chapter_twenty_five;

/**
 * **25.5 (Implement postorder traversal without using recursion) Implement the
 * postorder method in BST using a stack instead of recursion. Write a test
 * program that prompts the user to enter 15 integers, stores them in a BST, and
 * invokes the postorder method to display the elements.
 *
 *
 * @author Sharaf Qeshta
 * */
public class Problem$05
{
    public static void main(String[] args) {
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
        * 45 59 57 55 67 101 107 100 60
        * */
        tree.postorderWithoutRecursion();
    }
}
