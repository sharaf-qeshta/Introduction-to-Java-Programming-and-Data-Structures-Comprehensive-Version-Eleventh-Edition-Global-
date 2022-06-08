package chapter_twelve;

import java.io.File;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * *12.19 (Linking two files) Write a program that prompts the user to enter the name of
 * an author and the title of one their books. It writes the author’s name to a file
 * by using the method written in Programming Exercise 12.15. Their book’s title
 * is written at the end of a file Books.txt with the line number of the author’s
 * name in Authors.txt inserted before the title. Assume that the title is not
 * already stored in Books.txt and the author name is already in Authors.txt.
 *
 * @author Sharaf Qeshta
 * */
public class Problem$19
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        System.out.print("enter the author name: ");
        String authorName = scanner.nextLine();

        System.out.print("enter a book title: ");
        String bookTitle = scanner.nextLine();


        File authors = new File("src/chapter_twelve/Authors.txt");
        File books = new File("src/chapter_twelve/Books.txt");
        writeIn(authors, authorName); writeIn(books, bookTitle);
    }

    public static void writeIn(File file, String line)
    {
        try (PrintWriter output = new PrintWriter(file))
        {
            output.append(line).append("\n");
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
        }
    }
}