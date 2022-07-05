package chapter_seventeen;

import java.io.File;
import java.io.PrintWriter;

/**
 * *17.1 (Create a text file) Write a program to create a file named Exercise17_01.txt if it
 * does not exist. Append new data to it if it already exists. Write 150 integers created
 * randomly into the file using text I/O. Integers are separated by a space.
 *
 *
 * @author Sharaf Qeshta
 * */
public class Problem$01
{
    public static void main(String[] args)
    {
        File file = new File("src/Problem$01.txt");
        try
        {
            if (!file.exists())
                file.createNewFile();
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
        }


        try (PrintWriter writer = new PrintWriter(file))
        {
            for(int i = 1; i < 151; i++)
                writer.write((int) (Math.random() * 150) + " ");
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
        }
    }
}
