package chapter_sixteen;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.*;
import javafx.stage.Stage;

/**
 * **16.14 (Select a font) Write a program that can dynamically change the font of a text in
 * a label displayed on a stack pane. The text can be displayed in bold and italic at
 * the same time. You can select the font name or font size from combo boxes, as
 * shown in Figure 16.42a. The available font names can be obtained using Font
 * .getFontNames(). The combo box for the font size is initialized with numbers
 * from 1 to 100.
 *
 *
 * @author Sharaf Qeshta
 * */
public class Problem$14 extends Application
{
    private boolean italic_ = false;
    private boolean bold_ = false;

    @Override
    public void start(Stage primaryStage)
    {
        // top settings
        // fonts
        ComboBox<String> fonts = new ComboBox<>();
        fonts.getItems().addAll(Font.getFontNames());
        fonts.setStyle("-fx-color: red");
        fonts.setValue(fonts.getItems().get(0));

        // sizes
        ComboBox<Integer> sizes = new ComboBox<>();
        for (int i = 1; i < 101; i++)
            sizes.getItems().add(i);
        sizes.setStyle("-fx-color: blue");
        sizes.setValue(48);

        // top settings pane
        Label fontName = new Label("Font Name");
        Label fontSize = new Label("Font Size");
        HBox topSettings = new HBox(10, fontName, fonts, fontSize, sizes);
        topSettings.setAlignment(Pos.CENTER);

        // text
        Text text = new Text("Programming is Fun");
        text.setFont(Font.font(fonts.getValue(), 48));
        text.setTextAlignment(TextAlignment.CENTER);

        // bottom settings
        CheckBox italic = new CheckBox("Italic");
        CheckBox bold = new CheckBox("Bold");
        HBox bottomSettings = new HBox(10, bold, italic);
        bottomSettings.setAlignment(Pos.CENTER);

        // main pane
        VBox pane = new VBox(10, topSettings, text, bottomSettings);
        pane.setAlignment(Pos.CENTER);

        Scene scene = new Scene(pane, 500, 500);
        primaryStage.setTitle("Problem$14");
        primaryStage.setScene(scene);
        primaryStage.show();


        fonts.setOnAction(e -> text.setFont(Font.font(fonts.getValue(), sizes.getValue())));
        sizes.setOnAction(e -> text.setFont(Font.font(fonts.getValue(), sizes.getValue())));

        italic.setOnAction(e -> {
            if (text.getFont().getStyle().contains("Italic"))
            {
                if (bold_)
                    text.setFont(Font.font(fonts.getValue(), FontWeight.BOLD,
                            FontPosture.REGULAR,  sizes.getValue()));
                else
                    text.setFont(Font.font(fonts.getValue(),
                            FontPosture.REGULAR, sizes.getValue()));
                italic_ = false;
            }
            else
            {
                if (bold_)
                    text.setFont(Font.font(fonts.getValue(),
                            FontWeight.BOLD, FontPosture.ITALIC,  sizes.getValue()));
                else
                    text.setFont(Font.font(fonts.getValue(),
                            FontPosture.ITALIC, sizes.getValue()));
                italic_ = true;
            }
        });

        bold.setOnAction(e ->
        {
            if (text.getFont().getStyle().contains("Bold"))
            {
                if (italic_)
                    text.setFont(Font.font(fonts.getValue(), FontWeight.NORMAL, FontPosture.ITALIC,  sizes.getValue()));
                else
                    text.setFont(Font.font(fonts.getValue(), FontWeight.NORMAL, sizes.getValue()));
                bold_ = false;
            }
            else
            {
                if (italic_)
                    text.setFont(Font.font(fonts.getValue(), FontWeight.BOLD, FontPosture.ITALIC,  sizes.getValue()));
                else
                    text.setFont(Font.font(fonts.getValue(), FontWeight.BOLD, sizes.getValue()));
                bold_ = true;
            }
        });
    }
}
