package chapter_twenty;

import java.io.File;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;

/**
 * *20.18 (Directory size)  Listing 18.10, DirectorySize.java, gives a recursive method
 * for finding a directory size. Rewrite this method without using recursion. Your
 * program should use a queue to store the subdirectories under a directory. The
 * algorithm can be described as follows:
 * long getSize(File directory) {
 *  long size = 0;
 *  add directory to the queue;
 *  while (queue is not empty) {
 *  Remove an item from the queue into t;
 *  if (t is a file)
 *  size += t.length();
 *  else
 *  add all the files and subdirectories under t into the
 *  queue;
 *  }
 *  return size;
 * }
 *
 *
 * @author Sharaf Qeshta
 * */
public class Problem$18
{
    public static void main(String[] args)
    {
        /* 4375145 */
        System.out.println(getSize(new File("src/chapter_twenty")));
    }

    public static long getSize(File directory)
    {
        long size = 0;
        Queue<File> files = new LinkedList<>();
        files.add(directory);
        while (files.size() > 0)
        {
            File t = files.remove();
            if (t.isFile())
                size += t.length();
            else
                files.addAll(Arrays.asList(Objects.requireNonNull(t.listFiles())));
        }
        return size;
    }
}
