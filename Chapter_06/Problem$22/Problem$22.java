package chapter_six;

/**
 * **6.22 (Math: approximate the square root) There are several techniques for
 * implementing the sqrt method in the Math class. One such technique is known as the
 * Babylonian method. It approximates the square root of a number, n, by
 * repeatedly performing the calculation using the following formula:
 * nextGuess = (lastGuess + n / lastGuess) / 2
 * When nextGuess and lastGuess are almost identical, nextGuess is the
 * approximated square root. The initial guess can be any positive value (e.g., 1).
 * This value will be the starting value for lastGuess. If the difference between
 * nextGuess and lastGuess is less than a very small number, such as 0.0001,
 * you can claim that nextGuess is the approximated square root of n. If not,
 * nextGuess becomes lastGuess and the approximation process continues. Implement
 * the following method that returns the square root of n:
 * public static double sqrt(long n)
 *
 * @author Sharaf Qeshta
 * */

public class Problem$22
{
    public static void main(String[] args)
    {
        System.out.println(squareRoot(9)); // 3.0
        System.out.println(squareRoot(10)); // 3.162277660168379
        System.out.println(squareRoot(11)); // 3.3166247903554
        System.out.println(squareRoot(12)); // 3.464101615137755
        System.out.println(squareRoot(13)); // 3.6055512754639905
        System.out.println(squareRoot(16)); // 4.000000000000051
    }

    public static double squareRoot(int n)
    {
        double lastGuess = 1;
        while (true)
        {
            double nextGuess = (lastGuess + n / lastGuess) / 2.0;
            if (Math.abs(lastGuess - nextGuess) < 0.00001)
                return nextGuess;
            else
                lastGuess = nextGuess;
        }
    }
}
