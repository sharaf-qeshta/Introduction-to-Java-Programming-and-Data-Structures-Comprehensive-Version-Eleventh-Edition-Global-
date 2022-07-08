package chapter_seventeen;

import java.io.*;
import java.util.Scanner;

/**
 * *17.19 (View hex) Write a program that prompts the user to enter a file name, reads bytes
 * from the file, and displays each byte’s hex representation. (Hint: You can first
 * convert the byte value into an 8-bit string, then convert the bit string into a two digit hex string.)
 *
 *
 * @author Sharaf Qeshta
 * */
public class Problem$19
{
    public static void main(String[] args) throws IOException
    {
        Scanner scanner = new Scanner(System.in);

        System.out.print("enter file name: ");
        String fileName = scanner.next();
        System.out.println();

        FileInputStream file = new FileInputStream(new File(fileName));
        printHex(file);
    }

    public static void printHex(FileInputStream file) throws IOException
    {
        byte[] bytes = file.readAllBytes();

        for (byte x: bytes)
            System.out.println(x + ": "  + Integer.toHexString(x));
    }
}