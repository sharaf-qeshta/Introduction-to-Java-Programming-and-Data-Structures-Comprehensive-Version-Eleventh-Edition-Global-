package chapter_twenty_two;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * *22.26 (Bin packing with smallest object first) The bin packing problem is to pack the
 * objects of various weights into containers. Assume each container can hold a
 * maximum of 10 pounds. The program uses an algorithm that places an object
 * with the smallest weight into the first bin in which it would fit. Your program
 * should prompt the user to enter the total number of objects and the weight of each
 * object. The program displays the total number of containers needed to pack the
 * objects, and the contents of each container. Here is a sample run of the program:
 *
 *      Enter the number of objects: 6
 *      Enter the weights of the objects: 7 5 2 3 5 8
 *      Container 1 contains objects with weight 2 3 5
 *      Container 2 contains objects with weight 5
 *      Container 3 contains objects with weight 7
 *      Container 4 contains objects with weight 8
 *
 *      Does this program produce an optimal solution, that is, finding the minimum
 *      number of containers to pack the objects? No!
 *
 *
 * @author Sharaf Qeshta
 * */
public class Problem$26
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
    }

    public static ArrayList<ArrayList<Integer>> pack(int[] objects)
    {
        // sort
        boolean sorted = false;
        while (!sorted)
        {
            sorted = true;
            for (int i = 0; i < objects.length-1; i++)
            {
                if (objects[i] > objects[i+1])
                {
                    int temp = objects[i];
                    objects[i] = objects[i+1];
                    objects[i+1] = temp;
                    sorted = false;
                }
            }
        }

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
        containers.add((ArrayList<Integer>) currentContainer.clone());
        return containers;
    }
}
