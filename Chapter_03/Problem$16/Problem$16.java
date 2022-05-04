package chapter_three;

/**
 * 3.16 (Random point) Write a program that displays a random coordinate in a rectangle.
 * The rectangle is centred at (0, 0) with width 50 and height 150.
 *
 * @author Sharaf Qeshta
 * */

public class Problem$16
{
    public static void main(String[] args)
    {
        int X = (int) (Math.random() * (25 + 25 + 1) + -25);
        int Y = (int) (Math.random() * (75 + 75 + 1) + -75);

        System.out.println("(" + X + "," + Y + ")");
    }
}
