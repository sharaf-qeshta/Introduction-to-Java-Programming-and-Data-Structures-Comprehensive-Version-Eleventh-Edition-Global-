package chapter_sixteen;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * *16.12 (Demonstrate TextArea properties) Write a program that demonstrates the
 * properties of a text area. The program uses a check box to indicate whether the
 * text is wrapped onto next line, as shown in Figure 16.41a.
 *
 *
 * @author Sharaf Qeshta
 * */
public class Problem$12 extends Application
{
    @Override
    public void start(Stage primaryStage)
    {
        TextArea textArea = new TextArea();
        ScrollPane textAreaContainer = new ScrollPane(textArea);

        CheckBox editable = new CheckBox("Editable");
        CheckBox wrap = new CheckBox("Wrap");
        HBox settings = new HBox(10, editable, wrap);
        settings.setAlignment(Pos.CENTER);

        editable.setOnAction(e -> textArea.setEditable(!textArea.isEditable()));
        wrap.setOnAction(e -> textArea.setWrapText(!textArea.isWrapText()));

        VBox pane = new VBox(0, textAreaContainer, settings);

        textArea.prefWidthProperty().bind(pane.widthProperty());
        textArea.prefHeightProperty().bind(pane.heightProperty().subtract(20));

        Scene scene = new Scene(pane, 500, 500);
        primaryStage.setTitle("Problem$12");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
