package chapter_twenty_nine;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * *29.11 (Find shortest paths) Write a program that reads a connected graph from a
 * file. The graph is stored in a file using the same format specified in Programming
 * Exercise 29.9. Your program should prompt the user to enter the name of
 * the file then two vertices, and should display a shortest path between the two
 * vertices. For example, for the graph in Figure 29.23, a shortest path between
 * 0 and  1 can be displayed as 0 2 5 3 1. Here is a sample run of the program:
 *
 *              Enter a file name: WeightedGraphSample2.txt
 *              Enter two vertices (integer indexes): 0 1
 *              The number of vertices is 6
 *              Vertex 0: (0, 1, 100.0) (0, 2, 3.0)
 *              Vertex 1: (1, 0, 100.0) (1, 3, 20.0)
 *              Vertex 2: (2, 0, 3.0) (2, 3, 40.0) (2, 4, 2.0) (2, 5, 5.0)
 *              Vertex 3: (3, 1, 20.0) (3, 2, 40.0) (3, 5, 5.0)
 *              Vertex 4: (4, 2, 2.0) (4, 5, 9.0)
 *              Vertex 5: (5, 2, 5.0) (5, 3, 5.0) (5, 4, 9.0)
 *              A path from 0 to 1: 0 2 5 3 1
 *
 * 
 * @author Sharaf Qeshta
 * */
public class Problem$11
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a file name: ");
        String filePath = scanner.next();

        System.out.print("Enter two vertices (integer indexes): ");
        int u = scanner.nextInt(), v = scanner.nextInt();
        scanner.close();

        int vertices = 0;
        List<WeightedEdge> edges = new ArrayList<>();

        try (Scanner reader = new Scanner(new File(filePath)))
        {
            vertices = Integer.parseInt(reader.nextLine().trim());

            while (reader.hasNext())
            {
                String line = reader.nextLine().trim();
                String[] edgesInLine = line.split("[|]");
                for (String edge : edgesInLine)
                {
                    String[] edgeInfo = edge.split("[,]");
                    int u_ = Integer.parseInt(edgeInfo[0].trim());
                    int v_ = Integer.parseInt(edgeInfo[1].trim());
                    double weight = Integer.parseInt(edgeInfo[2].trim());

                    edges.add(new WeightedEdge(u_, v_, weight));
                    edges.add(new WeightedEdge(v_, u_, weight));
                }
            }
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
        }


        WeightedGraph<Integer> graph = new WeightedGraph<>(edges, vertices);
        graph.printWeightedEdges();

        WeightedGraph<Integer>.ShortestPathTree shortestPathTree = graph.getShortestPath(v);
        List<Integer> shortestPath = shortestPathTree.getPath(u);

        System.out.print("A path from " + u + " to " + v + ": ");
        shortestPath.forEach( e -> System.out.print(e + " "));
    }
}
