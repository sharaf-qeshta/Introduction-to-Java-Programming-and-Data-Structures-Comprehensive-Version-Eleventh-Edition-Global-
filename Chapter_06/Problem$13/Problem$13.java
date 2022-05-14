package chapter_six;

/**
 * *6.13 (Sum series) Write a method to compute the following series:
 *      m(i) = 1/3 + 2/4 + ... + i/(i+2)
 *
 *      Write a test program that displays the following table:
 *
 *      I       m(i)
 *      1       0.3333
 *      2       0.8333
 *      ...
 *      19      14.7093
 *      20      15.6184
 *
 * @author Sharaf Qeshta
 * */

public class Problem$13
{
    public static void main(String[] args)
    {
        printTable(20);
    }

    public static void printTable(int i)
    {
        System.out.println("I" + "\t\t\t\t" + "m(i)" );
        System.out.println("--------------------------------");
        double amount;
        for (int k = 1; k < i+1; k++)
        {
            amount= 0;
            for (int j = k; j > 0;j--)
                amount += j/(j+2.0);

            System.out.println(k + "\t\t\t\t" + amount);
        }
    }
}
