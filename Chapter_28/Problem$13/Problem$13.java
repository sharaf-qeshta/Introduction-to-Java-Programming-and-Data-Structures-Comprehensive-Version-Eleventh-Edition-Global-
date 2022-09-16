package chapter_twenty_eight;


import java.util.Scanner;

/**
 * **28.13 (4 * 4 16 tails problem) Listing 28.14, NineTail.java, presents a solution for
 * the nine tails problem. Revise this program for the 4 * 4 16 tails problem.
 * Note it is possible that a solution may not exist for a starting pattern. If so,
 * report that no solution exists.
 *
 *
 * @author Sharaf Qeshta
 * */
public class Problem$13
{
    /*
    * sample run =>
    * Enter the initial nine coins Hs and Ts: TTHHTTTHHTTTHHTT
    * The steps to flip the coins are
    * TTHH
    * TTTH
    * HTTT
    * HHTT
    *
    * TTHH
    * TTTH
    * TTTT
    * TTTT
    *
    * TTTT
    * TTTT
    * TTTT
    * TTTT
    */
    public static void main(String[] args)
    {
        System.out.print("Enter the initial nine coins Hs and Ts: ");
        Scanner input = new Scanner(System.in);
        String s = input.nextLine();
        char[] initialNode = s.toCharArray();

        SixteenTailModel model = new SixteenTailModel();
        java.util.List<Integer> path =
                model.getShortestPath(SixteenTailModel.getIndex(initialNode));

        System.out.println("The steps to flip the coins are ");
        for (int i = 0; i < path.size(); i++)
            SixteenTailModel.printNode(
                    SixteenTailModel.getNode(path.get(i)));
    }
}
