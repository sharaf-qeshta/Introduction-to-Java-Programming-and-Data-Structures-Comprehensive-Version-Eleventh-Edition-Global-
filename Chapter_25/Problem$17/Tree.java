package chapter_twenty_five;

import java.util.Stack;

/**
 * Define a Huffman coding tree
 */
public class Tree implements Comparable<Tree>
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

    public String getCode(char element)
    {
        Stack<Node> stack = new Stack<>();
        Node current = root;

        while (current != null || !stack.isEmpty())
        {
            while (current != null)
            {
                stack.push(current);
                current = current.left;
            }
            Node top = stack.pop();

            if (top.element == element)
                return top.code;

            current = top.right;
        }
        return null; // the element is not exist
    }




    public String decode(String bitString)
    {
        char[] elements = bitString.toCharArray();
        int index = 0;
        String encoded = "";
        while (index < elements.length)
        {
            Stack<Node> stack = new Stack<>();
            stack.push(root);
            while (!stack.isEmpty())
            {
                Node current = stack.pop();

                if (current.left == null && current.right == null)
                {
                    encoded += current.element;
                    break;
                }

                if (elements[index] == '0')
                    stack.push(current.left);
                else
                    stack.push(current.right);
                index++;
            }
        }

        return encoded;
    }
}
