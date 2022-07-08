package chapter_seventeen;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;

/**
 * 17.15 (Decrypt files) Suppose a file is encrypted using the scheme in Programming
 * Exercise 17.14. Write a program to decode an encrypted file. Your program
 * should prompt the user to enter an input file name for the encrypted file and an
 * output file name for the unencrypted version of the input file.
 *
 *
 * @author Sharaf Qeshta
 * */
public class Problem$15
{
    public static void main(String[] args) throws IOException
    {
        Scanner scanner = new Scanner(System.in);

        System.out.print("enter file to decrypt: ");
        String fileName = scanner.next();

        if (!fileName.contains(".encrypted"))
        {
            System.out.println("Invalid format " +  fileName.substring(fileName.lastIndexOf("."))
                    + "\nprogram only accept .encrypted files format :)");
            System.exit(-1);
        }

        FileInputStream file_ = new FileInputStream(new File(fileName));
        decrypt(file_, fileName.substring(0, fileName.lastIndexOf(".")));
    }


    private static void decrypt(FileInputStream file, String fileName)
            throws IOException
    {
        byte[] bytes = file.readAllBytes();

        RandomAccessFile decryptedFile = new RandomAccessFile(fileName, "rw");

        for (byte x: bytes)
            decryptedFile.writeByte((byte) (x-10));

        System.out.println("the decrypted file is " + fileName);
    }
}
