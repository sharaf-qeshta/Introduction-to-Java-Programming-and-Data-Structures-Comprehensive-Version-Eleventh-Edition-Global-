package chapter_six;

/**
 * **6.32 (Game: chance of winning at craps) Revise Exercise 6.30 to run it 15,000 times
 * and display the number of winning games.
 *
 * @author Sharaf Qeshta
 * */

public class Problem$32
{
    public static void main(String[] args)
    {
        int wins = 0;
        for (int i = 0; i < 15000;i++)
        {
            int previous = 0;
            while (true)
            {
                int diceOne = (int) ((Math.random() * 10 % 6) + 1);
                int diceTwo = (int) ((Math.random() * 10 % 6) + 1);

                int sum = diceOne + diceTwo;

                if (sum == previous)
                    sum = 7;
                else if (previous != 0)
                    sum = 2;

                if (sum == 2 | sum == 3 | sum == 12)
                {
                    break;
                }
                else if (sum == 7 | sum == 11)
                {
                    wins++;
                    break;
                }
                previous = sum;
            }
        }
        System.out.println("chance to win is " + ((wins/15_000.0)) * 100 + "%"); // 26% - 27%
    }

}
