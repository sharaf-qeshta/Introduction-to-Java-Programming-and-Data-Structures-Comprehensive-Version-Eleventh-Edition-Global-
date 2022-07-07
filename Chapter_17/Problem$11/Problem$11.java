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
 * **17.11 (Split files GUI) Rewrite Exercise 17.10 with a GUI, as shown in Figure 17.21a.
 *
 *
 * @author Sharaf Qeshta
 * */
public class Problem$11 extends Application
{
    @Override
    public void start(Stage primaryStage)
    {
        Scene scene = new Scene(getUI(), 600, 500);
        primaryStage.setTitle("Problem$11");
        primaryStage.setScene(scene);
        primaryStage.show();
        primaryStage.setResizable(false);
    }

    private VBox getUI()
    {
        Text text = new Text("If you split a file named temp.txt int 3 smaller"
                + " files\nthe three smaller files are temp.txt.1, temp.txt.2, and temp.txt.3");

        Label fileNameLabel = new Label("Enter a file name: ");
        TextField fileName = new TextField();
        fileName.setPrefColumnCount(25);
        HBox fileNameContainer = new HBox(5, fileNameLabel, fileName);
        fileNameContainer.setAlignment(Pos.CENTER);

        Label smallerFileLabel = new Label("Specify the number of smaller files: ");
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
                Problem$10.main(new String[]{fileName_, pieces});
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
}
