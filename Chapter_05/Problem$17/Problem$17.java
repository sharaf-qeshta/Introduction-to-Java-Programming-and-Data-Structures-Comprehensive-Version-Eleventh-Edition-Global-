package chapter_five;

import java.util.Locale;
import java.util.Scanner;

/**
 * **5.17 (Display pyramid) Write a program that prompts the user to enter an integer from
 * 1 to 15 and displays a pyramid, as shown in the following sample run:
 *
 *          Enter the number of lines: 7
 *          7 6 5 4 3 2 1 2 3 4 5 6 7
 *          6 5 4 3 2 1 2 3 4 5 6
 *          5 4 3 2 1 2 3 4 5
 *          4 3 2 1 2 3 4
 *          3 2 1 2 3
 *          2 1 2
 *          1
 * @author Sharaf Qeshta
 * */

public class Problem$17
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in).useLocale(Locale.US);

        System.out.print("Enter the number of lines: ");
        int lines = scanner.nextInt();

        for (int i = lines; i > 0; i--)
        {
            for (int j = i; j > 0;j--)
            {
                if (j == 1)
                {
                    for (int k = 1; k < i+1; k++)
                        System.out.print(k + " ");
                }
                else
                    System.out.print(j + " ");
            }
            System.out.println();
        }
    }
}
