package chapter_eleven;

import java.util.ArrayList;
import java.lang.System;
import java.util.Locale;
import java.util.Scanner;

/**
 * **11.19 (Bin packing using first fit) The bin packing problem is to pack the objects of various
 * weights into containers. Assume each container can hold a maximum of 10
 * pounds. The program uses an algorithm that places an object into the first bin in
 * which it would fit. Your program should prompt the user to enter the total number
 * of objects and the weight of each object. The program displays the total number
 * of containers needed to pack the objects and the contents of each container. Here
 * is a sample run of the program:
 *
 *          Enter the number of objects: 6
 *          Enter the weights of the objects: 7 5 2 3 5 8
 *          Container 1 contains objects with weight 7 2
 *          Container 2 contains objects with weight 5 3
 *          Container 3 contains objects with weight 5
 *          Container 4 contains objects with weight 8
 *
 * Does this program produce an optimal solution, that is, finding the minimum
 * number of containers to pack the objects?
 *
 * @author Sharaf Qeshta
 * */
public class Problem$19
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in).useLocale(Locale.US);
        ArrayList<Container> containers = new ArrayList<>();
        ArrayList<Double> weights = new ArrayList<>();



        System.out.print("enter the number of objects: ");
        int objectsNumber = scanner.nextInt();

        for (int i = 1; i < objectsNumber+1;i++)
        {
            System.out.print("enter the weight of object " + i + ": ");
            double weight = scanner.nextDouble();
            weights.add(weight);
        }

        while(!weights.isEmpty())
        {
            Container container = new Container();
            container.startFilling(weights);
            containers.add(container);
        }

        for (Container container: containers)
            System.out.println("Container _ contains objects with weight " + container.getWeights());
    }
}
