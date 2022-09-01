package chapter_twenty_five;


import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;

/**
 * Listing 25.9 BTView.java
 * */
public class TreePane extends Pane
{
    Tree tree;
    private double radius = 15; // Tree node radius
    private double vGap = 50; // Gap between two levels in a tree

    TreePane(Tree tree, double width, double height)
    {
        setWidth(width);
        setHeight(height);

        setMinWidth(250);
        setMinHeight(250);
        this.tree = tree;
        if (tree != null)
            displayTree();
    }

    public void displayTree()
    {
        this.getChildren().clear(); // Clear the pane
        if (tree.root != null)
        {
            // Display tree recursively
            displayTree(tree.root, getWidth() / 2, vGap,
                    getWidth() / 4);
        }
    }

    /**
     * Display a subtree rooted at position (x, y)
     */
    private void displayTree(Tree.Node root,
                             double x, double y, double hGap)
    {
        if (root.left != null)
        {
            // Draw a line to the left node
            getChildren().add(new Line(x - hGap, y + vGap, x, y));

            // Draw the code
            double middleX = (x - hGap + x) / 2;
            double middleY = (y + vGap + y) / 2;
            getChildren().add(new Text(middleX-5, middleY-5, "0"));

            // Assign the codes
            root.left.code = root.code + "0";

            // Draw the left subtree recursively
            displayTree(root.left, x - hGap, y + vGap, hGap / 2);
        }

        if (root.right != null)
        {
            // Draw a line to the right node
            getChildren().add(new Line(x + hGap, y + vGap, x, y));

            // Draw the code
            double middleX = (x + hGap + x) / 2;
            double middleY = (y + vGap + y) / 2;
            getChildren().add(new Text(middleX+5, middleY-5, "1"));

            // Assign the codes
            root.right.code = root.code + "1";

            // Draw the right subtree recursively
            displayTree(root.right, x + hGap, y + vGap, hGap / 2);
        }

        // Display a node
        Circle circle = new Circle(x, y, radius);
        circle.setFill(Color.WHITE);
        circle.setStroke(Color.BLACK);
        getChildren().addAll(circle,
                new Text(x - 4, y + 4, root.weight + ""));

        // is a leaf
        if (root.left == null && root.right == null)
            getChildren().add(new Text(circle.getCenterX()-5, circle.getCenterY()+radius+10, root.element + ""));
    }
}
