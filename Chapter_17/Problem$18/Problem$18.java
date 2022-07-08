package chapter_seventeen;

import java.io.*;
import java.util.Scanner;

/**
 * *17.18 (View bits) Write the following method that displays the bit representation for the
 * last byte in an integer:
 * public static String getBits(int value)
 * For a hint, see Programming Exercise 5.44. Write a program that prompts the user
 * to enter a file name, reads bytes from the file, and displays each byte’s binary
 * representation.
 *
 *
 * @author Sharaf Qeshta
 * */
public class Problem$18
{
    public static void main(String[] args) throws IOException
    {
        Scanner scanner = new Scanner(System.in);

        System.out.print("enter file name: ");
        String fileName = scanner.next();
        System.out.println();

        FileInputStream file = new FileInputStream(new File(fileName));
        printBits(file);
    }

    public static void printBits(FileInputStream file) throws IOException
    {
        byte[] bytes = file.readAllBytes();

        for (byte x: bytes)
            System.out.println(x + ": "  + getBits(x));
    }


    public static String getBits(int value)
    {
        StringBuilder bits = new StringBuilder();

        for (int i = 0; i < 32; i++) // 8 byte, 16 short, 32 integer, 64 long
        {
            bits.insert(0, (value & 1));
            value >>= 1;
        }

        return bits.toString();
    }
}