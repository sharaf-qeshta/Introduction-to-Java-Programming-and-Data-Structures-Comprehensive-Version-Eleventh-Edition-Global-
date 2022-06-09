package chapter_twelve;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * *12.21 (Using two files) Write a program that prompts the user to enter the name of an
 * author and prints the titles of their books. You can use the method of
 * Programming Exercise 12.14. Assume that you have a file “authors” and a file “books”
 * created from Programming Exercise 12.19.
 *
 * @author Sharaf Qeshta
 * */
public class Problem$21
{
    public static final String BOOKS_PATH = "src/chapter_twelve/Books.txt";
    public static final String AUTHORS_PATH = "src/chapter_twelve/Authors.txt";

    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter Author Name: ");
        String author = scanner.nextLine();

        List<String> books = getAllLines(new File(BOOKS_PATH));
        List<String> authors = getAllLines(new File(AUTHORS_PATH));

        int[] bounds = getBounds(authors, author);

        System.out.println("Author " + author + " Wrote: ");
        for (int i = bounds[0]; i < bounds[1]; i++)
            System.out.println(books.get(i));
    }
    
    public static List<String> getAllLines(File file)
    {
        List<String> lines = new ArrayList<>();
        try (Scanner scanner = new Scanner(file))
        {
            while (scanner.hasNext())
                lines.add(scanner.nextLine().trim());
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
        }
        return lines;
    }
    
    public static int[] getBounds(List<String> lines, String author)
    {
        int[] bounds = new int[2];
        boolean found = false;
        for (int i = 0; i < lines.size(); i++)
        {
            if (lines.get(i).equals(author))
            {
                bounds[0] = i;
                found = true;
            }

            if (found && !lines.get(i).isEmpty())
                bounds[1] = i;
        }
        if (bounds[1] <= bounds[0])
            bounds[1] = lines.size();
        return bounds;
    }
}