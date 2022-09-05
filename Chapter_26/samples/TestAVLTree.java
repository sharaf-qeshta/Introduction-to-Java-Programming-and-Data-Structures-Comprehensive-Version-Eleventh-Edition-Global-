package chapter_twenty_six.samples;

/**
 * Listing 26.4 TestAVLTree.java
 * */
public class TestAVLTree
{
    public static void main(String[] args)
    {
        // Create an AVL tree
        AVLTree<Integer> tree = new AVLTree<Integer>(new Integer[]{25,
                20, 5});
        System.out.print("After inserting 25, 20, 5:");
        printTree(tree);

        tree.insert(34);
        tree.insert(50);
        System.out.print("\nAfter inserting 34, 50:");
        printTree(tree);

        tree.insert(30);
        System.out.print("\nAfter inserting 30");
        printTree(tree);

        tree.insert(10);
        System.out.print("\nAfter inserting 10");
        printTree(tree);

        tree.delete(34);
        tree.delete(30);
        tree.delete(50);
        System.out.print("\nAfter removing 34, 30, 50:");
        printTree(tree);

        tree.delete(5);
        System.out.print("\nAfter removing 5:");
        printTree(tree);

        System.out.print("\nTraverse the elements in the tree: ");
        for (int e : tree)
        {
            System.out.print(e + " ");
        }
    }

    public static void printTree(BST tree)
    {
        // Traverse tree
        System.out.print("\nInorder (sorted): ");
        tree.inorder();
        System.out.print("\nPostorder: ");
        tree.postorder();
        System.out.print("\nPreorder: ");
        tree.preorder();
        System.out.print("\nThe number of nodes is " + tree.getSize());
        System.out.println();
    }
}

