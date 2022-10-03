package chapter_thirty;

import java.util.HashSet;
import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * 30.8 (Eliminate duplicates) Rewrite Programming Exercise 7.15 using streams and
 * sort the elements in the new array in increasing order.
 *
 *
 * @author Sharaf Qeshta
 * */
public class Problem$08
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter 10 numbers: ");

        int[] list = new int[10];

        IntStream.of(list).map(e -> e = scanner.nextInt()).collect(HashSet::new,
                HashSet::add, HashSet::add).stream().sorted().forEach(e -> System.out.print(e + " "));
    }
}
