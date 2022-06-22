package chapter_fifteen;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.Locale;
import java.util.Scanner;

/**
 * **15.10 (Enter and display a string) Write a program that receives a string from the
 * keyboard and displays it on a pane. The Enter key signals the end of a string.
 * Whenever a new string is entered, it is displayed on the pane.
 *
 *
 * @author Sharaf Qeshta
 * */
public class Problem$10 extends Application
{
    private static int row = 0;
    private static int column = 1;
    private static final int MAX_WORDS_IN_ROW = 10;

    public static void main(String[] args)
    {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage)
    {
        GridPane pane = new GridPane();
        Scanner scanner = new Scanner(System.in).useLocale(Locale.US);

        Scene scene = new Scene(pane, 500, 500);
        primaryStage.setTitle("Problem$10");
        primaryStage.setScene(scene);
        primaryStage.show();

        pane.setOnKeyPressed(e ->
        {
            if (e.getCode() == KeyCode.INSERT)
            {
                System.out.print("enter a string: ");
                String phrase = scanner.next();
                System.out.println();
                Text text = new Text(phrase + ", ");
                pane.add(text, column, row);
                column++;
                if (column == MAX_WORDS_IN_ROW)
                    row++;
            }
        });

        pane.requestFocus();
    }
}
