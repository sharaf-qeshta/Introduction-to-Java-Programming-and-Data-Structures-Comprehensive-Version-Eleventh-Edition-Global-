package chapter_twenty_six;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * *26.1 (Display AVL tree graphically) Write a program that displays an AVL tree along
 * with its balance factor for each node.
 *
 *
 * @author Sharaf Qeshta
 * */
public class Problem$01 extends Application
{
    /*
    * each node constructed as follow
    * element:balanceFactor
    * */
    @Override
    public void start(Stage primaryStage)
    {
        AVLTree<Integer> tree = new AVLTree<>();
        tree.insert(25);
        tree.insert(20);
        tree.insert(5);
        tree.insert(34);
        tree.insert(30);
        tree.insert(50);
        tree.insert(4);

        Pane avlPane = new AVLPane(tree);

        Scene scene = new Scene(avlPane, 500, 500);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Problem$01");
        primaryStage.show();
    }
}
