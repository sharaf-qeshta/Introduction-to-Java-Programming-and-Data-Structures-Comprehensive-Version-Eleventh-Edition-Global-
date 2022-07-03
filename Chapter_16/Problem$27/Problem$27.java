package chapter_sixteen;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * **16.27 (Display country flag and flag description) Listing 16.8, ComboBoxDemo.
 * java, gives a program that lets the user view a country’s flag image and description
 * by selecting the country from a combo box. The description is a string
 * coded in the program. Rewrite the program to read the text description from
 * a file. Suppose the descriptions are stored in the files description0.txt, . . . ,
 * and description8.txt under the text directory for the nine countries Canada,
 * China, Denmark, France, Germany, India, Norway, the United Kingdom, and
 * the United States, in this order.
 *
 *
 * @author Sharaf Qeshta
 * */
public class Problem$27 extends Application
{
    private final String[] flagTitles = {"Canada", "China", "Denmark",
            "France", "Germany", "India", "Norway", "United Kingdom",
            "United States of America"};


    private final ImageView[] flagImage =
    {
            new ImageView("chapter_sixteen/image/canada.png"),
            new ImageView("chapter_sixteen/image/china.png"),
            new ImageView("chapter_sixteen/image/denmark.png"),
            new ImageView("chapter_sixteen/image/france.png"),
            new ImageView("chapter_sixteen/image/germany.png"),
            new ImageView("chapter_sixteen/image/india.png"),
            new ImageView("chapter_sixteen/image/norway.png"),
            new ImageView("chapter_sixteen/image/united kingdom.png"),
            new ImageView("chapter_sixteen/image/united states.png")
    };


    private final String[] flagDescription = new String[9];

    private final DescriptionPane descriptionPane = new DescriptionPane();


    private final ComboBox<String> cbo = new ComboBox<>();

    @Override
    public void start(Stage primaryStage)
    {
        flagDescription[0] = getDescription(0);
        flagDescription[1] = getDescription(1);
        flagDescription[2] = getDescription(2);
        flagDescription[3] = getDescription(3);
        flagDescription[4] = getDescription(4);
        flagDescription[5] = getDescription(5);
        flagDescription[6] = getDescription(6);
        flagDescription[7] = getDescription(7);
        flagDescription[8] = getDescription(8);

        setDisplay(0);

        BorderPane pane = new BorderPane();

        BorderPane paneForComboBox = new BorderPane();
        paneForComboBox.setLeft(new Label("Select a country: "));
        paneForComboBox.setCenter(cbo);
        pane.setTop(paneForComboBox);
        cbo.setPrefWidth(400);
        cbo.setValue("Canada");

        ObservableList<String> items =
                FXCollections.observableArrayList(flagTitles);
        cbo.getItems().addAll(items);
        pane.setCenter(descriptionPane);


        cbo.setOnAction(e -> setDisplay(items.indexOf(cbo.getValue())));

        Scene scene = new Scene(pane, 450, 170);
        primaryStage.setTitle("Problem$27");
        primaryStage.setScene(scene);
        primaryStage.show();
    }


    public void setDisplay(int index)
    {
        descriptionPane.setTitle(flagTitles[index]);
        descriptionPane.setImageView(flagImage[index]);
        descriptionPane.setDescription(flagDescription[index]);
    }

    private String getDescription(int i)
    {
        File file = new File("src/chapter_sixteen/descriptions/description"+i+".txt");
        String description = "";

        try (Scanner scanner = new Scanner(file))
        {
            while (scanner.hasNext())
                description += scanner.nextLine() + "\n";
        }
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }
        return description;
    }
}
