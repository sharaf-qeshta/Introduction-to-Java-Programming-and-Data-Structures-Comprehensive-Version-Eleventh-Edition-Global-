package chapter_twenty_two;

/**
 * *22.4 (Computing exponentials) Write a method public static double
 * exp(double x, int n) that computes exp(x, n), which is an approximation
 * of the exponential of x to the order n.
 * exp(x, n) = x0/0! + x1/1! + x2/2! + c + xn/n!
 * Analyze the time complexity of your method. Here is a sample run:
 *
 *          exp(1.0, 0) = 1.0
 *          exp(1.0, 2) = 2.5
 *          exp(1.0, 4) = 2.708333333333333
 *          exp(1.0, 6) = 2.7180555555555554
 *          exp(1.0, 8) = 2.71827876984127
 *          exp(1.0, 10) = 2.7182818011463845
 *
 *
 * @author Sharaf Qeshta
 * */
public class Problem$04
{
    public static void main(String[] args)
    {
        System.out.println("exp(1.0, 0) = " + exp(1, 0));
        System.out.println("exp(1.0, 2) = " + exp(1, 2));
        System.out.println("exp(1.0, 4) = " + exp(1, 4));
        System.out.println("exp(1.0, 6) = " + exp(1, 6));
        System.out.println("exp(1.0, 8) = " + exp(1, 8));
        System.out.println("exp(1.0, 10) = " + exp(1, 10));
    }


    /** Time Complexity O(n²) 'Quadratic Algorithm' */
    public static double exp(double x, int n)
    {
        double exponential = 0;
        for (int i = 0; i < n+1; i++)
            exponential += Math.pow(x, i) / factorial(i);
        return exponential;
    }

    public static int factorial(int i)
    {
        if (i == 0)
            return 1;

        int total = 1;
        for (int j = 1; j < i+1; j++)
            total *= j;
        return total;
    }
}
