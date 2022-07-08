package chapter_seventeen.samples;

import java.io.*;

/**
 * Listing 17.5 TestObjectOutputStream.java
 */
public class TestObjectOutputStream
{
    public static void main(String[] args) throws IOException
    {
        try ( // Create an output stream for file object.dat
              ObjectOutputStream output =
                      new ObjectOutputStream(new FileOutputStream("object.dat"));
        )
        {
            // Write a string, double value, and object to the file
            output.writeUTF("John");
            output.writeDouble(85.5);
            output.writeObject(new java.util.Date());
        }
    }
}
