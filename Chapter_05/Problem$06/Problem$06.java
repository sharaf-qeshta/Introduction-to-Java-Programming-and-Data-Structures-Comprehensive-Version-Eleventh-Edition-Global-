package chapter_five;

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
        System.out.println("Celsius" + "\t\tFahrenheit"+
                "\t\t\t|\t\t\t" + "Fahrenheit" + "\t\tCelsius");
        int j = 20;
        for (int i = 0; i < 101; i+=2, j+=5)
        {
            double fahrenheit = i * 9.0/5 + 32;
            double celsius = (j - 32) / (9 / 5.0);

            System.out.println(i + "\t\t\t\t" + fahrenheit
                    +"\t\t\t|\t\t\t" + j + "\t\t\t\t" + celsius );
        }
    }
}
