package chapter_five;

import java.util.Locale;
import java.util.Scanner;

/**
 * 5.2 (Repeat multiplications) Listing 5.4, SubtractionQuizLoop.java, generates five random
 * subtraction questions. Revise the program to generate ten random multiplication
 * questions for two integers between 1 and 12. Display the correct count and test time.
 *
 * @author Sharaf Qeshta
 * */

public class Problem$02
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in).useLocale(Locale.US);

        int correctAnswers = 0;
        long startTime = System.currentTimeMillis();

        for (int i = 0; i < 10; i++)
        {
            int x = (int) ((Math.random() * 100 % 12) + 1);
            int y = (int) ((Math.random() * 100 % 12) + 1);

            int multiplication = x * y;
            System.out.print(x + " * " + y + " = ");
            int answer = scanner.nextInt();

            if (answer == multiplication)
            {
                correctAnswers++;
                System.out.println("right!!");
            }
            else
                System.out.println("wrong!! the right answer is : " + answer);

            System.out.println();
        }
        long endTime = System.currentTimeMillis();

        long estimatedTime = endTime - startTime;

        int seconds = (int) (estimatedTime / 1000);
        int minutes = seconds / 60;
        seconds = seconds % 60;

        System.out.println("you got " + correctAnswers + " out of 10");
        System.out.println("you end the quiz with : " + minutes + ":" + seconds + " minutes");
    }
}
