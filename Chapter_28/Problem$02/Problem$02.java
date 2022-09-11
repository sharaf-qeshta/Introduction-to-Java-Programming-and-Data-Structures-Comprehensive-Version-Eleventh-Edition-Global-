package chapter_twenty_eight;


import java.io.File;
import java.io.PrintWriter;
import java.util.List;

/**
 * *28.2 (Create a file for a graph) Modify Listing 28.2, TestGraph.java to create a file
 * representing graph1. The file format is described in Programming Exercise
 * 28.1. Create the file from the array defined in lines 8–21 in Listing 28.2. The
 * number of vertices for the graph is 12, which will be stored in the first line of
 * the file. The contents of the file should be as follows:
 *
 *          12
 *          0 1 3 5
 *          1 0 2 3
 *          2 1 3 4 10
 *          3 0 1 2 4 5
 *          4 2 3 5 7 8 10
 *          5 0 3 4 6 7
 *          6 5 7
 *          7 4 5 6 8
 *          8 4 7 9 10 11
 *          9 8 11
 *          10 2 4 8 11
 *          11 8 9 10
 *
 *
 * @author Sjaraf Qeshta
 * */
public class Problem$02
{
    private static final String FILE_PATH = "src/chapter_twenty_eight/graph.txt";

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

        Graph<String> graph = new UnweightedGraph<>(vertices, edges);

        try(PrintWriter writer = new PrintWriter(new File(FILE_PATH)))
        {
            int verticesCount = graph.getSize();
            writer.write(verticesCount + "\n");
            for (int i = 0; i < verticesCount; i++)
            {
                String line = i + " ";
                List<Integer> list = graph.getNeighbors(i);
                for (int vertex: list)
                    line += vertex + " ";
                writer.write(line + "\n");
            }
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
        }
    }
}
