package chapter_seven;

import java.util.Locale;
import java.util.Scanner;

/**
 * *7.1 (Assign grades) Write a program that reads student scores, gets the best score, and
 * then assigns grades based on the following scheme:
 * Grade is A if score is >= best -5
 * Grade is B if score is >= best -10;
 * Grade is C if score is >= best -15;
 * Grade is D if score is >= best -20;
 * Grade is F otherwise.
 * The program prompts the user to enter the total number of students, and then
 * prompts the user to enter all of the scores, and concludes by displaying the grades.
 * Here is a sample run:
 *
 *          Enter the number of students: 4
 *          Enter 4 scores: 40 55 70 58
 *          Student 0 score is 40 and grade is F
 *          Student 1 score is 55 and grade is C
 *          Student 2 score is 70 and grade is A
 *          Student 3 score is 58 and grade is C
 *
 * @author Sharaf Qeshta
 * */

public class Problem$01
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in).useLocale(Locale.US);

        System.out.print("Enter the number of students: ");
        int nS = scanner.nextInt();

        System.out.print("Enter " + nS + " scores: ");

        int[] scores = new int[nS];

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nS; i++)
        {
            int score = scanner.nextInt();
            scores[i] = score;
            if (score > max)
                max = score;
        }

        for (int i = 0; i < nS; i++)
            System.out.println("student " +i+ " score is " + scores[i] + " and grade is " + getChar(scores[i], max));
    }

    public static char getChar(int score, int max)
    {
        if (score >= max-5)
            return 'A';
        else if (score >= max-10)
            return 'B';
        else if (score >= max-15)
            return 'C';
        else if (score >= max-20)
            return 'D';
        else
            return 'F';
    }
}
