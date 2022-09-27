package chapter_twenty_nine;


import java.io.File;
import java.io.PrintWriter;
import java.util.List;

/**
 * *29.10 (Create a file for a graph) Modify Listing 29.3, TestWeightedGraph.java, to
 * create a file for representing graph1. The file format is described in Programming
 * Exercise 29.9. Create the file from the array defined in lines 7–24 in
 * Listing 29.3. The number of vertices for the graph is 12, which will be stored
 * in the first line of the file. An edge (u, v) is stored if u < v. The contents of the
 * file should be as follows:
 *
 *          12
 *          0, 1, 807 | 0, 3, 1331 | 0, 5, 2097
 *          1, 2, 381 | 1, 3, 1267
 *          2, 3, 1015 | 2, 4, 1663 | 2, 10, 1435
 *          3, 4, 599 | 3, 5, 1003
 *          4, 5, 533 | 4, 7, 1260 | 4, 8, 864 | 4, 10, 496
 *          5, 6, 983 | 5, 7, 787
 *          6, 7, 214
 *          7, 8, 888
 *          8, 9, 661 | 8, 10, 781 | 8, 11, 810
 *          9, 11, 1187
 *          10, 11, 239
 *
 *
 * @author Sharaf Qeshta
 * */
public class Problem$10
{
    public static final String FILE_PATH = "src/chapter_twenty_nine/GraphSample.txt";
    public static void main(String[] args)
    {
        String[] vertices = {"Seattle", "San Francisco", "Los Angeles",
                "Denver", "Kansas City", "Chicago", "Boston", "New York",
                "Atlanta", "Miami", "Dallas", "Houston"};

        int[][] edges =
                {
                        {0, 1, 807}, {0, 3, 1331}, {0, 5, 2097},
                        {1, 0, 807}, {1, 2, 381}, {1, 3, 1267},
                        {2, 1, 381}, {2, 3, 1015}, {2, 4, 1663}, {2, 10, 1435},
                        {3, 0, 1331}, {3, 1, 1267}, {3, 2, 1015}, {3, 4, 599},
                        {3, 5, 1003},
                        {4, 2, 1663}, {4, 3, 599}, {4, 5, 533}, {4, 7, 1260},
                        {4, 8, 864}, {4, 10, 496},
                        {5, 0, 2097}, {5, 3, 1003}, {5, 4, 533},
                        {5, 6, 983}, {5, 7, 787},
                        {6, 5, 983}, {6, 7, 214},
                        {7, 4, 1260}, {7, 5, 787}, {7, 6, 214}, {7, 8, 888},
                        {8, 4, 864}, {8, 7, 888}, {8, 9, 661},
                        {8, 10, 781}, {8, 11, 810},
                        {9, 8, 661}, {9, 11, 1187},
                        {10, 2, 1435}, {10, 4, 496}, {10, 8, 781}, {10, 11, 239},
                        {11, 8, 810}, {11, 9, 1187}, {11, 10, 239}
                };

        WeightedGraph<String> graph =
                new WeightedGraph<>(vertices, edges);

        try(PrintWriter writer = new PrintWriter(new File(FILE_PATH)))
        {
            writer.write(graph.getSize() + "\n");
            for (int i = 0; i < graph.getSize(); i++)
            {
                List<Integer> iNeighbours = graph.getNeighbors(i);
                String iEdges = "";
                for (int neighbour: iNeighbours)
                {
                    if (i < neighbour)
                    {
                        iEdges += i + ", " + neighbour + ", " + graph.getWeight(i, neighbour) + " | ";
                    }
                }
                if (iEdges.length() > 0)
                    iEdges = iEdges.substring(0, iEdges.length()-2);
                writer.write(iEdges + "\n");
            }
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
        }
    }
}
