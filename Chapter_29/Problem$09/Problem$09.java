package chapter_twenty_nine;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * *29.9 (Find a minimum spanning tree) Write a program that reads a connected graph
 * from a file and displays its minimum spanning tree. The first line in the file
 * contains a number that indicates the number of vertices (n). The vertices are
 * labeled as 0, 1, ... , n−1. Each subsequent line describes the edges in the form
 * of u1, v1, w1 | u2, v2, w2 | .... Each triplet in this form describes
 * an edge and its weight. Figure 29.23 shows an example of the file for the corresponding graph.
 * Note that we assume the graph is undirected. If the graph has
 * an edge (u, v), it also has an edge (v, u). Only one edge is represented in the
 * file. When you construct a graph, both edges need to be added.
 * Only one edge is represented in the file. When you construct a graph, both
 * edges need to be added. Your program should prompt the user to enter the name
 * of the file, read data from the file, create an instance g of WeightedGraph,
 * invoke g.printWeightedEdges() to display all edges, invoke
 * getMinimumSpanningTree() to obtain an instance tree of WeightedGraph.
 * MST, invoke tree.getTotalWeight() to display the weight of the minimum
 * spanning tree, and invoke tree.printTree() to display the tree. Here is a
 * sample run of the program:
 *
 *              Enter a file name: c:\exercise\WeightedGraphSample2.txt
 *              The number of vertices is 6
 *              Vertex 0: (0, 1, 100) (0, 2, 3)
 *              Vertex 1: (1, 0, 100) (1, 3, 20)
 *              Vertex 2: (2, 0, 3)(2, 3, 40) (2, 4, 2) (2, 5, 5)
 *              Vertex 3: (3, 1, 20) (3, 2, 40) (3, 5, 5)
 *              Vertex 4: (4, 2, 2) (4, 5, 9)
 *              Vertex 5: (5, 2, 5) (5, 3, 5) (5, 4, 9)
 *              Total weight in MST is 35
 *              Root is: 0
 *              Edges: (3, 1) (0, 2) (5, 3)(2, 4) (2, 5)
 *
 * (Hint: Use new WeightedGraph(list, numberOfVertices) to create
 * a graph, where list contains a list of WeightedEdge objects. Use
 * new WeightedEdge(u, v, w) to create an edge. Read the first line to
 * get the number of vertices. Read each subsequent line into a string s and use
 * s.split("[\\|]") to extract the triplets. For each triplet, use triplet
 * .split("[,]") to extract vertices and weight.)
 *
 *
 * @author Sharaf Qeshta
 * */
public class Problem$09
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a file name: ");
        String filePath = scanner.next();

        int verticesCount = 0;
        List<WeightedEdge> edges = new ArrayList<>();

        try(Scanner reader = new Scanner(new File(filePath)))
        {
            verticesCount = Integer.parseInt(reader.nextLine());
            System.out.println("The number of vertices is " + verticesCount);
            while (reader.hasNext())
            {
                String vertex = reader.nextLine();
                String[] edgesArray = vertex.split("[|]");
                for (String edge : edgesArray)
                {
                    String[] edgeData = edge.split("[,]");
                    int u = Integer.parseInt(edgeData[0].trim());
                    int v = Integer.parseInt(edgeData[1].trim());
                    int weight = Integer.parseInt(edgeData[2].trim());
                    edges.add(new WeightedEdge(u, v, weight));
                    edges.add(new WeightedEdge(v, u, weight));
                }
            }
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
        }

        WeightedGraph<Integer> graph = new WeightedGraph<>(edges, verticesCount);
        graph.printWeightedEdges();
        WeightedGraph<Integer>.MST tree = graph.getMinimumSpanningTree();
        System.out.println("Total weight in MST is "  + tree.getTotalWeight());
        tree.printTree();
    }
}
