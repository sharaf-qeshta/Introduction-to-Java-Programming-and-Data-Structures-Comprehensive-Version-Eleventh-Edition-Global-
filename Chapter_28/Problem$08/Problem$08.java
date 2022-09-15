package chapter_twenty_eight;

/**
 * **28.8 (Test bipartite) Recall that a graph is bipartite if its vertices can be divided
 * into two disjoint sets such that no edges exist between vertices in the same set.
 * Define a new class named UnweightedGraphTestBipartite with the following
 * method to detect whether the graph is bipartite:
 *
 * public boolean isBipartite();
 *
 *
 * @author Sharaf Qeshta
 * */
public class Problem$08
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

        UnweightedGraphTestBipartite<String> graph
                = new UnweightedGraphTestBipartite<>(vertices, edges);

        System.out.println(graph.isBipartite()); // false


        String[] vertices2 = {"Seattle", "San Francisco", "Los Angeles",
                "Denver", "Kansas City", "Chicago", "Boston", "New York"};

        int[][] edges2 =
                {
                        {0, 4},
                        {1, 5},
                        {2, 6},
                        {3, 7},
                        {4, 0},
                        {5, 1},
                        {6, 2},
                        {7, 3}
                };

        UnweightedGraphTestBipartite<String> graph2 =
                new UnweightedGraphTestBipartite<>(vertices2, edges2);

        System.out.println(graph2.isBipartite()); // true
    }
}
