package chapter_three;

import java.util.Random;
import java.util.Scanner;

/**
 * **3.15 (Game: lottery) Revise Listing 3.8, Lottery.java, to generate a lottery of a three-digit
 * number. The program prompts the user to enter a three-digit number and determines
 * whether the user wins according to the following rules:
 * 1. If the user input matches the lottery number in the exact order, the award is
 * $12,000.
 * 2. If all digits in the user input match all digits in the lottery number, the award
 * is $5,000.
 * 3. If one digit in the user input matches a digit in the lottery number, the award
 * is $2,000
 *
 * @author Sharaf Qeshta
 * */

public class Problem$15
{
    public static void main(String[] args)
    {
        Random random = new Random();
        int lotteryNumber = random.nextInt(900) + 100;
        String lotteryString = lotteryNumber + "";
        Scanner scanner = new Scanner(System.in);

        System.out.print("enter your guess : ");
        int guess = scanner.nextInt();
        String guessString = guess + "";

        String output = "0$";

        boolean char1Match = lotteryString.contains(guessString.charAt(0) + "");
        boolean char2Match = lotteryString.contains(guessString.charAt(1) + "");
        boolean char3Match = lotteryString.contains(guessString.charAt(2) + "");

        if (lotteryNumber == guess) // If the user input matches the lottery number in the exact order, the award is $12,000.
            output = "12,000$";
        else if (char1Match && char2Match && char3Match) // If all digits in the user input match all digits in the lottery number, the award $5,000.
            output = "5,000$";
        // logic explained
        // true xor ( false xor false) = true
        // false xor ( true xor false) = true
        // false xor ( false xor true) = true
        else if (char1Match ^ (char3Match ^ char2Match)) // If one digit in the user input matches a digit in the lottery number, the award 2,000$
            output = "2000$";
        System.out.println(lotteryNumber + " " + output);
    }
}
