package chapter_twenty_nine;

import java.util.ArrayList;
import java.util.List;

public class ShortestPathWeightedGraph<T> extends WeightedGraph<T>
{
    public ShortestPathWeightedGraph(T[] vertices, int[][] edges)
    {
        super(vertices, edges);
    }

    public ShortestPathWeightedGraph(int[][] edges, int vertices)
    {
        super(edges, vertices);
    }

    @Override
    public ShortestPathTree getShortestPath(int sourceVertex)
    {
        // cost[v] stores the cost of the path from v to the source
        double[] cost = new double[getSize()];

        for (int i = 0; i < cost.length; i++)
            cost[i] = Double.POSITIVE_INFINITY; // Initial cost set to infinity

        cost[sourceVertex] = 0; // Cost of source is 0

        // parent[v] stores the previous vertex of v in the path
        int[] parent = new int[getSize()];
        parent[sourceVertex] = -1; // The parent of source is set to −1

        // T stores the vertices whose path found so far
        List<Integer> T = new ArrayList<>();
        AVLTree<Integer> tree = new AVLTree<>();
        for (int i = 0; i < getSize(); i++)
            tree.add(i);

        // Expand T
        while (T.size() < getSize())
        {
            // Find smallest cost u in V − T
            int u = -1; // Vertex to be determined
            double currentMinCost = Double.POSITIVE_INFINITY;
            for (int i : tree)
            {
                if (cost[i] < currentMinCost)
                {
                    currentMinCost = cost[i];
                    u = i;
                }
            }

            if (u == -1)
                break;
            else
                T.add(u); // Add a new vertex to T
            tree.delete(u);

            // Adjust cost[v] for v that is adjacent to u and v in V − T
            for (Edge e : neighbors.get(u))
            {
                if (!T.contains(e.v)
                        && cost[e.v] > cost[u] + ((WeightedEdge) e).weight)
                {
                    cost[e.v] = cost[u] + ((WeightedEdge) e).weight;
                    parent[e.v] = u;
                }
            }
        } // End of while

        // Create a ShortestPathTree
        return new ShortestPathTree(sourceVertex, parent, T, cost);
    }
}
