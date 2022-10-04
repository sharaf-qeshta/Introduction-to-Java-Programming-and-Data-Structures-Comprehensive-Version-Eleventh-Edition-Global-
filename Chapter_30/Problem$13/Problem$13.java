package chapter_thirty;

import java.util.Scanner;

/**
 * 30.13 (Count the letters in a string) Rewrite Programming Exercise 6.20 using streams.
 *
 *
 * @author Sharaf Qeshta
 * */
public class Problem$13
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        System.out.print("enter a string: ");
        long count = scanner.nextLine().chars().filter(Character::isLetter).count();

        System.out.println("The number of letters : " + count);
    }
}
