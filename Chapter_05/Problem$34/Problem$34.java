package chapter_five;

import java.util.Scanner;

/**
 * ***5.34 (Game: scissor, rock, paper) Programming Exercise 3.17 gives a program that plays
 * the scissor-rock-paper game. Revise the program to let the user continuously play
 * until either the user or the computer wins three times more than their opponent.
 *
 * @author Sharaf Qeshta
 * */

public class Problem$34
{
    public static String judge(int pc, int user)
    {
        if (pc + 2 == user)
            return "Computer Won!";
        else if (user + 2 == pc)
            return "You Won!";
        else if (pc > user)
            return "Computer Won!";
        else if (pc < user)
            return "You Won!";
        else
            return "It is a draw";
    }

    public static String converter(int SRP)
    {
        return switch (SRP)
        {
            case 0 -> "Scissor";
            case 1 -> "Rock";
            case 2 -> "Paper";
            default -> "None";
        };
    }

    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        int computerWins = 0;
        int playerWins = 0;

        while (Math.abs(computerWins - playerWins) < 3)
        {
            int SRP = (int) Math.round(Math.random() * (2));
            System.out.print("scissor (0), rock (1), paper (2): ");
            int userSRP = scanner.nextInt();

            System.out.print("The Computer is " + converter(SRP) + ". ");
            if (SRP == userSRP)
                System.out.print("You are " + converter(userSRP) + " too. ");
            else
                System.out.print("you are " + converter(userSRP) + ". ");

            String output = judge(SRP, userSRP);
            System.out.print(output);
            if (output.equals("You Won!"))
                playerWins++;
            else if (output.equals("Computer Won!"))
                computerWins++;
            System.out.println("\nComputer: " + computerWins + ", Player: " + playerWins);
        }

        if (computerWins < playerWins)
            System.out.println("You Won!");
        else
            System.out.println("Computer Won!");
    }
}

