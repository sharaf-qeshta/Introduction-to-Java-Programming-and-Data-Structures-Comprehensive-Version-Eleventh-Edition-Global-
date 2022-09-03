package chapter_twenty_five;

import java.io.Serializable;

public class Node implements Serializable
{
    public char element; // Stores the character for a leaf node
    public int weight; // weight of the subtree rooted at this node
    public Node left; // Reference to the left subtree
    public Node right; // Reference to the right subtree
    public String code = ""; // The code of this node from the root

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
