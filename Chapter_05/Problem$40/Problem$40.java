package chapter_five;

/**
 * 5.40 (Simulation: heads or tails) Write a program that simulates flipping a coin two
 * millions times and displays the number of heads and tails
 *
 * @author Sharaf Qeshta
 * */

public class Problem$40
{
    public static void main(String[] args)
    {
        // since its a random operation
        int heads = 0, tails = 0;

        for (int i = 0; i < 2_000_000;i++)
        {
            int flip = (int) ((Math.random()*10) % 2); // 0 or 1
            if (flip == 0)
                heads++;
            else
                tails++;
        }

        System.out.println("heads: " + heads + " times, and tails: " + tails + " times.");
    }
}

