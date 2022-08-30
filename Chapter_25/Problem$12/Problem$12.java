package chapter_twenty_five;

/**
 * **25.12 (Test BST) Design and write a complete test program to test if the BST class in
 * Listing 25.4 meets all requirements.
 *
 *
 * @author Sharaf Qeshta
 * */
public class Problem$12
{
    // we have a tree look like this
    //                               (60)
    //                              /    \
    //                           (55)    (100)
    //                           /  \    /   \
    //                        (45) (57) (67) (107)
    //                                \      /
    //                               (59)   (101)
    //
    // traversals
    // inorder: 45 55 57 59 60 67 100 101 107
    // postorder: 45 59 57 55 67 101 107 100 60
    // preorder: 60 55 45 57 59 100 67 107 101
    // breadth_first: 60 55 100 45 57 67 107 59 101
    //
    // general
    // size: 9
    // leaves: 4
    // non_leaves: 5
    // height: 4
    // perfect: false

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
        * 45 55 57 59 60 67 100 101 107
        * */
        tree.inorder();
        System.out.println();

        /*
        * 45 59 57 55 67 101 107 100 60
        * */
        tree.postorder();
        System.out.println();

        /*
        * 60 55 45 57 59 100 67 107 101
        * */
        tree.preorder();
        System.out.println();

        /*
        * 60 55 100 45 57 67 107 59 101
        * */
        tree.breadthFirstTraversal();
        System.out.println();

        System.out.println(tree.size); // 9
        System.out.println(tree.getNumberOfLeaves()); // 4
        System.out.println(tree.getNumberOfNonLeaves()); // 5
        System.out.println(tree.height()); // 4
        System.out.println(tree.isPerfectBST()); // false
    }
}
