package chapter_five;

import java.text.DecimalFormat;
import java.text.NumberFormat;

/**
 * 5.6 (Conversion from square meter to ping) Write a program that displays the following
 * two tables side by side (note that 1 ping = 3.305 square meters):
 * Ping     Square meter |      Square meter    Ping
 * 10       33.050       |      30              9.077
 * 15       49.575       |      35              10.590
 *                      ...
 * 75       247.875      |      95              28.744
 * 80       264.400      |      100             30.257
 *
 * @author Sharaf Qeshta
 * */

public class Problem$06
{
    public static void main(String[] args)
    {
        System.out.println("Ping" + "\tSquare meter"+
                "\t|\t" + "Square meter" + "\tPing");

        NumberFormat formatter = new DecimalFormat("#0.000");

        // 1 ping = 3.305
        int j = 30;
        for (int i = 10; i < 81; i+=5, j+=5)
        {
            double squareMeter = i * 3.305;
            double ping = j / 3.305;

            System.out.println(i + "\t\t" + formatter.format(squareMeter)
                    +"\t\t\t|\t" + j + "\t\t\t\t" + formatter.format(ping));
        }
    }
}
