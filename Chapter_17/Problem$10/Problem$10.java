package chapter_seventeen;

import java.io.*;
import java.util.ArrayList;

/**
 * *17.10 (Split files) Suppose you want to back up a huge file (e.g., a 10-GB AVI file) to a
 * CD-R. You can achieve it by splitting the file into smaller pieces and backing up
 * these pieces separately. Write a utility program that splits a large file into smaller
 * ones using the following command:
 * java Exercise17_10 SourceFile numberOfPieces
 * The command creates the files SourceFile.1, SourceFile.2, . . . , SourceFile.n,
 * where n is numberOfPieces and the output files are about the same size.
 *
 *
 * @author Sharaf Qeshta
 * */
public class Problem$10
{
    public static void main(String[] args) throws IOException
    {
        File file = new File(args[0]);
        createBackup(file, Integer.parseInt(args[1]));
    }


    private static void createBackup(File file, int pieces)
            throws IOException
    {
        ArrayList<Integer> values = getValues(file);
        int backupSize = values.size() / pieces;

        RandomAccessFile backup = new RandomAccessFile
                (file.getName() + ".1", "rw");
        for (int i = 0; i < values.size(); i++)
        {
            if (i % backupSize == 0)
                backup =  new RandomAccessFile
                        (file.getName() + "."  + ((i / backupSize) + 1), "rw");
            backup.write(values.get(i));
        }
    }


    private static ArrayList<Integer> getValues(File file)
            throws FileNotFoundException
    {
        FileInputStream x = new FileInputStream(file);
        ArrayList<Integer> integers = new ArrayList<>();
        try
        {
            int value;
            while ((value = x.read()) != -1)
                integers.add(value);
            return integers;
        }
        catch (EOFException ignored) { }
        catch (IOException exception)
        {
            exception.printStackTrace();
        }
        return integers;
    }
}

class Test
{
    public static void main(String[] args) throws IOException
    {
        Problem$10.main(new String[] {"src/chapter_seventeen/earth.avi", "3"});
    }
}
