package chapter_seventeen;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;

/**
 * 17.14 (Encrypt files) Encode the file by adding 10 to every byte in the file. Write a gram
 * that prompts the user to enter an input file name and an output file name and saves
 * the encrypted version of the input file to the output file.
 *
 *
 * @author Sharaf Qeshta
 * */
public class Problem$14
{
    public static void main(String[] args) throws IOException
    {
        Scanner scanner = new Scanner(System.in);

        System.out.print("enter file to encrypt: ");
        String fileName = scanner.next();
        File file = new File(fileName);
        FileInputStream file_ = new FileInputStream(file);
        encrypt(file_, file.getName());
    }

    private static void encrypt(FileInputStream file, String fileName)
            throws IOException
    {
        byte[] bytes = file.readAllBytes();


        RandomAccessFile encryptedFile = new RandomAccessFile(fileName + ".encrypted", "rw");

        for (byte x: bytes)
            encryptedFile.writeByte(x+10);
        System.out.println("the encrypted file is " + fileName + ".encrypted");
    }
}
