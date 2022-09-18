package chapter_twenty_eight;

/**
 * **28.16 (Induced subgraph) Given an undirected graph G = (V, E) and an integer k,
 * find an induced subgraph H of G of maximum size such that all vertices of H
 * have a degree 7 = k, or conclude that no such induced subgraph exists.
 * Implement the method with the following header:
 * public static <V> Graph<V> maxInducedSubgraph(Graph<V> g, int k)
 * The method returns an empty graph if such a subgraph does not exist.
 * (Hint: An intuitive approach is to remove vertices whose degree is less than k.
 * As vertices are removed with their adjacent edges, the degrees of other vertices
 * may be reduced. Continue the process until no vertices can be removed, or all
 * the vertices are removed.)
 *
 *
 * @author Sharaf Qeshta
 * */
public class Problem$16
{
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

        UnweightedGraph<String> graph = new UnweightedGraph<>(vertices, edges);
        Graph<String> inducedSubgraph1 = maxInducedSubgraph(graph, 1);

        System.out.println(inducedSubgraph1.getSize()); // 12

        Graph<String> inducedSubgraph2 = maxInducedSubgraph(graph, 3); // 9
        System.out.println(inducedSubgraph2.getSize());
    }


    public static <V> Graph<V> maxInducedSubgraph(Graph<V> g, int k)
    {
        while (true)
        {
            int removeIndex = -1;
            for (int i = 0; i < g.getSize(); i++)
            {
                int degree = g.getNeighbors(i).size();
                if (degree < k)
                {
                    removeIndex = i;
                    break;
                }
            }

            if (removeIndex == -1 || g.getSize() == 0)
                return g;
            g.remove(g.getVertex(removeIndex));
        }
    }
}
