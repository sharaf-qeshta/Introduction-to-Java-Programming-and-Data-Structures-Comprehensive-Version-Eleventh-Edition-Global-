package chapter_fourteen;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.io.File;

/**
 * 14.8 (Display 54 cards) Expand Exercise 14.3 to display all 54 cards (including two
 * jokers), nine per row. The image files are jokers and are named 53.png and 54.png
 *
 * @author Sharaf Qeshta
 * */
public class Problem$08 extends Application
{
    public static void main(String[] args)
    {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage)
    {
        GridPane pane = new GridPane();
        pane.setAlignment(Pos.CENTER);
        pane.setHgap(10);
        pane.setVgap(10);

        File[] cards = new File("src/chapter_fourteen/PNG-cards-1.3").listFiles();

        int index = 0;

        for (int i = 0; i < 6; i++)
        {
            for (int j = 0; j < 9;j++, index++)
            {
                assert cards != null;
                ImageView node = new ImageView("sample/PNG-cards-1.3/" + cards[index].getName());
                node.setFitHeight(100);
                node.setFitWidth(50);
                pane.add(node, j, i);
            }
        }

        Scene scene = new Scene(pane, 500, 500);
        primaryStage.setTitle("Problem$08");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
