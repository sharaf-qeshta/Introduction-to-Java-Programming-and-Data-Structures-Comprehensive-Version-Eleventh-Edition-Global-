package chapter_seventeen;

import java.io.*;
import java.util.Scanner;

/**
 * *17.4 (Convert a text file into UTF) Write a program that reads lines of characters from
 * a text file and writes each line as a UTF string into a binary file. Display the
 * sizes of the text file and the binary file. Use the following command to run the
 * program:
 * java Exercise17_04 Welcome.java Welcome.utf
 *
 *
 * @author Sharaf Qeshta
 */
public class Problem$04
{
    public static void main(String[] args)
    {
        try
                (
                        Scanner textFile = new Scanner(new File(args[0]));
                        DataOutputStream binaryFile = new DataOutputStream
                                (new FileOutputStream(args[1]))
                )
        {
            while (textFile.hasNext())
                binaryFile.writeUTF(textFile.nextLine());
        }
        catch (IOException exception)
        {
            exception.printStackTrace();
        }
    }
}

// testing
class Test
{
    public static void main(String[] args)
    {
        Problem$04.main(new String[] {"src/chapter_seventeen/Problem$04.java", "Welcome.utf"});
    }
}
