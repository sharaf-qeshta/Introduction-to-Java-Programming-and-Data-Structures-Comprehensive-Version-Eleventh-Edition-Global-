package chapter_twenty_two;


/** Listing 22.3 GCD.java */
public class GCD
{
    public static int gcd(int m, int n)
    {
        int gcd = 1;

        if (m % n == 0) return n;

        for (int k = n / 2; k >= 1; k--)
        {
            if (m % k == 0 && n % k == 0)
            {
                gcd = k;
                break;
            }
        }
        return gcd;
    }
}
