package chapter_thirty_one;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * 31.4 (Color and font) Write a program that displays five texts vertically, as shown in
 * Figure 31.49a. Set a random color and opacity for each text and set the font of each
 * text to Times Roman, bold, italic, and 22 pixels.
 *
 *
 * @author Sharaf Qeshta
 * */
public class Problem$04 extends Application
{
    @Override
    public void start(Stage stage)
    {
        Pane pane = new Pane();

        int x = 50;
        for (int i = 0; i < 5; i++)
        {
            Text text = new Text(x, 250, "Java");
            text.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.ITALIC, 22));
            text.setFill(new Color(Math.random(), Math.random(), Math.random(), Math.random()));
            text.setRotate(90);
            pane.getChildren().add(text);

            x += 50;
        }

        Scene scene = new Scene(pane, 400, 400);
        stage.setScene(scene);
        stage.setTitle("Problem$04");
        stage.show();
    }
}
