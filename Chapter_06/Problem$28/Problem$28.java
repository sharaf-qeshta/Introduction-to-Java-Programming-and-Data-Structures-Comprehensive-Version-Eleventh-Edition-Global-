package chapter_six;

/**
 * **6.28 (Mersenne prime) A prime number is called a Mersenne prime if it can be written
 * in the form 2 p - 1 for some positive integer p. Write a program that finds all
 * Mersenne primes with p <= 31 and displays the output as follows:
 *
 * p    2^p – 1
 * 2    3
 * 3    7
 * 5    31
 * ...
 *
 * @author Sharaf Qeshta
 * */

public class Problem$28
{
    public static void main(String[] args)
    {
        /*
        * P				2^p - 1
          -----------------------------
          2				3
          3				7
          5				31
          7				127
          13			8191
          17			131071
          19			524287
          31			2147483647
        * */
        System.out.println("P\t\t\t\t2^p - 1");
        System.out.println("-----------------------------");

        for (int p = 2; p < 32; p++)
        {
            int x = (int) (Math.pow(2, p) - 1);

            if (isPrime(x))
                System.out.println(p + "\t\t\t\t" + x);
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
