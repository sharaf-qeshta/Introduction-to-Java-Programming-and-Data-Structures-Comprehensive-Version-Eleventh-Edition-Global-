package chapter_seventeen.samples;

import java.io.*;

/**
 * Listing 17.6 TestObjectInputStream.java
 */
public class TestObjectInputStream
{
    public static void main(String[] args)
            throws ClassNotFoundException, IOException
    {
        try ( // Create an input stream for file object.dat
              ObjectInputStream input =
                      new ObjectInputStream(new FileInputStream("object.dat"));
        )
        {
            // Read a string, double value, and object from the file
            String name = input.readUTF();
            double score = input.readDouble();
            java.util.Date date = (java.util.Date) (input.readObject());
            System.out.println(name + " " + score + " " + date);
        }
    }
}
