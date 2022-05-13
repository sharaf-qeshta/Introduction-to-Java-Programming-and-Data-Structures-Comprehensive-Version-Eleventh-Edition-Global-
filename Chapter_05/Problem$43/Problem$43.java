package chapter_five;

/**
 * *5.43 (Math: combinations) Write a program that displays all possible combinations
 * for picking two numbers from integers 1 to 7. Also display the total number of
 * all combinations.
 *
 *          1 2
 *          1 3
 *          ...
 *          ...
 *          The total number of all combinations is 21
 * */

public class Problem$43
{
    public static void main(String[] args)
    {
        int count = 0;
        for (int i = 1; i < 7; i++)
        {
            for (int j = i+1; j < 8; j++)
            {
                if (i == j)
                    continue;
                System.out.println(i + " " + j);
                count++;
            }
        }
        System.out.println("The total number of all combinations is " + count);
    }
}

