package chapter_twenty;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * ***20.7 (Game: hangman) Programming Exercise 7.35 presents a console version of
 * the popular hangman game. Write a GUI program that lets a user play the
 * game. The user guesses a word by entering one letter at a time, as shown in
 * Figure 20.18. If the user misses seven times, a hanging man swings. Once
 * a  word is finished, the user can press the Enter key to continue to guess
 * another word.
 *
 *
 * @author Sharaf Qeshta
 * */
public class Problem$07 extends Application
{
    public static boolean finish = false;

    @Override
    public void start(Stage primaryStage)
    {
        pane.setPrefWidth(300);

        Label guess_a_word = new Label("Guess A word: ");
        HBox container1 = new HBox(5, guess_a_word, asterisks);

        randomWord = words[(int) ((Math.random() * 10) % words.length)];
        progress = createAsterisks(randomWord.length());
        asterisks.setText(progress);

        Text text = new Text("To Continue The Game, Press Enter");
        text.setVisible(false);
        VBox container2 = new VBox(10, container1, text);
        HBox container = new HBox(20, pane, container2);
        container2.setAlignment(Pos.CENTER);
        container.setAlignment(Pos.CENTER);
        container1.setAlignment(Pos.CENTER);

        Scene scene = new Scene(container, 500, 500);
        primaryStage.setTitle("Problem$07");
        primaryStage.setScene(scene);
        primaryStage.show();

        container.setOnKeyPressed(e ->
        {
            if (finish & e.getCode() == KeyCode.ENTER)
            {
                pane.draw();
                finish = false;
                text.setVisible(false);
                container1.getChildren().clear();
                randomWord = words[(int) ((Math.random() * 10) % words.length)];
                progress = createAsterisks(randomWord.length());
                asterisks.setText(progress);
                container1.getChildren().addAll(guess_a_word, asterisks);
            }
            if (progress.equals(randomWord))
            {
                container1.getChildren().clear();
                container1.getChildren().add(new Text("The Word is "  + randomWord));
                text.setVisible(true);
                finish = true;
            }
            else
            {
                if (finish)
                {
                    container1.getChildren().clear();
                    container1.getChildren().add(new Text("The Word is "  + randomWord));
                    text.setVisible(true);
                }
                else
                {
                    progress = check(e.getText().charAt(0), randomWord.toCharArray(), progress);
                    asterisks.setText(progress);
                }
            }
        });
        container.requestFocus();
    }


    public static String[] words = {"write", "that", "programme"};
    private static final Label asterisks = new Label();
    private static final HangmanPane pane = new HangmanPane();
    private static String randomWord;
    private static String progress;

    public String check(char letter, char[] letters, String progress)
    {
        char[] progress_ = progress.toCharArray();
        boolean exist = false;
        for (int i = 0; i < letters.length;i++)
        {
            if (letters[i] == letter)
            {
                if (progress_[i] != '*')
                    return progress;
                progress_[i] = letter;
                exist = true;
            }
        }
        if (!exist)
        {
            pane.next();
            return progress; // wrong guess
        }
        return String.valueOf(progress_); // true guess
    }

    public String createAsterisks(int length)
    {
        char[] out = new char[length];
        for (int i = 0; i < length; i++)
            out[i] = '*';
        return String.valueOf(out);
    }
}
