package chapter_sixteen;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * **16.10 (Text viewer) Write a program that displays a text file in a text area, as shown
 * in Figure 16.40a. The user enters a file name in a text field and clicks the View
 * button; the file is then displayed in a text area.
 *
 *
 * @author Sharaf Qeshta
 * */
public class Problem$10 extends Application
{
    @Override
    public void start(Stage primaryStage)
    {
        TextArea textArea = new TextArea();
        ScrollPane scrollPane = new ScrollPane(textArea);


        Label filenameLabel = new Label("File Name");
        filenameLabel.setAlignment(Pos.CENTER);
        TextField fileName = new TextField();
        fileName.setPrefColumnCount(30);
        Button view = new Button("View");

        HBox controllers = new HBox(5, filenameLabel, fileName, view);
        controllers.setAlignment(Pos.CENTER);
        controllers.setStyle("-fx-border-color: black");

        VBox pane = new VBox(10, scrollPane, controllers);

        textArea.prefWidthProperty().bind(pane.widthProperty());
        textArea.prefHeightProperty().bind(pane.heightProperty().subtract(20));

        view.setOnAction(e ->
        {
            StringBuilder content = new StringBuilder();
            for (String line: getAllLines(fileName.getText()))
                content.append(line).append("\n");
            textArea.setText(content.toString());
        });


        Scene scene = new Scene(pane, 500, 500);
        primaryStage.setTitle("Problem$10");
        primaryStage.setScene(scene);
        primaryStage.show();
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
