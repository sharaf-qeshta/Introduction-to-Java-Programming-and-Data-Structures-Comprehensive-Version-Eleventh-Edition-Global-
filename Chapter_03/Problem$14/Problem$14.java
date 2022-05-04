package chapter_three;

import java.util.Locale;
import java.util.Scanner;

/**
 * 3.14 (Game: heads or tails) Write a program that lets the user guess whether the flip of
 * a coin results in heads or tails. The program randomly generates an integer 0 or 1,
 * which represents head or tail. The program prompts the user to enter a guess, and
 * reports whether the guess is correct or incorrect.
 *
 * @author Sharaf Qeshta
 * */

public class Problem$14
{
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in).useLocale(Locale.US);
        double random = (int) Math.round(Math.random());
        System.out.print("guess head(0) or tail(1): ");
        int guess = scan.nextInt();
        System.out.println((random == guess) ? "Correct!" : "Incorrect!");
    }
}
