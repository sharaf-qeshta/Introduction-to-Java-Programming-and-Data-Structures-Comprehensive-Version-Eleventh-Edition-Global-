package chapter_eight;

import java.util.Arrays;

/**
 * *8.18 (Shuffle rows) Write a method that shuffles the rows in a two-dimensional int
 * array using the following header:
 * public static void shuffle(int[][] m)
 *  Write a test program that shuffles the following matrix:
 * int[][] m = {{1, 2}, {3, 4}, {5, 6}, {7, 8}, {9, 10}};
 *
 * @author Sharaf Qeshta
 * */

public class Problem$18
{
    public static void main(String[] args)
    {
        int[][] m = {{1, 2}, {3, 4}, {5, 6}, {7, 8}, {9, 10}};
        shuffle(m);
        /* [[9, 10], [7, 8], [1, 2], [3, 4], [5, 6]] */
        System.out.println(Arrays.deepToString(m));
    }

    public static void shuffle(int[][] m)
    {
        for (int i = 0; i < m.length;i++)
        {
            int randomIndex = (int) ((Math.random() * 10) % m.length);
            while (randomIndex == i)
                randomIndex = (int) ((Math.random() * 10) % m.length);
            int[] temp = m[i];
            m[i] = m[randomIndex];
            m[randomIndex] = temp;
        }
    }
}
