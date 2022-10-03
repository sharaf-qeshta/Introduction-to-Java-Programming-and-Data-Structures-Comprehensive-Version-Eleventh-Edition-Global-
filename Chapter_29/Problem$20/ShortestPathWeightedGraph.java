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

        boolean[] isInT = new boolean[getSize()]; // by default all values are false

        // Expand T
        while (T.size() < getSize())
        {
            // Find smallest cost u in V − T
            int u = -1; // Vertex to be determined
            double currentMinCost = Double.POSITIVE_INFINITY;
            for (int i = 0; i < getSize(); i++)
            {
                if (!isInT[i] && cost[i] < currentMinCost)
                {
                    currentMinCost = cost[i];
                    u = i;
                }
            }

            if (u == -1)
                break;
            else
                T.add(u); // Add a new vertex to T
            isInT[u] = true;

            // Adjust cost[v] for v that is adjacent to u and v in V − T
            for (Edge e : neighbors.get(u))
            {
                if (!isInT[e.v]
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


    @Override
    public MST getMinimumSpanningTree(int startingVertex)
    {
        // cost[v] stores the cost by adding v to the tree
        double[] cost = new double[getSize()];
        for (int i = 0; i < cost.length; i++)
            cost[i] = Double.POSITIVE_INFINITY; // Initial cost

        cost[startingVertex] = 0; // Cost of source is 0

        int[] parent = new int[getSize()]; // Parent of a vertex
        parent[startingVertex] = -1; // startingVertex is the root
        double totalWeight = 0; // Total weight of the tree thus far

        List<Integer> T = new ArrayList<>();

        boolean[] isInT = new boolean[getSize()];
        // Expand T
        while (T.size() < getSize())
        {
            // Find smallest cost u in V − T
            int u = -1; // Vertex to be determined
            double currentMinCost = Double.POSITIVE_INFINITY;
            for (int i = 0; i < getSize(); i++)
            {
                if (!isInT[i] && cost[i] < currentMinCost)
                {
                    currentMinCost = cost[i];
                    u = i;
                }
            }

            if (u == -1)
                break;
            else
                T.add(u); // Add a new vertex to T
            isInT[u] = true;

            totalWeight += cost[u]; // Add cost[u] to the tree

            // Adjust cost[v] for v that is adjacent to u and v in V − T
            for (Edge e : neighbors.get(u))
            {
                if (!isInT[e.v] && cost[e.v] > ((WeightedEdge) e).weight)
                {
                    cost[e.v] = ((WeightedEdge) e).weight;
                    parent[e.v] = u;
                }
            }
        } // End of while

        return new MST(startingVertex, parent, T, totalWeight);
    }
}
