package chapter_seven;

import java.util.Scanner;

/**
 * ***7.37 (Game: bean machine) The bean machine, also known as a quincunx or the
 * Galton box, is a device for statistics experiments named after English scientist Sir
 * Francis Galton. It consists of an upright board with evenly spaced nails (or pegs)
 * in a triangular form, as shown in Figure 7.13
 * Balls are dropped from the opening of the board. Every time a ball hits a nail, it
 * has a 50% chance of falling to the left or to the right. The piles of balls are
 * accumulated in the slots at the bottom of the board.
 * Write a program that simulates the bean machine. Your program should prompt the
 * user to enter the number of the balls and the number of the slots in the machine.
 * Simulate the falling of each ball by printing its path. For example, the path for
 * the ball in Figure 7.13b is LLRRLLR and the path for the ball in Figure 7.13c is
 * RLRRLRR. Display the final buildup of the balls in the slots in a histogram. Here
 * is a sample run of the program:
 * (Hint: Create an array named slots. Each element in slots stores the number
 * of balls in a slot. Each ball falls into a slot via a path. The number of Rs in a path
 * is the position of the slot where the ball falls. For example, for the path LRLRLRR,
 * the ball falls into slots[4], and for the path RRLLLLL, the ball falls into
 * slots[2].)
 *
 *
 *          Enter the number of balls to drop: 5
 *          Enter the number of slots in the bean machine: 8
 *
 *          LRLRLRR
 *          RRLLLRR
 *          LLRLLRR
 *          RRLLLLL
 *          LRLRRLR
 *
 *                O
 *                O
 *              OOO
 *
 * @author Sharaf Qeshta
 * */

public class Problem$37
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of balls to drop: ");
        int ballsNumber = scanner.nextInt();

        System.out.print("Enter the number of slots in the bean machine: ");
        int slotsNumber = scanner.nextInt();

        createMachine(ballsNumber, slotsNumber);
    }

    public static void createMachine(int balls, int slotsNumber)
    {
        int[] slots =  new int[slotsNumber];

        StringBuilder ballPath;
        int numberOfRs;

        for (int i = 0; i < balls;i++)
        {
            ballPath = new StringBuilder();
            numberOfRs = 0;
            for (int j = 0; j < 7;j++) // 7 paths
            {
                int step = (int) ((Math.random() * 10) % 2); // 0 right 1 left

                if (step == 0)
                {
                    ballPath.append("R");
                    numberOfRs++;
                }
                else
                    ballPath.append("L");
            }
            System.out.println(ballPath);
            slots[numberOfRs]++;
        }

        // printing the result
        System.out.println();
        for (int i = 0; i < slotsNumber; i++)
        {
            for (int j = 0; j < slotsNumber; j++)
            {
                if (slots[j] > 0)
                {
                    System.out.print("O");
                    slots[j] -= 1;
                }
                else
                    System.out.print(" ");

            }
            System.out.println();
        }
    }
}
