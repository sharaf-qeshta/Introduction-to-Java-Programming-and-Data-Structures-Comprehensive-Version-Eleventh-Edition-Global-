package chapter_seventeen;

import java.io.*;

/**
 * *17.2 (Create a binary data file) Write a program to create a file named
 * Exercise17_02.dat if it does not exist. Append new data to it if it already exists.
 * Write 150 integers created randomly into the file using binary I/O.
 *
 *
 * @author Sharaf Qeshta
 * */
public class Problem$02
{
    public static void main(String[] args)
    {
        try (RandomAccessFile file = new RandomAccessFile
                (new File("src/Problem$02.dat"), "rw"))
        {
            file.seek(file.length());
            for(int i = 1; i < 151; i++)
                file.writeInt((int) (Math.random() * 150));
        }
        catch (IOException exception)
        {
            exception.printStackTrace();
        }
    }
}
