package chapter_twenty_nine;

import java.util.ArrayList;
import java.util.List;

public class WeightedTailModel16 extends SixteenTailModel
{
    /**
     * Construct a model
     */
    public WeightedTailModel16()
    {
        // Create edges
        List<WeightedEdge> edges = getEdges();

        // Create a graph
        WeightedGraph<Integer> graph = new WeightedGraph<>(edges, NUMBER_OF_NODES);

        // Obtain a shortest-path tree rooted at the target node
        tree = graph.getShortestPath(65535);
    }

    /**
     * Create all edges for the graph
     */
    private List<WeightedEdge> getEdges()
    {
        // Store edges
        List<WeightedEdge> edges = new ArrayList<>();
        for (int u = 0; u < NUMBER_OF_NODES; u++)
        {
            for (int k = 0; k < 16; k++)
            {
                char[] node = getNode(u); // Get the node for vertex u
                if (node[k] == 'H')
                {
                    int v = getFlippedNode(node, k);
                    int numberOfFlips = getNumberOfFlips(u, v);

                    // Add edge (v, u) for a legal move from node u to node v
                    edges.add(new WeightedEdge(v, u, numberOfFlips));
                }
            }
        }

        return edges;
    }

    private static int getNumberOfFlips(int u, int v)
    {
        char[] node1 = getNode(u);
        char[] node2 = getNode(v);

        int count = 0; // Count the number of different cells
        for (int i = 0; i < node1.length; i++)
            if (node1[i] != node2[i]) count++;

        return count;
    }

    public int getNumberOfFlips(int u)
    {
        return (int) ((WeightedGraph<Integer>.ShortestPathTree) tree)
                .getCost(u);
    }
}
