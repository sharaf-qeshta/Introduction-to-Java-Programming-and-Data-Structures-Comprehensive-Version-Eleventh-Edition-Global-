package chapter_eighteen;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

/**
 * **18.28 (Nonrecursive directory size) Rewrite Listing 18.7, DirectorySize.java, without
 * using recursion.
 *
 *
 * @author Sharaf Qeshta
 * */
public class Problem$28
{
    private static final ArrayList<File> files = new ArrayList<>();

    public static void main(String[] args)
    {
        File file = new File("src/chapter_eighteen");
        System.out.println(getSize(file)); // 32710
    }

    public static long getSize(File file)
    {
        files.clear();
        if (file.isDirectory())
        {
            files.addAll(Arrays.asList(Objects.requireNonNull(file.listFiles())));
            boolean condition = true;

            while (condition)
            {
                condition = false;
                for (File x: files)
                {
                    if (x.isDirectory())
                    {
                        files.addAll(Arrays.asList(Objects.requireNonNull(x.listFiles())));
                        condition = true;
                        files.remove(x);
                    }
                }
            }
        }
        else
            files.add(file);

        long fileSize = 0;
        for (File x: files)
            fileSize += x.length();

        return fileSize;
    }
}
