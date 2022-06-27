package chapter_sixteen;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * *16.6 (Demonstrate TextField properties) Write a program that sets the horizontal
 * alignment and column-size properties of a text field dynamically, as shown in
 * Figure 16.38a.
 *
 *
 * @author Sharaf Qeshta
 * */
public class Problem$06 extends Application
{
    public static void main(String[] args)
    {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage)
    {
        Label textLabel = new Label("Text Field");
        TextField text = new TextField();

        HBox textContainer = new HBox(10, textLabel, text);
        textContainer.setAlignment(Pos.CENTER);

        RadioButton left = new RadioButton("Left");
        RadioButton center = new RadioButton("Center");
        RadioButton right = new RadioButton("Right");

        Label columnSizeLabel = new Label("Column Size");
        TextField columnSizeInput = new TextField();
        columnSizeInput.setPrefColumnCount(2);

        HBox settings = new HBox(10, left, center, right, columnSizeLabel, columnSizeInput);
        settings.setAlignment(Pos.CENTER);

        ToggleGroup group = new ToggleGroup();
        left.setToggleGroup(group);
        center.setToggleGroup(group);
        right.setToggleGroup(group);

        left.setOnAction(e -> text.setAlignment(Pos.CENTER_LEFT));
        center.setOnAction(e -> text.setAlignment(Pos.CENTER));
        right.setOnAction(e -> text.setAlignment(Pos.CENTER_RIGHT));
        columnSizeInput.setOnAction(e ->
        {
            int columns;
            try
            {
                columns = Integer.parseInt(columnSizeInput.getText());
            }
            catch (Exception ex)
            {
                columnSizeInput.setText("Invalid Input");
                return;
            }
            text.setPrefColumnCount(columns);
        });


        VBox pane = new VBox();
        pane.setAlignment(Pos.CENTER);
        pane.setSpacing(10);
        pane.getChildren().addAll(textContainer, settings);

        Scene scene = new Scene(pane, 450, 170);
        primaryStage.setTitle("Problem$06");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
