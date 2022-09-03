package chapter_twenty_six;

/**
 * 26.2 (Compare performance) Write a test program that randomly generates 600,000
 * numbers and inserts them into a BST, reshuffles the 600,000 numbers and performs
 * a search, and reshuffles the numbers again before deleting them from
 * the tree. Write another test program that does the same thing for an AVLTree.
 * Compare the execution times of these two programs.
 *
 *
 * @author Sharaf Qeshta
 * */
public class Problem$02
{
    /*
    * BST take 717 MS to insert 600,000 numbers
    * AVL take 518 MS to insert 600,000 numbers

    * BST take 350 MS to search 600,000 numbers
    * AVL take 241 MS to search 600,000 numbers

    * BST take 276 MS to delete 600,000 numbers
    * AVL take 439 MS to delete 600,000 numbers

    * Result => AVL better than BST
    * */
    public static void main(String[] args)
    {
        // generate 600,000 integers
        int[] array = new int[600_000];
        for (int i = 0; i < array.length; i++)
            array[i] = (int) (Math.random() * 1000_000);

        BST<Integer> binaryTree = new BST<>();

        // inserts them into a BST
        long start = System.currentTimeMillis();
        for (int x: array)
            binaryTree.add(x);
        long end = System.currentTimeMillis();

        long bstInsertion = end - start;

        // reshuffles the 600,000 numbers and performs a search
        shuffle(array);
        start = System.currentTimeMillis();
        for (int x: array)
            binaryTree.search(x);
        end = System.currentTimeMillis();

        long bstSearch = end - start;


        // reshuffles the numbers again before deleting them from the tree
        shuffle(array);
        start = System.currentTimeMillis();
        for (int x: array)
            binaryTree.delete(x);
        end = System.currentTimeMillis();

        long bstDeletion = end - start;

        AVLTree<Integer> avlTree = new AVLTree<>();
        shuffle(array);

        // inserts them into a AVL tree
        start = System.currentTimeMillis();
        for (int x: array)
            avlTree.insert(x);
        end = System.currentTimeMillis();

        long avlInsertion = end - start;

        // reshuffles the 600,000 numbers and performs a search
        shuffle(array);
        start = System.currentTimeMillis();
        for (int x: array)
            avlTree.search(x);
        end = System.currentTimeMillis();

        long avlSearch = end - start;

        // reshuffles the numbers again before deleting them from the tree
        shuffle(array);
        start = System.currentTimeMillis();
        for (int x: array)
            avlTree.delete(x);
        end = System.currentTimeMillis();

        long avlDeletion = end - start;


        System.out.println("BST take " + bstInsertion + " MS to insert 600,000 numbers");
        System.out.println("AVL take " + avlInsertion + " MS to insert 600,000 numbers\n");

        System.out.println("BST take " + bstSearch + " MS to search 600,000 numbers");
        System.out.println("AVL take " + avlSearch + " MS to search 600,000 numbers\n");

        System.out.println("BST take " + bstDeletion + " MS to delete 600,000 numbers");
        System.out.println("AVL take " + avlDeletion + " MS to delete 600,000 numbers\n");

        if ((bstSearch + bstInsertion + bstDeletion) < (avlInsertion + avlSearch + avlDeletion))
            System.out.println("Result => BST better than AVL");
        else
            System.out.println("Result => AVL better than BST");
    }

    public static void shuffle(int[] array)
    {
        for (int i = 0; i < array.length; i++)
        {
            int index = (int) ((Math.random() * array.length * 2) % array.length);
            int temp = array[i];
            array[i] = array[index];
            array[index] = temp;
        }
    }
}
