package chapter_seven;

import java.util.Locale;
import java.util.Scanner;

/**
 * *7.28 (Math: permutations) Write a program that prompts the user to enter four integers
 * and then displays all possible ways of arranging the four integers.
 *
 * @author Sharaf Qeshta
 * */


public class Problem$28
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in).useLocale(Locale.US);

        System.out.print("Enter four integers: ");
        int[] list = new int[4];

        for (int i = 0; i < 4; i++)
        {
            int input = scanner.nextInt();
            list[i] = input;
        }

        printPermutations(list);
    }

    /**
     * this used only for four numbers in future exercises
     * we will develop a better algorithm
     * */
    public static void printPermutations(int[] array)
    {
        for (int i = 0; i < array.length;i++)
        {
            for (int j = 0; j < array.length;j++)
            {
                for (int k = 0; k < array.length;k++)
                {
                    for (int m = 0; m < array.length;m++)
                    {
                        if (i == j || j == k || k == m
                                || i == k || i == m || j == m) {}
                        else
                        {
                            System.out.print(array[i] + ", ");
                            System.out.print(array[j] + ", ");
                            System.out.print(array[k] + ", ");
                            System.out.print(array[m] + "\n");
                        }
                    }
                }
            }
        }
    }
}
