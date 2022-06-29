package chapter_sixteen;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * **16.11 (Create a histogram for occurrences of letters) Write a program that reads a
 * file and displays a histogram to show the occurrences of each letter in the file,
 * as shown in Figure 16.40b. The file name is entered from a text field. Pressing
 * the Enter key on the text field causes the program to start to read, process the
 * file, and display the histogram. The histogram is displayed in the center of the
 * window. Define a class named Histogram that extends Pane. The class contains the
 * property counts that is an array of 26 elements. counts[0] stores the
 * number of A, counts[1] the number of B, and so on. The class also contains a
 * setter method for setting a new counts and displaying the histogram for the new
 * counts.
 *
 *
 * @author Sharaf Qeshta
 * */
public class Problem$11 extends Application
{
    private int[] letters = new int[26];
    @Override
    public void start(Stage primaryStage)
    {
        Label filenameLabel = new Label("File Name");
        filenameLabel.setAlignment(Pos.CENTER);
        TextField fileName = new TextField();
        fileName.setPrefColumnCount(30);
        Button view = new Button("View");

        HBox controllers = new HBox(5, filenameLabel, fileName, view);
        controllers.setAlignment(Pos.CENTER);
        controllers.setStyle("-fx-border-color: black");

        Histogram histogram = new Histogram(letters);

        BorderPane pane = new BorderPane();
        pane.setCenter(histogram);
        pane.setBottom(controllers);


        view.setOnAction(e ->
        {
            analyze(fileName.getText());
            histogram.rePaint(letters);
        });

        Scene scene = new Scene(pane, 500, 500);
        primaryStage.setTitle("Problem$11");
        primaryStage.setScene(scene);
        primaryStage.show();
    }


    private void analyze(String path)
    {
        letters = new int[26];
        ArrayList<String> lines = getAllLines(path);

        for (String line: lines)
        {
            char[] lineChars = line.toCharArray();

            for (char x: lineChars)
            {
                if (Character.isLetter(x))
                    letters[((int) Character.toLowerCase(x)) - 97]++;
            }
        }
    }


    private ArrayList<String> getAllLines(String path)
    {
        File file = new File(path);
        ArrayList<String> lines = new ArrayList<>();

        try (Scanner scanner = new Scanner(file))
        {
            while (scanner.hasNext())
                lines.add(scanner.nextLine());
        }
        catch (FileNotFoundException e)
        {
            System.out.println("File Not Exist");
        }
        return lines;
    }
}
