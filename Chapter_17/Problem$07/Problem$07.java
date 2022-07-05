package chapter_seventeen;

import java.io.*;

/**
 * *17.7 (Restore objects from a file) Suppose a file named Exercise17_06.dat has
 * been created using the ObjectOutputStream from the preceding programming
 * exercises. The file contains Loan objects. The Loan class in Listing 10.2
 * does not implement Serializable. Rewrite the Loan class to implement
 * Serializable. Write a program that reads the Loan objects from the file and
 * displays the total loan amount. Suppose that you don’t know how many Loan
 * objects are there in the file, use EOFException to end the loop.
 *
 *
 * @author Sharaf Qeshta
 * */
public class Problem$07
{
    public static void main(String[] args)
    {
        try (ObjectInputStream binaryFile = new ObjectInputStream
                        (new FileInputStream("src/Problem$06.dat")))
        {
            while (true)
            {
                Loan loan = (Loan) binaryFile.readObject();
                System.out.println(loan.getLoanAmount());
            }
        }
        catch (EOFException e)
        {
            System.out.println();
        }
        catch (IOException | ClassNotFoundException exception)
        {
            exception.printStackTrace();
        }
    }
}
