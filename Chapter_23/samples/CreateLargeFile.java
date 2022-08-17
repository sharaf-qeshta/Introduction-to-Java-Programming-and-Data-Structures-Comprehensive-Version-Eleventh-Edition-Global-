package chapter_twenty_three.samples;

import java.io.*;

/**
 * Listing 23.11 CreateLargeFile.java
 */
public class CreateLargeFile
{
    public static void main(String[] args) throws Exception
    {
        DataOutputStream output = new DataOutputStream(
                new BufferedOutputStream(
                        new FileOutputStream("largedata.dat")));

        for (int i = 0; i < 2_000_000; i++)
            output.writeInt((int) (Math.random() * 1000000));

        output.close();

        // Display first 100 numbers
        DataInputStream input = new DataInputStream(
                new BufferedInputStream(new FileInputStream("largedata.dat")));
        for (int i = 0; i < 100; i++)
            System.out.print(input.readInt() + " ");

        input.close();
    }
}

