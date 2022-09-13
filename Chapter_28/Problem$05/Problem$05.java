package chapter_twenty_eight;

import java.util.List;
import java.util.Scanner;

/**
 * *28.5 (Find paths) Define a new class named UnweightedGraphWithGetPath that
 * extends UnweightedGraph with a new method for finding a path between two
 * vertices with the following header:
 * public List<Integer> getPath(int u, int v);
 * The method returns a List<Integer> that contains all the vertices in a
 * path from u to v in this order. Using the BFS approach, you can obtain
 * the shortest path from u to v. If there isn’t a path from u to v, the method
 * returns null. Write a test program that creates a graph for Figure 28.1. The
 * program prompts the user to enter two cities and displays their paths. Here
 * is a sample run:
 *
 *          Enter a starting city: Seattle
 *          Enter an ending city: Miami
 *          The path is Seattle Denver Kansas City Atlanta Miami
 *
 *
 * @author Sharaf Qeshta
 * */
public class Problem$05
{
    public static void main(String[] args)
    {
        String[] vertices = {"Seattle", "San Francisco", "Los Angeles",
                "Denver", "Kansas City", "Chicago", "Boston", "New York",
                "Atlanta", "Miami", "Dallas", "Houston"};

        int[][] edges =
                {
                        {0, 1}, {0, 3}, {0, 5},
                        {1, 0}, {1, 2}, {1, 3},
                        {2, 1}, {2, 3}, {2, 4}, {2, 10},
                        {3, 0}, {3, 1}, {3, 2}, {3, 4}, {3, 5},
                        {4, 2}, {4, 3}, {4, 5}, {4, 7}, {4, 8}, {4, 10},
                        {5, 0}, {5, 3}, {5, 4}, {5, 6}, {5, 7},
                        {6, 5}, {6, 7},
                        {7, 4}, {7, 5}, {7, 6}, {7, 8},
                        {8, 4}, {8, 7}, {8, 9}, {8, 10}, {8, 11},
                        {9, 8}, {9, 11},
                        {10, 2}, {10, 4}, {10, 8}, {10, 11},
                        {11, 8}, {11, 9}, {11, 10}
                };

        UnweightedGraphWithGetPath<String> graph = new UnweightedGraphWithGetPath<>(vertices, edges);

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a starting city: ");
        String start = scanner.next();

        System.out.print("Enter an ending city: ");
        String end = scanner.next();



        int startIndex = graph.getIndex(start);
        int endIndex = graph.getIndex(end);
        List<Integer> path = graph.getPath(startIndex, endIndex);

        if (path == null)
            System.out.println("there`s no such path");
        else
        {
            System.out.print("The path is ");
            for (int index: path)
                System.out.print(graph.getVertex(index) + " ");
        }
    }
}
