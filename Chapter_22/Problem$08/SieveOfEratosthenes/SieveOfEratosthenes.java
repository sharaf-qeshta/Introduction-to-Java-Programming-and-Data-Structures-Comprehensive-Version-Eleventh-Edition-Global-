package chapter_twenty_two;


import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.HashMap;

/**
 * an efficient way to get prime numbers less than x
 * */
public class SieveOfEratosthenes
{
    private static final String FILE_PATH = "src/chapter_twenty_two/PrimeNumbers.dat";

    /**
     * 50M is the maximum limit that i can reach with my device
     * for 2gb ram if you have a some editing to decrease space complexity
     * tell me
     * */
    public static void main(String[] args)
    {
        writeAllPrimes(50_000_000L);
    }

    public static void writeAllPrimes(long bound)
    {
        HashMap<Long, Boolean> primesMap = new HashMap<>();

        for (long i = 0; i < bound; i++)
        {
            primesMap.put(i, true);
        }

        for (long k = 2; k <= bound / k; k++)
        {
            if(primesMap.get(k))
            {
                for (long i = k; i <= bound / k; i++)
                    primesMap.put(k * i, false);
            }
        }

        try (RandomAccessFile writer = new RandomAccessFile(FILE_PATH, "rw"))
        {
            primesMap.forEach((key, value) ->
            {
                if (value)
                {
                    try
                    {
                        writer.writeLong(key);
                    }
                    catch (IOException exception)
                    {
                        exception.printStackTrace();
                    }
                }
            });
        }
        catch (Exception ignored) { }
    }
}
