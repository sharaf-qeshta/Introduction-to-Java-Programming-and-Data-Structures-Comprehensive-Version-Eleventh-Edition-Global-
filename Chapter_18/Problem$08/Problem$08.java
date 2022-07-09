package chapter_eighteen;

/**
 * *18.8 Let f be a function. Let l, r, and e be real numbers. Write a recursive method that
 * computes and returns a value v such that |f(v)| <= e, and l < v < r. That is, a
 * method that finds an approximation of a zero of f between l and r. We assume that
 * f(l)f(r) < 0.
 *
 *
 * @author Sharaf Qeshta
 * */
public class Problem$08
{
    public static void main(String[] args)
    {
        System.out.println(computeZeroOfF(-4, 4, 0)); // -2
    }

    public static int computeZeroOfF(int l, int r, int e)
    {
        if (l == r)
            return 0;
        if (Math.abs(getY(l+1)) <= e)
            return l+1;
        return computeZeroOfF(l+1, r, e);
    }

    public static int getY(int x)
    {
        return 2 * x + 4; // 2x + b
    }
}
