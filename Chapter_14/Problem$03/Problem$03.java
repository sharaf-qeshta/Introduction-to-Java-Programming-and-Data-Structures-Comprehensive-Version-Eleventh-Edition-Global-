package chapter_fourteen;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.io.File;

/**
 * *14.3 (Display three tiles) Write a program that displays three tiles randomly selected
 * from tiles of 32, as shown in Figure 14.43c. The Tien-Gow tiles image files are
 * named 1.png, 2.png, . . . , 32.png and stored in the image/tiengow directory.
 * All three tiles are distinct and selected randomly. Hint: You can select random
 * tiles by storing the numbers 1–32 to an array list, perform a random shuffle
 * introduced in Section 11.12, and use the first three numbers in the array list as
 * the file names for the image.
 *
 * @author Sharaf Qeshta
 * */
public class Problem$03 extends Application
{
    public static void main(String[] args)
    {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage)
    {
        HBox pane = new HBox(20);
        pane.setAlignment(Pos.CENTER);

        File[] cards = new File("src/chapter_fourteen/PNG-cards-1.3").listFiles();

        for (int i = 0; i < 3; i ++)
        {
            assert cards != null;
            int random = (int) ((Math.random() * 10) % cards.length);
            ImageView node = new ImageView("chapter_fourteen/PNG-cards-1.3/" + cards[random].getName());
            node.setFitHeight(200);
            node.setFitWidth(100);
            pane.getChildren().add(node);
        }

        Scene scene = new Scene(pane, 500, 500);
        primaryStage.setTitle("Problem$03");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
