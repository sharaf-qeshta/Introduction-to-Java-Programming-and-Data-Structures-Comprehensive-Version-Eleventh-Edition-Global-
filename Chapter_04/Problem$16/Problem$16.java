package chapter_four;


/**
 * 4.16 (Random character) Write a program that displays a random lowercase letter using
 * the Math.random() method.
 *
 * @author Sharaf Qeshta
 * */

public class Problem$16
{
    public static void main(String[] args)
    {
        System.out.println((char) (((Math.random() * 1000) % 25) + 97));
    }
}
