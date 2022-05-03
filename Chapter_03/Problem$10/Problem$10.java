package chapter_three;

import java.util.Locale;
import java.util.Scanner;

/**
 * 3.10 (Game: multiplication quiz) Listing 3.3, SubtractionQuiz.java, randomly generates
 * a subtraction question. Revise the program to randomly generate a multiplication
 * question with two integers less than 1000.
 *
 * @author Sharaf Qeshta
 * */

public class Problem$10
{
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in).useLocale(Locale.US);

        int number1 = (int) (Math.random() * ((999 - 1) + 1)) + 1,
            number2 = (int) (Math.random() * ((999 - 1) + 1)) + 1;

        System.out.print(number1 + " * " + number2 + " = ");
        int answer = scan.nextInt();

        System.out.println((number1 * number2 == answer) ? "Correct!" : "Wrong!");
    }
}
