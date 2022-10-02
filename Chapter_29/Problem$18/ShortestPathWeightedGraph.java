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
        int[] parent = new int[getSize()];
        parent[sourceVertex] = -1; // the root
        double[] cost = new double[getSize()];
        /*
        * for (each u in V – T)
        * cost[u] = infinity;
        * */
        for (int i = 0; i < getSize(); i++)
            cost[i] = Double.POSITIVE_INFINITY;

        /*
        * Let T be a set that contains the vertices whose
        * paths to s are known;
        * */
        List<Integer> T = new ArrayList<>();

        /*
        * Initially T contains source vertex s with cost[s] = 0;
        */
        T.add(sourceVertex);
        cost[sourceVertex] = 0;

        /*
        * while (size of T < n)
        * */
        while (T.size() < getSize())
        {
            /*
            * Find v in V – T with the smallest cost[u] + w(u, v) value
            * among all u in T;
            * */
            double currentMin = Double.POSITIVE_INFINITY;
            int u = -1, v = -1;
            for (int i = 0; i < getSize(); i++)
            {
                // Find v in V – T
                if (!T.contains(i))
                {
                    // among all u in T
                    for (int j : T)
                    {
                        double weight = getWeight(j, i);
                        if (weight < 0) // Edge is not exist
                            continue;

                        double current = cost[j] + weight;
                        if (current < currentMin)
                        {
                            currentMin = current;
                            u = j;
                            v = i;
                        }
                    }
                }
            }

            if (u == -1)
                break;
            /*
            * Add v to T and set cost[v] = cost[u] + w(u, v);
            * */
            T.add(v);
            cost[v] = cost[u] + getWeight(u, v);

            /*
            * parent[v] = u;
            * */
            parent[v] = u;
        }

        // Create a ShortestPathTree
        return new ShortestPathTree(sourceVertex, parent, T, cost);
    }
}
