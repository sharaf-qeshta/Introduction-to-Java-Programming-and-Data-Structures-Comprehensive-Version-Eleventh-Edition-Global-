package chapter_twenty_eight;

import chapter_twenty_eight.samples.NineTailModel;

import java.util.Scanner;

/**
 * **28.12 (Variation of the nine tails problem) In the nine tails problem, when you flip a
 * coin, the horizontal and vertical neighboring cells are also flipped. Rewrite the
 * program, assuming all neighboring cells including the diagonal neighbors are
 * also flipped.
 *
 *
 * @author Sharaf Qeshta
 * */
public class Problem$12
{
    /* sample run =>
    * Enter the initial nine coins Hs and Ts: HHHTTTHTH
    * The steps to flip the coins are
    * HHH
    * TTT
    * HTH
    *
    * HTT
    * TTH
    * HTH
    *
    * THT
    * HTH
    * HTH
    *
    * HTH
    * HHH
    * HTH
    *
    * HHH
    * TTT
    * HHH
    *
    * HHH
    * THT
    * TTT
    *
    * TTT
    * TTT
    * TTT
    * */
    public static void main(String[] args)
    {
        // Prompt the user to enter nine coins' Hs and Ts
        System.out.print("Enter the initial nine coins Hs and Ts: ");
        Scanner input = new Scanner(System.in);
        String s = input.nextLine();
        char[] initialNode = s.toCharArray();

        NineTailModel model = new NineTailModel();
        java.util.List<Integer> path =
                model.getShortestPath(NineTailModel.getIndex(initialNode));

        System.out.println("The steps to flip the coins are ");
        for (int i = 0; i < path.size(); i++)
            NineTailModel.printNode(
                    NineTailModel.getNode(path.get(i)));
    }
}
