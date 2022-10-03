package chapter_thirty;

import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * 30.4 (Print distinct numbers) Rewrite Programming Exercise 7.5 using streams.
 * Display the numbers in increasing order
 *
 *
 * @author Sharaf Qeshta
 * */
public class Problem$04
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter ten numbers: ");

        int[] numbers = new int[10];

        long evens = IntStream.of(numbers).map(e -> e = scanner.nextInt())
                .filter(e -> e % 2 == 0).count();

        System.out.println("The number of odd numbers: " + (numbers.length - evens));
        System.out.println("The number of even numbers: " + evens);
    }
}
