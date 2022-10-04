package chapter_thirty.samples;

import java.io.File;
import java.nio.file.Files;
import java.util.Scanner;

/**
 * Listing 30.11 DirectorySizeStream.java
 * */
public class DirectorySizeStream
{
    public static void main(String[] args) throws Exception
    {
        // Prompt the user to enter a directory or a file
        System.out.print("Enter a directory or a file: ");
        Scanner input = new Scanner(System.in);
        String directory = input.nextLine();

        // Display the size
        System.out.println(getSize(new File(directory)) + " bytes");
    }

    public static long getSize(File file)
    {
        if (file.isFile())
        {
            return file.length();
        }
        else
        {
            try
            {
                return Files.list(file.toPath()).parallel().
                        mapToLong(e -> getSize(e.toFile())).sum();
            }
            catch (Exception ex)
            {
                return 0;
            }
        }
    }
}
