package chapter_five;

/**
 * *5.15 (Display the ASCII character table) Write a program that prints the characters in
 * the ASCII character table from ! to ~. Display 10 characters per line. The ASCII
 * table is given in Appendix B. Characters are separated by exactly one space.
 *
 * @author Sharaf Qeshta
 * */

public class Problem$15
{
    public static void main(String[] args)
    {
        int counter = 0;
        for (int i = '!'; i < '~'+1; i++)
        {
            if (counter % 10 == 0)
                System.out.println();

            System.out.print((char) i+ " ");
            counter++;
        }
    }
}
