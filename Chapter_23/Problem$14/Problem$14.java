package chapter_twenty_three;

import java.io.*;

/**
 * *23.14 (Execution time for external sorting) Write a program that obtains the execution
 * time of external sorts for integers of size 6,000,000, 12,000,000, 18,000,000,
 * 24,000,000, 30,000,000, and 36,000,000. Your program should print a table
 * like this:
 *
 *
 * @author Sharaf Qeshta
 * */
public class Problem$14
{
    public static final int[] RANGES = {6_000_000, 12_000_000, 18_000_000, 24_000_000, 30_000_000, 36_000_000};

    public static void main(String[] args) throws Exception
    {
        /*
        * result =>
        * File Size         6000000           12000000          18000000          24000000          30000000          36000000
        * Time              106388            237935            380899            589254            793190            911424
        * */
        System.out.printf("%-18s", "File Size");
        for (int i = 0; i < RANGES.length; i++)
            System.out.printf("%-18s", RANGES[i] + "");

        System.out.println();

        System.out.printf("%-18s", "Time");
        for (int i = 0; i < RANGES.length; i++)
            System.out.printf("%-18s", test(RANGES[i]));
    }


    public static long test(int size) throws Exception
    {
        String fileName = "large_data" + size + ".dat";
        String sortedName = "sorted_data" + size + ".dat";
        try
        {
            createFile(size, fileName);
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
            return 0;
        }
        long start = System.currentTimeMillis();
        ExternalSort.sort(fileName, sortedName);
        long end = System.currentTimeMillis();
        return end - start;
    }


    public static void createFile(int size, String fileName) throws Exception
    {
        DataOutputStream output = new DataOutputStream(
                new BufferedOutputStream(
                        new FileOutputStream(fileName)));

        for (int i = 0; i < size; i++)
            output.writeInt((int) (Math.random() * 1_000_000));

        output.close();
    }
}
