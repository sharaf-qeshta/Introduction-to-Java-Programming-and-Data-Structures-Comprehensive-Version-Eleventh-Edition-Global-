package chapter_twenty_eight;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * *28.1 (Test whether a graph is connected) Write a program that reads a graph from
 * a file and determines whether the graph is connected. The first line in the file
 * contains a number that indicates the number of vertices (n). The vertices are
 * labeled as 0, 1, . . . , n−1. Each subsequent line, with the format u v1 v2 ...,
 * describes edges (u, v1), (u, v2), and so on. Figure 28.21 gives the examples of
 * two files for their corresponding graphs.
 * Your program should prompt the user to enter a URL for the file, then it
 * should read data from the file, create an instance g of UnweightedGraph,
 * invoke g.printEdges() to display all edges, and invoke dfs() to obtain
 * an instance tree of UnweightedGraph<V>.SearchTree. If
 * tree.getNumberOfVerticesFound() is the same as the number of vertices
 * in the graph, the graph is connected. Here is a sample run of the
 *
 *          Enter a URL:
 *          https://liveexample.pearsoncmg.com/test/GraphSample1.txt
 *          The number of vertices is 6
 *          Vertex 0: (0, 1) (0, 2)
 *          Vertex 1: (1, 0) (1, 3)
 *          Vertex 2: (2, 0) (2, 3) (2, 4)
 *          Vertex 3: (3, 1) (3, 2) (3, 4) (3, 5)
 *          Vertex 4: (4, 2) (4, 3) (4, 5)
 *          Vertex 5: (5, 3) (5, 4)
 *          The graph is connected
 *
 * (Hint: Use new UnweightedGraph(list, numberOfVertices) to create
 * a graph, where list contains a list of Edge objects. Use new Edge(u, v)
 * to create an edge. Read the first line to get the number of vertices. Read each
 * subsequent line into a string s and use s.split("[\;\s+]") to extract the
 * vertices from the string and create edges from the vertices.)
 *
 *
 * @author Sharaf Qeshta
 * */
public class Problem$01
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a URL: ");
        String url = scanner.nextLine();

        int vertices = 0;
        List<Edge> list = new ArrayList<>();
        try (Scanner reader = new Scanner(new URL(url).openStream()))
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

        Graph<Integer> graph = new UnweightedGraph<>(list, vertices);
        graph.printEdges();

        UnweightedGraph<Integer>.SearchTree tree = graph.dfs(0);

        if (tree.getNumberOfVerticesFound() == vertices)
            System.out.println("The graph is connected");
        else
            System.out.println("The graph is not connected");
    }
}
