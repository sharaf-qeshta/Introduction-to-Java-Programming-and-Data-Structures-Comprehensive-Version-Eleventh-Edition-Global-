package chapter_fourteen;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 * *14.1 (Display images) Write a program that displays four images in a grid pane, as
 * shown in Figure 14.43a.
 *
 * @author Sharaf Qeshta
 * */
public class Problem$01 extends Application
{
    public static void main(String[] args)
    {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage)
    {
        GridPane pane = new GridPane();
        pane.setHgap(5);
        pane.setVgap(5);

        ImageView us = new ImageView("chapter_fourteen/us.jpg");
        ImageView uk = new ImageView("chapter_fourteen/uk.png");
        ImageView ca = new ImageView("chapter_fourteen/ca.png");
        ImageView ch = new ImageView("chapter_fourteen/ch.png");

        us.setFitWidth(250);
        us.setFitHeight(250);

        uk.setFitWidth(250);
        uk.setFitHeight(250);

        ca.setFitWidth(250);
        ca.setFitHeight(250);

        ch.setFitWidth(250);
        ch.setFitHeight(250);


        pane.add(uk, 0, 0);
        pane.add(ca, 1, 0);
        pane.add(us, 1, 1);
        pane.add(ch, 0, 1);

        Scene scene = new Scene(pane, 500, 500);
        primaryStage.setTitle("Problem$01");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
