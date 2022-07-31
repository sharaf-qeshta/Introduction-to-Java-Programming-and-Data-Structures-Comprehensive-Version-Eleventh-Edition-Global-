package chapter_twenty_two;


import java.io.File;
import java.io.RandomAccessFile;
import java.util.ArrayList;

/**
 * *22.12 (Last 100 prime numbers) Programming Exercise 22.8 stores the prime numbers
 * in a file named PrimeNumbers.dat. Write an efficient program that reads the
 * last 100 numbers in the file. (Hint: Don’t read all numbers from the file. Skip
 * all numbers before the last 100 numbers in the file.)
 *
 *
 * @author Sharaf Qeshta
 * */
public class Problem$12
{
    private static final String FILE_PATH = "src/chapter_twenty_two/PrimeNumbers.dat";

    public static void main(String[] args)
    {
        getNumbers(100).forEach(System.out::println);
    }

    public static ArrayList<Long> getNumbers(int bound)
    {
        ArrayList<Long> primes = new ArrayList<>();
        int limit = 8*bound;
        int currentLimit = 8;
        long fileLength = new File(FILE_PATH).length();
        try (RandomAccessFile reader = new RandomAccessFile(FILE_PATH, "r"))
        {
            for (int i = currentLimit; i <= limit; i+=8)
            {
                reader.seek(fileLength - i);
                primes.add(reader.readLong());
            }
        }
        catch (Exception ignored) { }

        return primes;
    }
}
