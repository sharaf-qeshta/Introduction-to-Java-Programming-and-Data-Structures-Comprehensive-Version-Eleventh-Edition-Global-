package chapter_five;

/**
 * **5.19 (Display numbers in a pyramid pattern) Write a nested for loop that prints the
 * following output:
 *                          1
 *                    1     3    1
 *                  1   3   9   3   1
 *              1   3   9   27  9   3   1
 *          1   3   9   27  81  27  9   3   1
 *      1   3   9   27  81  243 81  27  9   3   1
 *  1   3   9   27  81  243 729 243 81  27  9   3   1
 *1 3   9   27  81  243 729 2187 729 243 81  27  9   3   1
 *
 *
 * @author Sharaf Qeshta
 *
 *  */

public class Problem$19
{
    public static void main(String[] args)
    {
        int start = 8, end = 8;

        for (int i = 0; i < 8; i++)
        {
            int out = 1;
            for (int j = 1; j < 16;j++)
            {
                if (j >= start & j <= end)
                {
                    System.out.print(out + "\t");
                    if (j >= 8)
                        out /=3;
                    else
                        out *=3;
                }
                else
                    System.out.print("\t");
            }
            start--;end++;
            System.out.println();
        }
    }
}
