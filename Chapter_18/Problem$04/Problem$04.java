package chapter_eighteen;

/**
 * 18.4 Combinations refer to the combination of n things taken p at a time without
 * repetition. A recursive definition of C(n, p) is C(n, 0) = C(n, n) = 1, otherwise
 * C(n, p) = C(n-1, p) + C(n-1, p-1).
 * Write a method public static long C(long n, long p) that computes
 * and returns C(n, p).
 *
 *
 * @author Sharaf Qeshta
 * */
public class Problem$04
{
    public static void main(String[] args)
    {
        System.out.println(C(4, 2));  // 6
        System.out.println(C(5, 3));  // 10
        System.out.println(C(6, 4));  // 15
        System.out.println(C(7, 2));  // 21
    }


    public static long C(long n, long p)
    {
        if (n == p || p == 0)
            return 1;
        return C(n-1, p) + C(n-1, p-1);
    }
}
