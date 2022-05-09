package chapter_five;

/**
 * 5.3 (Conversion from Cº to Fº) Write a program that displays the following table (note
 * that farenheit = celsius * 9/5 + 32):
 * Celsius  Fahrenheit
 * 0        32.0
 * 2        35.6
 *    ...
 * 98       208.4
 * 100      212.0
 *
 * @author Sharaf Qeshta
 * */

public class Problem$03
{
    public static void main(String[] args)
    {
        System.out.println("Celsius" + "\t\tFahrenheit");
        for (int i = 0; i < 101; i += 2)
        {
            double fahrenheit = i * 9.0 / 5 + 32;
            System.out.println(i + "\t\t\t\t" + fahrenheit);
        }
    }
}
