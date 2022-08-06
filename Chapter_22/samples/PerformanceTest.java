package chapter_twenty_two.samples;

/** Listing 22.1 PerformanceTest.java */
public class PerformanceTest
{
    public static void main(String[] args)
    {
        getTime(1000000);
        getTime(10000000);
        getTime(100000000);
        getTime(1000000000);
    }


    public static void getTime(long n)
    {
        long startTime = System.currentTimeMillis();
        long k = 0;

        for (long i = 1; i <= n; i++)
            k = k + 5;

        long endTime = System.currentTimeMillis();

        System.out.println("Execution time for n = " + n
                + " is " + (endTime - startTime) + " milliseconds");
    }
}
