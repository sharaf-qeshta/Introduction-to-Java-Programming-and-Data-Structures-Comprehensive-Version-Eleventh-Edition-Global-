package chapter_seventeen;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * *17.13 (Combine files GUI) Rewrite Exercise 17.12 with a GUI, as shown in Figure 17.21b.
 *
 *
 * @author Sharaf Qeshta
 * */
public class Problem$13 extends Application
{
    @Override
    public void start(Stage primaryStage)
    {
        Scene scene = new Scene(getUI(), 600, 500);
        primaryStage.setTitle("Problem$13");
        primaryStage.setScene(scene);
        primaryStage.show();
        primaryStage.setResizable(false);
    }

    private VBox getUI()
    {
        Text text = new Text("If the base file named temp.txt with three pieces,\n"
                + "temp.txt.1, temp.txt.2, and temp.txt.3 are combined into temp.txt");

        Label fileNameLabel = new Label("Enter a file name: ");
        TextField fileName = new TextField();
        fileName.setPrefColumnCount(25);
        HBox fileNameContainer = new HBox(5, fileNameLabel, fileName);
        fileNameContainer.setAlignment(Pos.CENTER);

        Label smallerFileLabel = new Label("Specify the number of small files: ");
        TextField smallerFilesCount = new TextField();
        smallerFilesCount.setPrefColumnCount(25);
        HBox smallerFilesContainer = new HBox(5, smallerFileLabel, smallerFilesCount);
        smallerFilesContainer.setAlignment(Pos.CENTER);

        Button start = new Button("Start");
        HBox buttonContainer = new HBox(start);
        buttonContainer.setAlignment(Pos.CENTER);

        start.setOnAction(e ->
        {
            String fileName_, pieces;
            try
            {
                fileName_ = fileName.getText().trim();
                pieces = smallerFilesCount.getText().trim();
            }
            catch (Exception ex)
            {
                return;
            }
            try
            {
                Problem$12.main(getArguments(fileName_, Integer.parseInt(pieces)));
            }
            catch (IOException exception)
            {
                exception.printStackTrace();
            }
        });

        VBox pane = new VBox(10, text, fileNameContainer, smallerFilesContainer, buttonContainer);
        pane.setAlignment(Pos.CENTER);
        return pane;
    }


    private String[] getArguments(String filename, int pieces)
    {
        String[] arguments = new String[pieces+1];

        for (int i = 0; i < arguments.length-1; i++)
            arguments[i] = filename + "." + (i+1);
        arguments[pieces] = filename;

        return arguments;
    }
}
