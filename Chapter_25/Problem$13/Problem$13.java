package chapter_twenty_five;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

/**
 * **25.13 (Add new buttons in BSTAnimation) Modify Listing 25.8, BSTAnimation.java,
 * to add three new buttons—Show Inorder, Show Preorder, and Show Postorder—
 * to display the result in a label, as shown in Figure 25.20. You need also to modify
 * Listing 25.4, BST.java to implement the inorderList(), preorderList(),
 * and postorderList() methods so each of these methods returns a List of
 * the node elements in inorder, preorder, and postorder, as follows:
 *
 * public java.util.List<E> inorderList();
 * public java.util.List<E> preorderList();
 * public java.util.List<E> postorderList();
 *
 *
 * @author Sharaf Qeshta
 * */
public class Problem$13 extends Application
{
    @Override // Override the start method in the Application class
    public void start(Stage primaryStage)
    {
        BST<Integer> tree = new BST<>(); // Create a tree

        BorderPane pane = new BorderPane();

        Label show = new Label();
        HBox showContainer = new HBox(show);
        showContainer.setAlignment(Pos.CENTER);
        pane.setTop(showContainer);

        BTView view = new BTView(tree); // Create a View
        pane.setCenter(view);

        TextField tfKey = new TextField();
        tfKey.setPrefColumnCount(3);
        tfKey.setAlignment(Pos.BASELINE_RIGHT);
        Button btInsert = new Button("Insert");
        Button btDelete = new Button("Delete");
        Button btInorder = new Button("Show Inorder");
        Button btPreorder = new Button("Show Preorder");
        Button btPostorder = new Button("Show Postorder");

        HBox hBox = new HBox(5);
        hBox.getChildren().addAll(new Label("Enter a key: "),
                tfKey, btInsert, btDelete, btInorder, btPreorder, btPostorder);
        hBox.setAlignment(Pos.CENTER);
        pane.setBottom(hBox);

        btInsert.setOnAction(e ->
        {
            int key = Integer.parseInt(tfKey.getText());
            if (tree.search(key))
            { // key is in the tree already
                view.displayTree();
                view.setStatus(key + " is already in the tree");
            }
            else
            {
                tree.insert(key); // Insert a new key
                view.displayTree();
                view.setStatus(key + " is inserted in the tree");
            }
        });

        btDelete.setOnAction(e ->
        {
            int key = Integer.parseInt(tfKey.getText());
            if (!tree.search(key))
            { // key is not in the tree
                view.displayTree();
                view.setStatus(key + " is not in the tree");
            }
            else
            {
                tree.delete(key); // Delete a key
                view.displayTree();
                view.setStatus(key + " is deleted from the tree");
            }
        });

        btInorder.setOnAction(e ->
                show.setText("Inorder: " + tree.inorderList()));
        btPreorder.setOnAction(e ->
                show.setText("Preorder: " + tree.preorderList()));
        btPostorder.setOnAction(e ->
                show.setText("Postorder: " + tree.postorderList()));

        // Create a scene and place the pane in the stage
        Scene scene = new Scene(pane, 600, 300);
        primaryStage.setTitle("Problem$13"); // Set the stage title
        primaryStage.setScene(scene); // Place the scene in the stage
        primaryStage.show(); // Display the stage
    }
}
