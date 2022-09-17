package chapter_twenty_eight;

/**
 * **28.14 (4 * 4 16 tails analysis) The nine tails problem in the text uses a 3 * 3 matrix.
 * Assume you have 16 coins placed in a 4 * 4 matrix. Write a program to find
 * out the number of the starting patterns that don’t have a solution.
 *
 *
 * @author Sharaf Qeshta
 * */
public class Problem$14
{
    public static void main(String[] args)
    {
        SixteenTailModel model = new SixteenTailModel();
        /*
        * 61440
        * hence the number of starting patterns that don’t have a solution is 61440 patterns
        * */
        System.out.println(model.getNumberOfInvalidStartPatter());
    }
}
