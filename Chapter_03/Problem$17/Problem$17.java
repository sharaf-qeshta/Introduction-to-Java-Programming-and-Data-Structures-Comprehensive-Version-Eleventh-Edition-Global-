package chapter_three;

import java.util.Scanner;

/**
 * *3.17 (Game: scissor, rock, paper) Write a program that plays the popular scissor–rock–
 * paper game. (A scissor can cut a paper, a rock can knock a scissor, and a paper can
 * wrap a rock.) The program randomly generates a number 0, 1, or 2 representing
 * scissor, rock, and paper. The program prompts the user to enter a number 0, 1, or
 * 2 and displays a message indicating whether the user or the computer wins, loses,
 * or draws. Here are sample runs:
 *
 *          scissor (0), rock (1), paper (2): 1
 *          The computer is scissor. You are rock. You won
 *
 *          scissor (0), rock (1), paper (2): 2
 *          The computer is paper. You are paper too. It is a draw
 *
 * @author Sharaf Qeshta
 * */

public class Problem$17
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
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int SRP = (int) ((Math.random() * 10 ) % 3);
        System.out.print("scissor (0), rock (1), paper (2): ");
        int userSRP = scanner.nextInt();

        System.out.print("The Computer is " +converter(SRP) + ". ");
        if (SRP == userSRP)
            System.out.print("You are " + converter(userSRP) + " too. ");
        else
            System.out.print("you are " + converter(userSRP) + ". ");

        System.out.print(judge(SRP, userSRP));
    }
}
