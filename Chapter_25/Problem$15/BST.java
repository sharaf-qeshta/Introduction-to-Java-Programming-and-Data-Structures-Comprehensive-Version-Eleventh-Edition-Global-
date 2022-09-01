package chapter_twenty_five;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Listing 25.4 BST.java
 * */
public class BST<E extends Comparable<E>> implements Tree<E> {
    protected TreeNode<E> root;
    protected int size = 0;

    /**
     * Create an empty binary tree
     */
    public BST() { }

    /**
     * Create a binary tree from an array of objects
     */
    public BST(E[] objects)
    {
        for (int i = 0; i < objects.length; i++)
            add(objects[i]);
    }

    /** Returns true if the element is in the tree */
    @Override
    public boolean search(E e)
    {
        TreeNode<E> current = root; // Start from the root

        while (current != null)
        {
            if (e.compareTo(current.element) < 0)
            {
                current = current.left;
            }
            else if (e.compareTo(current.element) > 0)
            {
                current = current.right;
            }
            else // element matches current.element
                return true; // Element is found
        }

        return false;
    }

    /** Insert element e into the binary tree
     * Return true if the element is inserted successfully
     * */
    @Override
    public boolean insert(E e)
    {
        if (root == null)
            root = createNewNode(e); // Create a new root
        else
        {
            // Locate the parent node
            TreeNode<E> parent = null;
            TreeNode<E> current = root;
            while (current != null)
                if (e.compareTo(current.element) < 0)
                {
                    parent = current;
                    current = current.left;
                }
                else if (e.compareTo(current.element) > 0)
                {
                    parent = current;
                    current = current.right;
                }
                else
                    return false; // Duplicate node not inserted

            // Create the new node and attach it to the parent node
            if (e.compareTo(parent.element) < 0)
            {
                parent.left = createNewNode(e);
                parent.left.parent = parent;
            }
            else
            {
                parent.right = createNewNode(e);
                parent.right.parent = parent;
            }
        }

        size++;
        return true; // Element inserted successfully
    }

    protected TreeNode<E> createNewNode(E e)
    {
        return new TreeNode<>(e);
    }

    /** Inorder traversal from the root */
    @Override
    public void inorder()
    {
        inorder(root);
    }

    /**
     * Inorder traversal from a subtree
     */
    protected void inorder(TreeNode<E> root)
    {
        if (root == null) return;
        inorder(root.left);
        System.out.print(root.element + " ");
        inorder(root.right);
    }

    /** Postorder traversal from the root */
    @Override
    public void postorder()
    {
        postorder(root);
    }

    /**
     * Postorder traversal from a subtree
     */
    protected void postorder(TreeNode<E> root)
    {
        if (root == null) return;
        postorder(root.left);
        postorder(root.right);
        System.out.print(root.element + " ");
    }

    /** Preorder traversal from the root */
    @Override
    public void preorder()
    {
        preorder(root);
    }

    /**
     * Preorder traversal from a subtree
     */
    protected void preorder(TreeNode<E> root)
    {
        if (root == null) return;
        System.out.print(root.element + " ");
        preorder(root.left);
        preorder(root.right);
    }

    /**
     * This inner class is static, because it does not access
     * any instance members defined in its outer class
     */
    public static class TreeNode<E>
    {
        protected E element;
        protected TreeNode<E> left;
        protected TreeNode<E> right;
        protected TreeNode<E> parent;

        public TreeNode(E e)
        {
            element = e;
        }
    }

    /** Get the number of nodes in the tree */
    @Override
    public int getSize()
    {
        return size;
    }

    /**
     * Returns the root of the tree
     */
    public TreeNode<E> getRoot()
    {
        return root;
    }

    /**
     * Returns a path from the root leading to the specified element
     */
    public java.util.ArrayList<TreeNode<E>> path(E e)
    {
        java.util.ArrayList<TreeNode<E>> list =
                new java.util.ArrayList<>();
        TreeNode<E> current = root; // Start from the root

        while (current != null)
        {
            list.add(current); // Add the node to the list
            if (e.compareTo(current.element) < 0)
            {
                current = current.left;
            }
            else if (e.compareTo(current.element) > 0)
            {
                current = current.right;
            }
            else
                break;
        }

        return list; // Return an array list of nodes
    }

