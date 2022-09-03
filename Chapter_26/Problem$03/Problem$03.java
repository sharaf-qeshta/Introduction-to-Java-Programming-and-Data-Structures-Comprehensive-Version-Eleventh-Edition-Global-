package chapter_twenty_six;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * ***26.3 (AVL tree animation) Write a program that animates the AVL tree insert,
 * delete, and search methods, as shown in Figure 26.2.
 *
 *
 * @author Sharaf Qeshta
 * */
public class Problem$03 extends Application
{
    private static AVLTree<Integer> tree = new AVLTree<>();
    @Override
    public void start(Stage primaryStage)
    {
        VBox pane = new VBox(10);
        pane.setAlignment(Pos.CENTER);

        Label status = new Label();
        pane.getChildren().add(status);

        Pane avlPane = new AVLPane(tree);
        pane.getChildren().add(avlPane);

        HBox settings = new HBox(5);
        settings.setAlignment(Pos.CENTER);

        Label enterKey = new Label("Enter a Key: ");
        TextField key = new TextField();
        key.setPrefColumnCount(6);
        Button search = new Button("Search");
        Button insert = new Button("Insert");
        Button remove = new Button("Remove");

        settings.getChildren().addAll(enterKey, key, search, insert, remove);
        pane.getChildren().add(settings);

        Scene scene = new Scene(pane, 500, 500);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Problem$03");
        primaryStage.show();


        search.setOnAction(e ->
        {
            int key_;
            try
            {
                key_ = Integer.parseInt(key.getText());;
            }
            catch (Exception exception)
            {
                return;
            }

            if (tree.search(key_))
                status.setText("Key " + key_ + " exist in the tree");
            else
                status.setText("Key " + key_ + " is not in the tree");
        });


        insert.setOnAction(e ->
        {
            int key_;
            try
            {
                key_ = Integer.parseInt(key.getText());;
            }
            catch (Exception exception)
            {
                return;
            }

            if (tree.insert(key_))
            {
                status.setText("Key " + key_ + " inserted in the tree");
                pane.getChildren().set(1, new AVLPane(tree));
            }
            else
                status.setText("Key " + key_ + " already in the tree");
        });


        remove.setOnAction(e ->
        {
            int key_;
            try
            {
                key_ = Integer.parseInt(key.getText());;
            }
            catch (Exception exception)
            {
                return;
            }

            if (tree.delete(key_))
            {
                status.setText("Key " + key_ + " deleted from the tree");
                pane.getChildren().set(1, new AVLPane(tree));
            }
            else
                status.setText("Key " + key_ + " is not in the tree");
        });
    }
}
