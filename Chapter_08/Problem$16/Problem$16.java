package chapter_eight;

import java.util.Arrays;

/**
 * *8.16 (Sort two-dimensional array) Write a method to sort a two-dimensional array
 * using the following header:
 * public static void sort(int m[][])
 *  The method performs a primary sort on rows, and a secondary sort on columns.
 * For example, the following array
 * {{4, 2},{1, 7},{4, 5},{1, 2},{1, 1},{4, 1}}
 *  will be sorted to
 * {{4, 5},{4, 2},{4, 1},{1, 7},{1, 2},{1, 1}}.
 *
 * @author Sharaf Qeshta
 * */

public class Problem$16
{
    public static void main(String[] args)
    {
        int[][] data = {{4, 2},{1, 7},{4, 5},{1, 2},{1, 1},{4, 1}};

        sort(data);

        /* [[4, 5], [4, 2], [4, 1], [1, 7], [1, 2], [1, 1]] */
        System.out.println(Arrays.deepToString(data));
    }

    public static void sort(int[][] m)
    {
        int[] temp;
        boolean sorted = false;
        while(!sorted)
        {
            sorted = true;
            for (int i = 0; i < m.length - 1; i++)
            {
                if (m[i][0] < m[i + 1][0])
                {
                    temp = m[i];
                    m[i] = m[i + 1];
                    m[i + 1] = temp;
                    sorted = false;
                }
                else if (m[i][0] == m[i + 1][0])
                {
                    for (int j = 0; j < m[i].length; j++)
                    {
                        if (m[i][j] < m[i+1][j])
                        {
                            temp = m[i];
                            m[i] = m[i+1];
                            m[i+1] = temp;
                            sorted = false;
                        }
                    }
                }
            }
        }
    }
}
