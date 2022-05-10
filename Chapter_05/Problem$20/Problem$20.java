package chapter_five;

/**
 * *5.20 (Display prime numbers between 2 and 1,200) Modify Listing 5.15 to display all
 * the prime numbers between 2 and 1,200, inclusive. Display eight prime numbers
 * per line. Numbers are separated by exactly one space.
 *
 * @author Sharaf Qeshta
 * */

public class Problem$20
{
    public static void main(String[] args)
    {
        int lineSplitter = 0;
        for (int i = 2; i < 1201; i++)
        {
            boolean isPrime = true;

            for (int j = 2; j < i/2;j++)
            {
                if (i % j == 0)
                {
                    isPrime = false;
                    break;
                }
            }

            if (isPrime)
            {
                System.out.print(i + " ");
                lineSplitter++;
                if (lineSplitter % 8 == 0)
                    System.out.println();
            }
        }
    }
}
