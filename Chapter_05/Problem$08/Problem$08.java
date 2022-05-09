package chapter_five;

import java.util.Locale;
import java.util.Scanner;

/**
 * 5.8 (Find the highest score) Write a program that prompts the user to enter the number
 * of students and each student’s name and score, and finally displays the name of
 * the student with the highest score. Use the next() method in the Scanner class
 * to read a name, rather than using the nextLine() method.
 *
 * @author Sharaf Qeshta
 * */

public class Problem$08
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in).useLocale(Locale.US);

        System.out.print("enter the number of students: ");
        int numberOfStudent = scanner.nextInt();

        String maxName = ""; double maxScore = 0;

        for (int i = 0; i < numberOfStudent; i++)
        {
            System.out.print("enter the name of the student: ");
            String name = scanner.next();

            System.out.print("enter  " + name + " scores : ");
            double scores = scanner.nextDouble();

            if (scores > maxScore)
            {
                maxName = name;
                maxScore = scores;
            }
        }

        System.out.println(maxName + " have the highest score : " + maxScore);
    }
}
