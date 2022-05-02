package chapter_three;

import java.util.Locale;
import java.util.Scanner;


/**
 * 3.2 (Game: multiply three numbers) The program in Listing 3.1, AdditionQuiz.java,
 * generates two integers and prompts the user to enter the product of these two
 * integers. Revise the program to generate three single-digit integers and prompt the user
 * to enter the multiplication of these three integers.
 *
 * @author Sharaf Qeshta
 * */

public class Problem$02
{
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in).useLocale(Locale.US);

        int number1 = (int) (Math.random() * 10),
                number2 = (int) (Math.random() * 10),
                number3 = (int) (Math.random() * 10);

        System.out.print("what is the product of " + number1
                + " " + number2 + " " + number3 + ": ");

        int answer = scan.nextInt();
        int result = number1 * number2 * number3;

        String output = (result ==answer) ? "Correct!" : "Wrong!";
        System.out.println(output);
    }
}
