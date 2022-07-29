package chapter_twenty_two;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;

/**
 * **22.8 (All prime numbers up to 10,000,000,000) Write a program that finds
 * all prime numbers up to 10,000,000,000. There are approximately
 * 455,052,511 such prime numbers. Your program should meet the following
 * requirements:
 * ■■ Your program should store the prime numbers in a binary data file, named
 * PrimeNumbers.dat. When a new prime number is found, the number is
 * appended to the file.
 * ■■ To find whether a new number is prime, your program should load the prime
 * numbers from the file to an array of the long type of size 10000. If no
 * number in the array is a divisor for the new number, continue to read the
 * next 10000 prime numbers from the data file, until a divisor is found or all
 * numbers in the file are read. If no divisor is found, the new number is prime.
 * ■■ Since this program takes a long time to finish, you should run it as a batch
 * job from a UNIX machine. If the machine is shut down and rebooted, your
 * program should resume by using the prime numbers stored in the binary data
 * file rather than start over from scratch.
 *
 *
 * @author Sharaf Qeshta
 * */
public class Problem$08
{
    private static final String FILE_PATH = "src/chapter_twenty_two/PrimeNumbers.dat";

    /** the last prime is 66137
     * my device could not afford much calculation
     * */
    public static void main(String[] args)
    {
        addAllPrimes(10_000_000_000L);
    }

    private static void addAllPrimes(long bound)
    {
        long start = getLast();
        if (start != 2)
            start++;

        for (long i = start; i < bound+1; i++)
        {
            if (i % 2 == 0 || i % 3 == 0 || i % 5 == 0 || i % 7 == 0 || i % 9 == 0)
                continue;
            System.out.println(i);
            int length = 0;
            ArrayList<Long> previousPrimes = getPrimes(length);
            if (previousPrimes.size() == 0)
                write(i);
            else
            {
                boolean prime = true;
                while (previousPrimes.size() != 0 && prime)
                {
                    for (long x: previousPrimes)
                    {
                        if (i % x == 0)
                        {
                            prime = false;
                            break;
                        }
                    }
                    length += 10_000;
                    previousPrimes = getPrimes(length);
                }
                if (prime)
                    write(i);
            }
        }
    }

    public static long getLast()
    {
        long x = 2;
        try(RandomAccessFile reader = new RandomAccessFile(FILE_PATH, "r"))
        {
            while (true)
                x = reader.readLong();
        }
        catch (IOException ignored) { }
        return x;
    }

    public static boolean write(long x)
    {
        try (RandomAccessFile writer = new RandomAccessFile(FILE_PATH,"rw"))
        {
            writer.seek(new File(FILE_PATH).length());
            writer.writeLong(x);
            return true;
        }
        catch (Exception exception)
        {
            return false;
        }
    }

    public static ArrayList<Long> getPrimes(long position)
    {
        ArrayList<Long> primes = new ArrayList<>();
        int counter = 0;
        try (RandomAccessFile reader = new RandomAccessFile(FILE_PATH, "r"))
        {
            reader.seek(0);
            while (true)
            {
                long prime = reader.readLong();
                if (counter++ < position)
                    continue;
                primes.add(prime);
                if (counter >= (position+10000))
                    return primes;
            }
        }
        catch (Exception ignored) { }
        return primes;
    }
}
