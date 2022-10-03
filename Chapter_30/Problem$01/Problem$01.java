package chapter_thirty;

import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * 30.1 (Assign grades) Rewrite Programming Exercise 7.1 using streams.
 *
 *
 * @author Sharaf Qeshta
 * */
public class Problem$01
{
    public static int i = 0;

    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of students: ");
        int numberOfStudent = scanner.nextInt();

        System.out.print("Enter " + numberOfStudent + " scores: ");

        int[] scores = new int[numberOfStudent];

        for (int i = 0; i < numberOfStudent; i++)
            scores[i] = scanner.nextInt();

        int max = IntStream.of(scores).max().getAsInt();
        IntStream.of(scores).forEach(e ->
                System.out.println("student " + i++ + " score is " + e
                        + " and grade is " + getChar(e, max)));
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
