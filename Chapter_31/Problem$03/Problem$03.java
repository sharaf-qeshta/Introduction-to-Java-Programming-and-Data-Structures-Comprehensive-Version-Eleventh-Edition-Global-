package chapter_thirty_one;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.io.File;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

/**
 * *31.3 (Display three cards) Write a program that displays three cards randomly selected
 * from a deck of 52, as shown in Figure 31.48c. The card image files are named
 * 1.png, 2.png, . . ., 52.png and stored in the image/card directory. All the three
 * cards are distinct and selected randomly. Hint: You can select random cards by storing
 * the numbers 1–52 to an array, perform a random shuffle using Section 7.2.6,
 * and use the first three numbers in the array as the file names for the image. Use the
 * style sheet for border.
 *
 *
 * @author Sharaf Qeshta
 * */
public class Problem$03 extends Application
{
    @Override
    public void start(Stage stage)
    {
        HBox pane = new HBox(10);
        pane.setAlignment(Pos.CENTER);
        Scene scene = new Scene(pane, 400, 300);
        scene.getStylesheets().add("chapter_thirty_one/Problem$03.css");
        pane.getStyleClass().add("pane_border");

        List<File> cards = Arrays.asList
                (Objects.requireNonNull(new File("src/chapter_thirty_one/PNG-cards-1.3").listFiles()));
        Collections.shuffle(cards);

        for (int i = 0; i < 3; i++)
        {
            ImageView image = new ImageView("chapter_thirty_one/PNG-cards-1.3/" + cards.get(i).getName());
            image.setFitHeight(200);
            image.setFitWidth(100);
            pane.getChildren().add(image);
        }

        stage.setTitle("Problem$03");
        stage.setScene(scene);
        stage.show();
    }
}
