package chapter_thirty_six;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.File;
import java.util.Scanner;

/**
 * **36.11 (Specify file encodings) Write a program named Exercise36_11Writer
 * that writes 1307 * 16 Chinese Unicode characters starting from \u0E00 to a
 * file named Exercise36_11.gb using the GBK encoding scheme. Output 16
 * characters per line and separate the characters with spaces. Write a program named
 * Exercise36_11Reader that reads all the characters from a file using a specified
 * encoding. Figure 36.19 displays the file using the GBK encoding scheme.
 *
 *
 * @author Sharaf Qeshta
 * */
public class Problem$11 extends Application
{
    @Override
    public void start(Stage stage)
    {
        Label lblEnterAFile = new Label("Enter a File: ");
        TextField txtFile = new TextField();
        Label lblEncodingScheme = new Label("Enter the encoding scheme: ");
        TextField txtEncoding = new TextField();
        Button btnViewFile = new Button("View File");

        HBox header = new HBox(5, lblEnterAFile, txtFile,
                lblEncodingScheme, txtEncoding, btnViewFile);

        TextArea taContent = new TextArea();
        taContent.setMinWidth(500); taContent.setMinHeight(400);
        VBox pane = new VBox(10, header, taContent);

        Scene scene = new Scene(pane, 600, 500);
        stage.setScene(scene);
        stage.setTitle("Problem$11Reader");
        stage.show();

        btnViewFile.setOnAction(e ->
        {
            taContent.setText("");
            String filePath = txtFile.getText().trim();
            String encoding = txtEncoding.getText().trim();

            try (Scanner scanner = new Scanner(new File(filePath), encoding))
            {
                while (scanner.hasNext())
                    taContent.appendText(scanner.nextLine() + "\n");
            }
            catch (Exception exception)
            {
                exception.printStackTrace();
            }
        });
    }
}
