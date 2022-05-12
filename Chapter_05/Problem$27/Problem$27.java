package chapter_five;

/**
 * **5.27 (Display leap years) Write a program that displays all the leap years, ten per line,
 * from 2014 to 2114, separated by exactly one space. Also display the number of
 * leap years in this period.
 *
 * @author Sharaf Qeshta
 * */

public class Problem$27
{
    public static void main(String[] args)
    {
        int counter = 0;

        for (int i = 2014; i < 2115;i++)
        {
            if ((i % 4 == 0 && i % 100 != 0) || i % 400 == 0)
            {
                System.out.print(i + ", ");
                if (++counter % 10 == 0)
                    System.out.println();
            }
        }
        System.out.println("\nThe Number of Leap Years in Period (2014-2115): " + counter + " years");
    }
}

