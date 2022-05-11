package chapter_five;

/**
 * *5.24 (Sum a series) Write a program to compute the following summation:
 * (1/3) + (3/5) + (5/7) + (7/9) + (9/11) + (11/13) + ... + (95/97) + (97/99)
 *
 * @author Sharaf Qeshta
*/

public class Problem$24
{
    public static void main(String[] args)
    {
        double numerator = 1;
        double denominator = 3;

        double total = 0;
        while (denominator < 100)
        {
            total += numerator/denominator;
            numerator += 2;
            denominator += 2;
        }

        System.out.println("the result of the summation is : " + total);
    }
}
