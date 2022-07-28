package chapter_twenty_one;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


/**
 * **21.11 (Baby name popularity ranking) Use the data files from Programming Exercise 12.31
 * to write a program that enables the user to select a year, gender, and enter a
 * name to display the ranking of the name for the selected year and gender, as
 * shown in Figure 21.9. To achieve the best efficiency, create two arrays for boy’s
 * names and girl’s names, respectively. Each array has 10 elements for 10 years.
 * Each element is a map that stores a name and its ranking in a pair with the name
 * as the key.
 *
 *
 * @author Sharaf Qeshta
 * */
public class Problem$11 extends Application
{
    private static final Map<Integer, Map<String, Integer>> NAMES = new HashMap<>();

    @Override
    public void start(Stage primaryStage) throws MalformedURLException
    {
        setNames();
        Label label = new Label("Select A Year: ");
        ComboBox<Integer> year = new ComboBox<>();
        year.getItems().addAll(2001, 2002, 2003, 2004, 2005,
                2006, 2007, 2008, 2009, 2010);
        year.setValue(2010);
        HBox firstRow = new HBox(5, label, year);
        firstRow.setAlignment(Pos.CENTER);

        Label boyOrGirlLabel = new Label("Boy Or Girl: ");
        ComboBox<String> boyOrGirl = new ComboBox<>();
        boyOrGirl.getItems().addAll("Male", "Female");
        boyOrGirl.setValue("Male");
        HBox secondRow = new HBox(5, boyOrGirlLabel, boyOrGirl);
        secondRow.setAlignment(Pos.CENTER);

        Label enterNameLabel = new Label("Enter a name: ");
        TextField name = new TextField();
        name.setPrefColumnCount(12);
        HBox thirdRow = new HBox(5, enterNameLabel, name);
        thirdRow.setAlignment(Pos.CENTER);

        Button findRanking = new Button("Find Ranking");
        HBox fourthRow = new HBox(findRanking);
        fourthRow.setAlignment(Pos.CENTER);

        Text text = new Text("");

        VBox pane = new VBox(10, firstRow, secondRow, thirdRow, fourthRow, text);


        Scene scene = new Scene(pane, 500, 500);
        primaryStage.setTitle("Problem$11");
        primaryStage.setScene(scene);
        primaryStage.show();


        findRanking.setOnAction(e ->
        {
            String name_, gender_;
            int rank, year_;
            try
            {
                name_ = name.getText().trim();
                rank = NAMES.get(year.getValue()).get(name_);
                gender_ = boyOrGirl.getValue().trim();
                year_ = year.getValue();
            }
            catch (Exception ex)
            {
                return;
            }
            text.setText(gender_ + " name " + name_ + " is ranked #" + rank + " in year " + year_);
        });
    }


    public static ArrayList<String> getAllContent(URL url)
    {
        ArrayList<String> elements = new ArrayList<>();
        try (Scanner scanner = new Scanner(url.openStream()))
        {
            while (scanner.hasNext())
            {
                String x = scanner.nextLine();
                elements.add(x);
            }
        }
        catch (IOException exception)
        {
            exception.printStackTrace();
        }
        return elements;
    }

    public static ArrayList<String> getAllWords(String line)
    {
        ArrayList<String> words = new ArrayList<>();

        try ( Scanner scanner = new Scanner(line))
        {
            while (scanner.hasNext())
                words.add(scanner.next());
            return words;
        }
    }

    public static void setNames()
            throws MalformedURLException
    {
        for (int i = 2001; i < 2011; i++)
        {
            URL url = new URL("http://liveexample.pearsoncmg.com/data/babynamesranking" + i + ".txt");
            ArrayList<String> lines = getAllContent(url);
            Map<String, Integer> year = new HashMap<>();
            for (String line: lines)
            {
                ArrayList<String> words = getAllWords(line);
                int rank = Integer.parseInt(words.get(0));
                year.put(words.get(1), rank);
                year.put(words.get(3), rank);
            }
            NAMES.put(i, year);
        }
    }
}
