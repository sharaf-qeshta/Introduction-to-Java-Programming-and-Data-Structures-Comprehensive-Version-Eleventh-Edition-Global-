package chapter_twenty_two;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * **22.27 (Optimal bin packing) Rewrite the preceding program so that it finds an optimal
 * solution that packs all objects using the smallest number of containers. Here is
 * a sample run of the program:
 *
 *      Enter the number of objects: 6
 *      Enter the weights of the objects: 7 5 2 3 5 8
 *      Container 1 contains objects with weight 7 3
 *      Container 2 contains objects with weight 5 5
 *      Container 3 contains objects with weight 2 8
 *      The optimal number of bins is 3
 *
 *      What is the time complexity of your program?
 *
 *      
 * @author Sharaf Qeshta
 * */
public class Problem$27
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of objects: ");
        int objectsCount = scanner.nextInt();
        int[] objects = new int[objectsCount];

        System.out.print("Enter the weights of the objects: ");
        for (int i = 0; i < objectsCount; i++)
            objects[i] = scanner.nextInt();

        ArrayList<ArrayList<Integer>> containers = pack(objects);

        for (int i = 0; i < containers.size(); i++)
        {
            System.out.print("Container " + (i+1) + " contains objects with weight ");
            containers.get(i).forEach(e -> System.out.print(e + " "));
            System.out.println();
        }

        System.out.println("The optimal number of bins is " + containers.size());
    }

    public static ArrayList<ArrayList<Integer>> pack(int[] objects)
    {
        ArrayList<ArrayList<Integer>> optimalPack = new ArrayList<>();
        int sum = 0;
        for (int value: objects)
            sum += value;
        int optimalBins = (int) Math.ceil(sum/10.0);
        findBestFit(objects, 0, optimalBins, optimalPack);

        return optimalPack;
    }

    public static void findBestFit(int[] objects, int index,
                                          int optimalBins,
                                          ArrayList<ArrayList<Integer>> optimalPack)
    {
        for(int i = index; i < objects.length; i++)
        {
            int temp = objects[i];
            objects[i] = objects[index];
            objects[index] = temp;

            findBestFit(objects, index+1, optimalBins, optimalPack);

            temp = objects[i];
            objects[i] = objects[index];
            objects[index] = temp;
        }
        if (index == objects.length - 1)
        {
            ArrayList<ArrayList<Integer>> containers = new ArrayList<>();
            int currentContainerWeight = 0;
            ArrayList<Integer> currentContainer = new ArrayList<>();
            for (int i = 0; i < objects.length; i++)
            {
                int sum = currentContainerWeight + objects[i];
                if (sum == 10)
                {
                    currentContainer.add(objects[i]);
                    containers.add((ArrayList<Integer>) currentContainer.clone());
                    currentContainer = new ArrayList<>();
                    currentContainerWeight = 0;
                }
                else if (sum < 10)
                {
                    currentContainer.add(objects[i]);
                    currentContainerWeight += objects[i];
                }
                else
                {
                    containers.add((ArrayList<Integer>) currentContainer.clone());
                    currentContainer = new ArrayList<>();
                    currentContainer.add(objects[i]);
                    currentContainerWeight = objects[i];
                }
            }
            if (currentContainerWeight != 0)
                containers.add((ArrayList<Integer>) currentContainer.clone());

            if (containers.size() == optimalBins)
            {
                optimalPack.clear();
                optimalPack.addAll(containers);
            }
        }
    }
}
