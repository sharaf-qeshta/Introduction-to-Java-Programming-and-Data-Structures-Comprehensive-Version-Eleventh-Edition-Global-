package chapter_six;

/**
 * *6.14 (Estimate p) p can be computed using the following summation:
 *      m(i) = 4 * [1 - 1/3 + 1/5 - 1/7 + 1/9 - 1/11 + ... + -1^(i+1) / (2i -1)
 *
 * Write a method that returns m(i) for a given i and write a test program that
 * displays the following table:
 *
 *      I       m(i)
 *      1       4.0000
 *      101     3.1515
 *      201     3.1466
 *      301     3.1449
 *      401     3.1441
 *      501     3.1436
 *      601     3.1433
 *      701     3.1430
 *      801     3.1428
 *      901     3.1427
 *
 * @author Sharaf Qeshta
 * */

public class Problem$14
{
    public static void main(String[] args)
    {
        System.out.println("i\t\t\t\t\tm(i)");
        System.out.println("-----------------------------");

        for (int i = 1; i < 902;i+=100)
        {
            String m = String.format("%.4f", m(i));
            System.out.println(i + "\t\t\t\t\t" + m);
        }
    }

    public static double m(int i)
    {
        if (i == 1)
            return 4.0;

        double total = 0.0;
        for (int x = 1; x < i; x++)
        {
            double numerator = Math.pow(-1, x+1);
            double denominator = (2*x) - 1;

            total += numerator / denominator;
        }

        return total*4;
    }
}
