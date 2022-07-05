package chapter_seventeen;

import java.io.*;
import java.util.Date;

/**
 * *17.5 (Store objects and arrays in a file) Write a program that stores an array of the six
 * int values 1, 2, 3, 4,5, and 6, a Date object for the current time, and the double
 * value 10.5 into the file named Exercise17_05.dat.
 *
 *
 * @author Sharaf Qeshta
 * */
public class Problem$05
{
    public static void main(String[] args)
    {
        try (ObjectOutputStream binaryFile = new ObjectOutputStream
                        (new FileOutputStream("src/Problem$05.dat")))
        {
            binaryFile.writeObject(new int[] {1, 2, 3, 4, 5, 6});

            binaryFile.writeObject(new Date());

            binaryFile.writeObject(10.5);

        }
        catch (IOException exception)
        {
            exception.printStackTrace();
        }
    }
}
