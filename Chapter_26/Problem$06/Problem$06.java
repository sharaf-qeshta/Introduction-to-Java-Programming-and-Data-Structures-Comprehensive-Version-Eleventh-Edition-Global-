package chapter_twenty_six;

/**
 * **26.6 (Test AVLTree) Design and write a complete test program to test if the AVLTree
 * class in Listing 26.3 meets all requirements.
 *
 *
 * @author Sharaf Qeshta
 * */
public class Problem$06
{
    public static void main(String[] args)
    {
        AVLTree<Integer> tree = new AVLTree<>();
        tree.insert(25);
        tree.insert(20);
        tree.insert(5);
        tree.insert(34);
        tree.insert(30);
        tree.insert(50);
        tree.insert(4);

        for (int x: tree)
        {
            tree.displayPath(tree.root);
            tree.delete(x);
        }
    }
}
