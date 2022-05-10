package chapter_five;

/**
 * 5.11 (Find numbers divisible by 3 or 4, but not both) Write a program that displays all
 * the numbers from 100 to 200, ten per line, that are divisible by 3 or 4, but not both.
 * Numbers are separated by exactly one space.
 *
 * @author Sharaf Qeshta
 * */

public class Problem$11
{
    public static void main(String[] args)
    {
        int counter = 0;
        for (int i = 100; i < 201; i++)
        {
            if ( i % 4 == 0 ^ i % 3 == 0)
            {
                System.out.print(i + " ");
                counter++;
                if (counter % 10 == 0)
                    System.out.println();
            }
        }
    }
}
