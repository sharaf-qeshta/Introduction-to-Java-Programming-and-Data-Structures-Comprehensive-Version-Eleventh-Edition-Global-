package chapter_twelve;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

/**
 * ***12.17 (Game: hangman) Rewrite Programming Exercise 7.35. The program reads the
 * words stored in a text file named hangman.txt. Words are delimited by spaces.
 *
 * @author Sharaf Qeshta
 * */
public class Problem$17
{
    public static File file = new File("src/chapter_twelve/hangman.txt");
    public static ArrayList<String> words = getAllLines(file);

    public static void main(String[] args)
    {
        /*
        * sample run:
        * (Guess) Enter a letter in word ***** > w
        * (Guess) Enter a letter in word w**** > q
        * q is not in the word
        * (Guess) Enter a letter in word w**** > r
        * (Guess) Enter a letter in word wr*** > i
        * (Guess) Enter a letter in word wri** > t
        * (Guess) Enter a letter in word writ* > 1
        * 1 is not in the word
        * (Guess) Enter a letter in word writ* > e
        * The word is write You missed 2 time
        * Do you want to guess another word? Enter y or n> n
        * */
        start();
    }

    public static Object start()
    {
        Scanner scanner = new Scanner(System.in).useLocale(Locale.US);
        String randomWord = words.get((int) ((Math.random() * 10) % words.size()));
        String progress = createAsterisks(randomWord.length());
        int mistakes = 0;

        while(true)
        {
            System.out.print("(Guess) Enter a letter in word " + progress + " > ");
            String x = scanner.next();
            char x_ = x.toCharArray()[0];

            String status = check(x_, randomWord.toCharArray(), progress);

            if (status.length() == progress.length())
                progress = status;
            else
            {
                System.out.println(status);
                if (status.contains("is not"))
                    mistakes++;
            }

            if (progress.equals(randomWord))
            {
                System.out.println("The word is "+ randomWord + " You missed " +  mistakes + " time");
                System.out.print("Do you want to guess another word? Enter y or n> ");
                String answer_ = scanner.next();
                char answer = answer_.toCharArray()[0];

                if (answer == 'y')
                    return start();
                else
                    return "finished";
            }
        }
    }

    public static String createAsterisks(int length)
    {
        char[] out = new char[length];
        for (int i = 0; i < length; i++)
            out[i] = '*';
        return String.valueOf(out);
    }

    public static String check(char letter, char[] letters, String progress)
    {
        char[] progress_ = progress.toCharArray();
        boolean exist = false;
        for (int i = 0; i < letters.length;i++)
        {
            if (letters[i] == letter)
            {
                if (progress_[i] != '*')
                    return letter + " is already in the word";
                progress_[i] = letter;
                exist = true;
            }
        }
        if (!exist)
            return letter + " is not in the word";
        return String.valueOf(progress_);
    }


    public static ArrayList<String> getAllLines(File file)
    {
        ArrayList<String> lines = new ArrayList<>();
        try (Scanner scanner = new Scanner(file))
        {
            while (scanner.hasNext())
            {
                String string = scanner.nextLine();
                string = string.trim();
                lines.add(string);
            }
            return lines;

        }
        catch (FileNotFoundException e)
        {
            return lines;
        }
    }
}