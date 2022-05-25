package chapter_eight;

import java.util.Scanner;

/**
 * **8.11 (Game: nine heads and tails) Nine coins are placed in a 3-by-3 matrix with some
 * face up and some face down. You can represent the state of the coins using a
 * 3-by-3 matrix with values 0 (heads) and 1 (tails). Here are some examples:
 *
 *      0 0 0   1 0 1   1 1 0   1 0 1   1 0 0
 *      0 1 0   0 0 1   1 0 0   1 1 0   1 1 1
 *      0 0 0   1 0 0   0 0 1   1 0 0   1 1 0
 *  Each state can also be represented using a binary number. For example, the
 *  preceding matrices correspond to the numbers
 * 000010000 101001100 110100001 101110100 100111110
 *  There are a total of 512 possibilities, so you can use decimal numbers 0, 1, 2,
 * 3, . . . , and 511 to represent all states of the matrix. Write a program that prompts
 * the user to enter a number between 0 and 511 and displays the corresponding
 * matrix with the characters H and T. Here is a sample run:
 *
 *          Enter a number between 0 and 511: 7
 *          H H H
 *          H H H
 *          T T T
 *
 * The user entered 7, which corresponds to 000000111. Since 0 stands for H and
 * 1 for T, the output is correct.
 *
 * @author Sharaf Qeshta
 * */

public class Problem$11
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a number between 0 and 511: ");
        int input = scanner.nextInt();
        int[] result = getBinary(input);

        int lineCounter = 0;
        for (int j : result)
        {
            if (j == 0)
                System.out.print("H ");
            else
                System.out.print("T ");
            lineCounter++;
            if (lineCounter == 3)
            {
                System.out.println();
                lineCounter = 0;
            }
        }
    }

    public static int[] getBinary(int num)
    {
        int[] binary = new int[9];
        int id = 0;

        while (num > 0)
        {
            binary[id++] = num % 2;
            num /= 2;
        }
        reverse(binary);
        return binary;
    }

    public static void reverse(int[] list)
    {
        int last = list.length-1;
        for (int i = 0; i < list.length/2;i++, last--)
        {
            int temp = list[i];
            list[i] = list[last];
            list[last] = temp;
        }
    }

}
