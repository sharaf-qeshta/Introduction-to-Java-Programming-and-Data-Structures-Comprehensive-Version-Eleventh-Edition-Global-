package chapter_six;

import java.util.Scanner;

/**
 * **6.25 (Convert milliseconds to hours, minutes, and seconds) Write a method that
 * converts milliseconds to hours, minutes, and seconds using the following header:
 * public static String convertMillis(long millis)
 * The method returns a string as hours:minutes:seconds. For example,
 * convertMillis(5500) returns a string 0:0:5, convertMillis(100000)
 * returns a string 0:1:40, and convertMillis(555550000) returns a string
 * 154:19:10. Write a test program that prompts the user to enter a long integer for
 * milliseconds and displays a string in the format of hours:minutes:seconds.
 *
 * @author Sharaf Qeshta
 * */

public class Problem$25
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        System.out.print("enter millis: ");
        long millis = scanner.nextLong();

        System.out.println(convertMillis(millis));
    }

    public static String convertMillis(long millis)
    {
        int seconds = (int) (millis / 1000);
        int hours = seconds / 3600;
        seconds = seconds % 3600;
        int minutes = seconds / 60;
        seconds = seconds % 60;
        return hours + ":" + minutes + ":" + seconds;
    }

}
