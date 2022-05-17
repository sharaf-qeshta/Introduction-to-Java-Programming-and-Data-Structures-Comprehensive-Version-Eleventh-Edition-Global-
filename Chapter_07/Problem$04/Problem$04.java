package chapter_seven;

import java.util.Locale;
import java.util.Scanner;

/**
 * 7.4 (Analyze scores) Write a program that reads an unspecified number of scores and
 * determines how many scores are above or equal to the average, and how many
 * scores are below the average. Enter a negative number to signify the end of the
 * input. Assume the maximum number of scores is 100.
 *
 * @author Sharaf Qeshta
 * */

public class Problem$04
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in).useLocale(Locale.US);

        System.out.print("Enter the the scores: ");

        int[] scores = new int[100];
        int score = 1;

        for (int i = 0; i < 100 & score > 0; i++)
        {
            score = scanner.nextInt();
            if (score < 101 & score > 0)
                scores[i] = score;
        }

        double sum = 0;
        int count = 0;
        for (int i = 0; i < 100;i++)
        {
            if (scores[i] != 0)
            {
                sum += scores[i];count++;
            }
        }

        double average = sum/count;

        int aboveAverage = 0, belowAverage = 0, equalAverage = 0;
        for (int i = 0; i < 100; i++)
        {
            if (scores[i] != 0)
            {
                if (scores[i] > average)
                    aboveAverage++;
                else if (scores[i] < average)
                    belowAverage++;
                else
                    equalAverage++;
            }
        }

        System.out.println("there are " + aboveAverage + " scores above the average!");
        System.out.println("there are " + equalAverage + " scores equals the average!");
        System.out.println("there are " + belowAverage + " scores below the average!");
    }

}
