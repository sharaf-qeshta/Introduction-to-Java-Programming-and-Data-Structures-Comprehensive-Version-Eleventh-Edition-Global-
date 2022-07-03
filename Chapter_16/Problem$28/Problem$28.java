package chapter_sixteen;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * **16.28 (Slide show) Programming Exercise 15.30 developed a slide show using images.
 * Rewrite that program to develop a slide show using text files. Suppose that
 * 10 text files named slide0.txt, slide1.txt, . . . , slide9.txt are stored in the text
 * directory. Each slide displays the text from one file. Each slide is shown for one
 * second, and the slides are displayed in order. When the last slide finishes, the
 * first slide is redisplayed, and so on. Use a text area to display the slide.
 *
 *
 * @author Sharaf Qeshta
 * */
public class Problem$28 extends Application
{
    private final ArrayList<String> slides = new ArrayList<>();
    private int currentIndex = 0;


    @Override
    public void start(Stage primaryStage)
    {
        for (int i = 0; i < 9;i++)
            slides.add(getSlide(i));

        TextArea textArea = new TextArea(slides.get(currentIndex++));
        textArea.setEditable(false);

        StackPane pane = new StackPane(textArea);

        Scene scene = new Scene(pane, 500, 500);
        primaryStage.setTitle("Problem$28");
        primaryStage.setScene(scene);
        primaryStage.show();


        Timeline slidesMover = new Timeline(
                new KeyFrame(Duration.millis(1000), e -> {
                    if (currentIndex < 9)
                        textArea.setText(slides.get(currentIndex++));
                    else
                        currentIndex = 0;
                })
        );

        slidesMover.setCycleCount(Timeline.INDEFINITE);
        slidesMover.play();
    }


    private String getSlide(int i)
    {
        File file = new File("src/chapter_sixteen/slides/slide" + i + ".txt");
        String slide = "";

        try (Scanner scanner = new Scanner(file))
        {
            while (scanner.hasNext())
                slide += scanner.nextLine() + "\n";
        }
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }
        return slide;
    }
}
