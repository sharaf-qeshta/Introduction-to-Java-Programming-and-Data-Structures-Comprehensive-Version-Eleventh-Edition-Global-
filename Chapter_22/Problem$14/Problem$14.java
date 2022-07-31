package chapter_twenty_two;

/**
 * *22.14 (Execution time for prime numbers) Write a program that obtains the execution
 * time for finding all the prime numbers less than 9,000,000, 11,000,000,
 * 13,000,000, 15,000,000, 17,000,000, and 19,000,000 using the algorithms in
 * Listings 22.5–22.7. Your program should print a table like this:
 *
 *
 * @author Sharaf Qeshta
 * */
public class Problem$14
{
    public static final int[] LIMITS = {9_000_000, 11_000_000, 13_000_000,
                                    15_000_000, 17_000_000, 19_000_000};

    public static void main(String[] args)
    {
        /*
        * result =>
        *                      9000000          11000000          13000000          15000000          17000000          19000000
        * Listing 22.5           7232              9202              7912             10903             11163             12328
        * Listing 22.6           1784              1301              2351             2557              2639              3473
        * Listing 22.7           61                72                82               105               124               142
        * */
        System.out.printf("%31d%18d%18d%18d%18d%18d", LIMITS[0], LIMITS[1], LIMITS[2],
                LIMITS[3], LIMITS[4], LIMITS[5]);

        System.out.println();
        System.out.printf("%-10s", "Listing 22.5");

        for (int value: LIMITS)
            System.out.printf("%18d", testListing5(value));

        System.out.println();
        System.out.printf("%-10s", "Listing 22.6");

        for (int value: LIMITS)
            System.out.printf("%18d", testListing6(value));

        System.out.println();
        System.out.printf("%-10s", "Listing 22.7");

        for (int value: LIMITS)
            System.out.printf("%18d", testListing7(value));
    }

    public static long testListing5(int n)
    {
        long start = System.currentTimeMillis();
        PrimeNumbers.primeNumbers(n);
        long end = System.currentTimeMillis();
        return end - start;
    }

    public static long testListing6(int n)
    {
        long start = System.currentTimeMillis();
        EfficientPrimeNumbers.efficientPrimeNumbers(n);
        long end = System.currentTimeMillis();
        return end - start;
    }

    public static long testListing7(int n)
    {
        long start = System.currentTimeMillis();
        SieveOfEratosthenes.sieveOfEratosthenes(n);
        long end = System.currentTimeMillis();
        return end - start;
    }
}
