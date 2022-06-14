package chapter_fourteen;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

/**
 * 14.4 (Color and font) Write a program that displays five texts vertically, as shown in
 * Figure 14.44a. Set a random color and opacity for each text and set the font of
 * each text to Times Roman, bold, italic, and 24 pixels.
 *
 * @author Sharaf Qeshta
 * */
public class Problem$04 extends Application
{
    public static void main(String[] args)
    {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage)
    {
        HBox pane = new HBox();
        pane.setAlignment(Pos.CENTER);

        Font font = Font.font("Times Roman", FontWeight.BOLD, FontPosture.ITALIC, 24);

        for (int i = 0; i < 5; i ++)
        {
            Color color = new Color(Math.random(), Math.random(), Math.random(), Math.random());
            javafx.scene.control.Label node = new Label("JavaFX");
            node.setFont(font);
            node.setTextFill(color);
            node.setRotate(90);
            pane.getChildren().add(node);
        }

        Scene scene = new Scene(pane, 500, 500);
        primaryStage.setTitle("Problem$04");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
