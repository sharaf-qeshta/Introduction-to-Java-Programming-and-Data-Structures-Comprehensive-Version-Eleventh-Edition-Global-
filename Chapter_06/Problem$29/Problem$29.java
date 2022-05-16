package chapter_six;

/**
 * **6.29 (Twin primes) Twin primes are a pair of prime numbers that differ by 2. For
 * example, 3 and 5 are twin primes, 5 and 7 are twin primes, and 11 and 13 are
 * twin primes. Write a program to find all twin primes less than 1,200. Display the
 * output as follows:
 * (3, 5)
 * (5, 7)
 * ...
 *
 * @author Sharaf Qeshta
 * */

public class Problem$29
{
    public static void main(String[] args)
    {
        /*
        * (3, 5)
        * (5, 7)
        * (11, 13)
        * (17, 19)
        * (29, 31)
        * (41, 43)
        * (59, 61)
        * (71, 73)
        * (101, 103)
        * (107, 109)
        * (137, 139)
        ....
        * (1019, 1021)
        * (1031, 1033)
        * (1049, 1051)
        * (1061, 1063)
        * (1091, 1093)
        * (1151, 1153)
        * */
        for (int i = 2; i < 1200; i++)
        {
            if (isPrime(i+2) && isPrime(i))
                System.out.println("(" + i + ", " + (i + 2) + ")");
        }
    }

    public static boolean isPrime(int n)
    {
        for (int i = 2; i < (n/2)+1; i++)
        {
            if (n % i == 0)
                return false;
        }
        return true;
    }

}
