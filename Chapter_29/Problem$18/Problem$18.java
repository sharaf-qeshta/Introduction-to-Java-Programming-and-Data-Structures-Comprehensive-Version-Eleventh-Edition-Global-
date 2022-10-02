package chapter_twenty_nine;


/**
 * ***29.18 (Alternative version of Dijkstra algorithm) An alternative version of the
 * Dijkstra algorithm can be described as follows:
 * Input: a weighted graph G = (V, E) with nonnegative weights
 * Output: A shortest-path tree from a source vertex s
 *  1 ShortestPathTree getShortestPath(s) {
 *  2 Let T be a set that contains the vertices whose
 *  3 paths to s are known;
 *  4 Initially T contains source vertex s with cost[s] = 0;
 *  5 for (each u in V – T)
 *  6 cost[u] = infinity;
 *  7
 *  8 while (size of T < n) {
 *  9 Find v in V – T with the smallest cost[u] + w(u, v) value
 * 10 among all u in T;
 * 11 Add v to T and set cost[v] = cost[u] + w(u, v);
 * 12 parent[v] = u;
 * 13 }
 * 14 }
 *
 * The algorithm uses cost[v] to store the cost of a shortest path from vertex v
 * to the source vertex s. cost[s] is 0. Initially assign infinity to cost[v] to
 * indicate that no path is found from v to s. Let V denote all vertices in the graph
 * and T denote the set of the vertices whose costs are known. Initially, the source
 * vertex s is in T. The algorithm repeatedly finds a vertex u in T and a vertex v
 * in V–T such that cost[u] + w(u, v) is the smallest, and moves v to T. The
 * shortest-path algorithm given in the text continuously updates the cost and parent
 * for a vertex in V–T. This algorithm initializes the cost to infinity for each
 * vertex and then changes the cost for a vertex only once when the vertex is added
 * into T. Implement this algorithm and use Listing 29.7, TestShortestPath.java, to
 * test your new algorithm.
 *
 *
 * @author Sharaf Qeshta
 * */
public class Problem$18
{
    /**
     * All shortest paths from Chicago are:
     * A path from Chicago to Seattle: Chicago Seattle (cost: 2097.0)
     * A path from Chicago to San Francisco: Chicago Denver San Francisco (cost: 2270.0)
     * A path from Chicago to Los Angeles: Chicago Denver Los Angeles (cost: 2018.0)
     * A path from Chicago to Denver: Chicago Denver (cost: 1003.0)
     * A path from Chicago to Kansas City: Chicago Kansas City (cost: 533.0)
     * A path from Chicago to Chicago: Chicago (cost: 0.0)
     * A path from Chicago to Boston: Chicago Boston (cost: 983.0)
     * A path from Chicago to New York: Chicago New York (cost: 787.0)
     * A path from Chicago to Atlanta: Chicago Kansas City Atlanta (cost: 1397.0)
     * A path from Chicago to Miami: Chicago Kansas City Atlanta Miami (cost: 2058.0)
     * A path from Chicago to Dallas: Chicago Kansas City Dallas (cost: 1029.0)
     * A path from Chicago to Houston: Chicago Kansas City Dallas Houston (cost: 1268.0)
     * Shortest path from Houston to Chicago: Houston Dallas Kansas City Chicago
     *
     * All shortest paths from 3 are:
     * A path from 3 to 0: 3 1 0 (cost: 5.0)
     * A path from 3 to 1: 3 1 (cost: 3.0)
     * A path from 3 to 2: 3 2 (cost: 4.0)
     * A path from 3 to 3: 3 (cost: 0.0)
     * A path from 3 to 4: 3 4 (cost: 6.0)
     * */
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

        ShortestPathWeightedGraph<String> graph1 =
                new ShortestPathWeightedGraph<>(vertices, edges);
        ShortestPathWeightedGraph<String>.ShortestPathTree tree1 =
                graph1.getShortestPath(graph1.getIndex("Chicago"));
        tree1.printAllPaths();

        // Display shortest paths from Houston to Chicago
        System.out.print("Shortest path from Houston to Chicago: ");
        java.util.List<String> path
                = tree1.getPath(graph1.getIndex("Houston"));
        for (String s : path)
        {
            System.out.print(s + " ");
        }

        edges = new int[][]
                {
                        {0, 1, 2}, {0, 3, 8},
                        {1, 0, 2}, {1, 2, 7}, {1, 3, 3},
                        {2, 1, 7}, {2, 3, 4}, {2, 4, 5},
                        {3, 0, 8}, {3, 1, 3}, {3, 2, 4}, {3, 4, 6},
                        {4, 2, 5}, {4, 3, 6}
                };

        ShortestPathWeightedGraph<Integer> graph2 = new ShortestPathWeightedGraph<>(edges, 5);
        ShortestPathWeightedGraph<Integer>.ShortestPathTree tree2 =
                graph2.getShortestPath(3);
        System.out.println("\n");
        tree2.printAllPaths();
    }
}
