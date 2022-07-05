package chapter_seventeen;

import java.io.*;

/**
 * *17.8 (Update count) Suppose that you wish to track how many times a program has
 * been executed. You can store an int to count the file. Increase the count by 1
 * each time this program is executed. Let the program be Exercise17_08.txt and
 * store the count in Exercise17_08.dat.
 *
 *
 * @author Sharaf Qeshta
 */
public class Problem$08
{
    public static void main(String[] args)
    {
        try (DataInputStream inputStream = new DataInputStream
                (new FileInputStream("src/Problem$08.txt")))
        {
            increaseCounter();
        }
        catch (IOException exception)
        {
            System.out.println(exception.getMessage());
        }
    }


    private static void increaseCounter()
    {
        int value = getValue();

        try
        (DataOutputStream file = new DataOutputStream
               (new FileOutputStream("src/Problem$08.dat")))
        {
            file.writeInt(++value);
        }
        catch (IOException exception)
        {
            System.out.println(exception.getMessage());
        }
    }


    private static int getValue()
    {
        int value = 0;
        try
        (DataInputStream file = new DataInputStream
                    (new FileInputStream("src/Problem$08.dat")))
        {
                value = file.readInt();
        }
        catch (Exception exception)
        {
            System.out.println(exception.getMessage());
        }
        return value;
    }
}
