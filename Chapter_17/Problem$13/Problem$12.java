package chapter_seventeen;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * *17.12 (Combine files) Write a utility program that combines the files together into a
 * new file using the following command:
 * java Exercise17_12 SourceFile1 . . . SourceFilen TargetFile
 * The command combines SourceFile1, . . . , and SourceFilen into TargetFile.
 *
 *
 * @author Sharaf Qeshta
 * */
public class Problem$12
{
    public static void main(String[] args) throws IOException
    {
        RandomAccessFile target = new RandomAccessFile(args[args.length - 1], "rw");
        for (int i = 0; i < args.length - 1; i++)
        {
            File file = new File(args[i]);
            FileInputStream input = new FileInputStream(file);
            target.write(input.readAllBytes());
        }
    }
}
