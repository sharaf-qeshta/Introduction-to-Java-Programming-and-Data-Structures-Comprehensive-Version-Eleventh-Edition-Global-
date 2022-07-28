package chapter_twenty_two;

/**
 * *22.1 (Natural numbers and their squares) Knowing that (x + 1)² = x² + 2x + 1,
 * and that multiplication is more time consuming than addition, write an efficient
 * program that displays the first ten natural numbers and their squares. Knowing
 * that (x + 1)³ = x³ + 3x² + 3x + 1, the same process can be followed to display
 * the cubes of these numbers.
 * Here is a sample run:
 *
 *      0^2 = 0
 *      1^2 = 1
 *      2^2 = 4
 *      ...
 *      8^2 = 64
 *      9^2 = 81
 *      10^2 = 100
 *
 *
 * @author Sharaf Qeshta
 * */
public class Problem$01
{
    public static void main(String[] args)
    {
        /*
        * 0² = 0
        * 1² = 1
        * 2² = 4
        * 3² = 9
        * 4² = 16
        * 5² = 25
        * 6² = 36
        * 7² = 49
        * 8² = 64
        * 9² = 81
        * 10² = 100
        * */
        printSquares(10);


        /*
        * 0³ = 0
        * 1³ = 1
        * 2³ = 8
        * 3³ = 27
        * 4³ = 64
        * 5³ = 125
        * 6³ = 216
        * 7³ = 343
        * 8³ = 512
        * 9³ = 729
        * 10³ = 1000
        * */
        printCubes(10);
    }

    public static void printSquares(int bound)
    {
        int previousSquared = 0; // 0²
        System.out.println("0² = 0");

        for (int i = 1; i < bound+1; i++)
        {
            int currentSquared = previousSquared + (i-1 + i-1) + 1;
            System.out.println(i + "² = " + currentSquared);
            previousSquared = currentSquared;
        }
    }

    public static void printCubes(int bound)
    {
        int previousSquared = 0; // 0²
        int previousCubed = 0; // 0³
        System.out.println("0³ = 0");

        for (int i = 1; i < bound+1; i++)
        {
            int currentSquared = previousSquared + (i-1 + i-1) + 1;
            int currentCubed = previousCubed + previousSquared+ previousSquared + previousSquared
                    + (i-1 + i-1 + i-1) + 1;
            System.out.println(i + "³ = " + currentCubed);
            previousSquared = currentSquared;
            previousCubed = currentCubed;
        }
    }
}
