package chapter_seven;


import java.util.Locale;
import java.util.Scanner;

/**
 * ***7.35 (Game: hangman) Write a hangman game that randomly generates a word and
 * prompts the user to guess one letter at a time, as presented in the sample run.
 * Each letter in the word is displayed as an asterisk. When the user makes a correct
 * guess, the actual letter is then displayed. When the user finishes a word, display
 * the number of misses and ask the user whether to continue to play with another
 * word. Declare an array to store words, as follows:
 * // Add any words you wish in this array
 * String[] words = {"write", "that",...};
 *
 *          (Guess) Enter a letter in word ******* > p
 *          (Guess) Enter a letter in word p****** > r
 *          (Guess) Enter a letter in word pr**r** > p
 *           p is already in the word
 *          (Guess) Enter a letter in word pr**r** > o
 *          (Guess) Enter a letter in word pro*r** > g
 *          (Guess) Enter a letter in word progr** > n
 *           n is not in the word
 *          (Guess) Enter a letter in word progr** > m
 *          (Guess) Enter a letter in word progr*m > a
 *          The word is program. You missed 1 time
 *          Do you want to guess another word? Enter y or n>
 *
 * @author Sharaf Qeshta
 * */

public class Problem$35
{
    public static final String[] WORDS = {"write", "that", "programme"};

    public static void main(String[] args)
    {
        start();
    }

    public static String check(char letter, char[] letters, String progress){
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

    public static String createAsterisks(int length)
    {
        char[] out = new char[length];
        for (int i = 0; i < length; i++)
            out[i] = '*';
        return String.valueOf(out);
    }


    public static Object start()
    {
        Scanner scanner = new Scanner(System.in).useLocale(Locale.US);
        String randomWord = WORDS[(int) ((Math.random() * (WORDS.length * 2)) % WORDS.length)];
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
            else{
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
}
