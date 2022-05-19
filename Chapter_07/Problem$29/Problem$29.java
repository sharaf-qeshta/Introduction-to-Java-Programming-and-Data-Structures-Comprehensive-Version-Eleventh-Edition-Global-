package chapter_seven;


/**
 * *7.29 (Game: dice) Suppose three dice are thrown at random. Write a program that
 * shows all possible permutations or configurations of the three dice that yield the
 * sum of nine.
 *
 * @author Sharaf Qeshta
 * */


public class Problem$29
{
    public static void main(String[] args)
    {
        int[] dicePossibleValues = {1, 2, 3, 4, 5, 6};
        dicePermutations(dicePossibleValues);
    }

    public static void dicePermutations(int[] numbers)
    {
        for (int k : numbers)
        {
            for (int number : numbers)
            {
                for (int j : numbers)
                {
                    if (k + number + j == 9)
                        System.out.print(k + ", " + number + ", " + j + "\n");
                }
            }
        }
    }
}
