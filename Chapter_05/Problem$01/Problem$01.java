package chapter_five;

import java.util.Locale;
import java.util.Scanner;

/**
 * *5.1 (Pass or fail) Write a program that prompts a student to enter a Java score. If the
 * score is greater or equal to 60, display “you pass the exam”; otherwise, display “you
 * don’t pass the exam”. Your program ends with input -1. Here is a sample run:
 *
 *      Enter your score: 80
 *      You pass the exam.
 *
 *      Enter your score: 59
 *      You don't pass the exam.
 *
 *      Enter your score: −1
 *      No numbers are entered except 0
 *
 *
 * @author Sharaf Qeshta
 * */

public class Problem$01
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in).useLocale(Locale.US);

        System.out.print("Enter your score: ");
        int score = scanner.nextInt();

        while (score != -1)
        {
            if (score > 59)
                System.out.println("You pass the exam.");
            else
                System.out.println("You don't pass the exam.");

            System.out.print("\nEnter your score: ");
            score = scanner.nextInt();
        }

        System.out.println("No numbers are entered except 0");
    }
}
