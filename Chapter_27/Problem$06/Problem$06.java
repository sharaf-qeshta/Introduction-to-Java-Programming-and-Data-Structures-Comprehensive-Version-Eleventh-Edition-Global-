package chapter_twenty_seven;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * **27.6 (Animate linear probing) Write a program that animates linear probing, as shown
 * in Figure 27.3. You can change the initial size of the hash-table in the program.
 * Assume that the load-factor threshold is 0.8.
 *
 *
 * @author Sharaf Qeshta
 * */
public class Problem$06 extends Application
{
    @Override
    public void start(Stage primaryStage)
    {
        VBox pane = new VBox(10);
        pane.setAlignment(Pos.CENTER);
        pane.setPadding(new Insets(20, 20, 20, 20));
        Label status = new Label();
        pane.getChildren().add(status);

        MapPane mapPane = new MapPane(500, 250);
        pane.getChildren().add(mapPane);


        Label enterKey = new Label("Enter a key: ");
        TextField key = new TextField();
        key.setPrefColumnCount(6);
        Button search = new Button("Search");
        Button insert = new Button("Insert");
        Button remove = new Button("Remove");
        Button removeAll = new Button("Remove All");

        HBox settings = new HBox(5, enterKey, key, search, insert, remove, removeAll);
        pane.getChildren().add(settings);

        search.setOnAction(e ->
        {
            status.setText("");
            int key_;
            try
            {
                key_ = Integer.parseInt(key.getText());
            }
            catch (Exception exception)
            {
                return;
            }

            status.setText(mapPane.search(key_));
        });


        insert.setOnAction(e ->
        {
            status.setText("");
            int key_;
            try
            {
                key_ = Integer.parseInt(key.getText());
            }
            catch (Exception exception)
            {
                return;
            }
            mapPane.add(key_);
        });


        remove.setOnAction(e ->
        {
            status.setText("");
            int key_;
            try
            {
                key_ = Integer.parseInt(key.getText());
            }
            catch (Exception exception)
            {
                return;
            }
            mapPane.remove(key_);
        });

        removeAll.setOnAction(e ->
                mapPane.removeAll());

        Scene scene = new Scene(pane, 600, 500);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Problem$06");
        primaryStage.show();
    }
}
