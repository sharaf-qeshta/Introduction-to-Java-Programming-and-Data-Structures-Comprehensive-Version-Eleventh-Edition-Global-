package chapter_six;

/**
 * *6.6 (Display patterns) Write a method to display a pattern as follows:
 * 1
 * 1 2
 * 1 2 3
 * ...
 * n n−1 ... 3 2 1
 * The method header is
 * public static void displayPattern(int n)
 *
 * @author Sharaf Qeshta
 * */

public class Problem$06
{
    public static void main(String[] args)
    {
        displayPattern(50);
    }

    public static void displayPattern(int n)
    {
        for (int i = 1; i < n+1;i++)
        {
            for (int j = 1; j < i+1;j++)
                System.out.print(j + " ");
            System.out.println();
        }
    }

}
