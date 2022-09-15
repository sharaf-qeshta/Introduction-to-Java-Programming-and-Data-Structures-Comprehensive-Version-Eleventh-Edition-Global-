package chapter_twenty_eight;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * *28.10 (Find the shortest path) Write a program that reads a connected graph from a
 * file. The graph is stored in a file using the same format specified in Programming
 * Exercise 28.1. Your program should prompt the user to enter the name of
 * the file, then two vertices, and should display the shortest path between the two
 * vertices. For example, for the graph in Figure 28.21a, the shortest path between
 * 0 and 5 may be displayed as 0 1 3 5.
 * Here is a sample run of the program:
 *
 *          Enter a file name: c:\exercise\GraphSample1.txt
 *          Enter two vertices (integer indexes): 0 5
 *          The number of vertices is 6
 *          Vertex 0: (0, 1) (0, 2)
 *          Vertex 1: (1, 0) (1, 3)
 *          Vertex 2: (2, 0) (2, 3) (2, 4)
 *          Vertex 3: (3, 1) (3, 2) (3, 4) (3, 5)
 *          Vertex 4: (4, 2) (4, 3) (4, 5)
 *          Vertex 5: (5, 3) (5, 4)
 *          The path is 0 1 3 5
 *
 *
 * @author Sharaf Qeshta
 * */
public class Problem$10
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a file name: ");
        String fileName = scanner.next();

        System.out.print("Enter two vertices (integer indexes): ");
        int p1 = scanner.nextInt();
        int p2 = scanner.nextInt();

        int vertices = 0;
        List<Edge> list = new ArrayList<>();
        try (Scanner reader = new Scanner(new File(fileName)))
        {
            vertices = reader.nextInt();
            System.out.println("The number of vertices is " + vertices);
            while (reader.hasNext())
            {
                String line = reader.nextLine();
                if (line.isEmpty())
                    continue;
                Scanner lineReader = new Scanner(line);
                int vertex = lineReader.nextInt();
                while (lineReader.hasNext())
                    list.add(new Edge(vertex, lineReader.nextInt()));
            }
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
        }

        UnweightedGraph<Integer> graph = new UnweightedGraph<>(list, vertices);
        graph.printEdges();

        System.out.print("The path is ");
        graph.getPath(p1, p2).forEach(e -> System.out.print(e + " "));
    }
}
