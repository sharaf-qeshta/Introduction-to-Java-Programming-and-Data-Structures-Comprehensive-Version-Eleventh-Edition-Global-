package chapter_fifteen;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 * **15.6 (Alternate two messages) Write a program to display the text Welcome to
 * java and LearningJavaFX alternately with a mouse click.
 *
 *
 * @author Sharaf Qeshta
 * */
public class Problem$06 extends Application
{
    private static boolean index = true;
    public static void main(String[] args)
    {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage)
    {
        StackPane pane = new StackPane();
        pane.setAlignment(Pos.CENTER);

        String[] phrase = {"Welcome To Java", "LearningJavaFX"};

        Label text = new Label(phrase[0]);
        pane.getChildren().add(text);

        text.setOnMousePressed(e -> {
            text.setText(phrase[(index)? 0 : 1]);
            index = !index;
        });


        Scene scene = new Scene(pane, 500, 500);
        primaryStage.setTitle("Problem$06");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
