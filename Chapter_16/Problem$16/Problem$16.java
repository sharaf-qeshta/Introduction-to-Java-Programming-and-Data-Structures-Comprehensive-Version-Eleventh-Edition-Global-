package chapter_sixteen;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * *16.16 (Use ComboBox and ListView) Write a program that demonstrates selecting
 * items in a list. The program uses a combo box to specify a selection mode, as
 * shown in Figure 16.43a. When you select items, they are displayed in a label
 * below the list.
 *
 *
 * @author Sharaf Qeshta
 * */
public class Problem$16 extends Application
{
    @Override
    public void start(Stage primaryStage)
    {
        // top
        Label label = new Label("Choose Selection Mode");
        ComboBox<String> choiceMode = new ComboBox<>();
        choiceMode.getItems().addAll("Multiple", "Single");
        choiceMode.setValue("Multiple");
        HBox controllers = new HBox(10, label, choiceMode);
        controllers.setAlignment(Pos.CENTER);


        // list view
        ObservableList<String> items =
                FXCollections.observableArrayList("China", "Japan",
                        "Korea", "India", "Malaysia", "Vietnam", "Laos", "Taiwan", "Cambodia"
                        , "Thailand", "Myanmar", "Singapore", "Indonesia", "Nepal", "Bangladesh", "Bhutan");
        ListView<String> lv = new ListView<>(items);

        lv.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

        // show selected items
        Label choices = new Label("Selected Items Are ");

        VBox pane = new VBox(5, controllers, lv, choices);


        Scene scene = new Scene(pane, 500, 500);
        primaryStage.setTitle("Problem$16");
        primaryStage.setScene(scene);
        primaryStage.show();

        // listeners
        lv.getSelectionModel().selectedItemProperty().addListener(ov ->
        {
            String newString = "Selected Items Are ";
            for (String choice: lv.getSelectionModel().getSelectedItems())
                newString += choice +", ";
            choices.setText(newString);
        });

        choiceMode.setOnAction(e ->
        {
            if (choiceMode.getValue().equals("Multiple"))
                lv.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
            else
                lv.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        });
    }
}
