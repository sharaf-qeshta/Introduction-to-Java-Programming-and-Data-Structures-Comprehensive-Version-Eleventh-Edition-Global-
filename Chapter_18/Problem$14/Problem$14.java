package chapter_eighteen;

/**
 * *18.14 Assume that you are not able to perform other operations on an int value than
 * to decrement it and compare it with zero and one. Write two methods odd(int x)
 * and even(int x) that respectively return if x is odd or even. We assume that
 * x >= 0.
 *
 *
 * @author Sharaf Qeshta
 * */
public class Problem$14
{
    public static void main(String[] args)
    {
        System.out.println(odd(10)); // false
        System.out.println(even(10)); // true

        System.out.println(odd(123)); // true
        System.out.println(even(123)); // false

        System.out.println(odd(14_446)); // false
        System.out.println(even(14_446)); // true
    }


    public static boolean odd(int x)
    {
        if (x == 0)
            return false;
        if (x == 1)
            return true;
        return odd(x-2);
    }

    public static boolean even(int x)
    {
        if (x == 0)
            return true;
        if (x == 1)
            return false;
        return even(x-2);
    }
}
