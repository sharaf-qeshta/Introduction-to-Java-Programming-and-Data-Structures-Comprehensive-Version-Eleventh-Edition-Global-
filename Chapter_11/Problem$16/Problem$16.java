package chapter_eleven;

import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;
import java.lang.System;

/**
 * **11.16 (Addition quiz) Rewrite Listing 5.1, RepeatAdditionQuiz.java, to alert the user
 * if an answer is entered again. (Hint: use an array list to store answers.) Here is a
 * sample run:
 *
 *          What is 5 + 9? 12
 *          Wrong answer. Try again. What is 5 + 9? 34
 *          Wrong answer. Try again. What is 5 + 9? 12
 *          You already entered 12
 *          Wrong answer. Try again. What is 5 + 9? 14
 *          You got it!
 *
 * @author Sharaf Qeshta
 * */
public class Problem$16
{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in).useLocale(Locale.US);
        ArrayList<Integer> answers = new ArrayList<>();

        int rand1 = (int) (Math.random() * 10);
        int rand2 = (int) (Math.random() * 10);
        String question = "whats is " + rand1 + " + " + rand2 + "? ";
        int answer_ = rand1 + rand2;

        while (true)
        {
            System.out.print(question);
            int answer = scanner.nextInt();

            if (answer == answer_)
            {
                System.out.println("You got it!");
                break;
            }

            if (answers.contains(answer))
                System.out.println("You already entered " + answer);
            else
                answers.add(answer);
            System.out.print("Wrong answer. Try again. ");
        }
    }
}
