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
import java.util.Arrays;


/**
 * **17.21 (Hex editor) Write a GUI application that lets the user to enter a file name in the
 * text field and press the Enter key to display its hex representation in a text area.
 * The user can also modify the hex code and save it back to the file, as shown in
 * Figure 17.23b.
 *
 *
 * @author Sharaf Qeshta
 * */
public class Problem$21 extends Application
{
    private final TextArea editor = new TextArea();
    private final ArrayList<Character> validCharacters =  new ArrayList<>(Arrays.asList(
            '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'a', 'B', 'b', 'C', 'c',
            'D', 'd', 'E', 'e', 'F', 'f'
    ));

    @Override
    public void start(Stage primaryStage)
    {
        Scene scene = new Scene(getUI(), 600, 500);
        primaryStage.setTitle("Problem$21");
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
                        if (!validCharacters.contains(x))
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
            if (i % 2 == 0 & i != 0)
            {
                bytes.add(x);
                x = "";
            }
            x += editorText.charAt(i);
        }

        BitOutputStream bitOutputStream = new BitOutputStream(new File(fileName));
        for (String i : bytes)
            bitOutputStream.writeBit(getBits(getDecimal(i)));
        file.close();
    }

    private void readFile(String fileName)
            throws IOException
    {
        FileInputStream file = new FileInputStream(new File(fileName));

        byte[] bytes = file.readAllBytes();

        StringBuilder bits = new StringBuilder();

        for (byte x: bytes)
            bits.append(Integer.toHexString(x));


        editor.setText(bits.toString());
        file.close();
    }

    public static int getDecimal(String hex)
    {
        String digits = "0123456789ABCDEF";
        hex = hex.toUpperCase();
        int val = 0;
        for (int i = 0; i < hex.length(); i++)
        {
            char c = hex.charAt(i);
            int d = digits.indexOf(c);
            val = 16 * val + d;
        }
        return val;
    }

    private String getBits(int value)
    {
        StringBuilder bits = new StringBuilder();

        for (int i = 0; i < 8; i++) // 8 byte, 16 short, 32 integer, 64 long
        {
            bits.insert(0, (value & 1));

            value >>= 1;
        }

        return bits.toString();
    }
}
