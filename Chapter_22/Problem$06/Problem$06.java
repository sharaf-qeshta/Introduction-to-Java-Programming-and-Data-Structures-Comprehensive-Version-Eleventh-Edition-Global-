package chapter_twenty_two;

/**
 * *22.6 (Execution time for GCD) Write a program that obtains the execution time for
 * finding the GCD of every two consecutive Fibonacci numbers from the index
 * 46 to index 50 using the algorithms in Listings 22.3 and 22.4. Your program
 * should print a table like this:
 *
 *                             46       47      48      49      50
 *      Listing 22.3 GCD
 *      Listing 22.4 GCDEuclid
 *
 *
 * @author Sharaf Qeshta
 * */
public class Problem$06
{
    public static void main(String[] args)
    {
        System.out.printf("%30d%8d%10d%10d%10d\n", 46, 47, 48, 49, 50);

        System.out.printf("%-25s", "Listing 22.3 GCD");
        for (int i = 46; i < 51; i++)
            System.out.printf("%-10d", testGCD(i));

        System.out.println();

        System.out.printf("%-25s", "Listing 22.4 GCDEuclid");
        for (int i = 46; i < 51; i++)
            System.out.printf("%-10d", testGCDEuclid(i));
    }


    public static long testGCD(int index)
    {
        long fib = ImprovedFibonacci.fib(index);
        long startTime = System.nanoTime();
        GCD.gcd((int) fib, index);
        long endTime = System.nanoTime();
        return endTime - startTime;
    }

    public static long testGCDEuclid(int index)
    {
        long fib = ImprovedFibonacci.fib(index);
        long startTime = System.nanoTime();
        GCDEuclid.gcd((int) fib, index);
        long endTime = System.nanoTime();
        return endTime - startTime;
    }
}
