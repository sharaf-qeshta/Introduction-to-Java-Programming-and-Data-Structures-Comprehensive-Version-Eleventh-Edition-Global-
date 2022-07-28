package chapter_twenty_one;

import java.util.HashSet;
import java.util.Scanner;

/**
 * **21.15 (Addition quiz) Rewrite Programming Exercise 11.16 to store the answers in a set
 * rather than a list.
 *
 *
 * @author Sharaf Qeshta
 * */
public class Problem$15
{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        HashSet<Integer> answers = new HashSet<>();

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
            answers.add(answer);

            System.out.print("Wrong answer. Try again. ");
        }
    }
}
