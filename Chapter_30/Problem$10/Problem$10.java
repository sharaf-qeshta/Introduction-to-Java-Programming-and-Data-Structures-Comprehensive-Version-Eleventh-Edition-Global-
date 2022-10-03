package chapter_thirty;

import java.util.Scanner;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * 30.10 (Convert binary to decimal) Write a program that prompts the user to enter a
 * binary number in string and displays its decimal value. Use Stream’s reduce
 * method to convert a binary number to decimal.
 *
 *
 * @author Sharaf Qeshta
 * */
public class Problem$10
{
    public static int i = 0;
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a binary value : ");
        String binary = scanner.next();

        int[] chars = new int[binary.length()];
        int j = 0;
        for (int i = binary.length()-1; i > -1; i--)
            chars[j++] = Integer.parseInt(binary.charAt(i) + "");

        System.out.println("the decimal representation of " + binary + " is "
                + IntStream.of(chars).reduce(0, (e1, e2) -> e1 + e2 * (int) Math.pow(2, i++)));
    }
}


