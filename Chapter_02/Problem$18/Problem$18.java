package chapter_two;


/**
 * 2.18 (Print a table) Write a program that displays the following table. Calculate the
 * middle point of two points.
 *    a       b     Middle Point
 * (0, 0)   (2, 1)  (1.0, 0.5)
 * (1, 4)   (4, 2)  (2.5, 3.0)
 * (2, 7)   (6, 3)  (4.0, 5.0)
 * (3, 9)   (10, 5) (6.5, 7.0)
 * (4, 11)  (12, 7) (8.0, 9.0)
 *
 * @author Sharaf Qeshta
 * */

public class Problem$18
{
    public static void main(String[] args)
    {
        int x0 = 0, y0 = 0, x1 = 2, y1 = 1; // line 1
        int x2 = 1, y2 = 4, x3 = 4, y3 = 2; // line 2
        int x4 = 2, y4 = 7, x5 = 6, y5 = 3; // line 3
        int x6 = 3, y6 = 9, x7 = 10, y7 = 5; // line 4
        int x8 = 4, y8 = 11, x9 = 12, y9 = 7; // line 5

        double mp0x = (x0 + x1) / 2.0, mp0y = (y0 + y1) / 2.0; // line 1
        double mp1x = (x2 + x3) / 2.0, mp1y = (y2 + y3) / 2.0; // line 2
        double mp2x = (x4 + x5) / 2.0, mp2y = (y4 + y5) / 2.0; // line 3
        double mp3x = (x6 + x7) / 2.0, mp3y = (y6 + y7) / 2.0; // line 4
        double mp4x = (x8 + x9) / 2.0, mp4y = (y8 + y9) / 2.0; // line 5


        // table

        System.out.println("\ta\t" + "\tb\t" + "\tMiddle Point"); // line 1
        // line 2
        System.out.println(" (" + x0 + ", " + y0 + ")\t" +
                " (" + x1 + ", " + y1 + ")\t"
                + "   (" + mp0x + ", " + mp0y + ")");
        // line3
        System.out.println(" (" + x2 + ", " + y2 + ")\t" +
                " (" + x3 + ", " + y3 + ")\t"
                + "   (" + mp1x + ", " + mp1y + ")");
        // line 4
        System.out.println(" (" + x4 + ", " + y4 + ")\t" +
                " (" + x5 + ", " + y5 + ")\t"
                + "   (" + mp2x + ", " + mp2y + ")");
        // line 5
        System.out.println(" (" + x6 + ", " + y6 + ")\t" +
                " (" + x7 + ", " + y7 + ")"
                + "   (" + mp3x + ", " + mp3y + ")");
        // line 6
        System.out.println(" (" + x8 + ", " + y8 + ")" +
                " (" + x9 + ", " + y9 + ")"
                + "   (" + mp4x + ", " + mp4y + ")");
    }
}
