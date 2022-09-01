package chapter_twenty_five;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Random;
import java.util.Scanner;

/**
 * ***25.16 (Data compression: Huffman coding) Write a program that prompts the user to
 * enter a file name, then displays the frequency table of the characters in the file
 * and the Huffman code for each character.
 *
 *
 * @author Sharaf Qeshta
 */
public class Problem$16
{
    /*
    * result =>
    * Enter text: src/chapter_twenty_five/file.txt
    * ASCII Code     Character      Frequency      Code
    * 32                            34             111
    * 40             (              1              10110010
    * 41             )              1              0010011
    * 44             ,              1              10110011
    * 46             .              1              0010001
    * 58             :              1              10110100
    * 68             D              1              1010000
    * 72             H              2              1011000
    * 87             W              1              0010000
    * 97             a              17             1101
    * 98             b              1              0010010
    * 99             c              9              0000
    * 100            d              4              101001
    * 101            e              21             011
    * 102            f              9              0011
    * 103            g              2              1010001
    * 104            h              10             0100
    * 105            i              7              10001
    * 108            l              4              101111
    * 109            m              6              10000
    * 110            n              10             0101
    * 111            o              9              0001
    * 112            p              5              00101
    * 113            q              1              10110101
    * 114            r              13             1001
    * 115            s              7              10101
    * 116            t              16             1100
    * 117            u              4              101110
    * 121            y              2              1011011
    * */
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter text: ");
        String fileName = input.nextLine();

        String text = "";
        // read the file
        try (Scanner file = new Scanner(new File(fileName)))
        {
            while (file.hasNext())
                text += file.next() + " ";
        }
        catch (IOException exception)
        {
            System.out.println("Something went wrong: " + exception.getMessage());
        }


        int[] counts = getCharacterFrequency(text); // Count frequency

        System.out.printf("%-15s%-15s%-15s%-15s\n",
                "ASCII Code", "Character", "Frequency", "Code");

        Tree tree = getHuffmanTree(counts); // Create a Huffman tree
        String[] codes = getCode(tree.root); // Get codes

        for (int i = 0; i < codes.length; i++)
            if (counts[i] != 0) // (char)i is not in text if counts[i] is 0
                System.out.printf("%-15d%-15s%-15d%-15s\n",
                        i, (char) i + "", counts[i], codes[i]);
    }

    /**
     * Get Huffman codes for the characters
     * This method is called once after a Huffman tree is built
     */
    public static String[] getCode(Tree.Node root)
    {
        if (root == null) return null;
        String[] codes = new String[2 * 128];
        assignCode(root, codes);
        return codes;
    }

    /* Recursively get codes to the leaf node */
    private static void assignCode(Tree.Node root, String[] codes)
    {
        if (root.left != null)
        {
            root.left.code = root.code + "0";
            assignCode(root.left, codes);

            root.right.code = root.code + "1";
            assignCode(root.right, codes);
        }
        else
        {
            codes[(int) root.element] = root.code;
        }
    }

    /**
     * Get a Huffman tree from the codes
     */
    public static Tree getHuffmanTree(int[] counts)
    {
        // Create a heap to hold trees
        Heap<Tree> heap = new Heap<>();
        for (int i = 0; i < counts.length; i++)
        {
            if (counts[i] > 0)
                heap.add(new Tree(counts[i], (char) i)); // A leaf node tree
        }

        while (heap.getSize() > 1)
        {
            Tree t1 = heap.remove(); // Remove the smallest−weight tree
            Tree t2 = heap.remove(); // Remove the next smallest
            heap.add(new Tree(t1, t2)); // Combine two trees
        }

        return heap.remove(); // The final tree
    }

    /**
     * Get the frequency of the characters
     */
    public static int[] getCharacterFrequency(String text)
    {
        int[] counts = new int[256]; // 256 ASCII characters

        for (int i = 0; i < text.length(); i++)
            counts[(int) text.charAt(i)]++; // Count the characters in text

        return counts;
    }

    /**
     * Define a Huffman coding tree
     */
    public static class Tree implements Comparable<Tree>
    {
        Node root; // The root of the tree

        /**
         * Create a tree with two subtrees
         */
        public Tree(Tree t1, Tree t2)
        {
            root = new Node();
            root.left = t1.root;
            root.right = t2.root;
            root.weight = t1.root.weight + t2.root.weight;
        }

        /**
         * Create a tree containing a leaf node
         */
        public Tree(int weight, char element)
        {
            root = new Node(weight, element);
        }

        /** Compare trees based on their weights */
        @Override
        public int compareTo(Tree t)
        {
            if (root.weight < t.root.weight) // Purposely reverse the order
                return 1;
            else if (root.weight == t.root.weight)
                return 0;
            else
                return -1;
        }

        public class Node
        {
            char element; // Stores the character for a leaf node
            int weight; // weight of the subtree rooted at this node
            Node left; // Reference to the left subtree
            Node right; // Reference to the right subtree
            String code = ""; // The code of this node from the root

            /**
             * Create an empty node
             */
            public Node() { }

            /**
             * Create a node with the specified weight and character
             */
            public Node(int weight, char element)
            {
                this.weight = weight;
                this.element = element;
            }
        }
    }
}
