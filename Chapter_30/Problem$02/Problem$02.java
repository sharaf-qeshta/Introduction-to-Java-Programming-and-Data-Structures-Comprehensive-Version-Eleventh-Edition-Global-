package chapter_thirty;

import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * 30.2 (Count occurrence of numbers) Rewrite Programming Exercise 7.3 using streams.
 *
 *
 * @author Sharaf Qeshta
 * */
public class Problem$02
{
    public static int i = 1;
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the integers between 1 and 50: ");

        int[] occurrences = new int[50];

        int num =  scanner.nextInt();
        while (num != 0)
        {
            if (num < 51 && num > 0)
                occurrences[num-1] += 1;
            num = scanner.nextInt();
        }

        IntStream.of(occurrences).forEach(e ->
        {
            String output = " time";

            if (e > 1)
                output = " times";

            if (e != 0)
                System.out.println(i + " occurs " + e  + output);
            i++;
        });
    }
}