    /** Delete an element from the binary tree.
     * Return true if the element is deleted successfully
     * Return false if the element is not in the tree */
    @Override
    public boolean delete(E e)
    {
        // Locate the node to be deleted and also locate its parent node
        TreeNode<E> parent = null;
        TreeNode<E> current = root;
        while (current != null)
        {
            if (e.compareTo(current.element) < 0)
            {
                parent = current;
                current = current.left;
            }
            else if (e.compareTo(current.element) > 0)
            {
                parent = current;
                current = current.right;
            }
            else
                break; // Element is in the tree pointed at by current
        }
        if (current == null)
            return false; // Element is not in the tree

        // Case 1: current has no left child
        if (current.left == null)
        {
            // Connect the parent with the right child of the current node
            if (parent == null)
            {
                root = current.right;
            }
            else
            {
                if (e.compareTo(parent.element) < 0)
                {
                    parent.left = current.right;
                    if (parent.left != null)
                        parent.right.parent = parent;
                }
                else
                {
                    parent.right = current.right;
                    if (parent.right != null)
                        parent.right.parent = parent;
                }
            }
        }
        else
        {
            // Case 2: The current node has a left child
            // Locate the rightmost node in the left subtree of
            // the current node and also its parent
            TreeNode<E> parentOfRightMost = current;
            TreeNode<E> rightMost = current.left;

            while (rightMost.right != null)
            {
                parentOfRightMost = rightMost;
                rightMost = rightMost.right; // Keep going to the right
            }

            // Replace the element in current by the element in rightMost
            current.element = rightMost.element;

            // Eliminate rightmost node
            if (parentOfRightMost.right == rightMost)
            {
                parentOfRightMost.right = rightMost.left;
                if (parentOfRightMost.right != null)
                    parentOfRightMost.right.parent = parentOfRightMost;
            }
            else
            {
                // Special case: parentOfRightMost == current
                parentOfRightMost.left = rightMost.left;
                if (parentOfRightMost.left != null)
                    parentOfRightMost.left.parent = parentOfRightMost;
            }
        }

        size--;
        return true; // Element deleted successfully
    }

    /** Obtain an iterator. Use inorder. */
    @Override
    public java.util.Iterator<E> iterator()
    {
        return new InorderIterator();
    }

    // Inner class InorderIterator
    private class InorderIterator implements java.util.Iterator<E>
    {
        // Store the elements in a list
        private java.util.ArrayList<E> list =
                new java.util.ArrayList<>();
        private int current = 0; // Point to the current element in list

        public InorderIterator()
        {
            inorder(); // Traverse binary tree and store elements in list
        }

        /**
         * Inorder traversal from the root
         */
        private void inorder()
        {
            inorder(root);
        }

        /**
         * Inorder traversal from a subtree
         */
        private void inorder(TreeNode<E> root)
        {
            if (root == null) return;
            inorder(root.left);
            list.add(root.element);
            inorder(root.right);
        }

        /** More elements for traversing? */
        @Override
        public boolean hasNext()
        {
            if (current < list.size())
                return true;
            return false;
        }

        /** Get the current element and move to the next */
        @Override
        public E next()
        {
            return list.get(current++);
        }

        /** Remove the current element */
        @Override
        public void remove()
        {
            if (current == 0) // next() has not been called yet
                throw new IllegalStateException();

            delete(list.get(--current));
            list.clear(); // Clear the list
            inorder(); // Rebuild the list
        }
    }

    /** Remove all elements from the tree */
    @Override
    public void clear()
    {
        root = null;
        size = 0;
    }

    /** Return the node for the specified element.
     * Return null if the element is not in the tree. */
    private TreeNode<E> getNode(E element)
    {
        Stack<TreeNode<E>> stack = new Stack<>();
        TreeNode<E> current = root;

        while (current != null || !stack.isEmpty())
        {
            while (current != null)
            {
                stack.push(current);
                current = current.left;
            }
            TreeNode<E> top = stack.pop();
            if (top.element == element)
                return top;
            current = top.right;
        }
        return null;
    }

    /** Return true if the node for the element is a leaf */
    public boolean isLeaf(E element)
    {
        TreeNode<E> node = getNode(element);
        return node.left == null && node.right == null;
    }

    /** Return the path of elements from the specified element
     * to the root in an array list. */
    public ArrayList<E> getPath(E e)
    {
        ArrayList<E> path = new ArrayList<>();
        TreeNode<E> current = getNode(e);

        while (current != null)
        {
            path.add(current.element);
            current = current.parent;
        }

        return path;
    }
}
