package chapter_twenty_eight;



/**
 * *28.3 (Implement DFS using a stack) The depth-first search algorithm described
 * in Listing 28.8, Depth-First Search Algorithm uses recursion. Design a new
 * algorithm without using recursion. Describe it using pseudocode. Implement it
 * by defining a new class named UnweightedGraphWithNonrecursiveDFS
 * that extends UnweightedGraph and overriding the dfs method. Write a test
 * program same as Listing 28.9, TestPFS.java except that UnweightedGraph is
 * replaced by UnweightedGraphWithNonrecursiveDFS.
 *
 *
 * @author Sharaf Qeshta
 * */
public class Problem$03
{
    public static void main(String[] args)
    {
        /*
        * 12 vertices are searched in this DFS order:
        * Chicago New York Atlanta Houston Dallas Kansas City Denver Los Angeles San Francisco Seattle Miami Boston
        * parent of Seattle is San Francisco
        * parent of San Francisco is Los Angeles
        * parent of Los Angeles is Denver
        * parent of Denver is Kansas City
        * parent of Kansas City is Dallas
        * parent of Boston is New York
        * parent of New York is Chicago
        * parent of Atlanta is New York
        * parent of Miami is Houston
        * parent of Dallas is Houston
        * parent of Houston is Atlanta
        * */
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

        Graph<String> graph = new UnweightedGraphWithNonrecursiveDFS<>(vertices, edges);
        UnweightedGraph<String>.SearchTree dfs =
                graph.dfs(graph.getIndex("Chicago"));
        java.util.List<Integer> searchOrders = dfs.getSearchOrder();
        System.out.println(dfs.getNumberOfVerticesFound() +
                " vertices are searched in this DFS order:");
        for (int i = 0; i < searchOrders.size(); i++)
            System.out.print(graph.getVertex(searchOrders.get(i)) + " ");
        System.out.println();

        for (int i = 0; i < searchOrders.size(); i++)
            if (dfs.getParent(i) != -1)
                System.out.println("parent of " + graph.getVertex(i) +
                        " is " + graph.getVertex(dfs.getParent(i)));
    }
}
