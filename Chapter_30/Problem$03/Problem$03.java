package chapter_thirty;

import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * 30.3 (Analyze scores) Rewrite Programming Exercise 7.4 using streams.
 *
 *
 * @author Sharaf Qeshta
 * */
public class Problem$03
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the the scores: ");

        int[] scores = new int[100];
        int score = 1;

        for (int i = 0; i < 100 & score > 0; i++)
        {
            score = scanner.nextInt();
            if (score < 101 & score > 0)
                scores[i] = score;
        }

        scores = IntStream.of(scores).filter(e -> e != 0).toArray();

        double average = IntStream.of(scores).average().getAsDouble();

        System.out.println("there are " + IntStream.of(scores).filter(e -> e > average).count()
                + " scores above the average!");
        System.out.println("there are " + IntStream.of(scores).filter(e -> e == average).count()
                + " scores equals the average!");
        System.out.println("there are " + IntStream.of(scores).filter(e -> e < average).count()
                + " scores below the average!");
    }
}
