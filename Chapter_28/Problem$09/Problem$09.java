package chapter_twenty_eight;

/**
 * **28.9 (Get bipartite sets) Add a new method in UnweightedGraph with the following
 * header to return two bipartite sets if the graph is bipartite:
 * public List<List<Integer>> getBipartite();
 * The method returns a List that contains two sublists, each of which contains a
 * set of vertices. If the graph is not bipartite, the method returns null.
 *
 *
 * @author Sharaf Qeshta
 * */
public class Problem$09
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

        UnweightedGraph<String> graph
                = new UnweightedGraph<>(vertices, edges);

        /*
        * null
        * */
        System.out.println(graph.getBipartite());


        String[] vertices2 = {"Seattle", "San Francisco", "Los Angeles",
                "Denver", "Kansas City", "Chicago", "Boston", "New York"};

        int[][] edges2 =
                {
                        {0, 4}, {0, 5},
                        {1, 5},
                        {2, 6},
                        {3, 7},
                        {4, 0},
                        {5, 1}, {5, 0},
                        {6, 2},
                        {7, 3}
                };

        UnweightedGraph<String> graph2 =
                new UnweightedGraph<>(vertices2, edges2);

        /*
        * [[4, 5, 6, 7], [0, 1, 2, 3]]
        * */
        System.out.println(graph2.getBipartite());
    }
}
