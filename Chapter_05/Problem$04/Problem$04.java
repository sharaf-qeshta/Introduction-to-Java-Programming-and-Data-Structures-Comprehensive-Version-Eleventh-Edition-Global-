package chapter_five;

/**
 * 5.4 (Conversion from inch to centimeter) Write a program that displays the following
 * table (note that 1 inch is 2.54 centimeters):
 * Inches   Centimetres
 * 1        2.54
 * 2        5.08
 *      ...
 * 9        22.86
 * 10       25.4
 *
 * @author Sharaf Qeshta
 * */

public class Problem$04
{
    public static void main(String[] args)
    {
        System.out.println("Inches" + "\t\tCentimetres");
        for (int i = 1; i < 11; i++)
        {
            double centimeter = i * 2.54;
            System.out.println(i + "\t\t\t" + centimeter);
        }
    }
}
