package chapter_twelve;

import java.io.File;
import java.util.Scanner;

/**
 * **12.26 (Create a directory) Write a program that prompts the user to enter a directory
 * name and creates a directory using the File’s mkdirs method. The program
 * displays the message “Directory created successfully” if a directory is created
 * or “Directory already exists” if the directory already exists.
 *
 * @author Sharaf Qeshta
 * */
public class Problem$26
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        System.out.print("enter a directory name: ");
        String directoryName = scanner.nextLine();
        File file = new File(directoryName);

        if (file.mkdir())
            System.out.println("directory created successfully");
        else
            System.out.println("the directory is already exist");
    }
}
