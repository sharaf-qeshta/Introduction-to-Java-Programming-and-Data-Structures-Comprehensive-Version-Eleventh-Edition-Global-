package chapter_nine;

import java.util.Random;

/**
 * *9.4 (Use the Random class) Write a program that creates a Random object with seed
 * 1000 and displays the first 50 random integers between 0 and 100 using the
 * nextInt(100) method.
 *
 * @author Sharaf Qeshta
 * */

public class Problem$04
{
    public static void main(String[] args)
    {
        Random random = new Random();
        random.setSeed(1000);

        for (int i = 0; i < 50;i++)
            System.out.print(random.nextInt(100) + " ");
    }
}
