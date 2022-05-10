package chapter_five;

import java.util.Locale;
import java.util.Scanner;

/**
 * *5.9 (Find the two lowest scores) Write a program that prompts the user to enter the number
 * of students and each student’s name and score, and finally displays the names of the
 * students with the lowest and second-lowest scores.
 *
 * @author Sharaf Qeshta
 * */

public class Problem$09
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in).useLocale(Locale.US);

        System.out.print("enter the number of students: ");
        int numberOfStudent = scanner.nextInt();

        String lowestName1 = ""; double lowestScore1 = 1000;
        String lowestName2 = ""; double lowestScore2 = 1000;

        for (int i = 0; i < numberOfStudent; i++)
        {
            System.out.print("enter the name of the student: ");
            String name = scanner.next();

            System.out.print("enter  " + name + " scores : ");
            double scores = scanner.nextDouble();

            if (i == 0)
            {
                lowestName1 = name;
                lowestScore1 = scores;
                lowestScore2 = scores;
                lowestName2 = name;
            }

            if (scores < lowestScore2)
            {
                if (scores < lowestScore1)
                {
                    double temp = lowestScore1;
                    String temp2 = lowestName1;
                    lowestScore1 = scores;
                    lowestName1 = name;
                    lowestScore2 = temp;
                    lowestName2 = temp2;
                }
                else
                {
                    lowestName2 = name;
                    lowestScore2 = scores;
                }
            }
        }

        System.out.println(lowestName1 + " have the lowest score : " + lowestScore1);
        System.out.println(lowestName2 + " have the second lowest score : " + lowestScore2);
    }
}
