package chapter_fifteen;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.File;
import java.util.ArrayList;
import java.util.Objects;

/**
 * *15.1 (Pick four cards) Write a program that lets the user click the Refresh button to
 * display four cards from a deck of 52 cards, as shown in Figure 15.26a. (See the
 * hint in Programming Exercise 14.3 on how to obtain four random cards.)
 *
 *
 * @author Sharaf Qeshta
 * */
public class Problem$01 extends Application
{
    public static void main(String[] args)
    {
        launch(args);
    }

    private final ArrayList<ImageView> ALL_IMAGES = getAllImages();
    @Override
    public void start(Stage primaryStage){
        VBox pane = new VBox();
        pane.setAlignment(Pos.CENTER);
        pane.setSpacing(20);

        HBox hBox = new HBox();
        hBox.setSpacing(10);
        hBox.setAlignment(Pos.CENTER);
        get4RandomImages(hBox);
        Button refresh = new Button("Refresh");

        refresh.setOnAction(e -> get4RandomImages(hBox));

        pane.getChildren().addAll(hBox, refresh);

        Scene scene = new Scene(pane, 500, 500);
        primaryStage.setTitle("Problem$01");
        primaryStage.setScene(scene);
        primaryStage.show();


        pane.requestFocus();
    }


    private void get4RandomImages(HBox horizontalPane)
    {
        horizontalPane.getChildren().clear();

        for (int i = 0; i < 4; i ++)
        {
            try {
                int random = (int) ((Math.random() * 100) % ALL_IMAGES.size());
                ImageView image = ALL_IMAGES.get(random);
                horizontalPane.getChildren().add(image);
            }catch (Exception e){
                i = (i == 0)? 0 : i-1;
            }
        }
    }


    private ArrayList<ImageView> getAllImages()
    {
        ArrayList<ImageView> images = new ArrayList<>();
        File[] cards = new File("src/sample/PNG-cards-1.3").listFiles();
        for (int i = 0; i < Objects.requireNonNull(cards).length; i++)
        {
            ImageView node = new ImageView("chapter_fifteen/PNG-cards-1.3/" + cards[i].getName());
            node.setFitHeight(200);
            node.setFitWidth(100);
            images.add(node);
        }
        return images;
    }
}
