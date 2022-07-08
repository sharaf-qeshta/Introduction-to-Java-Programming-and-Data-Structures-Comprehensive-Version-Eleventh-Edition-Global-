package chapter_eighteen;


/**
 * 18.5 The previous method is probably not efficient if you wrote it exactly as its
 * recursive definition. It is not because the method is recursive but because it has not
 * been well-written. It is quite easy to verify that there is another recurrent definition
 * of C(n, p), which is C(n, 0) = C(n, n) = 1, otherwise C(n, p) = C(n, p-1) *
 * (n-p +1)/p. Keeping this in mind, write the previous method.
 *
 *
 * @author Sharaf Qeshta
 * */
public class Problem$05
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
        return C(n, p - 1) * (n-p+1)/p;
    }
}
