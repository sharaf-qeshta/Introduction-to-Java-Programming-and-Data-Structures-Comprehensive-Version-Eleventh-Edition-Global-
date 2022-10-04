package chapter_thirty;

import java.util.Scanner;

/**
 * 30.14 (Occurrences of a specified character) Rewrite Programming Exercise 6.23
 * using streams.
 *
 *
 * @author Sharaf Qeshta
 * */
public class Problem$14
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the word and the specified character: ");
        String word = scanner.next().trim();
        char character = scanner.next().trim().charAt(0);

        long occurrences = word.chars().filter(e -> e == character).count();
        System.out.println("number of " +  character + " in " + word + " is " + occurrences);
    }
}
