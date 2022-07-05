package chapter_seventeen;

import java.io.*;

/**
 * *17.3 (Sum all the floating points in a binary data file) Suppose a binary data file
 * named Exercise17_03.dat has been created and its data are created using
 * writeDouble(double) in DataOutputStream. The file contains an unspecified
 * number of floating points. Write a program to find the sum of the floating
 * points
 *
 *
 * @author Sharaf Qeshta
 * */
public class Problem$03
{
    public static void main(String[] args)
    {
        double sum = 0;
        try (DataInputStream output = new DataInputStream
                (new FileInputStream("src/Problem$03.dat")))
        {
            double value;

            while ((value = output.readDouble()) > -1)
                sum += value;
        }
        catch (EOFException e)
        {
            System.out.println("the sum is " + sum);
        }
        catch (IOException exception)
        {
            exception.printStackTrace();
        }
    }
}
