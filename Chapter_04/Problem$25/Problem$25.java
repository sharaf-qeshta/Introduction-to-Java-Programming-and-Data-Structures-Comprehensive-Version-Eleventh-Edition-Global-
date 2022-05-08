package chapter_four;

/**
 * *4.25 (Generate vehicle plate numbers) Assume that a vehicle plate number consists of
 * three uppercase letters followed by four digits. Write a program to generate a plate
 * number.
 *
 * @author Sharaf Qeshta
 * */

public class Problem$25
{
    public static void main(String[] args)
    {
        // upper case letters between 65..90
        char ch1 = (char) (((int) (Math.random() * 100) % 26) + 65);
        char ch2 = (char) (((int) (Math.random() * 100) % 26) + 65);
        char ch3 = (char) (((int) (Math.random() * 100) % 26) + 65);

        int n1 = (int) (Math.random() * 10);
        int n2 = (int) (Math.random() * 10);
        int n3 = (int) (Math.random() * 10);
        int n4 = (int) (Math.random() * 10);

        System.out.println("plate: " + ch1+ch2+ch3 + "-" + n1 + n2 + n3 + n4);
    }
}
