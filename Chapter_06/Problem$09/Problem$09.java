package chapter_six;

/**
 * 6.9 (Conversions between pounds and kilograms) Write a class that contains the
 * following two methods:
 *
 * public static double poundToKilogram(double pound)
 *
 * public static double kilogramToPound(double kilogram)
 *
 * The formula for the conversion is:
 * pound = 0.453 * kilogram
 * kilogram = 2.204 * pound
 * Write a test program that invokes these methods to display the following tables:
 *
 *          Kilograms   Pounds  |   Pounds  Kilograms
 *          1           2.2     |   20      9.09
 *          3           6.6     |   25      11.36
 *          ...
 *          197         433.4   |   510     231.82
 *          199         437.8   |   515     234.09
 *
 * @author Sharaf Qeshta
 * */

public class Problem$09
{
    public static void main(String[] args)
    {
        System.out.println("Kilograms\t\t\tPounds\t\t\t|\t\t\t" +
                "Pounds\t\t\tKilograms");


        for (int i =1, j =20; i < 200; i+=2, j+=5)
        {
            String k = String.format("%.2f", kilogramToPound(i));
            String m = String.format("%.2f", poundToKilogram(j));
            System.out.print(i +"\t\t\t\t\t" + k+ "\t\t\t|\t\t\t");
            System.out.print(j +"\t\t\t\t" + m);
            System.out.println();
        }
    }

    /** Convert from pounds to kilograms */
    public static double poundToKilogram(double pound)
    {
        return 0.453 * pound;
    }

    /** Convert from kilograms to pounds */
    public static double kilogramToPound(double kilogram)
    {
        return 2.204 * kilogram;
    }

}
