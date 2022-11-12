package chapter_thirty_six;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * *36.1 (Unicode viewer) Develop a GUI application that displays Unicode characters, as
 * shown in Figure 36.13. The user specifies a Unicode in the text field and presses the
 * Enter key to display a sequence of Unicode characters starting with the specified
 * Unicode. The Unicode characters are displayed in a scrollable text area of 20 lines.
 * Each line contains 16 characters preceded by the Unicode that is the code for the
 * first character on the line.
 *
 *
 * @author Sharaf Qeshta
 * */
public class Problem$01 extends Application
{
    @Override
    public void start(Stage stage)
    {
        Label lblSpecifyAUnicode = new Label("Specify a Unicode");
        TextField tfUnicode = new TextField();
        HBox pane1 = new HBox(10, lblSpecifyAUnicode, tfUnicode);
        pane1.setAlignment(Pos.CENTER);
        TextArea taOutput = new TextArea();

        VBox pane = new VBox(10, pane1, taOutput);
        pane.setAlignment(Pos.CENTER);

        Scene scene = new Scene(pane , 350, 250);
        stage.setScene(scene);
        stage.setTitle("Problem$01");
        stage.show();

        tfUnicode.setOnAction(e ->
        {
            taOutput.setText("");
            int currentCharacter = Integer.parseInt(tfUnicode.getText().trim(), 16);
            for (int i = 0; i < 20; i++)
            {
                taOutput.appendText(String.format("%04x", currentCharacter) + " ");
                for (int j = 0; j < 16; j++)
                {
                    char character = (char) currentCharacter;
                    taOutput.appendText(character + " ");
                    currentCharacter++;
                }
                taOutput.appendText("\n");
            }
        });
    }
}
