package chapter_five;

/**
 * 5.5 (Conversion from Cº to Fº and Fº to Cº) Write a program that displays the following
 * two tables side by side:
 * Celsius Fahrenheit |     Fahrenheit  Celsius
 * 0        32.000    |     20          −6.667
 * 2        35.600    |     25          −3.889
 *                   ...
 * 98       208.400   |     265         129.444
 * 100      212.000   |     270         132.222
 *
 * @author Sharaf Qeshta
 * */

public class Problem$05
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
