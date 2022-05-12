package chapter_five;

/**
 * **5.33 (Perfect number) A positive integer is called a perfect number if it is equal to the
 * sum of all of its positive divisors, excluding itself. For example, 6 is the first perfect
 * number because 6 = 3 + 2 + 1. The next is 28 = 14 + 7 + 4 + 2 + 1. There
 * are four perfect numbers < 10,000. Write a program to find all these four numbers.
 *
 * @author Sharaf Qeshta
 * */

public class Problem$33
{
    public static void main(String[] args)
    {
        int sum = 0;
        for (int i = 2; i < 10001;i++)
        {
            for (int j = 1; j < (i/2)+1;j++)
            {
                if (i % j == 0)
                    sum += j;
            }
            if (sum == i)
                System.out.println("I found one here: " + i);

            sum = 0;
        }
    }
}

