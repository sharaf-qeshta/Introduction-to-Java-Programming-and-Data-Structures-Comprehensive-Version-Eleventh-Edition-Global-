package chapter_twenty_six;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;

public class AVLPane extends Pane
{
    private AVLTree<Integer> tree;
    private double radius = 15;
    private double vGap = 50;


    public AVLPane(AVLTree<Integer> tree)
    {
        setStyle("-fx-border-color: black");
        setMinSize(480, 250);
        this.tree = tree;
        if (tree.root != null)
            displayTree((AVLTree.AVLTreeNode<Integer>) tree.root, 500/2.0, vGap, 500/4.0);
    }

    private void displayTree(AVLTree.AVLTreeNode<Integer> root,
                             double x, double y, double hGap)
    {
        if (root.left != null)
        {
            getChildren().add(new Line(x - hGap, y + vGap, x, y));
            displayTree((AVLTree.AVLTreeNode<Integer>) root.left, x - hGap, y + vGap, hGap / 2);
        }

        if (root.right != null)
        {
            getChildren().add(new Line(x + hGap, y + vGap, x, y));
            displayTree((AVLTree.AVLTreeNode<Integer>) root.right, x + hGap, y + vGap, hGap / 2);
        }


        Circle circle = new Circle(x, y, radius);
        circle.setFill(Color.WHITE);
        circle.setStroke(Color.BLACK);
        getChildren().addAll(circle,
                new Text(x-4, y + 4, root.element + ""));
    }
}
