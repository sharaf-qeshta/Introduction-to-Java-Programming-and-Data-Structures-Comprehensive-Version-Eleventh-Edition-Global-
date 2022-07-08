package chapter_seventeen;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.*;
import java.util.ArrayList;

/**
 * **17.20 (Binary editor) Write a GUI application that lets the user to enter a file name in 
 * the text field and press the Enter key to display its binary representation in a text 
 * area. The user can also modify the binary code and save it back to the file, as 
 * shown in Figure 17.23a
 * 
 *
 * @author Sharaf Qeshta	
*/
public class Problem$20 extends Application
{
    private final TextArea editor = new TextArea();

    @Override
    public void start(Stage primaryStage)
    {
        Scene scene = new Scene(getUI(), 600, 500);
        primaryStage.setTitle("Problem$20");
        primaryStage.setScene(scene);
        primaryStage.show();
    }


    public VBox getUI()
    {
        Label label = new Label("Enter A File: ");
        TextField fileName = new TextField();
        fileName.setPrefColumnCount(15);

        HBox fileInputContainer = new HBox(5, label, fileName);
        fileInputContainer.setAlignment(Pos.CENTER);

        editor.setWrapText(true);

        Button saveTheChange = new Button("Save The Change");
        HBox buttonContainer = new HBox(saveTheChange);
        buttonContainer.setAlignment(Pos.CENTER);

        VBox pane = new VBox(20, fileInputContainer, editor, buttonContainer);
        editor.prefHeightProperty().bind(pane.heightProperty().divide(1.5));
        editor.prefWidthProperty().bind(pane.widthProperty());
        pane.setAlignment(Pos.CENTER);


        // listeners
        fileName.setOnAction(e ->
        {
            try
            {
                readFile(fileName.getText().trim());
            }
            catch (IOException exception)
            {
                exception.printStackTrace();
            }
        });

        saveTheChange.setOnAction(e ->
        {
            try
            {
                saveChanges(fileName.getText().trim());
            }
            catch (IOException exception)
            {
                exception.printStackTrace();
            }
        });

        // input restrictions
        editor.textProperty().addListener(
                (observable, oldValue, newValue) ->
                {
                    char[] chars = newValue.toCharArray();

                    for (char x: chars)
                    {
                        if (x != '1' & x != '0')
                        {
                            editor.setText(oldValue);
                            return;
                        }
                    }
                    editor.setText(newValue);
                }
        );
        return pane;
    }

    private void saveChanges(String fileName) throws IOException
    {
        FileOutputStream file = new FileOutputStream(new File(fileName));

        String editorText = editor.getText();

        ArrayList<String> bytes = new ArrayList<>();

        String x = "";
        for (int i = 0; i < editorText.length(); i++)
        {
            if (i % 8 == 0 & i != 0)
            {
                bytes.add(x);
                x = "";
            }
            if (i == editorText.length() - 1)
                bytes.add(x);
            x += editorText.charAt(i);
        }

        System.out.println(bytes.size());

        for (String i : bytes)
            file.write(Integer.parseInt(i, 2));
        file.close();
    }

    private void readFile(String fileName)
            throws IOException
    {
        FileInputStream file = new FileInputStream(new File(fileName));

        byte[] bytes = file.readAllBytes();

        StringBuilder bits = new StringBuilder();

        for (byte x: bytes)
            bits.append(getBits(x));

        editor.setText(bits.toString());
        file.close();
    }

    private String getBits(int value)
    {
        StringBuilder bits = new StringBuilder();

        for (int i = 0; i < 8;i++) // 8 byte, 16 short, 32 integer, 64 long
        {
            bits.insert(0, (value & 1));

            value >>= 1;
        }

        return bits.toString();
    }
}
