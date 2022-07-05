package chapter_seventeen;

import java.io.*;
import java.util.Date;

/**
 * *17.6 (Store Loan objects) The Loan class in Listing 10.2 does not implement
 * Serializable. Rewrite the Loan class to implement Serializable. Write
 * a program that creates five Loan objects and stores them in a file named
 * Exercise17_06.dat.
 *
 *
 * @author Sharaf Qeshta
 * */
public class Problem$06
{
    public static void main(String[] args)
    {
        try (ObjectOutputStream binaryFile = new ObjectOutputStream
                        (new FileOutputStream("src/Problem$06.dat")))
        {
            for (int i = 0; i < 5; i++)
                binaryFile.writeObject(new Loan(i, i, i));
        }
        catch (IOException exception)
        {
            exception.printStackTrace();
        }
    }
}
