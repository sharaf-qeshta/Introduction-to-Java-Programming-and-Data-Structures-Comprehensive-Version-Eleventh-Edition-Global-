package chapter_twenty_nine;



import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.Scanner;

/**
 * **29.7 (Weighted 4 * 4 16 tails) Revise Listing 29.9, WeightedNineTail.java, for the
 * weighted 4 * 4 16 tails problem. Your program should read the model object
 * created from the preceding exercise.
 *
 *
 * @author Sharaf Qeshta
 * */
public class Problem$07
{
    private static final String FILE_PATH = "src/chapter_twenty_nine/WeightedTailModel16.dat";

    public static void main(String[] args)
    {
        // Prompt the user to enter the sixteen coins' Hs and Ts
        System.out.print("Enter an initial sixteen coins' Hs and Ts: ");
        Scanner input = new Scanner(System.in);
        String s = input.nextLine();

        char[] initialNode = s.toCharArray();

        WeightedTailModel16 model16 = null;
        try(ObjectInputStream stream =
                    new ObjectInputStream(new FileInputStream(new File(FILE_PATH))))
        {
            model16 = (WeightedTailModel16) stream.readObject();
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
        }

        java.util.List<Integer> path =
                model16.getShortestPath(SixteenTailModel.getIndex(initialNode));

        System.out.println("The steps to flip the coins are ");
        for (int i = 0; i < path.size(); i++)
            SixteenTailModel.printNode(SixteenTailModel.getNode(path.get(i)));

        System.out.println("The number of flips is " +
                model16.getNumberOfFlips(SixteenTailModel.getIndex(initialNode)));
    }
}
